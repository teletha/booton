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

import java.util.function.Function;

import kiss.Disposable;

/**
 * @version 2014/01/04 14:47:49
 */
public abstract class Subject<T, R> extends Observable<R> implements Observer<T> {

    /**
     * @param subscriber
     */
    protected Subject(Function<Observer<? super R>, Disposable> subscriber) {
        super(subscriber);
    }
}
