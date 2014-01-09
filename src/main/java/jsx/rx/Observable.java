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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import kiss.Disposable;

/**
 * @version 2014/01/09 1:16:11
 */
public class Observable<V> {

    /** For reuse. */
    private static final Disposable EmptyDisposable = () -> {
    };

    /** For reuse. */
    private static final Predicate<Boolean> IdenticalPredicate = value -> {
        return value;
    };

    /** For reuse. */
    public static final Observable NEVER = new Observable(observer -> {
        return EmptyDisposable;
    });

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

        return unsubscriber == null ? EmptyDisposable : unsubscriber;
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
        DelegatableObserver<V> observer = new DelegatableObserver<V>(delegator);
        observer.next = next;
        observer.error = error;
        observer.complete = complete;

        return subscribe(observer);
    }

    /**
     * @version 2014/01/09 13:35:39
     */
    private static class DelegatableObserver<V> implements Observer<V> {

        /** The delegation. */
        private final Observer<? super V> delegator;

        /** The delegation. */
        private Consumer<? super V> next;

        /** The delegation. */
        private Consumer<Throwable> error;

        /** The delegation. */
        private Runnable complete;

        /**
         * @param delegator
         * @param next
         * @param error
         * @param complete
         */
        private DelegatableObserver(Observer<? super V> delegator) {
            this.delegator = delegator;
        }

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
            ScheduledFuture future = latest.get();

            if (future != null) {
                future.cancel(true);
            }

            Runnable task = () -> {
                latest.set(null);
                observer.onNext(value);
            };
            latest.set(tasks.schedule(task, time, unit));
        });
    }

    private Set<V> distinct;

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
        return new Observable<V>(observer -> {
            distinct = new HashSet();

            return subscribe(value -> {
                if (distinct.add(value)) {
                    observer.onNext(value);
                }
            });
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
     * Flattens a sequence of {@link Observable} emitted by an Observable into one
     * {@link Observable}, without any transformation.
     * </p>
     * 
     * @param other A target {@link Observable} to merge.
     * @return Chainable API.
     */
    public final Observable<V> merge(Observable<V> other) {
        return new Observable<V>(observer -> {
            return new Disposables().add(subscribe(observer)).add(other.subscribe(observer));
        });
    }

    public final Observable<V> repeat() {
        return new Observable<V>(observer -> {
            DelegatableObserver<V> delegator = new DelegatableObserver<V>(observer);
            delegator.complete = () -> {
                observer.onCompleted();
                subscribe(delegator);
            };
            return subscribe(delegator);
        });
    }

    /** The skip counter. */
    private AtomicLong skip;

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
        return new Observable<V>(observer -> {
            skip = new AtomicLong();

            return subscribe(value -> {
                if (count < skip.incrementAndGet()) {
                    observer.onNext(value);
                }
            });
        });
    }

    private AtomicBoolean skipUntil;

    /**
     * <p>
     * Create an {@link Observable} that skips the first sequence items emitted by the
     * {@link Observable} and emits the remainder.
     * </p>
     * 
     * @param count A number of items to skip.
     * @return Chainable API.
     */
    public final <T> Observable<V> skipUntil(Observable<T> predicate) {
        return new Observable<V>(observer -> {
            skipUntil = new AtomicBoolean();

            return new Disposables().add(subscribe(value -> {
                if (skipUntil.get()) {
                    observer.onNext(value);
                }
            })).add(predicate.subscribe(value -> {
                skipUntil.set(true);
            }));
        });
    }

    /** The take counter. */
    private AtomicLong take;

    /**
     * <p>
     * Create an {@link Observable} that emits only the first sequence items emitted by the source
     * {@link Observable}.
     * </p>
     * 
     * @param count A number of items to emit.
     * @return Chainable API.
     */
    public final Observable<V> take(long count) {
        return new Observable<V>(observer -> {
            take = new AtomicLong(count);

            return subscribe(value -> {
                long current = take.decrementAndGet();

                if (0 <= current) {
                    observer.onNext(value);

                    if (0 == current) {
                        observer.onCompleted();
                        unsubscriber.dispose();
                    }
                }
            });
        });
    }

    /**
     * <p>
     * Create an {@link Observable} that emits only the first sequence items emitted by the source
     * {@link Observable}.
     * </p>
     * 
     * @param count A number of items to skip.
     * @return Chainable API.
     */
    public final <T> Observable<V> takeUntil(Observable<T> predicate) {
        return new Observable<V>(observer -> {
            Disposables disposables = new Disposables();

            return disposables.add(subscribe(observer)).add(predicate.subscribe(value -> {
                observer.onCompleted();
                disposables.dispose();
            }));
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
     * @version 2014/01/09 2:14:14
     */
    private static class Disposables implements Disposable {

        /** The container. */
        private final List<Disposable> list = new ArrayList();

        /**
         * <p>
         * Add {@link Disposable}.
         * </p>
         * 
         * @param disposable A target to add.
         * @return Chainable API.
         */
        private Disposables add(Disposable disposable) {
            list.add(disposable);

            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void dispose() {
            for (Disposable disposable : list) {
                disposable.dispose();
            }
        }
    }

    /**
     * <p>
     * Create an {@link Observable} that emits true if all specified observables emit true as latest
     * event.
     * </p>
     * 
     * @param observables A list of target {@link Observable} to test.
     * @return Chainable API.
     */
    public static Observable<Boolean> all(Observable<Boolean>... observables) {
        return all(IdenticalPredicate, observables);
    }

    /**
     * <p>
     * Create an {@link Observable} that emits true if all specified observables emit true as latest
     * event.
     * </p>
     * 
     * @param predicate A test function.
     * @param observables A list of target {@link Observable} to test.
     * @return Chainable API.
     */
    public static <V> Observable<Boolean> all(Predicate<V> predicate, Observable<V>... observables) {
        return condition(values -> {
            for (boolean value : values) {
                if (value) {
                    return false;
                }
            }
            return true;
        }, predicate, observables);
    }

    /**
     * <p>
     * Create an {@link Observable} that emits true if any specified observable emits true as latest
     * event.
     * </p>
     * 
     * @param observables A list of target {@link Observable} to test.
     * @return Chainable API.
     */
    public static Observable<Boolean> any(Observable<Boolean>... observables) {
        return any(IdenticalPredicate, observables);
    }

    /**
     * <p>
     * Create an {@link Observable} that emits true if any specified observable emits true as latest
     * event.
     * </p>
     * 
     * @param predicate A test function.
     * @param observables A list of target {@link Observable} to test.
     * @return Chainable API.
     */
    public static <V> Observable<Boolean> any(Predicate<V> predicate, Observable<V>... observables) {
        return condition(values -> {
            for (boolean value : values) {
                if (!value) {
                    return true;
                }
            }
            return false;
        }, predicate, observables);
    }

    /**
     * <p>
     * Create an {@link Observable} that emits true if all specified observables emit false as
     * latest event.
     * </p>
     * 
     * @param observables A list of target {@link Observable} to test.
     * @return Chainable API.
     */
    public static Observable<Boolean> none(Observable<Boolean>... observables) {
        return none(IdenticalPredicate, observables);
    }

    /**
     * <p>
     * Create an {@link Observable} that emits true if all specified observables emit false as
     * latest event.
     * </p>
     * 
     * @param predicate A test function.
     * @param observables A list of target {@link Observable} to test.
     * @return Chainable API.
     */
    public static <V> Observable<Boolean> none(Predicate<V> predicate, Observable<V>... observables) {
        return condition(values -> {
            for (boolean value : values) {
                if (!value) {
                    return false;
                }
            }
            return true;
        }, predicate, observables);
    }

    /**
     * <p>
     * Helper method to merge the test result of each {@link Observable}.
     * </p>
     * 
     * @param condition A test function for result.
     * @param predicate A test function for each {@link Observable}.
     * @param observables A list of target {@link Observable} to test.
     * @return Chainable API.
     */
    private static <V> Observable<Boolean> condition(Predicate<boolean[]> condition, Predicate<V> predicate, Observable<V>... observables) {
        if (observables == null || observables.length == 0 || predicate == null) {
            return NEVER;
        }

        return new Observable<Boolean>(observer -> {
            Disposables disposables = new Disposables();
            boolean[] conditions = new boolean[observables.length];

            for (int i = 0; i < observables.length; i++) {
                int index = i;
                disposables.add(observables[index].subscribe(value -> {
                    conditions[index] = !predicate.test(value);

                    observer.onNext(condition.test(conditions));
                }));
            }
            return disposables;
        });
    }
}
