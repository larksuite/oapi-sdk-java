package com.lark.oapi.sample.agent;

import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.sse.SSEEvent;
import com.lark.oapi.core.sse.SSEOptions;
import com.lark.oapi.core.sse.SSEStream;
import com.lark.oapi.service.agent.v1.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

final class AgentConversation {
    private AgentConversation() {}

    static void chat(AgentSample example) throws Exception {
        CreateSessionReqBody body = CreateSessionReqBody.newBuilder()
                .uuid(UUID.randomUUID().toString())
                .name("SDK Agent example")
                .build();
        CreateSessionReq request = CreateSessionReq.newBuilder()
                .createSessionReqBody(body)
                .build();
        CreateSessionResp response = example.client.agent().v1().session()
                .create(request, example.options);
        CreateSessionRespBody session = AgentSample.checked(response, "create session");
        if (session.getId() == null) {
            throw new IllegalStateException("create session: missing id");
        }
        List<Object> contents = new ArrayList<>();
        TextItem text = TextItem.newBuilder()
                .type("text")
                .text("请用三句话介绍 SSE。")
                .build();
        contents.add(text);
        String fileUri = System.getenv("AGENT_FILE_URI");
        if (fileUri != null && !fileUri.isEmpty()) {
            // Lightweight union: retain a raw object for a file branch not listed in Meta.
            Map<String, Object> file = new HashMap<>();
            file.put("type", "file");
            file.put("uri", AgentSample.required("AGENT_FILE_URI"));
            contents.add(file);
        }
        Event event = Event.newBuilder()
                .type("user.message")
                .contents(contents.toArray())
                .build();
        CreateSessionEventReq eventRequest = eventRequest(session.getId(), event);
        CreateSessionEventResp eventResponse = example.client.agent().v1().sessionEvent()
                .create(eventRequest, example.options);
        CreateSessionEventRespBody sent = AgentSample.checked(eventResponse, "send message");
        Message[] messages = sent.getMessages();
        if (messages == null || messages.length == 0 || messages[0].getId() == null) {
            throw new IllegalStateException("send message: missing user query id");
        }
        String query = sent.getMessages()[0].getId();
        System.out.println("AGENT_SESSION_ID=" + session.getId());
        System.out.println("AGENT_QUERY_MESSAGE_ID=" + query);
        read(example, session.getId(), query, "", false);
    }

    private static CreateSessionEventReq eventRequest(String sid, Event event) {
        CreateSessionEventReqBody body = CreateSessionEventReqBody.newBuilder()
                .uuid(UUID.randomUUID().toString())
                .events(new Event[]{event})
                .build();
        return CreateSessionEventReq.newBuilder()
                .sessionId(sid)
                .createSessionEventReqBody(body)
                .build();
    }

    static void read(
            AgentSample example,
            String sid,
            String query,
            String cursor,
            boolean closeEarly) throws Exception {
        SSEOptions bounds = new SSEOptions()
                .openTimeoutMillis(10000)
                .idleReadTimeoutMillis(60000)
                .totalTimeoutMillis(180000)
                .maxEventBytes(1024 * 1024)
                .lastEventId(cursor);
        RequestOptions options = RequestOptions.newBuilder()
                .userAccessToken(AgentSample.required("USER_ACCESS_TOKEN"))
                .build();
        options.setSSEOptions(bounds);
        StreamSessionEventReq request = StreamSessionEventReq.newBuilder()
                .sessionId(sid)
                .messageId(query)
                .build();
        try (SSEStream stream = example.client.agent().v1().sessionEvent()
                .stream(request, options)) {
            SSEEvent event;
            while ((event = stream.readNext()) != null) {
                handleEvent(event);
                // Checkpoint only after the event has been processed; an empty id resets it.
                if (event.getId() != null) {
                    System.out.println("AGENT_LAST_EVENT_ID=" + event.getId());
                }
                if (closeEarly) {
                    System.out.println(
                            "closing receiver after one event; Agent may continue generating");
                    break;
                }
            }
        }
    }

    private static void handleEvent(SSEEvent event) {
        JsonElement parsed = JsonParser.parseString(event.getData());
        if (!parsed.isJsonObject()) {
            throw new IllegalStateException("SSE data must be a JSON object");
        }
        JsonObject data = parsed.getAsJsonObject();
        if ("message.failed".equals(event.getEvent())) {
            throw new IllegalStateException("Agent reply failed");
        }
        if (data.has("BaseResp") && data.get("BaseResp").isJsonObject()) {
            JsonObject base = data.getAsJsonObject("BaseResp");
            if (base.has("StatusCode")) {
                long code = base.get("StatusCode").getAsLong();
                if (code != 0) {
                    throw new IllegalStateException("SSE business error: code " + code);
                }
            }
        }
        if ("text".equals(event.getEvent()) || "text.delta".equals(event.getEvent())) {
            String key = "text".equals(event.getEvent()) ? "text" : "delta";
            String text = data.has(key) ? data.get(key).getAsString() : "";
            // Deliver text to your UI here; complete items replace previews for the same item id.
            System.out.println("text received: " + text.length() + " characters");
        } else {
            System.out.println("SSE event=" + event.getEvent());
        }
        if (data.has("message") && data.get("message").isJsonObject()) {
            JsonObject message = data.getAsJsonObject("message");
            boolean assistant = message.has("role") &&
                    "assistant".equals(message.get("role").getAsString());
            if (assistant && message.has("id")) {
                System.out.println("AGENT_ASSISTANT_MESSAGE_ID=" + message.get("id").getAsString());
            }
        }
    }

    static void interrupt(AgentSample example) throws Exception {
        String sid = AgentSample.required("AGENT_SESSION_ID");
        String assistant = AgentSample.required("AGENT_ASSISTANT_MESSAGE_ID");
        Event event = Event.newBuilder()
                .type("user.interrupt")
                .messageId(assistant)
                .build();
        CreateSessionEventReq request = eventRequest(sid, event);
        CreateSessionEventResp response = example.client.agent().v1().sessionEvent()
                .create(request, example.options);
        AgentSample.checked(response, "interrupt reply");
        System.out.println("interrupt accepted; immediate snapshot may still be in_progress");
        GetSessionMessageReq getRequest = GetSessionMessageReq.newBuilder()
                .sessionId(sid)
                .messageId(assistant)
                .build();
        GetSessionMessageResp getResponse = example.client.agent().v1().sessionMessage()
                .get(getRequest, example.options);
        GetSessionMessageRespBody state = AgentSample.checked(getResponse, "query reply");
        if (state.getMessage() == null) {
            throw new IllegalStateException("query reply: missing message");
        }
        System.out.println("reply status=" + state.getMessage().getStatus());
        System.out.println("completed may mean the reply finished before the interrupt");
    }
}
