package com.lark.oapi.sample.event;

import com.lark.oapi.Client;
import com.lark.oapi.core.httpclient.OkHttpTransport;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.event.EventDispatcher;
import com.lark.oapi.okhttp.OkHttpClient;
import com.lark.oapi.service.contact.v3.ContactService.P2UserCreatedV3Handler;
import com.lark.oapi.service.contact.v3.model.P2UserCreatedV3;
import com.lark.oapi.service.im.v1.ImService.P1MessageReadV1Handler;
import com.lark.oapi.service.im.v1.ImService.P2MessageReadV1Handler;
import com.lark.oapi.service.im.v1.ImService.P2MessageReceiveV1Handler;
import com.lark.oapi.service.im.v1.model.P1MessageReadV1;
import com.lark.oapi.service.im.v1.model.P2MessageReadV1;
import com.lark.oapi.service.im.v1.model.P2MessageReceiveV1;
import com.larksuite.oapi.sdk.servlet.ext.ServletAdapter;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
      })
      .build();
  Client client = Client.newBuilder("appId", "appSecret")
      .httpTransport(new OkHttpTransport(new OkHttpClient().newBuilder()
          .callTimeout(3L, TimeUnit.SECONDS)
          .build())) // 自定义传输层
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
