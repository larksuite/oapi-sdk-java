// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;

import com.larksuite.oapi.core.response.BaseResponse;
import com.larksuite.oapi.core.utils.Strings;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class GetFileResp extends BaseResponse {

    private ByteArrayOutputStream fileStream;
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ByteArrayOutputStream getFileStream() {
        return fileStream;
    }

    public void setFileStream(ByteArrayOutputStream fileStream) {
        this.fileStream = fileStream;
    }

    public void writeFile(String path) throws IOException {
        if (Strings.isEmpty(path)) {
            throw new RuntimeException("path is blank");
        }
        FileOutputStream file = new FileOutputStream(path);
        file.write(getFileStream().toByteArray());
        file.close();
    }
}