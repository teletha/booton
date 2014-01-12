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

import java.util.Arrays;
import java.util.function.Function;

import kiss.Disposable;

import org.junit.Test;
import org.junit.runner.RunWith;

import antibug.Async;
import booton.soeur.ScriptRunner;

/**
 * @version 2014/01/11 2:51:33
 */
@RunWith(ScriptRunner.class)
public class ObservableTest {

    static {
        Observable.tasks = Async.use();
    }

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

        assert condition.isSubscribed();
        assert emitter.isSubscribed();
        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(20) == null;

        condition.emit("start");
        assert emitter.emitAndRetrieve(10) == 10;
        assert emitter.emitAndRetrieve(20) == 20;

        disposable.dispose();
        assert condition.isUnsubscribed() == true;
        assert emitter.isUnsubscribed() == true;
        assert emitter.emitAndRetrieve(10) == null;
    }

    @Test
    public void skipUntilCondition() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        Disposable disposable = emitter.observe().skipUntil(v -> {
            return v % 3 == 0;
        }).subscribe(emitter);

        assert emitter.isSubscribed();
        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(20) == null;
        assert emitter.emitAndRetrieve(30) == 30;
        assert emitter.emitAndRetrieve(10) == 10;
        assert emitter.emitAndRetrieve(20) == 20;

        disposable.dispose();
        assert emitter.isUnsubscribed() == true;
        assert emitter.emitAndRetrieve(10) == null;
    }

    @Test
    public void skipUntilConditionRepeat() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        Disposable disposable = emitter.observe().skipUntil(v -> {
            return v % 3 == 0;
        }).take(2).repeat().subscribe(emitter);

        assert emitter.isSubscribed();
        assert emitter.emitAndRetrieve(20) == null;
        assert emitter.emitAndRetrieve(30) == 30;
        assert emitter.emitAndRetrieve(40) == 40;
        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(20) == null;
        assert emitter.emitAndRetrieve(60) == 60;
        assert emitter.emitAndRetrieve(90) == 90;
        assert emitter.emitAndRetrieve(100) == null;

        disposable.dispose();
        assert emitter.isUnsubscribed() == true;
        assert emitter.emitAndRetrieve(30) == null;
    }

    @Test
    public void skipUntilRepeat() throws Exception {
        EventEmitter<String> condition = new EventEmitter();
        EventEmitter<Integer> emitter = new EventEmitter();
        Disposable disposable = emitter.observe().skipUntil(condition.observe()).take(1).repeat().subscribe(emitter);

        assert condition.isSubscribed();
        assert emitter.isSubscribed();
        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(20) == null;

        condition.emit("start");
        assert emitter.emitAndRetrieve(10) == 10;
        assert emitter.emitAndRetrieve(20) == null;

        condition.emit("start");
        assert emitter.emitAndRetrieve(10) == 10;
        assert emitter.emitAndRetrieve(20) == null;

        disposable.dispose();
        assert condition.isUnsubscribed() == true;
        assert emitter.isUnsubscribed() == true;
        assert emitter.emitAndRetrieve(10) == null;
    }

    @Test
    public void buffer() throws Exception {
        EventEmitter<Integer[]> reciever = new EventEmitter();
        EventEmitter<Integer> emitter = new EventEmitter();
        Disposable disposable = emitter.observe().buffer(2).subscribe(reciever);

        emitter.emit(10);
        assert reciever.retrieve() == null;
        emitter.emit(20);
        assert Arrays.equals(reciever.retrieve(), new Integer[] {10, 20});

        emitter.emit(30);
        assert reciever.retrieve() == null;
        emitter.emit(40);
        assert Arrays.equals(reciever.retrieve(), new Integer[] {30, 40});

        disposable.dispose();
        assert emitter.isUnsubscribed();

        emitter.emit(50);
        emitter.emit(60);
        assert reciever.retrieve() == null;
    }

    @Test
    public void bufferRepeat() throws Exception {
        EventEmitter<Integer[]> reciever = new EventEmitter();
        EventEmitter<Integer> emitter = new EventEmitter();
        Disposable disposable = emitter.observe().buffer(2).skip(1).take(1).repeat().subscribe(reciever);

        emitter.emit(10);
        emitter.emit(20);
        assert reciever.retrieve() == null;
        emitter.emit(30);
        emitter.emit(40);
        assert Arrays.equals(reciever.retrieve(), new Integer[] {30, 40});

        emitter.emit(50);
        emitter.emit(60);
        assert reciever.retrieve() == null;
        emitter.emit(70);
        emitter.emit(80);
        assert Arrays.equals(reciever.retrieve(), new Integer[] {70, 80});

        disposable.dispose();
        assert emitter.isUnsubscribed();

        emitter.emit(90);
        emitter.emit(100);
        emitter.emit(110);
        emitter.emit(120);
        assert reciever.retrieve() == null;
    }

    @Test
    public void bufferInterval1() throws Exception {
        EventEmitter<Integer[]> reciever = new EventEmitter();
        EventEmitter<Integer> emitter = new EventEmitter();
        Disposable disposable = emitter.observe().buffer(2, 1).subscribe(reciever);

        emitter.emit(10);
        assert reciever.retrieve() == null;
        emitter.emit(20);
        assert Arrays.equals(reciever.retrieve(), new Integer[] {10, 20});

        emitter.emit(30);
        assert Arrays.equals(reciever.retrieve(), new Integer[] {20, 30});
        emitter.emit(40);
        assert Arrays.equals(reciever.retrieve(), new Integer[] {30, 40});

        disposable.dispose();
        assert emitter.isUnsubscribed();

        emitter.emit(50);
        assert reciever.retrieve() == null;
    }

    @Test
    public void bufferInterval2() throws Exception {
        EventEmitter<Integer[]> reciever = new EventEmitter();
        EventEmitter<Integer> emitter = new EventEmitter();
        Disposable disposable = emitter.observe().buffer(2, 3).subscribe(reciever);

        emitter.emit(10);
        assert reciever.retrieve() == null;
        emitter.emit(20);
        assert reciever.retrieve() == null;
        emitter.emit(30);
        assert Arrays.equals(reciever.retrieve(), new Integer[] {20, 30});
        emitter.emit(40);
        assert reciever.retrieve() == null;
        emitter.emit(50);
        assert reciever.retrieve() == null;
        emitter.emit(60);
        assert Arrays.equals(reciever.retrieve(), new Integer[] {50, 60});

        disposable.dispose();
        assert emitter.isUnsubscribed();

        emitter.emit(70);
        assert reciever.retrieve() == null;
    }

    @Test
    public void as() throws Exception {
        EventEmitter<Integer> reciever = new EventEmitter();
        EventEmitter<Number> emitter = new EventEmitter();
        emitter.observe().as(Integer.class).subscribe(reciever);

        emitter.emit(10);
        assert reciever.retrieve() == 10;

        emitter.emit(2.1F);
        assert reciever.retrieve() == null;
        emitter.emit(-1.1D);
        assert reciever.retrieve() == null;
        emitter.emit(20L);
        assert reciever.retrieve() == null;
    }

    @Test
    public void diff() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        Disposable disposable = emitter.observe().diff().subscribe(emitter);

        assert emitter.isSubscribed();
        assert emitter.emitAndRetrieve(10) == 10;
        assert emitter.emitAndRetrieve(20) == 20;
        assert emitter.emitAndRetrieve(20) == null;
        assert emitter.emitAndRetrieve(10) == 10;
        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(20) == 20;

        disposable.dispose();
        assert emitter.isUnsubscribed();
        assert emitter.emitAndRetrieve(10) == null;
    }

    @Test
    public void take() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        emitter.observe().take(1).subscribe(emitter);

        assert !emitter.isUnsubscribed();
        assert emitter.emitAndRetrieve(10) == 10;
        assert emitter.isUnsubscribed();
        assert emitter.emitAndRetrieve(20) == null;
    }

    @Test
    public void takeUntil() throws Exception {
        EventEmitter<String> condition = new EventEmitter();
        EventEmitter<Integer> emitter = new EventEmitter();
        emitter.observe().takeUntil(condition.observe()).subscribe(emitter);

        assert condition.isSubscribed();
        assert emitter.isSubscribed();
        assert emitter.emitAndRetrieve(10) == 10;
        assert emitter.emitAndRetrieve(20) == 20;

        condition.emit("start");
        assert condition.isUnsubscribed() == true;
        assert emitter.isUnsubscribed() == true;
        assert emitter.emitAndRetrieve(10) == null;
    }

    @Test
    public void takeUntilCondition() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        emitter.observe().takeUntil(v -> {
            return v % 3 == 0;
        }).subscribe(emitter);

        assert emitter.emitAndRetrieve(10) == 10;
        assert emitter.emitAndRetrieve(20) == 20;
        assert emitter.emitAndRetrieve(30) == 30;

        assert emitter.isUnsubscribed();
        assert emitter.emitAndRetrieve(40) == null;
    }

    @Test
    public void takeUntilConditionRepeat() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        Disposable disposable = emitter.observe().skip(1).takeUntil(v -> {
            return v % 3 == 0;
        }).repeat().subscribe(emitter);

        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(20) == 20;
        assert emitter.emitAndRetrieve(30) == 30;

        assert emitter.emitAndRetrieve(40) == null;
        assert emitter.emitAndRetrieve(60) == 60;
        assert emitter.emitAndRetrieve(70) == null;
        assert emitter.emitAndRetrieve(80) == 80;
        assert emitter.emitAndRetrieve(100) == 100;

        disposable.dispose();
        assert emitter.isUnsubscribed();
        assert emitter.emitAndRetrieve(110) == null;
    }

    @Test
    public void skipAndTake() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        emitter.observe().skip(1).take(1).subscribe(emitter);

        assert !emitter.isUnsubscribed();
        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(20) == 20;
        assert emitter.isUnsubscribed();
        assert emitter.emitAndRetrieve(30) == null;
    }

    @Test
    public void repeat() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        Disposable disposable = emitter.observe().skip(1).take(1).repeat().subscribe(emitter);

        assert emitter.isSubscribed();
        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(20) == 20;
        assert emitter.isSubscribed();
        assert emitter.emitAndRetrieve(30) == null;
        assert emitter.emitAndRetrieve(40) == 40;
        assert emitter.isSubscribed();

        disposable.dispose();
        assert emitter.isUnsubscribed() == true;
        assert emitter.emitAndRetrieve(50) == null;
    }

    @Test
    public void repeatFinitely() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        emitter.observe().skip(1).take(1).repeat(2).subscribe(emitter);

        assert emitter.isSubscribed();
        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(20) == 20;
        assert emitter.isSubscribed();
        assert emitter.emitAndRetrieve(30) == null;
        assert emitter.emitAndRetrieve(40) == 40;
        assert emitter.isUnsubscribed();
        assert emitter.emitAndRetrieve(30) == null;
    }

    @Test
    public void repeatThen() throws Exception {
        EventEmitter<Integer> sub = new EventEmitter();
        EventEmitter<Integer> emitter = new EventEmitter();
        Disposable disposable = emitter.observe().skip(1).take(2).repeat().merge(sub.observe()).subscribe(emitter);

        assert emitter.isSubscribed();
        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(20) == 20;
        assert emitter.emitAndRetrieve(30) == 30;
        assert emitter.isSubscribed();
        assert emitter.emitAndRetrieve(30) == null;
        assert emitter.emitAndRetrieve(40) == 40;
        assert emitter.emitAndRetrieve(50) == 50;
        assert emitter.isSubscribed();

        // from sub
        assert sub.isSubscribed();
        sub.emit(100);
        assert emitter.retrieve() == 100;
        sub.emit(200);
        assert emitter.retrieve() == 200;

        disposable.dispose();
        assert emitter.isUnsubscribed() == true;
        assert emitter.emitAndRetrieve(50) == null;

        // from sub
        sub.emit(300);
        assert emitter.retrieve() == null;
        assert sub.isUnsubscribed() == true;
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
    public void debounceRepeat() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        emitter.observe().debounce(10, MILLISECONDS).skip(1).take(1).repeat().subscribe(emitter);

        assert emitter.emitAndRetrieve(10) == null;
        assert emitter.emitAndRetrieve(20) == null;
        assert emitter.emitAndRetrieve(30) == null;

        Async.awaitTasks();
        assert emitter.retrieve() == null;

        emitter.emit(10);
        Async.awaitTasks();
        assert emitter.retrieve() == 10;

        emitter.emit(10);
        Async.awaitTasks();
        assert emitter.retrieve() == null;
        emitter.emit(10);
        Async.awaitTasks();
        assert emitter.retrieve() == 10;
    }

    @Test
    public void delay() throws Exception {
        EventEmitter<Integer> emitter = new EventEmitter();
        emitter.observe().delay(10, MILLISECONDS).subscribe(emitter);

        assert emitter.emitAndRetrieve(10) == null;
        Async.awaitTasks();
        assert emitter.retrieve() == 10;

        assert emitter.emitAndRetrieve(20) == null;
        assert emitter.emitAndRetrieve(30) == null;
        Async.awaitTasks();
        assert emitter.retrieve() == 20;
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
        assert emitter.isUnsubscribed() == true;
        assert emitter.emitAndRetrieve(10) == null;
    }

    @Test
    public void merge() throws Exception {
        EventEmitter<Integer> emitter1 = new EventEmitter();
        EventEmitter<Integer> emitter2 = new EventEmitter();
        Disposable disposable = emitter1.observe().merge(emitter2.observe()).subscribe(emitter1);

        assert emitter1.isSubscribed();
        assert emitter2.isSubscribed();
        assert emitter1.emitAndRetrieve(10) == 10;
        assert emitter1.emitAndRetrieve(20) == 20;

        emitter2.emit(100);
        emitter2.emit(200);
        assert emitter1.retrieve() == 100;
        assert emitter1.retrieve() == 200;

        disposable.dispose();
        assert emitter1.isUnsubscribed() == true;
        assert emitter2.isUnsubscribed() == true;
    }

    @Test
    public void all() throws Exception {
        EventEmitter<Integer> emitter1 = new EventEmitter();
        EventEmitter<Integer> emitter2 = new EventEmitter();
        EventEmitter<Boolean> reciever = new EventEmitter();

        Disposable disposable = Observable.all(value -> {
            return 20 <= value;
        }, emitter1.observe(), emitter2.observe()).subscribe(reciever);

        assert emitter1.isSubscribed();
        assert emitter2.isSubscribed();
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
        assert emitter1.isUnsubscribed() == true;
        assert emitter2.isUnsubscribed() == true;
    }

    @Test
    public void any() throws Exception {
        EventEmitter<Integer> emitter1 = new EventEmitter();
        EventEmitter<Integer> emitter2 = new EventEmitter();
        EventEmitter<Boolean> reciever = new EventEmitter();

        Disposable disposable = Observable.any(value -> {
            return 20 <= value;
        }, emitter1.observe(), emitter2.observe()).subscribe(reciever);

        assert emitter1.isSubscribed();
        assert emitter2.isSubscribed();
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
        assert emitter1.isUnsubscribed() == true;
        assert emitter2.isUnsubscribed() == true;
    }

    @Test
    public void none() throws Exception {
        EventEmitter<Integer> emitter1 = new EventEmitter();
        EventEmitter<Integer> emitter2 = new EventEmitter();
        EventEmitter<Boolean> reciever = new EventEmitter();

        Disposable disposable = Observable.none(value -> {
            return 20 <= value;
        }, emitter1.observe(), emitter2.observe()).subscribe(reciever);

        assert emitter1.isSubscribed();
        assert emitter2.isSubscribed();
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
        assert emitter1.isUnsubscribed() == true;
        assert emitter2.isUnsubscribed() == true;
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
