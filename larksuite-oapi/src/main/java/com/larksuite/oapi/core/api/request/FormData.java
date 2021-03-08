package com.larksuite.oapi.core.api.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormData {
    private final Map<String, Object> params;
    private final List<FormDataFile> files;

    public FormData() {
        this.params = new HashMap<>();
        this.files = new ArrayList<>();
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public List<FormDataFile> getFiles() {
        return files;
    }

    public void addFile(String field, FormDataFile file) {
        file.setFieldName(field);
        this.files.add(file);
    }

    public void addField(String field, Object val) {
        this.params.put(field, val);
    }

}
