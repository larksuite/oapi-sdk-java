package com.lark.oapi.core.request;

import com.lark.oapi.service.agent.v1.model.CreateFileReqBody;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import com.sun.net.httpserver.HttpServer;
import com.lark.oapi.core.httpclient.*;
import com.lark.oapi.okhttp.OkHttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.config.RequestConfig;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.lang.reflect.InvocationTargetException;
import com.google.gson.annotations.SerializedName;

public class TestUploadFilename {
    @Test
    public void explicitFilenameOverridesLocalName() throws Exception {
        for (String name : new String[]{"report.txt", "中文报告.txt"}) {
            CreateFileReqBody body = CreateFileReqBody.newBuilder()
                    .file(new File("local.tmp")).filename(name).build();
            FormData form = encode(body);
            assertEquals(name, form.getFiles().get(0).getFileName());
            assertEquals(name, form.getParams().get("filename"));
            assertEquals("local.tmp", form.getFiles().get(0).getFile().getName());
        }
    }

    @Test
    public void absentFilenameUsesLocalName() throws Exception {
        CreateFileReqBody body = CreateFileReqBody.newBuilder().file(new File("local.txt")).build();
        assertEquals("local.txt", encode(body).getFiles().get(0).getFileName());
    }

    @Test
    public void rejectsUnsafeExplicitFilenames() throws Exception {
        for (String name : new String[]{"../report.txt", "sub/report.txt", "sub\\report.txt", "bad\r\nname", "bad\0name"}) {
            try {
                encode(CreateFileReqBody.newBuilder().file(new File("local.txt")).filename(name).build());
                fail("expected upload filename rejection");
            } catch (InvocationTargetException error) {
                assertTrue(error.getCause() instanceof IllegalArgumentException);
            }
        }
    }

    private static class OtherUpload {
        @SerializedName("file")
        private final File file = new File("local.txt");
        @SerializedName("filename")
        private final String filename = "business-name.txt";
    }

    @Test
    public void unmappedFilenameDoesNotOverrideFile() throws Exception {
        assertEquals("local.txt", encode(new OtherUpload()).getFiles().get(0).getFileName());
    }

    @Test
    public void bothTransportsSendExplicitFilename() throws Exception {
        for (String name : new String[]{"report.txt", "中文报告.txt"}) {
            exerciseTransport(name, false);
            exerciseTransport(name, true);
        }
    }

    private void exerciseTransport(String name, boolean apache) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        CompletableFuture<String> captured = new CompletableFuture<>();
        server.createContext("/upload", exchange -> {
            try (java.io.InputStream input = exchange.getRequestBody()) {
                captured.complete(new String(input.readAllBytes(), StandardCharsets.UTF_8));
                exchange.sendResponseHeaders(200, 0);
            } catch (Exception error) {
                captured.completeExceptionally(error);
            } finally {
                exchange.close();
            }
        });
        File local = File.createTempFile("sdk-upload-", ".tmp");
        OkHttpClient ok = new OkHttpClient.Builder().callTimeout(3, TimeUnit.SECONDS).build();
        try (CloseableHttpClient http = HttpClients.custom().setDefaultRequestConfig(
                RequestConfig.custom().setConnectTimeout(3000).setSocketTimeout(3000).build()).build()) {
            Files.write(local.toPath(), "contents".getBytes(StandardCharsets.UTF_8));
            server.start();
            RawRequest request = new RawRequest();
            request.setReqUrl("http://127.0.0.1:" + server.getAddress().getPort() + "/upload");
            request.setHttpMethod("POST");
            request.setHeaders(Collections.emptyMap());
            request.setBody(encode(CreateFileReqBody.newBuilder().file(local).filename(name).build()));
            IHttpTransport transport = apache ? ApacheHttpClientTransport.newBuilder().httpclient(http).build()
                    : new OkHttpTransport(ok);
            assertEquals(200, transport.execute(request).getStatusCode());
            String wire = captured.get(3, TimeUnit.SECONDS);
            assertTrue(wire, wire.contains("filename=\"" + name + "\""));
            assertTrue(wire, wire.contains("\r\n\r\n" + name + "\r\n"));
            assertTrue(wire, wire.contains("contents"));
        } finally {
            server.stop(0);
            ok.connectionPool().evictAll();
            ok.dispatcher().executorService().shutdown();
            Files.delete(local.toPath());
        }
    }

    private FormData encode(Object body) throws Exception {
        Method method = ReqTranslator.class.getDeclaredMethod("buildFormData", Object.class);
        method.setAccessible(true);
        return (FormData) method.invoke(new ReqTranslator(), body);
    }
}
