package com.lark.oapi.scene.registration;

public class ExpiredException extends RegisterAppException {
    public ExpiredException(String code, String description) {
        super(code, description);
    }
}
