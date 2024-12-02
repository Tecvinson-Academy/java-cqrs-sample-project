package com.tecvinsonacademy.cqrs_sample_project.items.commands;

import com.tecvinsonacademy.cqrs_sample_project.mediator.CommandHandler;
import org.springframework.stereotype.Component;

@Component
public class CreateItemCommandHandler implements CommandHandler<CreateItemCommand> {


    public CreateItemCommandHandler() {

    }

    @Override
    public void handle(CreateItemCommand command) {
        // Simulate saving to database
        System.out.println("Item created: " + command.getName());
    }
}

