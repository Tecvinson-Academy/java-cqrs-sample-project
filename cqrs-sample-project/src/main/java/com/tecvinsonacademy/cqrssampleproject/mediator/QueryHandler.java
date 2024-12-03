package com.tecvinsonacademy.cqrssampleproject.mediator;

public interface QueryHandler<Q extends Query<R>, R> {
    R handle(Q query);
}
