package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// POST /open-apis/hire/v1/talents/combined_create
public class CombinedCreateTalentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CombinedCreateTalentReq req = CombinedCreateTalentReq.newBuilder()
                .userIdType("user_id")
                .combinedCreateTalentReqBody(CombinedCreateTalentReqBody.newBuilder()
                        .initSourceId("1")
                        .resumeSourceId("1")
                        .folderIdList(new String[]{})
                        .creatorId("ou-xxx")
                        .creatorAccountType(1)
                        .resumeAttachmentId("12345")
                        .basicInfo(TalentCombinedBasicInfo.newBuilder().build())
                        .educationList(new TalentCombinedEducationInfo[]{})
                        .careerList(new TalentCombinedCareerInfo[]{})
                        .projectList(new TalentCombinedProjectInfo[]{})
                        .worksList(new TalentCombinedWorkInfo[]{})
                        .awardList(new TalentCombinedAwardInfo[]{})
                        .languageList(new TalentCombinedLanguageInfo[]{})
                        .snsList(new TalentCombinedSnsInfo[]{})
                        .preferredCityCodeList(new String[]{})
                        .selfEvaluation(TalentSelfEvaluation.newBuilder().build())
                        .customizedData(new TalentCustomizedDataObjectValue[]{})
                        .build())
                .build();

        // 发起请求
        CombinedCreateTalentResp resp = client.hire().v1().talent().combinedCreate(req);

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
