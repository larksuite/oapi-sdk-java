package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.BatchGetTmpDownloadUrlMediaReq;
import com.lark.oapi.service.drive.v1.model.BatchGetTmpDownloadUrlMediaResp;

// GET /open-apis/drive/v1/medias/batch_get_tmp_download_url
public class BatchGetTmpDownloadUrlMediaSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    BatchGetTmpDownloadUrlMediaReq req = BatchGetTmpDownloadUrlMediaReq.newBuilder()
        .fileTokens(new String[]{})
        .extra(
            "[请参考-上传点类型及对应Extra说明](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/drive-v1/media/introduction)")
        .build();

    // 发起请求
    BatchGetTmpDownloadUrlMediaResp resp = client.drive().media().batchGetTmpDownloadUrl(req);

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
