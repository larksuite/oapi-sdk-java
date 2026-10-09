package com.lark.oapi.sample.agent;

import com.lark.oapi.service.agent.v1.model.CreateFileReq;
import com.lark.oapi.service.agent.v1.model.CreateFileReqBody;
import com.lark.oapi.service.agent.v1.model.CreateFileRespBody;
import com.lark.oapi.service.agent.v1.model.CreateFileResp;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

final class AgentUpload {
    private AgentUpload() {}

    static void upload(AgentSample example) throws Exception {
        String source = System.getenv("AGENT_FILE_PATH");
        boolean temporary = source == null || source.isEmpty();
        Path path;
        if (temporary) {
            // Java's generated upload model accepts File. Materialize the memory example.
            path = Files.createTempFile("sdk-agent-", ".tmp");
        } else {
            path = Paths.get(source);
            for (Path part : path) {
                if ("..".equals(part.toString())) {
                    throw new IllegalArgumentException(
                            "AGENT_FILE_PATH must not contain parent traversal");
                }
            }
            path = path.normalize();
        }
        try {
            if (temporary) {
                byte[] content = "SDK Agent upload example\n".getBytes(StandardCharsets.UTF_8);
                Files.write(path, content);
            }
            String filename = System.getenv("AGENT_FILENAME");
            if (filename == null || filename.isEmpty()) {
                filename = "report.txt";
            }
            CreateFileReqBody body = CreateFileReqBody.newBuilder()
                    .file(path.toFile())
                    .filename(filename)
                    .uuid(UUID.randomUUID().toString())
                    .build();
            CreateFileReq request = CreateFileReq.newBuilder()
                    .createFileReqBody(body)
                    .build();
            CreateFileResp response = example.client.agent().v1().file()
                    .create(request, example.options);
            CreateFileRespBody uploaded = AgentSample.checked(response, "upload");
            if (uploaded.getUri() == null) {
                throw new IllegalStateException("upload: missing URI");
            }
            System.out.println("AGENT_FILE_URI=" + uploaded.getUri());
            System.out.println("upload succeeded; set AGENT_FILE_URI and run chat to reference it");
        } finally {
            if (temporary) {
                Files.delete(path);
            }
        }
    }
}
