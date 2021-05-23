package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.AppSettings;
import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Domain;
import com.larksuite.oapi.core.api.response.Response;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.sample.config.Configs;
import com.larksuite.oapi.service.meeting_room.v1.MeetingRoomService;
import com.larksuite.oapi.service.meeting_room.v1.model.CountryListResult;

public class MeetingRoomSample {

    // for Cutome APP（自建应用）
    private static final AppSettings appSettings = Config.getInternalAppSettingsByEnv();
    // config with redis store
    // private static final Config config = Configs.getConfigWithRedisStore("https://open.feishu.cn", appSettings);
    // private static final Config config = Configs.getConfig("https://open.feishu.cn", appSettings);
    private static final Config config = Configs.getConfig(Domain.FeiShu, appSettings);

    public static void main(String[] args) throws Exception {
        MeetingRoomService meetingRoomService = new MeetingRoomService(config);
        Response<CountryListResult> response = meetingRoomService.getCountrys().list().execute();
        System.out.println(response.getRequestID());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }
}
