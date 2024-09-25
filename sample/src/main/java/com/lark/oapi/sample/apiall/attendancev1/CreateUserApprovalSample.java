package com.lark.oapi.sample.apiall.attendancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.attendance.v1.model.CreateUserApprovalReq;
import com.lark.oapi.service.attendance.v1.model.CreateUserApprovalReqBody;
import com.lark.oapi.service.attendance.v1.model.CreateUserApprovalResp;
import com.lark.oapi.service.attendance.v1.model.UserApproval;

// POST /open-apis/attendance/v1/user_approvals
public class CreateUserApprovalSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateUserApprovalReq req = CreateUserApprovalReq.newBuilder()
                .employeeType("employee_id")
                .createUserApprovalReqBody(CreateUserApprovalReqBody.newBuilder()
                        .userApproval(UserApproval.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        CreateUserApprovalResp resp = client.attendance().v1().userApproval().create(req);

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
