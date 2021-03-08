package com.larksuite.oapi.core.api.request;

import com.larksuite.oapi.core.api.tools.IOs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FormDataFile {

    private String fieldName;
    private String name;
    private String type;
    private ByteArrayInputStream content;
    private InputStream contentStream;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getName() {
        return name;
    }

    public FormDataFile setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public FormDataFile setType(String type) {
        this.type = type;
        return this;
    }

    public FormDataFile setContent(byte[] content) {
        this.content = new ByteArrayInputStream(content);
        return this;
    }

    public FormDataFile setContentStream(InputStream contentStream) {
        this.contentStream = contentStream;
        return this;
    }

    public InputStream content() {
        if (this.contentStream != null) {
            return this.contentStream;
        }
        return this.content;
    }

    public void write(OutputStream output) throws IOException {
        try {
            IOs.copy(content(), output);
        } finally {
            content().close();
        }
    }
}
