package com.larksuite.oapi.sample.tools;

import com.larksuite.oapi.core.api.tools.Files;
import com.larksuite.oapi.core.api.tools.IOs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileDownloadSample {

    public static final String URL = "https://sf1-ttcdn-tos.pstatp.com/obj/open-platform-opendoc/b7f456f542e8811e82657e577f126bce_WfFUj8sO1i.png";

    public static void main(String[] args) throws IOException {
        //download1();
        download2();
    }

    // file bytes
    private static void download1() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("download.png");
        byte[] bs = Files.DownloadFile(URL);
        fileOutputStream.write(bs);
        fileOutputStream.close();
    }

    // file stream
    private static void download2() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("download2.png");
        InputStream fileStream = Files.DownloadFileToStream(URL);
        IOs.copy(fileStream, fileOutputStream);
        fileOutputStream.close();
        fileStream.close();
    }
}
