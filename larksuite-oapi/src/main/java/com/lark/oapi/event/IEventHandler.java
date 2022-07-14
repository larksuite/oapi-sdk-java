package com.lark.oapi.event;

public interface IEventHandler<E> {

  E getEvent();

  void handle(E event);
}
