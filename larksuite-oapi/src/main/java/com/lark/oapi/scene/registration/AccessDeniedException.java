package com.lark.oapi.scene.registration;

public class AccessDeniedException extends RegisterAppException {
    public AccessDeniedException(String code, String description) {
        super(code, description);
    }
}
