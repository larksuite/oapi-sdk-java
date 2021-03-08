package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.api.response.EmptyData;
import com.larksuite.oapi.core.api.response.Response;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.service.calendar.v4.CalendarService;

public class CalendarSample {

    // for test
    private static final Config config = Config.getTestInternalConf("online");

    public static void main(String[] args) throws Exception {
        CalendarService calendarService = new CalendarService(config);
        Response<EmptyData> response = calendarService.getCalendarAcls().delete().setCalendarId("CalendarId").setAclId("AclId").execute();
        System.out.println(response.getRequestID());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }
}
