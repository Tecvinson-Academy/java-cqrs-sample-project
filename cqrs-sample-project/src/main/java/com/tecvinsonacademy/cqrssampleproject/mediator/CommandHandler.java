package com.tecvinsonacademy.cqrssampleproject.mediator;

public interface CommandHandler<C extends Command> {
    void handle(C command);
}