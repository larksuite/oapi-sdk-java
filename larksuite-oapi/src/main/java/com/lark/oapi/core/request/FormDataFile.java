package com.lark.oapi.core.request;


import java.io.File;

public class FormDataFile {

  private String fieldName;
  private String fileName;
  private String type;
  private String filePath;
  private File file;

  public File getFile() {
    return file;
  }

  public void setFile(File file) {
    this.file = file;
  }

  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public String getFileName() {
    return fileName;
  }

  public FormDataFile setFileName(String name) {
    this.fieldName = name;
    return this;
  }

  public String getType() {
    return type;
  }

  public FormDataFile setType(String type) {
    this.type = type;
    return this;
  }


}
