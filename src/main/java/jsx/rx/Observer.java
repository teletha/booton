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

/**
 * Provides a mechanism for receiving push-based notifications.
 * <p>
 * After an Observer calls an {@link Observable}'s <code>Observable.subscribe</code> method, the
 * {@link Observable} calls the Observer's <code>onNext</code> method to provide notifications. A
 * well-behaved {@link Observable} will call an Observer's <code>onCompleted</code> closure exactly
 * once or the Observer's <code>onError</code> closure exactly once.
 * <p>
 * For more information see the <a href="https://github.com/Netflix/RxJava/wiki/Observable">RxJava
 * Wiki</a>
 * 
 * @param <V>
 */
public interface Observer<V> {

    /**
     * Notifies the Observer that the {@link Observable} has finished sending push-based
     * notifications.
     * <p>
     * The {@link Observable} will not call this closure if it calls <code>onError</code>.
     */
    public default void onCompleted() {
        // do nothing
    }

    /**
     * Notifies the Observer that the {@link Observable} has experienced an error condition.
     * <p>
     * If the {@link Observable} calls this closure, it will not thereafter call <code>onNext</code>
     * or <code>onCompleted</code>.
     * 
     * @param e
     */
    public default void onError(Throwable e) {
        // do nothing
    }

    /**
     * Provides the Observer with new data.
     * <p>
     * The {@link Observable} calls this closure 1 or more times, unless it calls
     * <code>onError</code> in which case this closure may never be called.
     * <p>
     * The {@link Observable} will not call this closure again after it calls either
     * <code>onCompleted</code> or <code>onError</code>.
     * 
     * @param value
     */
    public default void onNext(V value) {
        // do nothing
    }
}