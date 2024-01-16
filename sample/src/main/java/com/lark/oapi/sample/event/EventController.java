/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lark.oapi.sample.event;

import com.lark.oapi.core.request.EventReq;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.event.CustomEventHandler;
import com.lark.oapi.event.EventDispatcher;
import com.lark.oapi.sdk.servlet.ext.ServletAdapter;
import com.lark.oapi.service.application.ApplicationService.P1AppOpenV6Handler;
import com.lark.oapi.service.application.ApplicationService.P1AppStatusChangedV6Handler;
import com.lark.oapi.service.application.ApplicationService.P1AppUninstalledV6Handler;
import com.lark.oapi.service.application.ApplicationService.P1OrderPaidV6Handler;
import com.lark.oapi.service.application.v6.model.P1AppOpenV6;
import com.lark.oapi.service.application.v6.model.P1AppStatusChangedV6;
import com.lark.oapi.service.application.v6.model.P1AppUninstalledV6;
import com.lark.oapi.service.application.v6.model.P1OrderPaidV6;
import com.lark.oapi.service.approval.ApprovalService.*;
import com.lark.oapi.service.approval.v4.model.*;
import com.lark.oapi.service.contact.ContactService.*;
import com.lark.oapi.service.contact.v3.model.*;
import com.lark.oapi.service.im.ImService.P1MessageReadV1Handler;
import com.lark.oapi.service.im.ImService.P1P2PChatCreatedV1Handler;
import com.lark.oapi.service.im.ImService.P2MessageReadV1Handler;
import com.lark.oapi.service.im.ImService.P2MessageReceiveV1Handler;
import com.lark.oapi.service.im.v1.model.P1MessageReadV1;
import com.lark.oapi.service.im.v1.model.P1P2PChatCreatedV1;
import com.lark.oapi.service.im.v1.model.P2MessageReadV1;
import com.lark.oapi.service.im.v1.model.P2MessageReceiveV1;
import com.lark.oapi.service.meeting_room.MeetingRoomService.P1ThirdPartyMeetingRoomChangedV1Handler;
import com.lark.oapi.service.meeting_room.v1.model.P1ThirdPartyMeetingRoomChangedV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class EventController {

    //1. 注册消息处理器
    private final EventDispatcher EVENT_DISPATCHER = EventDispatcher.newBuilder("", "")
            .onP2MessageReceiveV1(new P2MessageReceiveV1Handler() {
                @Override
                public void handle(P2MessageReceiveV1 event) throws Exception {
                    // 处理消息
                    System.out.println(Jsons.DEFAULT.toJson(event));
                    System.out.println(event.getRequestId());
                }
            }).onP2UserCreatedV3(new P2UserCreatedV3Handler() {
                @Override
                public void handle(P2UserCreatedV3 event) {
                    System.out.println(Jsons.DEFAULT.toJson(event));
                    System.out.println(event.getRequestId());
                }
            })
            .onP2MessageReadV1(new P2MessageReadV1Handler() {
                @Override
                public void handle(P2MessageReadV1 event) {
                    System.out.println(Jsons.DEFAULT.toJson(event));
                    System.out.println(event.getRequestId());
                }
            }).onP1MessageReadV1(new P1MessageReadV1Handler() {
                @Override
                public void handle(P1MessageReadV1 event) {
                    System.out.println(Jsons.DEFAULT.toJson(event));
                    System.out.println(event.getRequestId());
                }
            }).onP1UserChangedV3(new P1UserChangedV3Handler() {
                @Override
                public void handle(P1UserChangedV3 event) throws Exception {
                    System.out.println(Jsons.DEFAULT.toJson(event));
                    System.out.println(event.getRequestId());
                }
            }).onP1UserStatusChangedV3(new P1UserStatusChangedV3Handler() {
                @Override
                public void handle(P1UserStatusChangedV3 event) throws Exception {
                    System.out.println(Jsons.DEFAULT.toJson(event));
                    System.out.println(event.getRequestId());
                }
            }).onP1DepartmentChangedV3(new P1DepartmentChangedV3Handler() {
                @Override
                public void handle(P1DepartmentChangedV3 event) throws Exception {
                    System.out.println(Jsons.DEFAULT.toJson(event));
                    System.out.println(event.getRequestId());
                }
            }).onP1ContactScopeChangedV3(new P1ContactScopeChangedV3Handler() {
                @Override
                public void handle(P1ContactScopeChangedV3 event) throws Exception {
                    System.out.println(Jsons.DEFAULT.toJson(event));
                    System.out.println(event.getRequestId());
                }
            }).onP1P2PChatCreatedV1(new P1P2PChatCreatedV1Handler() {
                @Override
                public void handle(P1P2PChatCreatedV1 event) throws Exception {
                    System.out.println(Jsons.DEFAULT.toJson(event));
                    System.out.println(event.getRequestId());
                }
            }).onP1ThirdPartyMeetingRoomChangedV1(new P1ThirdPartyMeetingRoomChangedV1Handler() {
                @Override
                public void handle(P1ThirdPartyMeetingRoomChangedV1 event) throws Exception {
                    System.out.println(Jsons.DEFAULT.toJson(event));
                    System.out.println(event.getRequestId());
                }
            }).onP1LeaveApprovalV4(new P1LeaveApprovalV4Handler() {
                @Override
                public void handle(P1LeaveApprovalV4 event) throws Exception {
                    System.out.println(Jsons.DEFAULT.toJson(event));
                    System.out.println(event.getRequestId());
                }
            }).onP1WorkApprovalV4(new P1WorkApprovalV4Handler() {
                @Override
                public void handle(P1WorkApprovalV4 event) throws Exception {
                    System.out.println(Jsons.DEFAULT.toJson(event));
                    System.out.println(event.getRequestId());
                }
            }).onP1ShiftApprovalV4(new P1ShiftApprovalV4Handler() {
                @Override
                public void handle(P1ShiftApprovalV4 event) throws Exception {
                    System.out.println(Jsons.DEFAULT.toJson(event));
                    System.out.println(event.getRequestId());
                }
            }).onP1RemedyApprovalV4(new P1RemedyApprovalV4Handler() {
                @Override
                public void handle(P1RemedyApprovalV4 event) throws Exception {
                    System.out.println(Jsons.DEFAULT.toJson(event));
                    System.out.println(event.getRequestId());
                }
            }).onP1TripApprovalV4(new P1TripApprovalV4Handler() {
                @Override
                public void handle(P1TripApprovalV4 event) throws Exception {
                    System.out.println(Jsons.DEFAULT.toJson(event));
                    System.out.println(event.getRequestId());
                }
            }).onP1OutApprovalV4(new P1OutApprovalV4Handler() {
                @Override
                public void handle(P1OutApprovalV4 event) throws Exception {
                    System.out.println(Jsons.DEFAULT.toJson(event));
                    System.out.println(event.getRequestId());
                }
            }).onP1AppOpenV6(new P1AppOpenV6Handler() {
                @Override
                public void handle(P1AppOpenV6 event) throws Exception {
                    System.out.println(Jsons.DEFAULT.toJson(event));
                    System.out.println(event.getRequestId());
                }
            }).onP1AppStatusChangedV6(new P1AppStatusChangedV6Handler() {
                @Override
                public void handle(P1AppStatusChangedV6 event) throws Exception {
                    System.out.println(Jsons.DEFAULT.toJson(event));
                    System.out.println(event.getRequestId());
                }
            }).onP1OrderPaidV6(new P1OrderPaidV6Handler() {
                @Override
                public void handle(P1OrderPaidV6 event) throws Exception {
                    System.out.println(Jsons.DEFAULT.toJson(event));
                    System.out.println(event.getRequestId());
                }
            }).onP1AppUninstalledV6(new P1AppUninstalledV6Handler() {
                @Override
                public void handle(P1AppUninstalledV6 event) throws Exception {
                    System.out.println(Jsons.DEFAULT.toJson(event));
                    System.out.println(event.getRequestId());
                }
            }).onCustomizedEvent("message", new CustomEventHandler() {
                @Override
                public void handle(EventReq event) {
                    System.out.println("body:" + new String(event.getBody()));
                    System.out.println("plain:" + event.getPlain());
                }
            })
            .build();

    //2. 注入 ServletAdapter 实例
    @Autowired
    private ServletAdapter servletAdapter;

    //3. 创建路由处理器
    @RequestMapping("/webhook/event")
    public void event(HttpServletRequest request, HttpServletResponse response)
            throws Throwable {
        //3.1 回调扩展包提供的事件回调处理器
        servletAdapter.handleEvent(request, response, EVENT_DISPATCHER);
    }
}
