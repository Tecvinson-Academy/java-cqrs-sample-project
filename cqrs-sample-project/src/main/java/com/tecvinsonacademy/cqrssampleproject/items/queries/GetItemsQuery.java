package com.tecvinsonacademy.cqrssampleproject.items.queries;

import com.tecvinsonacademy.cqrssampleproject.mediator.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetItemsQuery implements Query<List<String>> { }

