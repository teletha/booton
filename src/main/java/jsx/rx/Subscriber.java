/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.rx;

import java.util.function.Consumer;

/**
 * @version 2014/01/09 13:35:39
 */
class Subscriber<V> implements Observer<V> {

    /** The delegation. */
    private final Observer<? super V> delegator;

    /** The delegation. */
    Consumer<? super V> next;

    /** The delegation. */
    Consumer<Throwable> error;

    /** The delegation. */
    Runnable complete;

    /**
     * @param delegator
     * @param next
     * @param error
     * @param complete
     */
    Subscriber(Observer<? super V> delegator) {
        this.delegator = delegator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCompleted() {
        if (complete != null) {
            complete.run();
        } else if (delegator != null) {
            delegator.onCompleted();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onError(Throwable e) {
        if (error != null) {
            error.accept(e);
        } else if (delegator != null) {
            delegator.onError(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onNext(V value) {
        if (next != null) {
            next.accept(value);
        } else if (delegator != null) {
            delegator.onNext(value);
        }
    }
}