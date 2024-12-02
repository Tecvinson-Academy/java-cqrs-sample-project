package com.tecvinsonacademy.cqrs_sample_project.items.events;

import com.tecvinsonacademy.cqrs_sample_project.mediator.Event;
import org.springframework.stereotype.Component;

@Component
public class ItemCreatedEvent implements Event {
    private String name = "";

    public ItemCreatedEvent() {

    }

    public ItemCreatedEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}