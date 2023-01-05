package com.lark.oapi.sample.apiall.face_detectionv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.face_detection.v1.model.DetectFaceAttributesImageReq;
import com.lark.oapi.service.face_detection.v1.model.DetectFaceAttributesImageReqBody;
import com.lark.oapi.service.face_detection.v1.model.DetectFaceAttributesImageResp;

// POST /open-apis/face_detection/v1/image/detect_face_attributes
public class DetectFaceAttributesImageSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DetectFaceAttributesImageReq req = DetectFaceAttributesImageReq.newBuilder()
                .detectFaceAttributesImageReqBody(DetectFaceAttributesImageReqBody.newBuilder()
                        .image("图片 base64 后的字符串")
                        .build())
                .build();

        // 发起请求
        DetectFaceAttributesImageResp resp = client.faceDetection().image().detectFaceAttributes(req);

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
