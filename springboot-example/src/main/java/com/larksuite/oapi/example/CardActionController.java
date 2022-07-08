package com.larksuite.oapi.example;

import com.larksuite.oapi.card.CardActionHandler;
import com.larksuite.oapi.card.enums.MessageCardButtonTypeEnum;
import com.larksuite.oapi.card.model.*;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.sdk.servlet.ext.ServletAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CardActionController {
    @Autowired
    private ServletAdapter servletAdapter;

    private final CardActionHandler CARD_ACTION_HANDLER = CardActionHandler.newBuilder("v", "e", new CardActionHandler.ICardHandler() {
        @Override
        public Object handle(CardAction cardAction) {
            System.out.println(Jsons.DEFAULT_GSON.toJson(cardAction));

            // 返回卡片
            return getCard();

//            // 返回自定义结果
//            Map<String, Object> map = new HashMap<>();
//            map.put("key1", "value1");
//            map.put("ke2", "value2");
//            CustomResponse customResponse = new CustomResponse();
//            customResponse.setStatusCode(0);
//            customResponse.setBody(map);
//            Map<String, List<String>> headers = new HashMap<String, List<String>>();
//            headers.put("key1", Arrays.asList("a", "b"));
//            headers.put("key2", Arrays.asList("c", "d"));
//            customResponse.setHeaders(headers);
//            return customResponse;
        }
    }).build();

    private MessageCard getCard() {
        // 配置
        MessageCardConfig config = MessageCardConfig.newBuilder()
                .enableForward(true)
                .wideScreenMode(true)
                .updateMulti(true)
                .build();

        // cardUrl
        MessageCardURL cardURL = MessageCardURL.newBuilder()
                .pcUrl("http://www.baidu.com")
                .iosUrl("http://www.google.com")
                .url("http://open.feishu.com")
                .androidUrl("http://www.jianshu.com")
                .build();

        // header
        MessageCardHeader header = MessageCardHeader.newBuilder()
                .template("red")
                .title(MessageCardPlainText.newBuilder()
                        .content("1 级报警 - 数据平台")
                        .build())
                .build();

        //elements
        MessageCardDiv div1 = MessageCardDiv.newBuilder()
                .fields(new MessageCardField[]{
                        MessageCardField.newBuilder()
                                .isShort(true)
                                .text(MessageCardLarkMd.newBuilder()
                                        .content("**🕐 时间：**2021-02-23 20:17:51")
                                        .build())
                                .build(),
                        MessageCardField.newBuilder()
                                .isShort(true)
                                .text(MessageCardLarkMd.newBuilder()
                                        .content("**🔢 事件 ID：：**336720")
                                        .build())
                                .build(),
                        MessageCardField.newBuilder()
                                .isShort(false)
                                .text(MessageCardLarkMd.newBuilder()
                                        .content("")
                                        .build())
                                .build(),
                        MessageCardField.newBuilder()
                                .isShort(true)
                                .text(MessageCardLarkMd.newBuilder()
                                        .content("**📋 项目：**\nQA 7")
                                        .build())
                                .build(),
                        MessageCardField.newBuilder()
                                .isShort(true)
                                .text(MessageCardLarkMd.newBuilder()
                                        .content("**👤 一级值班：**\n<at id=ou_c245b0a7dff2725cfa2fb104f8b48b9d>加多</at>")
                                        .build())
                                .build(),
                        MessageCardField.newBuilder()
                                .isShort(false)
                                .text(MessageCardLarkMd.newBuilder()
                                        .content("")
                                        .build())
                                .build(),
                        MessageCardField.newBuilder()
                                .isShort(true)
                                .text(MessageCardLarkMd.newBuilder()
                                        .content("**👤 二级值班：**\n<at id=ou_c245b0a7dff2725cfa2fb104f8b48b9d>加多</at>")
                                        .build())
                                .build()
                })
                .build();

        MessageCardImage image = MessageCardImage.newBuilder()
                .alt(MessageCardPlainText.newBuilder()
                        .content("")
                        .build())
                .imgKey("img_v2_8b2ebeaf-c97c-411d-a4dc-4323e8cba10g")
                .title(MessageCardLarkMd.newBuilder()
                        .content("支付方式 支付成功率低于 50%：")
                        .build())
                .build();

        MessageCardNote note = MessageCardNote.newBuilder()
                .elements(new IMessageCardNoteElement[]{MessageCardPlainText.newBuilder()
                        .content("🔴 支付失败数  🔵 支付成功数")
                        .build()})
                .build();

        Map<String, Object> value = new HashMap<>();
        value.put("key1", "value1");
        MessageCardAction cardAction = MessageCardAction.newBuilder()
                .actions(new IMessageCardActionElement[]{
                        MessageCardEmbedButton.newBuilder()
                                .buttonType(MessageCardButtonTypeEnum.PRIMARY)
                                .value(value)
                                .text(MessageCardPlainText.newBuilder().content("跟进处理").build())
                                .build(),
                        MessageCardEmbedSelectMenuStatic.newBuilder()
                                .options(new MessageCardEmbedSelectOption[]{
                                        MessageCardEmbedSelectOption.newBuilder()
                                                .value("1")
                                                .text(MessageCardPlainText.newBuilder()
                                                        .content("屏蔽10分钟")
                                                        .build())
                                                .build(),
                                        MessageCardEmbedSelectOption.newBuilder()
                                                .value("2")
                                                .text(MessageCardPlainText.newBuilder()
                                                        .content("屏蔽30分钟")
                                                        .build())
                                                .build(),
                                        MessageCardEmbedSelectOption.newBuilder()
                                                .value("3")
                                                .text(MessageCardPlainText.newBuilder()
                                                        .content("屏蔽1小时")
                                                        .build())
                                                .build(),
                                        MessageCardEmbedSelectOption.newBuilder()
                                                .value("4")
                                                .text(MessageCardPlainText.newBuilder()
                                                        .content("屏蔽24小时")
                                                        .build())
                                                .build()
                                })
                                .placeholder(MessageCardPlainText.newBuilder()
                                        .content("暂时屏蔽报警")
                                        .build())
                                .value(value)
                                .build()
                })
                .build();

        MessageCardHr hr = MessageCardHr.newBuilder().build();

        MessageCardDiv div2 = MessageCardDiv.newBuilder()
                .text(MessageCardLarkMd.newBuilder()
                        .content("🙋🏼 [我要反馈误报](https://open.feishu.cn/) | 📝 [录入报警处理过程](https://open.feishu.cn/)")
                        .build())
                .build();

        MessageCard card = MessageCard.newBuilder()
                .cardLink(cardURL)
                .config(config)
                .header(header)
                .elements(new MessageCardElement[]{div1, note, image, cardAction, hr, div2})
                .build();

        return card;
    }

    @RequestMapping("/webhook/card")
    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        servletAdapter.handleCardAction(request, response, CARD_ACTION_HANDLER);
    }
}
