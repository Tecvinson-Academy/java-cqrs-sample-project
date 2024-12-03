package com.tecvinsonacademy.cqrssampleproject.items.events;

import com.tecvinsonacademy.cqrssampleproject.mediator.Event;
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