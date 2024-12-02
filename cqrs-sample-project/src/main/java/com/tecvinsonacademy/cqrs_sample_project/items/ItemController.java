package com.tecvinsonacademy.cqrs_sample_project.items;

import com.tecvinsonacademy.cqrs_sample_project.items.commands.CreateItemCommand;
import com.tecvinsonacademy.cqrs_sample_project.mediator.Mediator;
import com.tecvinsonacademy.cqrs_sample_project.items.queries.GetItemsQuery;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final Mediator mediator;

    public ItemController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public void createItem(@RequestBody String name) {
        mediator.send(new CreateItemCommand(name));
    }

    @GetMapping
    public List<String> getItems() {
        return mediator.send(new GetItemsQuery());
    }
}

