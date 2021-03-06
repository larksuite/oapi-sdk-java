package com.larksuite.oapi.core.api.tools;

import com.larksuite.oapi.okhttp3_14.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Files {

    /**
     * @param url File net url
     * @return InputStream must close!!!!
     * @throws IOException IO exception
     */
    public static InputStream DownloadFileToStream(String url) throws IOException {
        com.larksuite.oapi.okhttp3_14.Request request = new com.larksuite.oapi.okhttp3_14.Request.Builder().url(url).get().build();
        Response response = OKHttps.defaultClient.newCall(request).execute();
        return Objects.requireNonNull(response.body()).byteStream();
    }

    /**
     * @param url File net url
     * @return File bytes
     * @throws IOException IO exception
     */
    public static byte[] DownloadFile(String url) throws IOException {
        com.larksuite.oapi.okhttp3_14.Request request = new com.larksuite.oapi.okhttp3_14.Request.Builder().url(url).get().build();
        Response response = OKHttps.defaultClient.newCall(request).execute();
        return Objects.requireNonNull(response.body()).bytes();
    }
}
