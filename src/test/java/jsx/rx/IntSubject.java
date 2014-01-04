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

/**
 * @version 2014/01/04 15:20:12
 */
public class IntSubject extends Subject<Integer> {

    private final AtomicInteger sum = new AtomicInteger();

    public IntSubject() {
        subscribe(value -> {
            sum.addAndGet(value);
        });
    }

    public void set(int value) {
        sum.addAndGet(value);
    }

    public int next(int value) {
        onNext(value);

        return sum.get();
    }
}
