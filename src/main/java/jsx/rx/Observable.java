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

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import kiss.Disposable;

/**
 * @version 2014/01/04 9:27:39
 */
public class Observable<V> {

    /** For reuse. */
    public static final Disposable NEVER = () -> {
    };

    private static final ScheduledExecutorService tasks = Executors.newScheduledThreadPool(4);

    private Function<Observer<? super V>, Disposable> subscriber;

    private Disposable unsubscriber;

    /**
     * <p>
     * Observable with Function to execute when subscribed to.
     * </p>
     * 
     * @param onSubscribe A subscriber {@link Function} to be executed when
     *            {@link #subscribe(Observer)} is called.
     */
    public Observable(Function<Observer<? super V>, Disposable> subscriber) {
        this.subscriber = subscriber;
    }

    /**
     * <p>
     * Observable with Function to execute when subscribed to.
     * </p>
     * 
     * @param next
     */
    private Observable(Observable<V> chain, BiConsumer<Observer<? super V>, V> next) {
        this.subscriber = observer -> {
            return chain.subscribe(observer, value -> {
                next.accept(observer, value);
            });
        };
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
    public final Disposable subscribe(Consumer<? super V> next, Consumer<Throwable> error, Runnable complete) {
        return subscribe(new Observer<V>() {

            /**
             * {@inheritDoc}
             */
            @Override
            public void onCompleted() {
                if (complete != null) {
                    complete.run();
                }
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void onError(Throwable e) {
                if (error != null) {
                    error.accept(e);
                }
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void onNext(V value) {
                if (next != null) {
                    next.accept(value);
                }
            }
        });
    }

    /**
     * <p>
     * An {@link Observer} must call an Observable's {@code subscribe} method in order to receive
     * items and notifications from the Observable.
     * </p>
     * 
     * @param observer A value observer.
     * @return A functionality provider for the dispose of this subscription.
     */
    public final Disposable subscribe(Observer<? super V> observer) {
        unsubscriber = subscriber.apply(observer);

        return unsubscriber == null ? NEVER : unsubscriber;
    }

    /**
     * <p>
     * An {@link Observer} must call an Observable's {@code subscribe} method in order to receive
     * items and notifications from the Observable.
     * 
     * @param delegator An observer delegator.
     * @param next A next process.
     * @return A functionality provider for the dispose of this subscription.
     */
    private final Disposable subscribe(Observer<? super V> delegator, Consumer<? super V> next) {
        return subscribe(delegator, next, null);
    }

    /**
     * <p>
     * An {@link Observer} must call an Observable's {@code subscribe} method in order to receive
     * items and notifications from the Observable.
     * 
     * @param delegator An observer delegator.
     * @param next A next process.
     * @param error An error handling.
     * @return A functionality provider for the dispose of this subscription.
     */
    private final Disposable subscribe(Observer<? super V> delegator, Consumer<? super V> next, Consumer<Throwable> error) {
        return subscribe(delegator, next, error, null);
    }

    /**
     * <p>
     * An {@link Observer} must call an Observable's {@code subscribe} method in order to receive
     * items and notifications from the Observable.
     * 
     * @param delegator An observer delegator.
     * @param next A next process.
     * @param error An error handling.
     * @param complete A complete process.
     * @return A functionality provider for the dispose of this subscription.
     */
    private final Disposable subscribe(Observer<? super V> delegator, Consumer<? super V> next, Consumer<Throwable> error, Runnable complete) {
        return subscribe(new Observer<V>() {

            /**
             * {@inheritDoc}
             */
            @Override
            public void onCompleted() {
                if (complete == null) {
                    delegator.onCompleted();
                } else {
                    complete.run();
                }
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void onError(Throwable e) {
                if (error == null) {
                    delegator.onError(e);
                } else {
                    error.accept(e);
                }
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void onNext(V value) {
                if (next == null) {
                    delegator.onNext(value);
                } else {
                    next.accept(value);
                }
            }
        });
    }

    /**
     * <p>
     * Create an {@link Observable} that skips the first sequence items emitted by the
     * {@link Observable} and emits the remainder.
     * </p>
     * 
     * @param count A number of items to skip.
     * @return Chainable API.
     */
    public final Observable<V> skip(long count) {
        AtomicInteger counter = new AtomicInteger();

        return new Observable<V>(this, (observer, value) -> {
            if (count < counter.incrementAndGet()) {
                observer.onNext(value);
            }
        });
    }

    /**
     * <p>
     * Create an {@link Observable} that emits only the first sequence items emitted by the source
     * {@link Observable}.
     * </p>
     * 
     * @param count A number of items to emit.
     * @return Chainable API.
     */
    public final Observable<V> limit(long count) {
        AtomicLong counter = new AtomicLong(count);

        return new Observable<V>(this, (observer, value) -> {
            long current = counter.decrementAndGet();

            if (0 <= current) {
                observer.onNext(value);

                if (0 == current) {
                    unsubscriber.dispose();
                }
            }
        });
    }

    /**
     * <p>
     * Filter values emitted by this {@link Observable}.
     * </p>
     * 
     * @param predicate A function that evaluates the values emitted by the source
     *            {@link Observable}, returning {@code true} if they pass the filter.
     * @return Chainable API.
     */
    public final Observable<V> filter(Predicate<? super V> predicate) {
        return new Observable<V>(this, (observer, value) -> {
            if (predicate.test(value)) {
                observer.onNext(value);
            }
        });
    }

    /**
     * <p>
     * Returns an {@link Observable} that applies the given constant to each item emitted by an
     * {@link Observable} and emits the result.
     * </p>
     * 
     * @param constant A constant to apply to each item emitted by this {@link Observable}.
     * @return Chainable API.
     */
    public final <R> Observable<R> map(R constant) {
        return new Observable<R>(observer -> {
            return subscribe(value -> {
                observer.onNext(constant);
            });
        });
    }

    /**
     * <p>
     * Returns an {@link Observable} that applies the given function to each item emitted by an
     * {@link Observable} and emits the result.
     * </p>
     * 
     * @param converter A converter function to apply to each item emitted by this
     *            {@link Observable}.
     * @return Chainable API.
     */
    public final <R> Observable<R> map(Function<? super V, ? extends R> converter) {
        return new Observable<R>(observer -> {
            return subscribe(value -> {
                observer.onNext(converter.apply(value));
            });
        });
    }

    /**
     * <p>
     * Returns a {@link Observable} consisting of the distinct elements (according to
     * {@link Object#equals(Object)}) of this stream.
     * </p>
     * <p>
     * For ordered streams, the selection of distinct elements is stable (for duplicated elements,
     * the element appearing first in the encounter order is preserved.) For unordered streams, no
     * stability guarantees are made.
     * </p>
     * 
     * @apiNote Preserving stability for {@code distinct()} in parallel pipelines is relatively
     *          expensive (requires that the operation act as a full barrier, with substantial
     *          buffering overhead), and stability is often not needed. Using an unordered stream
     *          source (such as {@link #generate(Supplier)}) or removing the ordering constraint
     *          with {@link #unordered()} may result in significantly more efficient execution for
     *          {@code distinct()} in parallel pipelines, if the semantics of your situation permit.
     *          If consistency with encounter order is required, and you are experiencing poor
     *          performance or memory utilization with {@code distinct()} in parallel pipelines,
     *          switching to sequential execution with {@link #sequential()} may improve
     *          performance.
     * @return Chainable API.
     */
    public final Observable<V> distinct() {
        Set<V> set = new HashSet();

        return new Observable<V>(this, (observer, value) -> {
            if (set.add(value)) {
                observer.onNext(value);
            }
        });
    }

    /**
     * <p>
     * Throttles by skipping items until "skipDuration" passes and then emits the next received
     * item.
     * </p>
     * 
     * @param time Time to wait before sending another item after emitting the last item.
     * @param unit A unit of time for the specified timeout.
     * @return Chainable API.
     */
    public final Observable<V> throttle(long time, TimeUnit unit) {
        AtomicLong latest = new AtomicLong();
        long delay = unit.toMillis(time);

        return filter(value -> {
            long now = System.currentTimeMillis();
            return latest.getAndSet(now) + delay <= now;
        });
    }

    /**
     * <p>
     * Drops items emitted by an {@link Observable} that are followed by newer items before a
     * timeout value expires. The timer resets on each emission.
     * </p>
     * 
     * @param time A time each value has to be "the most recent" of the {@link Observable} to ensure
     *            that it's not dropped.
     * @param unit A time unit.
     * @return Chainable API.
     */
    public final Observable<V> debounce(long time, TimeUnit unit) {
        AtomicReference<ScheduledFuture> latest = new AtomicReference();

        return new Observable<V>(this, (observer, value) -> {
            ScheduledFuture task = latest.get();

            if (task != null) {
                task.cancel(true);
            }

            latest.set(tasks.schedule(() -> {
                latest.set(null);
                observer.onNext(value);
            }, time, unit));
        });
    }

    /**
     * <p>
     * Alias of {@link #map(Object)}.
     * </p>
     * 
     * @param condition A converter function to apply to each item emitted by this
     *            {@link Observable}.
     * @return Chainable API.
     */
    public final <R> Observable<R> when(Function<? super V, ? extends R> condition) {
        return map(condition);
    }

    /**
     * <p>
     * Creates a pattern that matches when both Observable sequences have an available item.
     * </p>
     * 
     * @param right Observable sequence to match with the left sequence
     * @return Pattern object that matches when both Observable sequences have an available item
     * @throws NullPointerException if <code>right</code> is null
     * @see <a
     *      href="https://github.com/Netflix/RxJava/wiki/Combining-Observables#and-then-and-when">RxJava
     *      Wiki: and()</a>
     * @see <a href="http://msdn.microsoft.com/en-us/library/hh229153.aspx">MSDN: Observable.And</a>
     * @return
     */
    public final Observable<V> and() {
        return null;
    }
}
