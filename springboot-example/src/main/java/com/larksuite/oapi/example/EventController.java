package com.larksuite.oapi.example;

import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.event.EventDispatcher;
import com.larksuite.oapi.sdk.servlet.ext.ServletAdapter;
import com.larksuite.oapi.service.contact.v3.ContactService;
import com.larksuite.oapi.service.contact.v3.model.UserCreatedEvent;
import com.larksuite.oapi.service.im.v1.ImService;
import com.larksuite.oapi.service.im.v1.model.MessageReadEvent;
import com.larksuite.oapi.service.im.v1.model.MessageReceiveEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class EventController {
    private final EventDispatcher EVENT_DISPATCHER = new EventDispatcher.Builder("", "1212121212")
            .onMessageReceiveV1(new ImService.MessageReceiveEventHandler() {
                @Override
                public void handle(MessageReceiveEvent event) {
                    System.out.println(Jsons.DEFAULT_GSON.toJson(event));
                }
            }).onUserCreatedV3(new ContactService.UserCreatedEventHandler() {
                @Override
                public void handle(UserCreatedEvent event) {
                    System.out.println(Jsons.DEFAULT_GSON.toJson(event));
                }
            })
            .onMessageReadV1(new ImService.MessageReadEventHandler() {
                @Override
                public void handle(MessageReadEvent event) {
                    System.out.println(Jsons.DEFAULT_GSON.toJson(event));
                }
            })
            .build();

    @Autowired
    private ServletAdapter servletAdapter;

    @RequestMapping("/webhook/event")
    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        servletAdapter.handleEvent(request, response, EVENT_DISPATCHER);
    }
}
