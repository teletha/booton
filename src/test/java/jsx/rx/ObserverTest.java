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

import org.junit.Test;
import org.junit.runner.RunWith;

import rx.Observable;
import booton.soeur.ScriptRunner;

/**
 * @version 2013/12/30 11:19:45
 */
@RunWith(ScriptRunner.class)
public class ObserverTest {

    @Test
    public void testname() throws Exception {
        Observable.range(1, 10).where(v -> {
            return v % 2 == 0;
        }).subscribe(v -> {
            System.out.println(v);
        });
    }
}
