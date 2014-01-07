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

import static java.util.concurrent.TimeUnit.*;

import java.util.function.Function;

import kiss.Disposable;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.Async;
import booton.soeur.ScriptRunner;

/**
 * @version 2013/12/30 11:19:45
 */
@RunWith(ScriptRunner.class)
public class ObservableTest {

    @Test
    public void subscribe() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        Disposable unsubscribe = emitter.observe().subscribe(emitter);

        assert emitter.emitAndRetrieve(10) == 10;
        assert emitter.emitAndRetrieve(20) == 20;

        unsubscribe.dispose();
        assert emitter.emitAndRetrieve(30) == null;
    }

    @Test
    public void skip() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        Disposable unsubscribe = emitter.observe().skip(1).subscribe(emitter);

        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(20) == 20;

        unsubscribe.dispose();
        assert emitter.emitAndRetrieve(30) == null;
    }

    @Test
    public void take() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        emitter.observe().limit(1).subscribe(emitter);

        assert !emitter.isUnsbscribed();
        assert emitter.emitAndRetrieve(10) == 10;
        assert emitter.isUnsbscribed();
        assert emitter.emitAndRetrieve(20) == null;
    }

    @Test
    public void skipAndTake() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        emitter.observe().skip(1).limit(1).subscribe(emitter);

        assert !emitter.isUnsbscribed();
        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(20) == 20;
        assert emitter.isUnsbscribed();
        assert emitter.emitAndRetrieve(30) == null;
    }

    @Test
    public void filter() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        emitter.observe().filter(value -> {
            return value % 2 == 0;
        }).subscribe(emitter);

        assert emitter.emitAndRetrieve(10) == 10;
        assert emitter.emitAndRetrieve(20) == 20;
        assert emitter.emitAndRetrieve(25) == null;
    }

    @Test
    public void throttle() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        emitter.observe().throttle(20, MILLISECONDS).subscribe(emitter);

        assert emitter.emitAndRetrieve(10) == 10;
        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(10) == null;

        Async.wait(20);
        assert emitter.emitAndRetrieve(10) == 10;
    }

    @Test
    public void debounce() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        emitter.observe().debounce(10, MILLISECONDS).subscribe(emitter);

        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(20) == null;
        assert emitter.emitAndRetrieve(30) == null;

        Async.awaitTasks();
        assert emitter.retrieve() == 30;
    }

    @Test
    public void map() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        Disposable unsubscribe = emitter.observe().map((Function<Integer, Integer>) value -> {
            return value * 2;
        }).subscribe(emitter);

        assert emitter.emitAndRetrieve(10) == 20;
        assert emitter.emitAndRetrieve(20) == 40;

        unsubscribe.dispose();
        assert emitter.emitAndRetrieve(30) == null;
    }

    @Test
    public void distinct() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        emitter.observe().distinct().subscribe(emitter);

        assert emitter.emitAndRetrieve(10) == 10;
        assert emitter.emitAndRetrieve(20) == 20;
        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(20) == null;
        assert emitter.emitAndRetrieve(30) == 30;
    }
}
