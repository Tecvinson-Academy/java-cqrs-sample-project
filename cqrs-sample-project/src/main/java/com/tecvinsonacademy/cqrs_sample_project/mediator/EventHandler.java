package com.tecvinsonacademy.cqrs_sample_project.mediator;

public interface EventHandler<E extends Event> {
    void handle(E event);
}