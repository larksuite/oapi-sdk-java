package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.DownloadMediaReq;
import com.lark.oapi.service.drive.v1.model.DownloadMediaResp;

// GET /open-apis/drive/v1/medias/:file_token/download
public class DownloadMediaSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    DownloadMediaReq req = DownloadMediaReq.newBuilder()
        .fileToken("boxcnrHpsg1QDqXAAAyachabcef")
        .extra(
            "[请参考-上传点类型及对应Extra说明](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/drive-v1/media/introduction)")
        .build();

    // 发起请求
    DownloadMediaResp resp = client.drive().media().download(req);

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
