package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.SearchDepartmentReq;
import com.lark.oapi.service.corehr.v2.model.SearchDepartmentReqBody;
import com.lark.oapi.service.corehr.v2.model.SearchDepartmentResp;

// POST /open-apis/corehr/v2/departments/search
public class SearchDepartmentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SearchDepartmentReq req = SearchDepartmentReq.newBuilder()
                .pageSize(100)
                .pageToken("6891251722631890445")
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .searchDepartmentReqBody(SearchDepartmentReqBody.newBuilder()
                        .active(true)
                        .getAllChildren(false)
                        .managerList(new String[]{})
                        .departmentIdList(new String[]{})
                        .nameList(new String[]{})
                        .parentDepartmentId("7094136522860922222")
                        .codeList(new String[]{})
                        .fields(new String[]{})
                        .build())
                .build();

        // 发起请求
        SearchDepartmentResp resp = client.corehr().v2().department().search(req);

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
