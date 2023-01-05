package com.lark.oapi.sample.apiall.speech_to_textv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.speech_to_text.v1.model.*;

// POST /open-apis/speech_to_text/v1/speech/file_recognize
public class FileRecognizeSpeechSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        FileRecognizeSpeechReq req = FileRecognizeSpeechReq.newBuilder()
                .fileRecognizeSpeechReqBody(FileRecognizeSpeechReqBody.newBuilder()
                        .speech(Speech.newBuilder().build())
                        .config(FileConfig.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        FileRecognizeSpeechResp resp = client.speechToText().speech().fileRecognize(req);

        // 处理服务端错误
        if (!resp.success()) {
            System.out.println(String.format("code:%s,msg:%s,reqId:%s"
                    , resp.getCode(), resp.getMsg(), resp.getRequestId()));
            return;
        }

        // 业务数据处理
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
    }
}
