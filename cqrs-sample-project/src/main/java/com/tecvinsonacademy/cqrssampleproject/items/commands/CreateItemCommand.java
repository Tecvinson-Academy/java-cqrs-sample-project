package com.tecvinsonacademy.cqrssampleproject.items.commands;

import com.tecvinsonacademy.cqrssampleproject.mediator.Command;
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
