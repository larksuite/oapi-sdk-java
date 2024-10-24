package com.lark.oapi.event;

public interface ICallBackHandler<E, R> {
    E getEvent();

    R handle(E event) throws Exception;
}
