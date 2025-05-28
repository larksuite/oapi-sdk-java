package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/basic_info/bank_branchs/search
public class SearchBasicInfoBankBranchSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SearchBasicInfoBankBranchReq req = SearchBasicInfoBankBranchReq.newBuilder()
                .pageSize(100)
                .pageToken("MDBK00000120")
                .searchBasicInfoBankBranchReqBody(SearchBasicInfoBankBranchReqBody.newBuilder()
                        .bankIdList(new String[]{})
                        .bankBranchIdList(new String[]{})
                        .bankBranchNameList(new String[]{})
                        .codeList(new String[]{})
                        .statusList(new Integer[]{})
                        .updateStartTime("2020-01-01 00:00:00")
                        .updateEndTime("2024-01-01 00:00:00")
                        .build())
                .build();

        // 发起请求
        SearchBasicInfoBankBranchResp resp = client.corehr().v2().basicInfoBankBranch().search(req);

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
