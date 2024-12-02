package com.tecvinsonacademy.cqrs_sample_project.mediator;

public interface CommandHandler<C extends Command> {
    void handle(C command);
}