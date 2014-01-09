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

import static java.util.concurrent.TimeUnit.*;

import java.util.function.Function;

import kiss.Disposable;

import org.junit.Test;

import booton.soeur.Async;

/**
 * @version 2014/01/09 1:01:34
 */
// @RunWith(ScriptRunner.class)
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
    public void skipUntil() throws Exception {
        EventEmitter<String> condition = new EventEmitter();
        EventEmitter<Integer> emitter = new EventEmitter();
        Disposable disposable = emitter.observe().skipUntil(condition.observe()).subscribe(emitter);

        assert condition.isUnsbscribed() == false;
        assert emitter.isUnsbscribed() == false;
        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(20) == null;

        condition.emit("start");
        assert emitter.emitAndRetrieve(10) == 10;
        assert emitter.emitAndRetrieve(20) == 20;

        disposable.dispose();
        assert condition.isUnsbscribed() == true;
        assert emitter.isUnsbscribed() == true;
        assert emitter.emitAndRetrieve(10) == null;
    }

    @Test
    public void skipUntilRepeat() throws Exception {
        EventEmitter<String> condition = new EventEmitter();
        EventEmitter<Integer> emitter = new EventEmitter();
        Disposable disposable = emitter.observe().skipUntil(condition.observe()).take(1).repeat().subscribe(emitter);

        assert condition.isUnsbscribed() == false;
        assert emitter.isUnsbscribed() == false;
        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(20) == null;

        condition.emit("start");
        assert emitter.emitAndRetrieve(10) == 10;
        assert emitter.emitAndRetrieve(20) == null;

        condition.emit("start");
        assert emitter.emitAndRetrieve(10) == 10;
        assert emitter.emitAndRetrieve(20) == null;

        disposable.dispose();
        assert condition.isUnsbscribed() == true;
        assert emitter.isUnsbscribed() == true;
        assert emitter.emitAndRetrieve(10) == null;
    }

    @Test
    public void take() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        emitter.observe().take(1).subscribe(emitter);

        assert !emitter.isUnsbscribed();
        assert emitter.emitAndRetrieve(10) == 10;
        assert emitter.isUnsbscribed();
        assert emitter.emitAndRetrieve(20) == null;
    }

    @Test
    public void takeUntil() throws Exception {
        EventEmitter<String> condition = new EventEmitter();
        EventEmitter<Integer> emitter = new EventEmitter();
        emitter.observe().takeUntil(condition.observe()).subscribe(emitter);

        assert condition.isUnsbscribed() == false;
        assert emitter.isUnsbscribed() == false;
        assert emitter.emitAndRetrieve(10) == 10;
        assert emitter.emitAndRetrieve(20) == 20;

        condition.emit("start");
        assert condition.isUnsbscribed() == true;
        assert emitter.isUnsbscribed() == true;
        assert emitter.emitAndRetrieve(10) == null;
    }

    @Test
    public void skipAndTake() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        emitter.observe().skip(1).take(1).subscribe(emitter);

        assert !emitter.isUnsbscribed();
        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(20) == 20;
        assert emitter.isUnsbscribed();
        assert emitter.emitAndRetrieve(30) == null;
    }

    @Test
    public void repeat() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        Disposable disposable = emitter.observe().skip(1).take(1).repeat().subscribe(emitter);

        assert emitter.isUnsbscribed() == false;
        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(20) == 20;
        assert emitter.isUnsbscribed() == false;
        assert emitter.emitAndRetrieve(30) == null;
        assert emitter.emitAndRetrieve(40) == 40;
        assert emitter.isUnsbscribed() == false;

        disposable.dispose();
        assert emitter.isUnsbscribed() == true;
        assert emitter.emitAndRetrieve(50) == null;
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

    @Test
    public void distinctRepeat() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        Disposable disposable = emitter.observe().distinct().take(2).repeat().subscribe(emitter);

        assert emitter.emitAndRetrieve(10) == 10;
        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(20) == 20;

        assert emitter.emitAndRetrieve(10) == 10;
        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(20) == 20;

        disposable.dispose();
        assert emitter.isUnsbscribed() == true;
        assert emitter.emitAndRetrieve(10) == null;
    }

    @Test
    public void merge() throws Exception {
        EventEmitter<Integer> emitter1 = new EventEmitter();
        EventEmitter<Integer> emitter2 = new EventEmitter();
        Disposable disposable = emitter1.observe().merge(emitter2.observe()).subscribe(emitter1);

        assert emitter1.isUnsbscribed() == false;
        assert emitter2.isUnsbscribed() == false;
        assert emitter1.emitAndRetrieve(10) == 10;
        assert emitter1.emitAndRetrieve(20) == 20;

        emitter2.emit(100);
        emitter2.emit(200);
        assert emitter1.retrieve() == 100;
        assert emitter1.retrieve() == 200;

        disposable.dispose();
        assert emitter1.isUnsbscribed() == true;
        assert emitter2.isUnsbscribed() == true;
    }

    @Test
    public void all() throws Exception {
        EventEmitter<Integer> emitter1 = new EventEmitter();
        EventEmitter<Integer> emitter2 = new EventEmitter();
        EventEmitter<Boolean> reciever = new EventEmitter();

        Disposable disposable = Observable.all(value -> {
            return 20 <= value;
        }, emitter1.observe(), emitter2.observe()).subscribe(reciever);

        assert emitter1.isUnsbscribed() == false;
        assert emitter2.isUnsbscribed() == false;
        assert reciever.retrieve() == null;

        emitter1.emit(30);
        emitter2.emit(20);
        assert reciever.retrieveLast() == true;

        emitter1.emit(10);
        assert reciever.retrieveLast() == false;

        emitter1.emit(20);
        assert reciever.retrieveLast() == true;

        emitter2.emit(10);
        assert reciever.retrieveLast() == false;

        emitter2.emit(40);
        assert reciever.retrieveLast() == true;

        emitter1.emit(10);
        emitter2.emit(10);
        assert reciever.retrieveLast() == false;

        disposable.dispose();
        assert emitter1.isUnsbscribed() == true;
        assert emitter2.isUnsbscribed() == true;
    }

    @Test
    public void any() throws Exception {
        EventEmitter<Integer> emitter1 = new EventEmitter();
        EventEmitter<Integer> emitter2 = new EventEmitter();
        EventEmitter<Boolean> reciever = new EventEmitter();

        Disposable disposable = Observable.any(value -> {
            return 20 <= value;
        }, emitter1.observe(), emitter2.observe()).subscribe(reciever);

        assert emitter1.isUnsbscribed() == false;
        assert emitter2.isUnsbscribed() == false;
        assert reciever.retrieve() == null;

        emitter1.emit(30);
        emitter2.emit(20);
        assert reciever.retrieveLast() == true;

        emitter1.emit(10);
        assert reciever.retrieveLast() == true;

        emitter2.emit(10);
        assert reciever.retrieveLast() == false;

        emitter2.emit(20);
        assert reciever.retrieveLast() == true;

        disposable.dispose();
        assert emitter1.isUnsbscribed() == true;
        assert emitter2.isUnsbscribed() == true;
    }

    @Test
    public void none() throws Exception {
        EventEmitter<Integer> emitter1 = new EventEmitter();
        EventEmitter<Integer> emitter2 = new EventEmitter();
        EventEmitter<Boolean> reciever = new EventEmitter();

        Disposable disposable = Observable.none(value -> {
            return 20 <= value;
        }, emitter1.observe(), emitter2.observe()).subscribe(reciever);

        assert emitter1.isUnsbscribed() == false;
        assert emitter2.isUnsbscribed() == false;
        assert reciever.retrieve() == null;

        emitter1.emit(30);
        emitter2.emit(20);
        assert reciever.retrieveLast() == false;

        emitter1.emit(10);
        assert reciever.retrieveLast() == false;

        emitter2.emit(10);
        assert reciever.retrieveLast() == true;

        emitter2.emit(20);
        assert reciever.retrieveLast() == false;

        disposable.dispose();
        assert emitter1.isUnsbscribed() == true;
        assert emitter2.isUnsbscribed() == true;
    }

    // @Test
    // public void testname() throws Exception {
    // for (int i = 0; i < 4; i++) {
    // AtomicBoolean atomicBoolean = new AtomicBoolean();
    //
    // aaa(() -> {
    // AtomicBoolean inB = new AtomicBoolean();
    // System.out.println(atomicBoolean.hashCode());
    //
    // aaa(() -> {
    // System.out.println(atomicBoolean.hashCode() + "  " + inB.hashCode());
    // });
    //
    // });
    // }
    // }
    //
    // private void aaa(Runnable runnable) {
    // runnable.run();
    // }
}
