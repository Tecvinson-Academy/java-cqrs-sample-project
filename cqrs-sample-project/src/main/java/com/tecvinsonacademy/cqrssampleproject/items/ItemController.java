package com.tecvinsonacademy.cqrssampleproject.items;

import com.tecvinsonacademy.cqrssampleproject.items.commands.CreateItemCommand;
import com.tecvinsonacademy.cqrssampleproject.mediator.Mediator;
import com.tecvinsonacademy.cqrssampleproject.items.queries.GetItemsQuery;
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

