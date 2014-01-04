/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.rx;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

import javafx.beans.Observable;

/**
 * @version 2014/01/04 9:37:10
 */
public abstract class Base<T> implements Observable<T> {

    /** The actual observer. */
    private final Observer<T> delegator;

    /** The flag for completion. */
    private AtomicBoolean completed = new AtomicBoolean();

    /**
     * @param delegator
     * @param disposer
     */
    protected Base(Observer<T> delegator) {
        this.delegator = delegator;
    }

    protected abstract void onNext(final T element, final Consumer<? super R> onNext);

    protected void onError(final Exception exception, final Consumer<Exception> onError) {
        onError.accept(exception);
    }

    protected void onCompleted(final Runnable onCompleted) {
        onCompleted.run();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCompleted() {
        if (completed.compareAndSet(false, true)) {
            try {
                delegator.onCompleted();
            } catch (Throwable e) {
                onError(e);
            }

            // unsubscribe automatically
            dispose();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onError(Throwable e) {
        if (completed.compareAndSet(false, true)) {
            delegator.onError(e);

            // unsubscribe automatically
            dispose();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onNext(T item) {
        if (!completed.get()) {
            try {
                delegator.onNext(item);
            } catch (Throwable e) {
                onError(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void dispose() {
    }
}