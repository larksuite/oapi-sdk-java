package com.larksuite.oapi.core.exception;

// TODO 可以改进哈命名，{动词}+{名词}Exception，{形容词}+{名词}Exception
public class AccessTokenObtainException extends RuntimeException {

    public AccessTokenObtainException(String messagePrefix, String msg) {
        super(messagePrefix + msg);
    }
}
