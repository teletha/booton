/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.interfaces;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2012/12/04 9:58:51
 */
@SuppressWarnings("unused")
public class InterfaceTest extends ScriptTester {

    @Test
    public void single() throws Exception {
        test(new Scriptable() {

            int act() {
                Single single = new SingleImpementation();

                return single.value();
            }
        });

        test(new Scriptable() {

            int act() {
                Time time = new SingleImpementation();

                return time.next();
            }
        });

        test(new Scriptable() {

            int act() {
                Time time = new SingleImpementation();

                return time.before();
            }
        });
    }

    /**
     * @version 2012/12/04 9:59:51
     */
    private static interface Single {

        int value();
    }

    /**
     * @version 2012/12/04 9:59:51
     */
    private static interface Time {

        int before();

        int next();
    }

    /**
     * @version 2012/12/04 10:00:57
     */
    private static class SingleImpementation implements Single, Time {

        public int not() {
            return 0;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int value() {
            return 10;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int before() {
            return 20;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int next() {
            return 30;
        }

    }
}
