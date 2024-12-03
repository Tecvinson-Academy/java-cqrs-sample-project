package com.tecvinsonacademy.cqrssampleproject.mediator;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Mediator {

    private final Map<Class<?>, CommandHandler<?>> commandHandlers = new HashMap<>();
    private final Map<Class<?>, QueryHandler<?, ?>> queryHandlers = new HashMap<>();
    private final Map<Class<?>, EventHandler<?>> eventHandlers = new HashMap<>();

    public Mediator(List<CommandHandler<?>> commandHandlers,
                    List<QueryHandler<?, ?>> queryHandlers,
                    List<EventHandler<?>> eventHandlers) {
        // Register command handlers
        for (CommandHandler<?> handler : commandHandlers) {
            Class<?> commandType = resolveHandlerType(handler);
            this.commandHandlers.put(commandType, handler);
        }

        // Register query handlers
        for (QueryHandler<?, ?> handler : queryHandlers) {
            Class<?> queryType = resolveHandlerType(handler);
            this.queryHandlers.put(queryType, handler);
        }

        // Register event handlers
        for (EventHandler<?> handler : eventHandlers) {
            Class<?> eventType = resolveHandlerType(handler);
            this.eventHandlers.put(eventType, handler);
        }
    }

    private Class<?> resolveHandlerType(Object handler) {
        return (Class<?>) ((java.lang.reflect.ParameterizedType) handler.getClass()
                .getGenericInterfaces()[0]).getActualTypeArguments()[0];
    }

    public <R> R send(Query<R> query) {
        QueryHandler<Query<R>, R> handler = (QueryHandler<Query<R>, R>) queryHandlers.get(query.getClass());
        if (handler == null) {
            throw new RuntimeException("No QueryHandler found for query type: " + query.getClass().getName());
        }
        return handler.handle(query);
    }

    public void send(Command command) {
        CommandHandler<Command> handler = (CommandHandler<Command>) commandHandlers.get(command.getClass());
        if (handler == null) {
            throw new RuntimeException("No CommandHandler found for command type: " + command.getClass().getName());
        }
        handler.handle(command);
    }

    public void publish(Event event) {
        EventHandler<Event> handler = (EventHandler<Event>) eventHandlers.get(event.getClass());
        if (handler == null) {
            throw new RuntimeException("No EventHandler found for event type: " + event.getClass().getName());
        }
        handler.handle(event);
    }
}