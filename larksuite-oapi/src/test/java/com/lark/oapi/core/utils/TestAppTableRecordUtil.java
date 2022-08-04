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
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class TestAppTableRecordUtil {

  @Test
  public void testUtil() {
    Map<String, Object> map = new HashMap<>();
    map.put("bool", true);
    map.put("str", "zhailuxu");
    map.put("strList", new String[]{"zlx1", "gh2"});
    map.put("urlList", new Url[]{Url.newBuilder().text("t1").link("l1").build(),
        Url.newBuilder().text("t2").link("l2").build()});
    map.put("personList", new Person[]{Person.newBuilder().email("e1").id("id1").name("n1").build(),
        Person.newBuilder().email("e2").id("id2").name("n2").build()});
    map.put("attatchList", new Attachment[]{Attachment.newBuilder().fileToken("f1").size(1).build(),
        Attachment.newBuilder().fileToken("f2").size(2).build()});

    AppTableRecord appTableRecord = new AppTableRecord();
    appTableRecord.setFields(map);

    System.out.println(
        Jsons.DEFAULT.toJson(AppTableRecordUtil.getBooleanField(appTableRecord, "bool")));
    System.out.println(
        Jsons.DEFAULT.toJson(AppTableRecordUtil.getStringField(appTableRecord, "str")));
    System.out.println(
        Jsons.DEFAULT.toJson(AppTableRecordUtil.getStringListField(appTableRecord, "strList")));
    System.out.println(
        Jsons.DEFAULT.toJson(AppTableRecordUtil.getUrlListField(appTableRecord, "urlList")));
    System.out.println(
        Jsons.DEFAULT.toJson(AppTableRecordUtil.getPersonListField(appTableRecord, "personList")));
    System.out.println(Jsons.DEFAULT.toJson(
        AppTableRecordUtil.getAttachmentListField(appTableRecord, "attatchList")));

  }
}
