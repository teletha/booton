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
 * @version 2014/01/04 16:30:51
 */
public abstract class AbstractSubject<T> extends Subject<T, T> {

    /**
     * @param subscriber
     */
    protected AbstractSubject(Function<Observer<? super T>, Disposable> subscriber) {
        super(subscriber);
    }

}
