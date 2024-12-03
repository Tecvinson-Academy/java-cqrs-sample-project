package com.tecvinsonacademy.cqrssampleproject.items.queries;

import com.tecvinsonacademy.cqrssampleproject.mediator.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class GetItemsQueryHandler implements QueryHandler<GetItemsQuery, List<String>> {

    @Override
    public List<String> handle(GetItemsQuery query) {
        // Simulate fetching from database
        return Arrays.asList("Item1", "Item2", "Item3");
    }
}
