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

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

/**
 * @version 2013/12/30 11:19:45
 */
public class ObservableTest {

    @Test
    public void base() throws Exception {
        AtomicInteger sum = new AtomicInteger();

        Subject<Integer> subject = new Subject();
        subject.subscribe(value -> {
            sum.addAndGet(value);
        });

        assert sum.get() == 0;

        subject.onNext(10);
        assert sum.get() == 10;
    }

    @Test
    public void skip() throws Exception {
        IntSubject subject = new IntSubject();
        subject.skip(1).subscribe(value -> {
            subject.set(value);
        });

        assert subject.next(2) == 0;
    }
}
