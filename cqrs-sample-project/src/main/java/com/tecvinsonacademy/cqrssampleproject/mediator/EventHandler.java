package com.tecvinsonacademy.cqrssampleproject.mediator;

public interface EventHandler<E extends Event> {
    void handle(E event);
}