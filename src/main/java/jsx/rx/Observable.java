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

import java.util.function.Consumer;
import java.util.function.Function;

import kiss.Disposable;
import rx.Observable.OnSubscribeFunc;

/**
 * @version 2014/01/04 9:27:39
 */
public abstract class Observable<V> {

    private Function<Observer<? super V>, Disposable> subscriber;

    /**
     * Observable with Function to execute when subscribed to.
     * <p>
     * NOTE: Use {@link #create(OnSubscribeFunc)} to create an Observable instead of this
     * constructor unless you specifically have a need for inheritance.
     * 
     * @param onSubscribe {@link OnSubscribeFunc} to be executed when {@link #subscribe(Observer)}
     *            is called
     */
    protected Observable(Function<Observer<? super V>, Disposable> subscriber) {
        this.subscriber = subscriber;
    }

    /**
     * Returns an Observable that skips the first <code>num</code> items emitted by the source
     * Observable and emits the remainder.
     * <p>
     * <img width="640"
     * src="https://raw.github.com/wiki/Netflix/RxJava/images/rx-operators/skip.png">
     * <p>
     * You can ignore the first <code>num</code> items emitted by an Observable and attend only to
     * those items that come after, by modifying the Observable with the <code>skip</code> method.
     * 
     * @param number the number of items to skip
     * @return an Observable that is identical to the source Observable except that it does not emit
     *         the first <code>num</code> items that the source emits
     */
    public final Observable<V> skip(int number) {
        return null;
    }

    /**
     * <p>
     * * An {@link Observer} must call an Observable's {@code subscribe} method in order to receive
     * items and notifications from the Observable.
     * </p>
     * 
     * @param observer A value observer.
     * @return A functionality provider for the dispose of this subscription.
     */
    public final Disposable subscribe(Observer<V> observer) {
        return subscribe(observer::onNext, observer::onError, observer::onCompleted);
    }

    /**
     * <p>
     * An {@link Observer} must call an Observable's {@code subscribe} method in order to receive
     * items and notifications from the Observable.
     * 
     * @param next A next process.
     * @return A functionality provider for the dispose of this subscription.
     */
    public final Disposable subscribe(Consumer<? super V> next) {
        return subscribe(next, null);
    }

    /**
     * <p>
     * An {@link Observer} must call an Observable's {@code subscribe} method in order to receive
     * items and notifications from the Observable.
     * 
     * @param next A next process.
     * @param error An error handling.
     * @return A functionality provider for the dispose of this subscription.
     */
    public final Disposable subscribe(Consumer<? super V> next, Consumer<Throwable> error) {
        return subscribe(next, error, null);
    }

    /**
     * <p>
     * An {@link Observer} must call an Observable's {@code subscribe} method in order to receive
     * items and notifications from the Observable.
     * 
     * @param next A next process.
     * @param error An error handling.
     * @param complete A complete process.
     * @return A functionality provider for the dispose of this subscription.
     */
    public abstract Disposable subscribe(Consumer<? super V> next, Consumer<Throwable> error, Runnable complete);
}
