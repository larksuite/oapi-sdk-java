package com.lark.oapi.core.auth;

public interface ClientAssertionProvider {
    ClientAssertionToken retrieveToken(String aud) throws Exception;
}
