/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.method;

import org.junit.Test;

import booton.soeur.ScriptTester;
import booton.soeur.Scriptable;

/**
 * @version 2013/03/18 0:09:17
 */
public class StaticMethod extends ScriptTester {

    @Test
    public void callStaticMethodFromChildClass() throws Exception {
        test(new CallFromChild());
    }

    /**
     * @version 2013/03/18 0:10:24
     */
    private static class MethodDefinedInParent {

        public static int call() {
            return 10;
        }
    }

    /**
     * @version 2013/03/18 0:10:22
     */
    @SuppressWarnings("unused")
    private static class CallFromChild extends MethodDefinedInParent implements Scriptable {

        int act() {
            return call();
        }
    }
}
