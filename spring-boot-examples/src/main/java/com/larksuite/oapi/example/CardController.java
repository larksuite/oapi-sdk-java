package com.larksuite.oapi.example;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.card.Card;
import com.larksuite.oapi.core.card.CardServlet;
import com.larksuite.oapi.core.card.IHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.servlet.annotation.WebServlet;

// "Developer Console" -> "Features" -> "Bot", setting Message Card Request URL: https://domain/webhook/card
// Inherit CardServlet
@WebServlet("/webhook/card")
public class CardController extends CardServlet {

    private static final Logger log = LoggerFactory.getLogger(CardController.class);

    // Provide the config instance through InitConfig.java and inject the config instance through dependency
    public CardController(Config config) {
        super(config);
    }

    @PostConstruct
    public void init() {
        Card.setHandler(this.getConfig(), new IHandler() {

            // Return value: can be null or JSON string of new message card
            @Override
            public Object handle(Context context, com.larksuite.oapi.core.card.mode.Card card) throws Exception {
                // Print message card
                log.info("card:{}", card);
                log.info("card.getAction:{}", card.getAction());
                return "{\"config\":{\"wide_screen_mode\":true},\"i18n_elements\":{\"zh_cn\":[{\"tag\":\"div\",\"text\":{\"tag\":\"lark_md\",\"content\":\"[飞书](https://www.feishu.cn)整合即时沟通、日历、音视频会议、云文档、云盘、工作台等功能于一体，成就组织和个人，更高效、更愉悦。\"}}]}}";
            }
        });
    }
}
