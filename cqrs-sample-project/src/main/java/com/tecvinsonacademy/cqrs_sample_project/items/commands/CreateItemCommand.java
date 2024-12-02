package com.tecvinsonacademy.cqrs_sample_project.items.commands;

import com.tecvinsonacademy.cqrs_sample_project.mediator.Command;
import org.springframework.stereotype.Component;

@Component
public class CreateItemCommand implements Command {

    private String name = "";

    public CreateItemCommand() {
    }

    public CreateItemCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
