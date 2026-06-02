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

package com.lark.oapi.sample.api;

import com.lark.oapi.Client;
import com.lark.oapi.card.enums.MessageCardButtonTypeEnum;
import com.lark.oapi.card.enums.MessageCardHeaderTemplateEnum;
import com.lark.oapi.card.model.*;
import com.lark.oapi.core.cache.LocalCache;
import com.lark.oapi.core.enums.AppType;
import com.lark.oapi.core.enums.BaseUrlEnum;
import com.lark.oapi.core.exception.ClientTimeoutException;
import com.lark.oapi.core.exception.ServerTimeoutException;
import com.lark.oapi.core.httpclient.IHttpTransport;
import com.lark.oapi.core.request.FormData;
import com.lark.oapi.core.request.FormDataFile;
import com.lark.oapi.core.request.RawRequest;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.service.drive.v1.model.DownloadFileReq;
import com.lark.oapi.service.drive.v1.model.DownloadFileResp;
import com.lark.oapi.service.im.v1.enums.CreateFileCreateFileFileTypeEnum;
import com.lark.oapi.service.im.v1.enums.CreateImageCreateImageImageTypeEnum;
import com.lark.oapi.service.im.v1.enums.MsgTypeEnum;
import com.lark.oapi.service.im.v1.enums.ReceiveIdTypeEnum;
import com.lark.oapi.service.im.v1.enums.ext.*;
import com.lark.oapi.service.im.v1.model.*;
import com.lark.oapi.service.im.v1.model.ext.*;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ImSample {

    private static IHttpTransport httpTransport = new IHttpTransport() {
        private CloseableHttpClient httpclient = HttpClients.createDefault();

        @Override
        public RawResponse execute(RawRequest rawRequest) throws Exception {
            // 转换request
            HttpEntityEnclosingRequestBase request = new HttpEntityEnclosingRequestBase() {
                @Override
                public String getMethod() {
                    return rawRequest.getHttpMethod();
                }
            };

            request.setURI(URI.create(rawRequest.getReqUrl()));
            for (Map.Entry<String, List<String>> entry : rawRequest.getHeaders().entrySet()) {
                String key = entry.getKey();
                for (String value : entry.getValue()) {
                    request.addHeader(key, value);
                }
            }

            if (rawRequest.getBody() != null) {
                Object body = rawRequest.getBody();
                if (body instanceof FormData) {
                    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
                    builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
                    builder.setContentType(ContentType.create(ContentType.MULTIPART_FORM_DATA.getMimeType()));
                    for (FormDataFile file : ((FormData) rawRequest.getBody()).getFiles()) {
                        builder.addBinaryBody(file.getFieldName(), file.getFile(),
                                ContentType.APPLICATION_OCTET_STREAM,
                                Strings.isEmpty(file.getFileName()) ? "unknown" : file.getFileName());
                    }
                    for (Map.Entry<String, Object> entry : ((FormData) rawRequest.getBody()).getParams()
                            .entrySet()) {
                        builder.addTextBody(entry.getKey(), (String) entry.getValue());
                    }

                    request.setEntity(builder.build());
                } else {
                    StringEntity entity;
                    if (rawRequest.isSupportLong2String()) {
                        entity = new StringEntity(Jsons.LONG_TO_STR.toJson(rawRequest.getBody()));
                    } else {
                        entity = new StringEntity(Jsons.DEFAULT.toJson(rawRequest.getBody()));
                    }
                    request.setEntity(entity);
                }
            }

            // 发起调用
            CloseableHttpResponse response = httpclient.execute(request);

            // 转换结果为通用结果
            byte[] result = EntityUtils.toByteArray(response.getEntity());
            RawResponse rawResponse = new RawResponse();
            rawResponse.setStatusCode(response.getStatusLine().getStatusCode());
            rawResponse.setBody(result);
            rawResponse.setContentType(rawResponse.getContentType());
            Map<String, List<String>> headers = new HashMap<>();
            for (Header header : response.getAllHeaders()) {
                if (headers.containsKey(header.getName())) {
                    headers.get(header.getName()).add(header.getValue());
                } else {
                    List<String> values = new ArrayList<>();
                    values.add(header.getValue());
                    headers.put(header.getName(), values);
                }
            }
            rawResponse.setHeaders(headers);
            return rawResponse;
        }
    };

    public static void sendTextMsg(Client client) {
        // 使用Builder模式构建请求对象
        CreateMessageReq req = CreateMessageReq.newBuilder()
                .receiveIdType(ReceiveIdTypeEnum.OPEN_ID.getValue())
                .createMessageReqBody(CreateMessageReqBody.newBuilder()
                        .receiveId("ou_e7dae3dd13a73c25142e5776fece7732")
                        .msgType(MsgTypeEnum.MSG_TYPE_TEXT.getValue())
                        .content(MessageText.newBuilder()
                                .atUser("ou_155184d1e73cbfb8973e5a9e698e74f2", "tom")
                                .text(" test content")
                                .newLine()
                                .textLine("jiaduo")
                                .atAll()
                                .text("注意告警")
                                .build())
                        .build())
                .build();

        // 发起请求，并处理结果
        try {
            CreateMessageResp resp = client.im().message().create(req);
            if (resp.getCode() != 0) {
                System.out.println(String.format("code:%d,msg:%s,err:%s"
                        , resp.getCode(), resp.getMsg(), Jsons.DEFAULT.toJson(resp.getError())));
                return;
            }

            // 业务处理结果
            System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
            // 原生http信息
            System.out.println(Jsons.DEFAULT.toJson(resp.getRawResponse()));
            // 返回请求ID
            System.out.println(resp.getRequestId());
        } catch (ServerTimeoutException e) {
            // 服务端超时异常处理
            System.out.println(e.getMessage());
            return;
        } catch (ClientTimeoutException e) {
            // 客户端超时异常处理
            System.out.println(e.getMessage());
            return;
        } catch (IllegalArgumentException e) {
            // 参数非法异常处理
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            // 其他异常处理
            System.out.println(e.getMessage());
            return;
        }
    }

    public static void delMsg(Client client) throws Exception {
        // 使用Builder模式构建请求对象
        DeleteMessageReq req = DeleteMessageReq.newBuilder()
                .messageId("om_b5fe878cb07f5f0167cd0f4bf4cfe978")
                .build();

        // 发起请求，并处理结果
        DeleteMessageResp resp = client.im().message().delete(req);
        if (resp.getCode() != 0) {
            System.out.println(String.format("code:%d,msg:%s,err:%s"
                    , resp.getCode(), resp.getMsg(), Jsons.DEFAULT.toJson(resp.getError())));
            return;
        }

        // 业务处理结果
        EmptyData data = resp.getData();
        System.out.println(data);
        // 原生http信息
        System.out.println(Jsons.DEFAULT.toJson(resp.getRawResponse()));
        // 返回请求ID
        System.out.println(resp.getRequestId());
    }

    public static void sendInteractiveMonitorMsg(Client client) throws Exception {
        // 配置
        MessageCardConfig config = MessageCardConfig.newBuilder()
                .enableForward(true)
                .wideScreenMode(true)
                .updateMulti(true)
                .build();

        // cardUrl
        MessageCardURL cardURL = MessageCardURL.newBuilder()
                .pcUrl("http://www.baidu.com")
                .iosUrl("http://www.google.com")
                .url("http://open.feishu.com")
                .androidUrl("http://www.jianshu.com")
                .build();

        // header
        MessageCardHeader header = MessageCardHeader.newBuilder()
                .template(MessageCardHeaderTemplateEnum.RED)
                .title(MessageCardPlainText.newBuilder()
                        .content("1 级报警 - 数据平台")
                        .build())
                .build();

        //elements
        MessageCardDiv div1 = MessageCardDiv.newBuilder()
                .fields(new MessageCardField[]{
                        MessageCardField.newBuilder()
                                .isShort(true)
                                .text(MessageCardLarkMd.newBuilder()
                                        .content("**🕐 时间：**2021-02-23 20:17:51")
                                        .build())
                                .build(),
                        MessageCardField.newBuilder()
                                .isShort(true)
                                .text(MessageCardLarkMd.newBuilder()
                                        .content("**🔢 事件 ID：：**336720")
                                        .build())
                                .build(),
                        MessageCardField.newBuilder()
                                .isShort(false)
                                .text(MessageCardLarkMd.newBuilder()
                                        .content("")
                                        .build())
                                .build(),
                        MessageCardField.newBuilder()
                                .isShort(true)
                                .text(MessageCardLarkMd.newBuilder()
                                        .content("**📋 项目：**\nQA 7")
                                        .build())
                                .build(),
                        MessageCardField.newBuilder()
                                .isShort(true)
                                .text(MessageCardLarkMd.newBuilder()
                                        .content("**👤 一级值班：**\n<at id=ou_e7dae3dd13a73c25142e5776fece7732>加多</at>")
                                        .build())
                                .build(),
                        MessageCardField.newBuilder()
                                .isShort(false)
                                .text(MessageCardLarkMd.newBuilder()
                                        .content("")
                                        .build())
                                .build(),
                        MessageCardField.newBuilder()
                                .isShort(true)
                                .text(MessageCardLarkMd.newBuilder()
                                        .content("**👤 二级值班：**\n<at id=ou_e7dae3dd13a73c25142e5776fece7732>加多</at>")
                                        .build())
                                .build()
                })
                .build();

        MessageCardImage image = MessageCardImage.newBuilder()
                .alt(MessageCardPlainText.newBuilder()
                        .content("")
                        .build())
                .imgKey("img_v2_8b2ebeaf-c97c-411d-a4dc-4323e8cba10g")
                .title(MessageCardLarkMd.newBuilder()
                        .content("支付方式 支付成功率低于 50%：")
                        .build())
                .build();

        MessageCardNote note = MessageCardNote.newBuilder()
                .elements(new IMessageCardNoteElement[]{MessageCardPlainText.newBuilder()
                        .content("🔴 支付失败数  🔵 支付成功数")
                        .build()})
                .build();

        Map<String, Object> value = new HashMap<>();
        value.put("key1", "value1");
        MessageCardAction cardAction = MessageCardAction.newBuilder()
                .actions(new IMessageCardActionElement[]{
                        MessageCardEmbedButton.newBuilder()
                                .buttonType(MessageCardButtonTypeEnum.PRIMARY)
                                .value(value)
                                .text(MessageCardPlainText.newBuilder().content("跟进处理").build())
                                .build(),
                        MessageCardEmbedSelectMenuStatic.newBuilder()
                                .options(new MessageCardEmbedSelectOption[]{
                                        MessageCardEmbedSelectOption.newBuilder()
                                                .value("1")
                                                .text(MessageCardPlainText.newBuilder()
                                                        .content("屏蔽10分钟")
                                                        .build())
                                                .build(),
                                        MessageCardEmbedSelectOption.newBuilder()
                                                .value("2")
                                                .text(MessageCardPlainText.newBuilder()
                                                        .content("屏蔽30分钟")
                                                        .build())
                                                .build(),
                                        MessageCardEmbedSelectOption.newBuilder()
                                                .value("3")
                                                .text(MessageCardPlainText.newBuilder()
                                                        .content("屏蔽1小时")
                                                        .build())
                                                .build(),
                                        MessageCardEmbedSelectOption.newBuilder()
                                                .value("4")
                                                .text(MessageCardPlainText.newBuilder()
                                                        .content("屏蔽24小时")
                                                        .build())
                                                .build()
                                })
                                .placeholder(MessageCardPlainText.newBuilder()
                                        .content("暂时屏蔽报警")
                                        .build())
                                .value(value)
                                .build()
                })
                .build();

        MessageCardHr hr = MessageCardHr.newBuilder().build();

        MessageCardDiv div2 = MessageCardDiv.newBuilder()
                .text(MessageCardLarkMd.newBuilder()
                        .content(
                                "🙋🏼 [我要反馈误报](https://open.feishu.cn/) | 📝 [录入报警处理过程](https://open.feishu.cn/)")
                        .build())
                .extra(MessageCardEmbedOverflow.newBuilder()
                        .options(new MessageCardEmbedSelectOption[]{MessageCardEmbedSelectOption.newBuilder()
                                .text(MessageCardPlainText.newBuilder()
                                        .content("text")
                                        .build())
                                .build()})
                        .build())
                .build();

        MessageCardLayoutColumn layoutLeftColumn = MessageCardLayoutColumn.newBuilder()
                .width(MessageCardColumnWidthEnum.WEIGHTED)
                .weight(2)
                .verticalAlign(MessageCardColumnVerticalAlignEnum.CENTER)
                .columns(new MessageCardElement[]{
                        MessageCardLayoutMarkdown.newBuilder()
                                .textAlign(MessageCardLayoutTextAlignEnum.CENTER)
                                .content("多列布局左侧")
                                .build()
                })
                .build();
        MessageCardLayoutColumn layoutRightColumn = MessageCardLayoutColumn.newBuilder()
                .width(MessageCardColumnWidthEnum.WEIGHTED)
                .weight(1)
                .verticalAlign(MessageCardColumnVerticalAlignEnum.CENTER)
                .columns(new MessageCardElement[]{
                        MessageCardLayoutMarkdown.newBuilder()
                                .textAlign(MessageCardLayoutTextAlignEnum.CENTER)
                                .content("多列布局右侧")
                                .build()
                })
                .build();
        MessageCardLayout messageCardLayout = MessageCardLayout.newBuilder()
                .flexMode(MessageCardLayoutFlexModeEnum.NONE)
                .backgroundStyle(MessageCardBackgroundStyleEnum.GREY)
                .horizontalSpacing(MessageCardHorizontalSpacingEnum.DEFAULT)
                .columns(new MessageCardLayoutColumn[]{layoutLeftColumn, layoutRightColumn})
                .build();

        MessageCard card = MessageCard.newBuilder()
                .cardLink(cardURL)
                .config(config)
                .header(header)
                .elements(new MessageCardElement[]{div1, note, image, cardAction, hr, div2, messageCardLayout})
                .build();

        // 使用Builder模式构建请求对象
        CreateMessageReq req = CreateMessageReq.newBuilder()
                .receiveIdType(ReceiveIdTypeEnum.OPEN_ID.getValue())
                .createMessageReqBody(CreateMessageReqBody.newBuilder()
                        .receiveId("ou_e7dae3dd13a73c25142e5776fece7732")
                        .msgType(MsgTypeEnum.MSG_TYPE_INTERACTIVE.getValue())
                        .content(card.String())
                        .build())
                .build();

        CreateMessageResp resp = client.im().message().create(req);
        if (!resp.success()) {
            System.out.println(String.format("code:%d,msg:%s,err:%s"
                    , resp.getCode(), resp.getMsg(), Jsons.DEFAULT.toJson(resp.getError())));
            return;
        }

        // 业务处理结果
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
        // 原生http信息
        System.out.println(Jsons.DEFAULT.toJson(resp.getRawResponse()));
        // 返回请求ID
        System.out.println(resp.getRequestId());
        System.out.println(Jsons.DEFAULT.toJson(resp.getRequest()));
    }

    public static void sendInteractiveMonitorProcessedMsg(Client client) throws Exception {
        // 配置
        MessageCardConfig config = MessageCardConfig.newBuilder()
                .wideScreenMode(true)
                .build();

        // header
        MessageCardHeader header = MessageCardHeader.newBuilder()
                .template(MessageCardHeaderTemplateEnum.TURQUOISE)
                .title(MessageCardPlainText.newBuilder()
                        .content("【已处理】1 级报警 - 数据平台")
                        .build())
                .build();

        //elements
        MessageCardDiv div1 = MessageCardDiv.newBuilder()
                .fields(new MessageCardField[]{
                        MessageCardField.newBuilder()
                                .isShort(true)
                                .text(MessageCardLarkMd.newBuilder()
                                        .content("**🕐 时间：**2021-02-23 20:17:51")
                                        .build())
                                .build(),
                        MessageCardField.newBuilder()
                                .isShort(true)
                                .text(MessageCardLarkMd.newBuilder()
                                        .content("**🔢 事件 ID：：**336720")
                                        .build())
                                .build(),
                        MessageCardField.newBuilder()
                                .isShort(false)
                                .text(MessageCardLarkMd.newBuilder()
                                        .content("")
                                        .build())
                                .build(),
                        MessageCardField.newBuilder()
                                .isShort(true)
                                .text(MessageCardLarkMd.newBuilder()
                                        .content("**📋 项目：**\nQA 7")
                                        .build())
                                .build(),
                        MessageCardField.newBuilder()
                                .isShort(true)
                                .text(MessageCardLarkMd.newBuilder()
                                        .content("**👤 一级值班：**\n<at id=ou_e3f3fca5204cdf7552531c84a32f60d1>加多</at>")
                                        .build())
                                .build(),
                        MessageCardField.newBuilder()
                                .isShort(false)
                                .text(MessageCardLarkMd.newBuilder()
                                        .content("")
                                        .build())
                                .build(),
                        MessageCardField.newBuilder()
                                .isShort(true)
                                .text(MessageCardLarkMd.newBuilder()
                                        .content("**👤 二级值班：**\n<at id=ou_e3f3fca5204cdf7552531c84a32f60d1>加多</at>")
                                        .build())
                                .build()
                })
                .build();

        MessageCardImage image = MessageCardImage.newBuilder()
                .alt(MessageCardPlainText.newBuilder()
                        .content("")
                        .build())
                .imgKey("img_v2_8b2ebeaf-c97c-411d-a4dc-4323e8cba10g")
                .title(MessageCardLarkMd.newBuilder()
                        .content("支付方式 支付成功率低于 50%：")
                        .build())
                .build();

        MessageCardNote note = MessageCardNote.newBuilder()
                .elements(new IMessageCardNoteElement[]{MessageCardPlainText.newBuilder()
                        .content("🔴 支付失败数  🔵 支付成功数")
                        .build()})
                .build();

        MessageCardHr hr = MessageCardHr.newBuilder().build();

        MessageCardDiv div2 = MessageCardDiv.newBuilder()
                .text(MessageCardLarkMd.newBuilder()
                        .content(
                                "🙋🏼 [我要反馈误报](https://open.feishu.cn/) | 📝 [录入报警处理过程](https://open.feishu.cn/)")
                        .build())
                .build();

        MessageCardNote note2 = MessageCardNote.newBuilder()
                .elements(new IMessageCardNoteElement[]{MessageCardPlainText.newBuilder()
                        .content("✅ 李健已处理此报警")
                        .build()})
                .build();

        MessageCard card = MessageCard.newBuilder()
                .config(config)
                .header(header)
                .elements(new MessageCardElement[]{div1, note, image, note2, hr, div2})
                .build();

        // 使用Builder模式构建请求对象
        CreateMessageReq req = CreateMessageReq.newBuilder()
                .receiveIdType(ReceiveIdTypeEnum.OPEN_ID.getValue())
                .createMessageReqBody(CreateMessageReqBody.newBuilder()
                        .receiveId("ou_e3f3fca5204cdf7552531c84a32f60d1")
                        .msgType(MsgTypeEnum.MSG_TYPE_INTERACTIVE.getValue())
                        .content(card.String())
                        .build())
                .build();

        CreateMessageResp resp = client.im().message().create(req);
        if (!resp.success()) {
            System.out.println(String.format("code:%d,msg:%s,err:%s"
                    , resp.getCode(), resp.getMsg(), Jsons.DEFAULT.toJson(resp.getError())));
            return;
        }

        // 业务处理结果
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
        // 原生http信息
        System.out.println(Jsons.DEFAULT.toJson(resp.getRawResponse()));
        // 返回请求ID
        System.out.println(resp.getRequestId());
    }

    public static void sendImageMsg(Client client) throws Exception {
        // 使用Builder模式构建请求对象
        CreateMessageReq req = CreateMessageReq.newBuilder()
                .receiveIdType(ReceiveIdTypeEnum.OPEN_ID.getValue())
                .createMessageReqBody(CreateMessageReqBody.newBuilder()
                        .receiveId("ou_e3f3fca5204cdf7552531c84a32f60d1")
                        .msgType(MsgTypeEnum.MSG_TYPE_IMAGE.getValue())
                        .content(MessageImage.newBuilder()
                                .imageKey("img_v2_9068cbd5-71d8-4799-b29e-a01650b1328g")
                                .build())
                        .build())
                .build();

        // 发起请求，并处理结果
        Map<String, List<String>> headers = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("ss");
        CreateMessageResp resp = client.im().message()
                .create(req, RequestOptions.newBuilder().headers(headers).build());
        if (resp.getCode() != 0) {
            System.out.println(String.format("code:%d,msg:%s,err:%s"
                    , resp.getCode(), resp.getMsg(), Jsons.DEFAULT.toJson(resp.getError())));
            return;
        }

        // 业务处理结果
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
        // 原生http信息
        System.out.println(Jsons.DEFAULT.toJson(resp.getRawResponse()));
        // 返回请求ID
        System.out.println(resp.getRequestId());
    }

    public static void sendFileMsg(Client client) throws Exception {
        // 使用Builder模式构建请求对象
        CreateMessageReq req = CreateMessageReq.newBuilder()
                .receiveIdType(ReceiveIdTypeEnum.OPEN_ID.getValue())
                .createMessageReqBody(CreateMessageReqBody.newBuilder()
                        .receiveId("ou_e3f3fca5204cdf7552531c84a32f60d1")
                        .msgType(MsgTypeEnum.MSG_TYPE_FILE.getValue())
                        .content(MessageFile.newBuilder()
                                .fileKey("file_v2_5b4e3892-2e0b-43cd-a575-292d622b0dbg")
                                .build())
                        .build())
                .build();

        // 发起请求，并处理结果
        Map<String, List<String>> headers = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("ss");
        CreateMessageResp resp = client.im().message()
                .create(req, RequestOptions.newBuilder().headers(headers).build());
        if (resp.getCode() != 0) {
            System.out.println(String.format("code:%d,msg:%s,err:%s"
                    , resp.getCode(), resp.getMsg(), Jsons.DEFAULT.toJson(resp.getError())));
            return;
        }

        // 业务处理结果
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
        // 原生http信息
        System.out.println(Jsons.DEFAULT.toJson(resp.getRawResponse()));
        // 返回请求ID
        System.out.println(resp.getRequestId());
    }

    public static void sendAudioMsg(Client client) throws Exception {
        // 使用Builder模式构建请求对象
        CreateMessageReq req = CreateMessageReq.newBuilder()
                .receiveIdType(ReceiveIdTypeEnum.OPEN_ID.getValue())
                .createMessageReqBody(CreateMessageReqBody.newBuilder()
                        .receiveId("ou_e3f3fca5204cdf7552531c84a32f60d1")
                        .msgType(MsgTypeEnum.MSG_TYPE_AUDIO.getValue())
                        .content(MessageAudio.newBuilder()
                                .fileKey("file_v2_5b4e3892-2e0b-43cd-a575-292d622b0dbg")
                                .build())
                        .build())
                .build();

        // 发起请求，并处理结果
        Map<String, List<String>> headers = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("ss");
        CreateMessageResp resp = client.im().message()
                .create(req, RequestOptions.newBuilder().headers(headers).build());
        if (resp.getCode() != 0) {
            System.out.println(String.format("code:%d,msg:%s,err:%s"
                    , resp.getCode(), resp.getMsg(), Jsons.DEFAULT.toJson(resp.getError())));
            return;
        }

        // 业务处理结果
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
        // 原生http信息
        System.out.println(Jsons.DEFAULT.toJson(resp.getRawResponse()));
        // 返回请求ID
        System.out.println(resp.getRequestId());
    }

    public static void sendStickerMsg(Client client) throws Exception {
        // 使用Builder模式构建请求对象
        CreateMessageReq req = CreateMessageReq.newBuilder()
                .receiveIdType(ReceiveIdTypeEnum.OPEN_ID.getValue())
                .createMessageReqBody(CreateMessageReqBody.newBuilder()
                        .receiveId("ou_e3f3fca5204cdf7552531c84a32f60d1")
                        .msgType(MsgTypeEnum.MSG_TYPE_STICKER.getValue())
                        .content(MessageSticker.newBuilder()
                                .fileKey("file_v2_5b4e3892-2e0b-43cd-a575-292d622b0dbg")
                                .build())
                        .build())
                .build();

        // 发起请求，并处理结果
        Map<String, List<String>> headers = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("ss");
        CreateMessageResp resp = client.im().message()
                .create(req, RequestOptions.newBuilder().headers(headers).build());
        if (resp.getCode() != 0) {
            System.out.println(String.format("code:%d,msg:%s,err:%s"
                    , resp.getCode(), resp.getMsg(), Jsons.DEFAULT.toJson(resp.getError())));
            return;
        }

        // 业务处理结果
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
        // 原生http信息
        System.out.println(Jsons.DEFAULT.toJson(resp.getRawResponse()));
        // 返回请求ID
        System.out.println(resp.getRequestId());
    }

    public static void sendMediaMsg(Client client) throws Exception {
        // 使用Builder模式构建请求对象
        CreateMessageReq req = CreateMessageReq.newBuilder()
                .receiveIdType(ReceiveIdTypeEnum.OPEN_ID.getValue())
                .createMessageReqBody(CreateMessageReqBody.newBuilder()
                        .receiveId("ou_e3f3fca5204cdf7552531c84a32f60d1")
                        .msgType(MsgTypeEnum.MSG_TYPE_MEDIA.getValue())
                        .content(MessageMedia.newBuilder()
                                .fileKey("file_v2_5b4e3892-2e0b-43cd-a575-292d622b0dbg")
                                .imageKey("img_v121212121")
                                .build())
                        .build())
                .build();

        // 发起请求，并处理结果
        Map<String, List<String>> headers = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("ss");
        CreateMessageResp resp = client.im().message()
                .create(req, RequestOptions.newBuilder().headers(headers).build());
        if (resp.getCode() != 0) {
            System.out.println(String.format("code:%d,msg:%s,err:%s"
                    , resp.getCode(), resp.getMsg(), Jsons.DEFAULT.toJson(resp.getError())));
            return;
        }

        // 业务处理结果
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
        // 原生http信息
        System.out.println(Jsons.DEFAULT.toJson(resp.getRawResponse()));
        // 返回请求ID
        System.out.println(resp.getRequestId());
    }

    public static void sendPostMsg(Client client) throws Exception {
        // 创建a元素
        MessagePostA postA1 = MessagePostA.newBuilder().href("http://www.baidu.com").text("text1")
                .build();
        MessagePostA postA2 = MessagePostA.newBuilder().href("http://www.baidu.com").text("text2")
                .build();

        // 创建At元素
        MessagePostAt at = MessagePostAt.newBuilder()
                .userName("ou_e7dae3dd13a73c25142e5776fece7732")
                .userId("jiaduo")
                .build();

        // 创建图片元素
        MessagePostImage image = MessagePostImage.newBuilder()
                .imageKey("img_v2_9068cbd5-71d8-4799-b29e-a01650b1328g")
                .height(100)
                .width(200)
                .build();

        // 创建文本元素
        MessagePostText text = MessagePostText.newBuilder()
                .text("hello gh")
                .build();

        // 创建段
        List<MessagePostElement> segment1 = MessagePostSegment.newBuilder()
                .element(MessagePostA.newBuilder()
                        .href("http://www.baidu.com")
                        .text("text1")
                        .build())
                .element(postA2)
                .build();

        // 创建段
        List<MessagePostElement> segment2 = MessagePostSegment
                .newBuilder()
                .element(postA1)
                .element(postA2)
                .element(image)
                .element(text)
                .build();

        // 创建段
        List<MessagePostElement> segment3 = MessagePostSegment
                .newBuilder()
                .element(at)
                .element(postA2)
                .build();

        // 使用段创建POST消息内容
        String postContent = MessagePost.newBuilder()
                .zhCn(MessagePostContent.newBuilder()
                        .title("zhcn")
                        .segment(segment1)
                        .segment(segment2)
                        .segment(segment3)
                        .build())
                .enUs(MessagePostContent.newBuilder()
                        .title("enUs")
                        .segment(segment1)
                        .segment(segment3)
                        .build())
                .build();

        // 使用Builder模式构建请求对象
        CreateMessageReq req = CreateMessageReq.newBuilder()
                .receiveIdType(ReceiveIdTypeEnum.OPEN_ID.getValue())
                .createMessageReqBody(CreateMessageReqBody.newBuilder()
                        .receiveId("ou_e7dae3dd13a73c25142e5776fece7732")
                        .msgType(MsgTypeEnum.MSG_TYPE_POST.getValue())
                        .content(postContent)
                        .build())
                .build();

        CreateMessageResp resp = client.im().message().create(req);
        if (!resp.success()) {
            System.out.println(String.format("code:%d,msg:%s,err:%s"
                    , resp.getCode(), resp.getMsg(), Jsons.DEFAULT.toJson(resp.getError())));
            return;
        }

        // 业务处理结果
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
        // 原生http信息
        System.out.println(Jsons.DEFAULT.toJson(resp.getRawResponse()));
        // 返回请求ID
        System.out.println(resp.getRequestId());
    }

    public static void sendPostMsg2(Client client) throws Exception {

        MessagePostA postA1 = MessagePostA.newBuilder().href("http://www.baidu.com").text("text1")
                .build();
        MessagePostA postA2 = MessagePostA.newBuilder().href("http://www.baidu.com").text("text2")
                .build();

        MessagePostAt at = MessagePostAt.newBuilder()
                .userName("ou_e3f3fca5204cdf7552531c84a32f60d1")
                .userId("jiaduo")
                .build();

        MessagePostImage image = MessagePostImage.newBuilder()
                .imageKey("img_v2_9068cbd5-71d8-4799-b29e-a01650b1328g")
                .height(100)
                .width(200)
                .build();

        MessagePostText text = MessagePostText.newBuilder()
                .text("hello gh")
                .build();

        List<MessagePostElement> segment1 = MessagePostSegment.newBuilder()
                .element(MessagePostA.newBuilder()
                        .href("http://www.baidu.com")
                        .text("text1")
                        .build())
                .element(postA2)
                .build();

        List<MessagePostElement> segment2 = MessagePostSegment
                .newBuilder()
                .element(postA1)
                .element(postA2)
                .element(image)
                .element(text)
                .build();

        List<MessagePostElement> segment3 = MessagePostSegment
                .newBuilder()
                .element(at)
                .element(postA2)
                .build();

        String post = MessagePost.newBuilder()
                .zhCn(MessagePostContent.newBuilder()
                        .title("zhcn")
                        .segment(segment1)
                        .segment(segment2)
                        .segment(segment3)
                        .build())
                .enUs(MessagePostContent.newBuilder()
                        .title("enUs")
                        .segment(segment1)
                        .segment(segment3)
                        .build())
                .build();

        // 使用Builder模式构建请求对象
        CreateMessageReq req = CreateMessageReq.newBuilder()
                .receiveIdType(ReceiveIdTypeEnum.OPEN_ID.getValue())
                .createMessageReqBody(CreateMessageReqBody.newBuilder()
                        .receiveId("ou_e3f3fca5204cdf7552531c84a32f60d1")
                        .msgType(MsgTypeEnum.MSG_TYPE_POST.getValue())
                        .content(post)
                        .build())
                .build();

        CreateMessageResp resp = client.im().message().create(req);
        if (resp.getCode() != 0) {
            System.out.println(String.format("code:%d,msg:%s,err:%s"
                    , resp.getCode(), resp.getMsg(), Jsons.DEFAULT.toJson(resp.getError())));
            return;
        }

        // 业务处理结果
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
        // 原生http信息
        System.out.println(Jsons.DEFAULT.toJson(resp.getRawResponse()));
        // 返回请求ID
        System.out.println(resp.getRequestId());
    }

    public static void sendShareChatMsg(Client client) throws Exception {
        // 使用Builder模式构建请求对象
        CreateMessageReq req = CreateMessageReq.newBuilder()
                .receiveIdType(ReceiveIdTypeEnum.OPEN_ID.getValue())
                .createMessageReqBody(CreateMessageReqBody.newBuilder()
                        .receiveId("ou_e3f3fca5204cdf7552531c84a32f60d1")
                        .msgType(MsgTypeEnum.MSG_TYPE_SHARE_CHAT.getValue())
                        .content(
                                MessageShareChat.newBuilder().chatId("oc_4ea14cc15e39ef80a579ca74895a33ff").build())
                        .build())
                .build();

        // 发起请求，并处理结果
        Map<String, List<String>> headers = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("ss");
        CreateMessageResp resp = client.im().message()
                .create(req, RequestOptions.newBuilder().headers(headers).build());
        if (resp.getCode() != 0) {
            System.out.println(String.format("code:%d,msg:%s,err:%s"
                    , resp.getCode(), resp.getMsg(), Jsons.DEFAULT.toJson(resp.getError())));
            return;
        }

        // 业务处理结果
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
        // 原生http信息
        System.out.println(Jsons.DEFAULT.toJson(resp.getRawResponse()));
        // 返回请求ID
        System.out.println(resp.getRequestId());
    }

    public static void sendShareChatUser(Client client) throws Exception {
        // 使用Builder模式构建请求对象
        CreateMessageReq req = CreateMessageReq.newBuilder()
                .receiveIdType(ReceiveIdTypeEnum.OPEN_ID.getValue())
                .createMessageReqBody(CreateMessageReqBody.newBuilder()
                        .receiveId("ou_e3f3fca5204cdf7552531c84a32f60d1")
                        .msgType(MsgTypeEnum.MSG_TYPE_SHARE_USER.getValue())
                        .content(
                                MessageShareUser.newBuilder().userId("ou_487f709a942d16edafe57fd6fbc4bcf5").build())
                        .build())
                .build();

        // 发起请求，并处理结果
        Map<String, List<String>> headers = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("ss");
        CreateMessageResp resp = client.im().message()
                .create(req, RequestOptions.newBuilder().headers(headers).build());
        if (resp.getCode() != 0) {
            System.out.println(String.format("code:%d,msg:%s,err:%s"
                    , resp.getCode(), resp.getMsg(), Jsons.DEFAULT.toJson(resp.getError())));
            return;
        }

        // 业务处理结果
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
        // 原生http信息
        System.out.println(Jsons.DEFAULT.toJson(resp.getRawResponse()));
        // 返回请求ID
        System.out.println(resp.getRequestId());
    }

    public static void uploadImage(Client client) throws Exception {
        // 创建请求对象
        File file = new File("/Users/bytedance/Downloads/go-icon.png");
        CreateImageReq req = CreateImageReq.newBuilder()
                .createImageReqBody(CreateImageReqBody.newBuilder()
                        .imageType(CreateImageCreateImageImageTypeEnum.MESSAGE)
                        .image(file)
                        .build())
                .build();

        // 发起请求
        CreateImageResp resp = client.im().image().create(req, RequestOptions.newBuilder()
                .requestId("requestid-value")
                .build());
        if (resp.getCode() != 0) {
            System.out.println(String.format("code:%d,msg:%s,err:%s"
                    , resp.getCode(), resp.getMsg(), Jsons.DEFAULT.toJson(resp.getError())));
            return;
        }

        System.out.println(Jsons.DEFAULT.toJson(resp));
        // 原生http信息
        System.out.println(Jsons.DEFAULT.toJson(resp.getRawResponse()));
        // 返回请求ID
        System.out.println(resp.getRequestId());
    }

    public static void uploadFile(Client client) throws Exception {
        // 创建请求对象
        CreateFileReq req = CreateFileReq.newBuilder()
                .createFileReqBody(CreateFileReqBody.newBuilder()
                        .fileType(CreateFileCreateFileFileTypeEnum.PDF)
                        .fileName("db.pdf")
                        .file(new File("/Users/bytedance/Downloads/redis.pdf"))
                        .build())
                .build();

        // 发起请求
        CreateFileResp resp = client.im().file().create(req);
        if (resp.getCode() != 0) {
            System.out.println(String.format("code:%d,msg:%s,err:%s"
                    , resp.getCode(), resp.getMsg(), Jsons.DEFAULT.toJson(resp.getError())));
            return;
        }

        System.out.println(Jsons.DEFAULT.toJson(resp.getData().getFileKey()));
        // 原生http信息
        System.out.println(Jsons.DEFAULT.toJson(resp.getRawResponse()));
        // 返回请求ID
        System.out.println(resp.getRequestId());
    }

    public static void downLoadFile(Client client) throws Exception {
        // 创建请求对象
        GetFileReq req = GetFileReq.newBuilder().fileKey("file_v2_5b4e3892-2e0b-43cd-a575-292d622b0dbg")
                .build();

        // 发起请求
        GetFileResp resp = client.im().file().get(req);
        if (resp.getCode() != 0) {
            System.out.println(String.format("code:%d,msg:%s,err:%s"
                    , resp.getCode(), resp.getMsg(), Jsons.DEFAULT.toJson(resp.getError())));
            return;
        }

        // 写入文件到本地磁盘
        FileOutputStream file = new FileOutputStream("rocket-jiaduo.pdf");
        file.write(resp.getData().toByteArray());
        file.close();
        // 返回请求ID
        System.out.println(resp.getRequestId());
        System.out.println(resp.getFileName());
        System.out.println(Jsons.DEFAULT.toJson(resp.getRawResponse().getHeaders()));
    }

    public static void downLoadFile2(Client client) throws Exception {
        // 创建请求对象
        GetFileReq req = GetFileReq.newBuilder().fileKey("file_v2_5b4e3892-2e0b-43cd-a575-292d622b0dbg")
                .build();

        // 发起请求
        GetFileResp resp = client.im().file().get(req);
        if (resp.getCode() != 0) {
            System.out.println(String.format("code:%d,msg:%s,err:%s"
                    , resp.getCode(), resp.getMsg(), Jsons.DEFAULT.toJson(resp.getError())));
            return;
        }

        // 保存文件
        resp.writeFile("jiaduo2.pdf");

        // 返回请求ID
        System.out.println(resp.getRequestId());
    }

    public static void downLoadImage(Client client) throws Exception {
        // 创建请求对象
        GetImageReq req = GetImageReq.newBuilder()
                .imageKey("img_v2_9068cbd5-71d8-4799-b29e-a01650b1328g").build();

        // 发起请求
        GetImageResp resp = client.im().image().get(req);
        if (resp.getCode() != 0) {
            System.out.println(String.format("code:%d,msg:%s,err:%s"
                    , resp.getCode(), resp.getMsg(), Jsons.DEFAULT.toJson(resp.getError())));
            return;
        }

        // 保持图片到本地磁盘
        FileOutputStream file = new FileOutputStream("gh.jpg");
        file.write(resp.getData().toByteArray());
        file.close();
        // 返回请求ID
        System.out.println(resp.getRequestId());
    }

    public static void downloadDriveFile(Client client) throws Exception {
        // 构建请求对象
        DownloadFileReq req = DownloadFileReq.newBuilder().fileToken("boxcnTrRml0GB9E3NFDEyNtMeOb")
                .build();

        // 发起请求，并传递用户token
        DownloadFileResp resp = client.drive().file().download(req, RequestOptions.newBuilder()
                .userAccessToken("u-11ETll3Kd1O8NxVwd_uVVN0hnoUAlhcbWi00kg.yyIsw")
                .build());
        if (resp.getCode() != 0) {
            System.out.println(String.format("code:%d,msg:%s,err:%s"
                    , resp.getCode(), resp.getMsg(), Jsons.DEFAULT.toJson(resp.getError())));
            return;
        }

        // 保存文件到磁盘
        FileOutputStream file = new FileOutputStream("ruoran.pdf");
        file.write(resp.getData().toByteArray());
        file.close();
        // 返回请求ID
        System.out.println(resp.getRequestId());
        System.out.println(resp.getFileName());
    }

    public static void replayMsg(Client client) throws Exception {
        // 创建请求对象
        ReplyMessageReq req = ReplyMessageReq.newBuilder()
                .messageId("om_e23b4a2c15c809b54203ceb4860c6b0a")
                .replyMessageReqBody(ReplyMessageReqBody.newBuilder()
                        .msgType(MsgTypeEnum.MSG_TYPE_TEXT.getValue())
                        .content(
                                "{\"text\":\"<at user_id=\\\"ou_155184d1e73cbfb8973e5a9e698e74f2\\\">Tom</at> test content\"}")
                        .build())
                .build();

        // 发起请求
        ReplyMessageResp resp = client.im().message().reply(req);
        if (resp.getCode() != 0) {
            System.out.println(String.format("code:%d,msg:%s,err:%s"
                    , resp.getCode(), resp.getMsg(), Jsons.DEFAULT.toJson(resp.getError())));
            return;
        }

        System.out.println(Jsons.DEFAULT.toJson(resp));
        // 原生http信息
        System.out.println(Jsons.DEFAULT.toJson(resp.getRawResponse()));
        // 返回请求ID
        System.out.println(resp.getRequestId());
    }

    public static void main(String arg[]) throws Exception {
        String appId = System.getenv().get("APP_ID");
        String appSecret = System.getenv().get("APP_SECRET");

        // 构建client
        Client client = Client.newBuilder(appId, appSecret)
                .appType(AppType.SELF_BUILT) // 设置app类型，默认为自建
                .openBaseUrl(BaseUrlEnum.FeiShu) // 设置域名，默认为飞书
                .helpDeskCredential("helpDeskId", "helpDeskSecret") // 服务台应用才需要设置
                .tokenCache(LocalCache.getInstance()) // 设置token缓存，默认为内存缓存
                .requestTimeout(10, TimeUnit.SECONDS) // 设置httpclient 超时时间，默认永不超时
                //.disableTokenCache() // 禁用token管理，禁用后需要开发者自己传递token
                .logReqAtDebug(true)
//                .httpTransport(ApacheHttpClientTransport.newBuilder().httpclient(HttpClients.createDefault()).build())
                .build();

        sendPostMsg(client);
        // downLoadFile(client);
    }
}
