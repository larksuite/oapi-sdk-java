/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lark.oapi.core.utils;

import com.lark.oapi.service.bitable.v1.model.AppTableRecord;
import com.lark.oapi.service.bitable.v1.model.Attachment;
import com.lark.oapi.service.bitable.v1.model.Person;
import com.lark.oapi.service.bitable.v1.model.Url;

public class AppTableRecordUtil {

  public static String getStringField(AppTableRecord appTableRecord, String key) {
    if (appTableRecord == null || appTableRecord.getFields() == null) {
      return null;
    }

    if (appTableRecord.getFields().containsKey(key)) {
      return (String) appTableRecord.getFields().get(key);
    }
    return null;
  }

  public static Boolean getBooleanField(AppTableRecord appTableRecord, String key) {
    if (appTableRecord == null || appTableRecord.getFields() == null) {
      return null;
    }

    if (appTableRecord.getFields().containsKey(key)) {
      return (Boolean) appTableRecord.getFields().get(key);
    }
    return null;
  }

  public static String[] getStringListField(AppTableRecord appTableRecord, String key) {
    if (appTableRecord == null || appTableRecord.getFields() == null) {
      return null;
    }

    if (appTableRecord.getFields().containsKey(key)) {
      return (String[]) appTableRecord.getFields().get(key);
    }
    return null;
  }

  public static Url[] getUrlListField(AppTableRecord appTableRecord, String key) {
    if (appTableRecord == null || appTableRecord.getFields() == null) {
      return null;
    }

    if (appTableRecord.getFields().containsKey(key)) {
      return (Url[]) appTableRecord.getFields().get(key);
    }
    return null;
  }

  public static Person[] getPersonListField(AppTableRecord appTableRecord, String key) {
    if (appTableRecord == null || appTableRecord.getFields() == null) {
      return null;
    }

    if (appTableRecord.getFields().containsKey(key)) {
      return (Person[]) appTableRecord.getFields().get(key);
    }
    return null;
  }

  public static Attachment[] getAttachmentListField(AppTableRecord appTableRecord, String key) {
    if (appTableRecord == null || appTableRecord.getFields() == null) {
      return null;
    }

    if (appTableRecord.getFields().containsKey(key)) {
      return (Attachment[]) appTableRecord.getFields().get(key);
    }
    return null;
  }
}
