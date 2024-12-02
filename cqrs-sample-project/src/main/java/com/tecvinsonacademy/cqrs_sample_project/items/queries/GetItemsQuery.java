package com.tecvinsonacademy.cqrs_sample_project.items.queries;

import com.tecvinsonacademy.cqrs_sample_project.mediator.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetItemsQuery implements Query<List<String>> { }

