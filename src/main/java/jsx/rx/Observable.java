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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import kiss.Disposable;

/**
 * @version 2014/01/10 22:31:16
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

    /** The job scheduler. */
    public static ScheduledExecutorService tasks = Executors.newScheduledThreadPool(4);

    /** The subscriber. */
    private Function<Observer<? super V>, Disposable> subscriber;

    /** The unsubscriber. */
    private Disposable unsubscriber;

    /**
     * <p>
     * Create {@link Observable} with the specified subscriber {@link Function} which will be
     * invoked whenever you calls {@link #subscribe(Observer)} related methods.
     * </p>
     * 
     * @param subscriber A subscriber {@link Function}.
     * @see #subscribe(Observer)
     * @see #subscribe(Consumer)
     * @see #subscribe(Consumer, Consumer)
     * @see #subscribe(Consumer, Consumer, Runnable)
     */
    public Observable(Function<Observer<? super V>, Disposable> subscriber) {
        this.subscriber = subscriber;
    }

    /**
     * <p>
     * Create {@link Observable} with the specified subscriber {@link Function} which will be
     * invoked whenever you calls {@link #subscribe(Observer)} related methods.
     * </p>
     * 
     * @param previous A previous {@link Observable} of chain.
     * @param next A {@link Observer#onNext(Object)} method to delegate.
     */
    private Observable(Observable<V> previous, BiConsumer<Observer<? super V>, V> next) {
        this.subscriber = observer -> {
            Subscriber<V> delegator = new Subscriber(observer);
            delegator.next = value -> {
                next.accept(observer, value);
            };
            return previous.subscribe(delegator);
        };
    }

    /**
     * <p>
     * Receive values from this {@link Observable}.
     * </p>
     * 
     * @param next A delegator method of {@link Observer#onNext(Object)}.
     * @return Calling {@link Disposable#dispose()} will dispose this subscription.
     */
    public final Disposable subscribe(Consumer<? super V> next) {
        return subscribe(next, null);
    }

    /**
     * <p>
     * An {@link Observer} must call an Observable's {@code subscribe} method in order to receive
     * items and notifications from the Observable.
     * 
     * @param next A delegator method of {@link Observer#onNext(Object)}.
     * @param error A delegator method of {@link Observer#onError(Throwable)}.
     * @return Calling {@link Disposable#dispose()} will dispose this subscription.
     */
    public final Disposable subscribe(Consumer<? super V> next, Consumer<Throwable> error) {
        return subscribe(next, error, null);
    }

    /**
     * <p>
     * Receive values from this {@link Observable}.
     * </p>
     * 
     * @param next A delegator method of {@link Observer#onNext(Object)}.
     * @param error A delegator method of {@link Observer#onError(Throwable)}.
     * @param complete A delegator method of {@link Observer#onCompleted()}.
     * @return Calling {@link Disposable#dispose()} will dispose this subscription.
     */
    public final Disposable subscribe(Consumer<? super V> next, Consumer<Throwable> error, Runnable complete) {
        Subscriber<V> observer = new Subscriber(null);
        observer.next = next;
        observer.error = error;
        observer.complete = complete;

        return subscribe(observer);
    }

    /**
     * <p>
     * Receive values from this {@link Observable}.
     * </p>
     * 
     * @param observer A value observer of this {@link Observable}.
     * @return Calling {@link Disposable#dispose()} will dispose this subscription.
     */
    public final Disposable subscribe(Observer<? super V> observer) {
        return unsubscriber = subscriber.apply(observer);
    }

    /**
     * <p>
     * Indicates each value of an {@link Observable} sequence into consecutive non-overlapping
     * buffers which are produced based on value count information.
     * </p>
     * 
     * @param size A length of each buffer.
     * @return Chainable API.
     */
    public final Observable<V[]> buffer(int size) {
        return buffer(size, size);
    }

    /**
     * <p>
     * Indicates each values of an {@link Observable} sequence into zero or more buffers which are
     * produced based on value count information.
     * </p>
     * 
     * @param size A length of each buffer.
     * @param interval A number of values to skip between creation of consecutive buffers.
     * @return Chainable API.
     */
    public final Observable<V[]> buffer(int size, int interval) {
        return new Observable<V[]>(observer -> {
            Deque<V> buffer = new ArrayDeque();
            AtomicInteger timing = new AtomicInteger();

            return subscribe(value -> {
                buffer.offer(value);

                boolean validTiming = timing.incrementAndGet() == interval;
                boolean validSize = buffer.size() == size;

                if (validTiming && validSize) {
                    observer.onNext((V[]) buffer.toArray());
                }

                if (validTiming) {
                    timing.set(0);
                }

                if (validSize) {
                    buffer.pollFirst();
                }
            });
        });
    }

    /**
     * <p>
     * Drops values that are followed by newer values before a timeout. The timer resets on each
     * value emission.
     * </p>
     * 
     * @param time A time value.
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

    /**
     * <p>
     * Indicates the {@link Observable} sequence by due time with the specified source and time.
     * </p>
     * 
     * @param time The absolute time used to shift the {@link Observable} sequence.
     * @param unit A unit of time for the specified time.
     * @return Chainable API.
     */
    public final Observable<V> delay(long time, TimeUnit unit) {
        return new Observable<V>(this, (observer, value) -> {
            tasks.schedule(() -> {
                observer.onNext(value);
            }, time, unit);
        });
    }

    /** The previous value for diff. */
    private AtomicReference<V> diff;

    /**
     * <p>
     * Returns an {@link Observable} consisting of the distinct values (according to
     * {@link Object#equals(Object)}) of this stream.
     * </p>
     * 
     * @return Chainable API.
     */
    public final Observable<V> diff() {
        return new Observable<V>(observer -> {
            diff = new AtomicReference();

            return subscribe(value -> {
                V prev = diff.getAndSet(value);

                if (!Objects.equals(prev, value)) {
                    observer.onNext(value);
                }
            });
        });
    }

    /** The distinct set. */
    private Set<V> distinct;

    /**
     * <p>
     * Returns an {@link Observable} consisting of the distinct values (according to
     * {@link Object#equals(Object)}) of this stream.
     * </p>
     * 
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
     * Returns an {@link Observable} consisting of the values of this {@link Observable} that match
     * the given predicate.
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
     * @param constant A constant to apply to each value emitted by this {@link Observable}.
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
     * Returns an {@link Observable} that applies the given function to each value emitted by an
     * {@link Observable} and emits the result.
     * </p>
     * 
     * @param converter A converter function to apply to each value emitted by this
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
     * Flattens a sequence of {@link Observable} emitted by an {@link Observable} into one
     * {@link Observable}, without any transformation.
     * </p>
     * 
     * @param other A target {@link Observable} to merge.
     * @return Chainable API.
     */
    public final Observable<V> merge(Observable<V> other) {
        return new Observable<V>(observer -> {
            return new Unsubscriber().and(subscribe(observer)).and(other.subscribe(observer));
        });
    }

    /**
     * <p>
     * Generates an {@link Observable} sequence that repeats the given value infinitely.
     * </p>
     * 
     * @return Chainable API.
     */
    public final Observable<V> repeat() {
        return new Observable<V>(observer -> {
            Subscriber<V> delegator = new Subscriber<V>(observer);
            delegator.complete = () -> {
                observer.onCompleted();
                subscribe(delegator);
            };
            return subscribe(delegator);
        });
    }

    /**
     * <p>
     * Generates an {@link Observable} sequence that repeats the given value finitely.
     * </p>
     * 
     * @param count A number of repeat.
     * @return Chainable API.
     */
    public final Observable<V> repeat(int count) {
        AtomicInteger repeat = new AtomicInteger(count);

        return new Observable<V>(observer -> {
            Subscriber<V> subscriber = new Subscriber<V>(observer);
            subscriber.complete = () -> {
                if (repeat.decrementAndGet() == 0) {
                    unsubscriber.dispose();
                } else {
                    unsubscriber = new Unsubscriber().and(unsubscriber).and(subscribe(subscriber));
                }
            };
            return subscribe(subscriber);
        });
    }

    /** The skip counter. */
    private AtomicInteger skip;

    /**
     * <p>
     * Bypasses a specified number of values in an {@link Observable} sequence and then returns the
     * remaining values.
     * </p>
     * 
     * @param count A number of values to skip.
     * @return Chainable API.
     */
    public final Observable<V> skip(int count) {
        return new Observable<V>(observer -> {
            skip = new AtomicInteger();

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
     * Returns the values from the source {@link Observable} sequence only after the other
     * {@link Observable} sequence produces a value.
     * </p>
     * 
     * @param predicate An {@link Observable} sequence that triggers propagation of values of the
     *            source sequence.
     * @return Chainable API.
     */
    public final <T> Observable<V> skipUntil(Observable<T> predicate) {
        return new Observable<V>(observer -> {
            skipUntil = new AtomicBoolean();

            return new Unsubscriber().and(subscribe(value -> {
                if (skipUntil.get()) {
                    observer.onNext(value);
                }
            })).and(predicate.subscribe(value -> {
                skipUntil.set(true);
            }));
        });
    }

    /**
     * <p>
     * Returns the values from the source {@link Observable} sequence only after the other
     * {@link Observable} sequence produces a value.
     * </p>
     * 
     * @param predicate An {@link Observable} sequence that triggers propagation of values of the
     *            source sequence.
     * @return Chainable API.
     */
    public final <T> Observable<V> skipUntil(Predicate<V> predicate) {
        return new Observable<V>(observer -> {
            skipUntil = new AtomicBoolean();

            return subscribe(value -> {
                if (skipUntil.get()) {
                    observer.onNext(value);
                } else if (predicate.test(value)) {
                    skipUntil.set(true);
                    observer.onNext(value);
                }
            });
        });
    }

    /** The take counter. */
    private AtomicInteger take;

    /**
     * <p>
     * Returns a specified number of contiguous values from the start of an {@link Observable}
     * sequence.
     * </p>
     * 
     * @param count A number of values to emit.
     * @return Chainable API.
     */
    public final Observable<V> take(int count) {
        return new Observable<V>(observer -> {
            take = new AtomicInteger(count);

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
     * Returns the values from the source {@link Observable} sequence until the other
     * {@link Observable} sequence produces a value.
     * </p>
     * 
     * @param predicate An {@link Observable} sequence that terminates propagation of values of the
     *            source sequence.
     * @return Chainable API.
     */
    public final <T> Observable<V> takeUntil(Observable<T> predicate) {
        return new Observable<V>(observer -> {
            return unsubscriber = new Unsubscriber().and(subscribe(observer)).and(predicate.subscribe(value -> {
                observer.onCompleted();
                unsubscriber.dispose();
            }));
        });
    }

    /**
     * <p>
     * Returns the values from the source {@link Observable} sequence until the other
     * {@link Observable} sequence produces a value.
     * </p>
     * 
     * @param predicate An {@link Observable} sequence that terminates propagation of values of the
     *            source sequence.
     * @return Chainable API.
     */
    public final <T> Observable<V> takeUntil(Predicate<V> predicate) {
        return new Observable<V>(this, (observer, value) -> {
            if (predicate.test(value)) {
                observer.onNext(value);
                observer.onCompleted();
                unsubscriber.dispose();
            } else {
                observer.onNext(value);
            }
        });
    }

    /**
     * <p>
     * Throttles by skipping values until "skipDuration" passes and then emits the next received
     * value.
     * </p>
     * <p>
     * Ignores the values from an {@link Observable} sequence which are followed by another value
     * before due time with the specified source and time.
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
            Unsubscriber unsubscriber = new Unsubscriber();
            boolean[] conditions = new boolean[observables.length];

            for (int i = 0; i < observables.length; i++) {
                int index = i;
                unsubscriber.add(observables[index].subscribe(value -> {
                    conditions[index] = !predicate.test(value);

                    observer.onNext(condition.test(conditions));
                }));
            }
            return unsubscriber;
        });
    }
}
