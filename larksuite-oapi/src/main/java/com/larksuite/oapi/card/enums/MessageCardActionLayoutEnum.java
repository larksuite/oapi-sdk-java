package com.larksuite.oapi.card.enums;

public enum MessageCardActionLayoutEnum {
    BISECTED("bisected"), TRISECTION("trisection"), FLOW("flow");
    private String value;

    MessageCardActionLayoutEnum(String value) {
        this.value = value;
    }
}
