package com.lark.oapi.channel.normalize.converters;

import com.lark.oapi.channel.model.ResourceDescriptor;
import com.lark.oapi.channel.normalize.ChannelMessageConverter;
import com.lark.oapi.channel.normalize.ConvertContext;
import com.lark.oapi.channel.normalize.ConvertResult;
import com.lark.oapi.channel.normalize.MentionState;
import com.lark.oapi.channel.normalize.Mentions;
import com.lark.oapi.channel.normalize.MessageConverters;
import com.lark.oapi.channel.normalize.NormalizeTexts;
import com.lark.oapi.service.im.v1.model.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MergeForwardMessageConverter implements ChannelMessageConverter {
    private static final int MAX_FORWARD_ITEMS = 50;

    @Override
    public ConvertResult convert(String rawContent, ConvertContext context) {
        if (context.getOptions().getSubMessageFetcher() == null || context.getMessageId() == null || context.getMessageId().isEmpty()) {
            return new ConvertResult("<forwarded_messages/>", Collections.<ResourceDescriptor>emptyList());
        }
        List<Message> items;
        try {
            items = context.getOptions().getSubMessageFetcher().fetch(context.getMessageId());
        } catch (Exception ignored) {
            return new ConvertResult("<forwarded_messages/>", Collections.<ResourceDescriptor>emptyList());
        }
        if (items == null || items.isEmpty()) {
            return new ConvertResult("<forwarded_messages/>", Collections.<ResourceDescriptor>emptyList());
        }
        List<Message> capped = items.size() > MAX_FORWARD_ITEMS ? new ArrayList<Message>(items.subList(0, MAX_FORWARD_ITEMS)) : items;
        boolean truncated = items.size() > MAX_FORWARD_ITEMS;
        Map<String, List<Message>> childrenMap = buildChildrenMap(capped, context.getMessageId());
        return new ConvertResult(formatSubTree(context.getMessageId(), childrenMap, context, truncated), Collections.<ResourceDescriptor>emptyList());
    }

    private Map<String, List<Message>> buildChildrenMap(List<Message> items, String rootId) {
        Map<String, List<Message>> map = new LinkedHashMap<String, List<Message>>();
        for (Message item : items) {
            if (item == null) {
                continue;
            }
            if (rootId.equals(item.getMessageId()) && (item.getUpperMessageId() == null || item.getUpperMessageId().isEmpty())) {
                continue;
            }
            String parentId = item.getUpperMessageId() == null || item.getUpperMessageId().isEmpty() ? rootId : item.getUpperMessageId();
            List<Message> list = map.get(parentId);
            if (list == null) {
                list = new ArrayList<Message>();
                map.put(parentId, list);
            }
            list.add(item);
        }
        for (List<Message> list : map.values()) {
            Collections.sort(list, new Comparator<Message>() {
                @Override
                public int compare(Message left, Message right) {
                    return Long.compare(NormalizeTexts.parseLong(left.getCreateTime()), NormalizeTexts.parseLong(right.getCreateTime()));
                }
            });
        }
        return map;
    }

    private String formatSubTree(String parentId, Map<String, List<Message>> map, ConvertContext context, boolean truncated) {
        List<Message> children = map.get(parentId);
        if (children == null || children.isEmpty()) {
            return "<forwarded_messages/>";
        }
        List<String> parts = new ArrayList<String>();
        for (Message item : children) {
            try {
                String rendered = renderForwardItem(item, map, context);
                if (rendered != null && !rendered.isEmpty()) {
                    parts.add(rendered);
                }
            } catch (Exception ignored) {
            }
        }
        if (parts.isEmpty()) {
            return "<forwarded_messages/>";
        }
        String footer = truncated ? "\n... (truncated)" : "";
        return "<forwarded_messages>\n" + NormalizeTexts.joinLines(parts) + footer + "\n</forwarded_messages>";
    }

    private String renderForwardItem(Message item, Map<String, List<Message>> map, ConvertContext context) {
        String messageType = item.getMsgType() == null ? "text" : item.getMsgType();
        String senderId = item.getSender() == null || item.getSender().getId() == null ? "unknown" : item.getSender().getId();
        long createMs = NormalizeTexts.parseLong(item.getCreateTime());
        String timestamp = createMs > 0 ? NormalizeTexts.formatRfc3339Beijing(createMs) : "unknown";
        String displayName = context.getOptions().getSenderNameResolver() == null
                ? senderId
                : NormalizeTexts.firstNonBlank(context.getOptions().getSenderNameResolver().resolve(senderId), senderId, senderId);
        String content;
        if ("merge_forward".equals(messageType)) {
            content = item.getMessageId() == null ? "<forwarded_messages/>" : formatSubTree(item.getMessageId(), map, context, false);
        } else {
            String rawContent = item.getBody() == null ? "{}" : item.getBody().getContent();
            MentionState itemMentions = Mentions.extract(item.getMentions(), rawContent, context.getOptions().getBotIdentity());
            ConvertResult result = MessageConverters.convert(messageType, rawContent, itemMentions, context.getOptions(), item.getMessageId());
            content = Mentions.replaceKeys(result.getContent(), itemMentions, context.getOptions().isStripBotMentions());
            if (content == null || content.isEmpty()) {
                content = "[unsupported message]";
            }
        }
        return "[" + timestamp + "] " + displayName + ":\n" + NormalizeTexts.indentLines(content, "    ");
    }
}
