package com.tecvinsonacademy.cqrs_sample_project.mediator;

public interface QueryHandler<Q extends Query<R>, R> {
    R handle(Q query);
}
