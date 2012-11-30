/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.flow;

import org.junit.Test;

import booton.translator.api.Compilable;
import booton.translator.api.CompilableTester;

/**
 * @version 2012/11/30 8:36:59
 */
@SuppressWarnings("unused")
public class ForTest extends CompilableTester {

    @Test
    public void one() throws Exception {
        test(new Compilable() {

            String act() {
                int m = 0;

                for (int i = 0; i < 3; i++) {
                    m++;
                }

                return String.valueOf(m);
            }
        });
    }
}
