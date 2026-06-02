package com.lark.oapi.channel.normalize;

import com.lark.oapi.channel.normalize.converters.AudioMessageConverter;
import com.lark.oapi.channel.normalize.converters.CalendarMessageConverter;
import com.lark.oapi.channel.normalize.converters.FallbackMessageConverter;
import com.lark.oapi.channel.normalize.converters.FileMessageConverter;
import com.lark.oapi.channel.normalize.converters.ImageMessageConverter;
import com.lark.oapi.channel.normalize.converters.LocationMessageConverter;
import com.lark.oapi.channel.normalize.converters.MergeForwardMessageConverter;
import com.lark.oapi.channel.normalize.converters.PostMessageConverter;
import com.lark.oapi.channel.normalize.converters.ShareMessageConverter;
import com.lark.oapi.channel.normalize.converters.StickerMessageConverter;
import com.lark.oapi.channel.normalize.converters.SystemMessageConverter;
import com.lark.oapi.channel.normalize.converters.TextMessageConverter;
import com.lark.oapi.channel.normalize.converters.TodoMessageConverter;
import com.lark.oapi.channel.normalize.converters.VideoMessageConverter;
import com.lark.oapi.channel.normalize.converters.VideoChatMessageConverter;
import com.lark.oapi.channel.normalize.converters.VoteMessageConverter;
import com.lark.oapi.channel.normalize.converters.interactive.InteractiveMessageConverter;

import java.util.HashMap;
import java.util.Map;

class ConverterRegistry {
    private final Map<String, ChannelMessageConverter> converters = new HashMap<String, ChannelMessageConverter>();

    ConverterRegistry() {
        ShareMessageConverter shareChatConverter = new ShareMessageConverter("share_chat");
        ShareMessageConverter shareUserConverter = new ShareMessageConverter("share_user");
        register("text", new TextMessageConverter());
        register("post", new PostMessageConverter());
        register("image", new ImageMessageConverter());
        register("file", new FileMessageConverter());
        register("audio", new AudioMessageConverter());
        register("video", new VideoMessageConverter());
        register("media", new VideoMessageConverter());
        register("sticker", new StickerMessageConverter());
        register("interactive", new InteractiveMessageConverter());
        register("merge_forward", new MergeForwardMessageConverter());
        register("share_chat", shareChatConverter);
        register("share_user", shareUserConverter);
        register("location", new LocationMessageConverter());
        register("system", new SystemMessageConverter());
        register("vote", new VoteMessageConverter());
        register("todo", new TodoMessageConverter());
        register("calendar", new CalendarMessageConverter("calendar_invite"));
        register("general_calendar", new CalendarMessageConverter("calendar"));
        register("share_calendar_event", new CalendarMessageConverter("calendar_share"));
        register("folder", new com.lark.oapi.channel.normalize.converters.FolderMessageConverter());
        register("hongbao", new com.lark.oapi.channel.normalize.converters.HongbaoMessageConverter());
        register("video_chat", new VideoChatMessageConverter());
        register("unknown", new FallbackMessageConverter());
    }

    void register(String type, ChannelMessageConverter converter) {
        converters.put(type, converter);
    }

    ChannelMessageConverter get(String type) {
        return converters.get(type);
    }
}
