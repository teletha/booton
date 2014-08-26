/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.event;

import java.util.ArrayList;
import java.util.function.Consumer;

import kiss.Disposable;
import kiss.Reactor;

/**
 * @version 2014/01/14 10:23:18
 */
@SuppressWarnings("serial")
class Agent<V> extends ArrayList<Disposable> implements Reactor<V>, Disposable {

    /** The delegation. */
    Reactor<? super V> observer;

    /** The delegation. */
    Consumer<? super V> next;

    /** The delegation. */
    Consumer<Throwable> error;

    /** The delegation. */
    Runnable complete;

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCompleted() {
        if (complete != null) {
            complete.run();
        } else if (observer != null) {
            observer.onCompleted();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onError(Throwable e) {
        if (error != null) {
            error.accept(e);
        } else if (observer != null) {
            observer.onError(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onNext(V value) {
        if (next != null) {
            next.accept(value);
        } else if (observer != null) {
            observer.onNext(value);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void dispose() {
        for (Disposable disposable : this) {
            disposable.dispose();
        }
    }

    /**
     * <p>
     * Aggregate {@link Disposable} into this instance.
     * </p>
     * 
     * @param disposable A target to dispose.
     * @return Chainable API.
     */
    @Override
    public Agent<V> and(Disposable disposable) {
        add(disposable);

        // API definition
        return this;
    }
}