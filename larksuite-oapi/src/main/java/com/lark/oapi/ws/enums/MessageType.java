package com.lark.oapi.ws.enums;

public enum MessageType {
    EVENT("event"),
    CARD("card"),
    PING("ping"),
    PONG("pong")
    ;

    private String name;

    MessageType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static MessageType of(String name) {
        for (MessageType type : MessageType.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No MessageType name of " + name);
    }
}
