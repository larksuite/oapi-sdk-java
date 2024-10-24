// Code generated by lark suite oapi sdk gen
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

package com.lark.oapi.service.aily.v1.enums;

/**
 * 数据资源类型
 */
public enum DataAssetDataSourceTypeEnum {
    EXCEL("excel"), // excel
    PDF("pdf"), // pdf
    PPTX("pptx"), // pptx
    TXT("txt"), // txt
    DOCX("docx"), // docx
    MYSQL("mysql"), // mysql
    POSTGRESQL("postgresql"), // postgresql
    LARKBASE("larkbase"), // 飞书多维表格
    SALESFORCE("salesforce"), // salesforce
    FENXIANGXIAOKE("fenxiangxiaoke"), // 分享逍客
    QIANCHUAN("qianchuan"), // 巨量千川
    CLICKHOUSE("clickhouse"), // clickhouse
    DATABRICKS("databricks"), // databricks
    SERVICEDESK("servicedesk"), // 飞书服务台
    LARKBIZ_WIKI("larkbiz_wiki"), // 飞书Wiki
    LARKBIZ_DOC("larkbiz_doc"), // 飞书doc
    LARKBIZ_DOCS("larkbiz_docs"), // 飞书docs
    LARKBIZ_DOCX("larkbiz_docx"), // 飞书docx
    LARKBIZ_PDF("larkbiz_pdf"), // 飞书pdf
    LARKBIZ_WORD("larkbiz_word"), // 飞书word
    LARKBIZ_PPTX("larkbiz_pptx"), // 飞书pptx
    LARKBIZ_SHEETS("larkbiz_sheets"), // 飞书文档
    LARKBIZ_BASE("larkbiz_base"), // 飞书多维表格
    LARKBIZ_PERSONALFOLDER("larkbiz_personalfolder"), // 飞书个人文件夹
    LARKBIZ_SHAREDFOLDER("larkbiz_sharedfolder"), // 飞书共享文件夹
    OBJECT("object"), // 数据表
    ;
    private String value;

    DataAssetDataSourceTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}