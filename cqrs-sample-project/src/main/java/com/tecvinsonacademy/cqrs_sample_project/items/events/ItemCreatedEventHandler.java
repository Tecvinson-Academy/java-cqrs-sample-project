package com.tecvinsonacademy.cqrs_sample_project.items.events;

import com.tecvinsonacademy.cqrs_sample_project.config.RabbitMQConfig;
import com.tecvinsonacademy.cqrs_sample_project.mediator.EventHandler;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class ItemCreatedEventHandler implements EventHandler<ItemCreatedEvent> {
    private final RabbitTemplate rabbitTemplate;

    public ItemCreatedEventHandler(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void handle(ItemCreatedEvent event) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "item.created", event.getName());
        System.out.println("Event published to RabbitMQ: " + event.getName());
    }
}

