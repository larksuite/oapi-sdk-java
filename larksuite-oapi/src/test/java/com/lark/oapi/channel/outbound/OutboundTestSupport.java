package com.lark.oapi.channel.outbound;

import com.lark.oapi.Client;
import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.core.Config;
import com.lark.oapi.service.cardkit.CardkitService;
import com.lark.oapi.service.cardkit.v1.V1;
import com.lark.oapi.service.cardkit.v1.model.CreateCardReq;
import com.lark.oapi.service.cardkit.v1.model.CreateCardResp;
import com.lark.oapi.service.cardkit.v1.model.CreateCardRespBody;
import com.lark.oapi.service.cardkit.v1.model.IdConvertCardReq;
import com.lark.oapi.service.cardkit.v1.model.IdConvertCardResp;
import com.lark.oapi.service.cardkit.v1.model.IdConvertCardRespBody;
import com.lark.oapi.service.cardkit.v1.model.PatchCardElementReq;
import com.lark.oapi.service.cardkit.v1.model.PatchCardElementResp;
import com.lark.oapi.service.cardkit.v1.model.SettingsCardReq;
import com.lark.oapi.service.cardkit.v1.model.SettingsCardResp;
import com.lark.oapi.service.cardkit.v1.model.UpdateCardElementReq;
import com.lark.oapi.service.cardkit.v1.model.UpdateCardElementResp;
import com.lark.oapi.service.cardkit.v1.model.UpdateCardReq;
import com.lark.oapi.service.cardkit.v1.model.UpdateCardResp;
import com.lark.oapi.service.cardkit.v1.resource.Card;
import com.lark.oapi.service.cardkit.v1.resource.CardElement;
import com.lark.oapi.service.im.ImService;
import com.lark.oapi.service.im.v1.model.CreateFileReq;
import com.lark.oapi.service.im.v1.model.CreateFileResp;
import com.lark.oapi.service.im.v1.model.CreateFileRespBody;
import com.lark.oapi.service.im.v1.model.CreateImageReq;
import com.lark.oapi.service.im.v1.model.CreateImageResp;
import com.lark.oapi.service.im.v1.model.CreateImageRespBody;
import com.lark.oapi.service.im.v1.model.CreateMessageReactionResp;
import com.lark.oapi.service.im.v1.model.CreateMessageReq;
import com.lark.oapi.service.im.v1.model.CreateMessageResp;
import com.lark.oapi.service.im.v1.model.CreateMessageRespBody;
import com.lark.oapi.service.im.v1.model.DeleteMessageReactionReq;
import com.lark.oapi.service.im.v1.model.GetFileReq;
import com.lark.oapi.service.im.v1.model.GetFileResp;
import com.lark.oapi.service.im.v1.model.GetImageReq;
import com.lark.oapi.service.im.v1.model.GetImageResp;
import com.lark.oapi.service.im.v1.model.ListMessageReactionReq;
import com.lark.oapi.service.im.v1.model.ListMessageReactionResp;
import com.lark.oapi.service.im.v1.model.PatchMessageReq;
import com.lark.oapi.service.im.v1.model.PatchMessageResp;
import com.lark.oapi.service.im.v1.model.ReplyMessageReq;
import com.lark.oapi.service.im.v1.model.ReplyMessageResp;
import com.lark.oapi.service.im.v1.model.UpdateMessageReq;
import com.lark.oapi.service.im.v1.model.UpdateMessageResp;
import com.lark.oapi.service.im.v1.resource.File;
import com.lark.oapi.service.im.v1.resource.Image;
import com.lark.oapi.service.im.v1.resource.Message;
import com.lark.oapi.service.im.v1.resource.MessageReaction;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

final class OutboundTestSupport {
    private OutboundTestSupport() {
    }

    static LarkChannelOptions options() {
        LarkChannelOptions.Builder builder = LarkChannelOptions.newBuilder("cli_test", "secret").transport("webhook");
        LarkChannelOptions.OutboundConfig outbound = new LarkChannelOptions.OutboundConfig();
        LarkChannelOptions.RetryConfig retry = new LarkChannelOptions.RetryConfig();
        retry.setMaxAttempts(1);
        retry.setBaseDelayMs(0L);
        outbound.setRetry(retry);
        builder.outbound(outbound);
        return builder.build();
    }

    static Client createClient(StubMessage message, StubMessageReaction reaction, StubImage image, StubFile file) throws Exception {
        return createClient(message, reaction, image, file, new StubCardResource(), new StubCardElementResource());
    }

    static Client createClient(StubMessage message, StubMessageReaction reaction, StubImage image, StubFile file,
                               StubCardResource card, StubCardElementResource cardElement) throws Exception {
        Client client = Client.newBuilder("cli_test", "secret").build();
        setField(client, "im", new StubImService(message, reaction, image, file));
        setField(client, "cardkit", new StubCardkitService(card, cardElement));
        return client;
    }

    static CreateMessageResp okCreate(String messageId) {
        CreateMessageResp resp = new CreateMessageResp();
        CreateMessageRespBody body = new CreateMessageRespBody();
        body.setMessageId(messageId);
        resp.setData(body);
        return resp;
    }

    static CreateImageResp okImage(String imageKey) {
        CreateImageResp resp = new CreateImageResp();
        CreateImageRespBody body = new CreateImageRespBody();
        body.setImageKey(imageKey);
        resp.setData(body);
        return resp;
    }

    static CreateFileResp okFile(String fileKey) {
        CreateFileResp resp = new CreateFileResp();
        CreateFileRespBody body = new CreateFileRespBody();
        body.setFileKey(fileKey);
        resp.setData(body);
        return resp;
    }

    static CreateCardResp okCard(String cardId) {
        CreateCardResp resp = new CreateCardResp();
        CreateCardRespBody body = new CreateCardRespBody();
        body.setCardId(cardId);
        resp.setData(body);
        return resp;
    }

    static IdConvertCardResp okCardIdConvert(String cardId) {
        IdConvertCardResp resp = new IdConvertCardResp();
        IdConvertCardRespBody body = new IdConvertCardRespBody();
        body.setCardId(cardId);
        resp.setData(body);
        return resp;
    }

    static void setField(Object target, String fieldName, Object value) throws Exception {
        Field field = null;
        Class<?> type = target.getClass();
        while (type != null) {
            try {
                field = type.getDeclaredField(fieldName);
                break;
            } catch (NoSuchFieldException ignored) {
                type = type.getSuperclass();
            }
        }
        if (field == null) {
            throw new IllegalStateException("field not found: " + fieldName);
        }
        field.setAccessible(true);
        field.set(target, value);
    }

    static final class StubImService extends ImService {
        private final StubMessage message;
        private final StubMessageReaction reaction;
        private final StubImage image;
        private final StubFile file;

        StubImService(StubMessage message, StubMessageReaction reaction, StubImage image, StubFile file) {
            super(new Config());
            this.message = message;
            this.reaction = reaction;
            this.image = image;
            this.file = file;
        }

        @Override
        public Message message() {
            return message;
        }

        @Override
        public MessageReaction messageReaction() {
            return reaction;
        }

        @Override
        public Image image() {
            return image;
        }

        @Override
        public File file() {
            return file;
        }
    }

    static final class StubCardkitService extends CardkitService {
        private final StubCardkitV1 v1;

        StubCardkitService(StubCardResource card, StubCardElementResource cardElement) throws Exception {
            super(new Config());
            this.v1 = new StubCardkitV1(card, cardElement);
            setField(this, "v1", v1);
        }

        @Override
        public V1 v1() {
            return v1;
        }
    }

    static final class StubCardkitV1 extends V1 {
        private final StubCardResource card;
        private final StubCardElementResource cardElement;

        StubCardkitV1(StubCardResource card, StubCardElementResource cardElement) {
            super(new Config());
            this.card = card;
            this.cardElement = cardElement;
        }

        @Override
        public Card card() {
            return card;
        }

        @Override
        public CardElement cardElement() {
            return cardElement;
        }
    }

    static class StubMessage extends Message {
        CreateMessageReq createReq;
        List<CreateMessageReq> createReqs = new ArrayList<CreateMessageReq>();
        ReplyMessageReq replyReq;
        List<ReplyMessageReq> replyReqs = new ArrayList<ReplyMessageReq>();
        UpdateMessageReq updateReq;
        PatchMessageReq patchReq;
        CreateMessageResp createResp;
        ReplyMessageResp replyResp;
        RuntimeException createError;
        RuntimeException createErrorOnce;
        RuntimeException replyError;
        RuntimeException replyErrorOnce;

        StubMessage() {
            super(new Config());
        }

        @Override
        public CreateMessageResp create(CreateMessageReq req) {
            this.createReq = req;
            this.createReqs.add(req);
            if (createErrorOnce != null) {
                RuntimeException error = createErrorOnce;
                createErrorOnce = null;
                throw error;
            }
            if (createError != null) {
                throw createError;
            }
            return createResp;
        }

        @Override
        public ReplyMessageResp reply(ReplyMessageReq req) {
            this.replyReq = req;
            this.replyReqs.add(req);
            if (replyErrorOnce != null) {
                RuntimeException error = replyErrorOnce;
                replyErrorOnce = null;
                throw error;
            }
            if (replyError != null) {
                throw replyError;
            }
            return replyResp;
        }

        @Override
        public UpdateMessageResp update(UpdateMessageReq req) {
            this.updateReq = req;
            return new UpdateMessageResp();
        }

        @Override
        public PatchMessageResp patch(PatchMessageReq req) {
            this.patchReq = req;
            return new PatchMessageResp();
        }
    }

    static class StubMessageReaction extends MessageReaction {
        DeleteMessageReactionReq deleteReq;
        ListMessageReactionReq listReq;
        CreateMessageReactionResp createResp;
        ListMessageReactionResp listResp;

        StubMessageReaction() {
            super(new Config());
        }

        @Override
        public CreateMessageReactionResp create(com.lark.oapi.service.im.v1.model.CreateMessageReactionReq req) {
            return createResp;
        }

        @Override
        public com.lark.oapi.service.im.v1.model.DeleteMessageReactionResp delete(DeleteMessageReactionReq req) {
            this.deleteReq = req;
            return new com.lark.oapi.service.im.v1.model.DeleteMessageReactionResp();
        }

        @Override
        public ListMessageReactionResp list(ListMessageReactionReq req) {
            this.listReq = req;
            return listResp;
        }
    }

    static class StubImage extends Image {
        CreateImageReq createReq;
        CreateImageResp createResp;
        GetImageReq lastReq;
        GetImageResp resp;

        StubImage() {
            super(new Config());
        }

        @Override
        public GetImageResp get(GetImageReq req) {
            this.lastReq = req;
            return resp;
        }

        @Override
        public CreateImageResp create(CreateImageReq req) {
            this.createReq = req;
            return createResp;
        }
    }

    static class StubFile extends File {
        CreateFileReq createReq;
        CreateFileResp createResp;
        GetFileReq lastReq;
        GetFileResp resp;

        StubFile() {
            super(new Config());
        }

        @Override
        public GetFileResp get(GetFileReq req) {
            this.lastReq = req;
            return resp;
        }

        @Override
        public CreateFileResp create(CreateFileReq req) {
            this.createReq = req;
            return createResp;
        }
    }

    static class StubCardResource extends Card {
        CreateCardReq createReq;
        UpdateCardReq updateReq;
        SettingsCardReq settingsReq;
        IdConvertCardReq idConvertReq;
        CreateCardResp createResp;
        IdConvertCardResp idConvertResp;

        StubCardResource() {
            super(new Config());
        }

        @Override
        public CreateCardResp create(CreateCardReq req) {
            this.createReq = req;
            return createResp;
        }

        @Override
        public IdConvertCardResp idConvert(IdConvertCardReq req) {
            this.idConvertReq = req;
            return idConvertResp;
        }

        @Override
        public UpdateCardResp update(UpdateCardReq req) {
            this.updateReq = req;
            return new UpdateCardResp();
        }

        @Override
        public SettingsCardResp settings(SettingsCardReq req) {
            this.settingsReq = req;
            return new SettingsCardResp();
        }
    }

    static class StubCardElementResource extends CardElement {
        UpdateCardElementReq updateReq;
        PatchCardElementReq patchReq;

        StubCardElementResource() {
            super(new Config());
        }

        @Override
        public UpdateCardElementResp update(UpdateCardElementReq req) {
            this.updateReq = req;
            return new UpdateCardElementResp();
        }

        @Override
        public PatchCardElementResp patch(PatchCardElementReq req) {
            this.patchReq = req;
            return new PatchCardElementResp();
        }
    }
}
