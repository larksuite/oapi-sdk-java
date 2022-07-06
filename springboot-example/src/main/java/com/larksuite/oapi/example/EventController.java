package com.larksuite.oapi.example;

import com.larksuite.oapi.core.IHttpAdapter;
import com.larksuite.oapi.core.request.EventReq;
import com.larksuite.oapi.core.response.EventResp;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.event.EventDispatcher;
import com.larksuite.oapi.service.contact.v3.ContactService;
import com.larksuite.oapi.service.contact.v3.model.UserCreatedEvent;
import com.larksuite.oapi.service.im.v1.ImService;
import com.larksuite.oapi.service.im.v1.model.MessageReceiveEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class EventController {

    private final EventDispatcher EVENT_DISPATCHER = new EventDispatcher.Builder("v", "")
            .onMessageReceiveV1(new ImService.MessageReceiveEventHandler() {
                @Override
                public void handle(MessageReceiveEvent event) throws Exception {
                    System.out.println(Jsons.DEFAULT_GSON.toJson(event));
                }
            }).onUserCreatedV3(new ContactService.UserCreatedEventHandler() {
                @Override
                public void handle(UserCreatedEvent event) throws Exception {
                    System.out.println(Jsons.DEFAULT_GSON.toJson(event));
                }
            }).build();
    @Autowired
    private HttpTranslator httpTranslator;

    @RequestMapping("/webhook/event")
    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // 转换请求对象
        EventReq req = httpTranslator.translate(request);

        // 处理请求
        EventResp resp = EVENT_DISPATCHER.handle(req);

        // 回写结果
        httpTranslator.write(response, resp);
    }


    @RequestMapping("/webhook/event1")
    public void helloWorld2(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        IHttpAdapter adapter = new IHttpAdapter() {
            @Override
            public EventReq getEventReq() throws IOException {
                return httpTranslator.translate(request);
            }

            @Override
            public void writeResp(EventResp eventResp) throws IOException {
                httpTranslator.write(response, eventResp);
            }
        };

        EVENT_DISPATCHER.handle(adapter);
    }
}
