package com.larksuite.oapi.example;

import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.event.EventDispatcher;
import com.lark.oapi.service.contact.v3.ContactService;
import com.lark.oapi.service.contact.v3.model.P2UserCreatedV3;
import com.lark.oapi.service.im.v1.ImService;
import com.lark.oapi.service.im.v1.model.P1MessageReadV1;
import com.lark.oapi.service.im.v1.model.P2MessageReadV1;
import com.lark.oapi.service.im.v1.model.P2MessageReceiveV1;
import com.larksuite.oapi.sdk.servlet.ext.ServletAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

  // 1212121212
  private final EventDispatcher EVENT_DISPATCHER = EventDispatcher.newBuilder("", "")
      .onP2MessageReceiveV1(new ImService.P2MessageReceiveV1Handler() {
        @Override
        public void handle(P2MessageReceiveV1 event) {
          System.out.println(Jsons.DEFAULT.toJson(event));
          System.out.println(event.getRequestId());
        }
      }).onP2UserCreatedV3(new ContactService.P2UserCreatedV3Handler() {
        @Override
        public void handle(P2UserCreatedV3 event) {
          System.out.println(Jsons.DEFAULT.toJson(event));
          System.out.println(event.getRequestId());
        }
      })
      .onP2MessageReadV1(new ImService.P2MessageReadV1Handler() {
        @Override
        public void handle(P2MessageReadV1 event) {
          System.out.println(Jsons.DEFAULT.toJson(event));
          System.out.println(event.getRequestId());
        }
      }).onP1MessageReadV1(new ImService.P1MessageReadV1Handler() {
        @Override
        public void handle(P1MessageReadV1 event) {
          System.out.println(Jsons.DEFAULT.toJson(event));
          System.out.println(event.getRequestId());
        }
      })
      .build();

  @Autowired
  private ServletAdapter servletAdapter;

  @RequestMapping("/webhook/event")
  public void helloWorld(HttpServletRequest request, HttpServletResponse response)
      throws Throwable {
    servletAdapter.handleEvent(request, response, EVENT_DISPATCHER);
  }
}
