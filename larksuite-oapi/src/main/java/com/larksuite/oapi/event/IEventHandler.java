package com.larksuite.oapi.event;

public interface IEventHandler<E> {
    E getEvent();

    void handle(E event) throws Exception;
}
