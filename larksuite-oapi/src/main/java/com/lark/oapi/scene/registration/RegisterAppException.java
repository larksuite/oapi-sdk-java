package com.lark.oapi.scene.registration;

public class RegisterAppException extends Exception {
    private final String code;
    private final String description;

    public RegisterAppException(String code, String description) {
        super("register app error: " + code + ": " + description);
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
