/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.interfaces;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/11/03 16:22:21
 */
@RunWith(ScriptRunner.class)
public class InterfaceMethodTest {

    @Test
    public void staticMethod() throws Exception {
        assert InterfaceMethod.staticValue() == 10;
    }

    @Test
    public void defaultMethod() throws Exception {
        Implementation implementation = new Implementation();
        assert implementation.defaultInt() == -10;
        assert implementation.defaultString().equals("default");
        assert implementation.superString().equals("super");
    }

    /**
     * @version 2013/11/03 16:22:54
     */
    private static interface InterfaceMethod {

        static int staticValue() {
            return 10;
        }

        default int defaultInt() {
            return -10;
        }
    }

    /**
     * @version 2013/11/03 16:22:54
     */
    private static interface OtherInterface extends SuperInterface {

        default String defaultString() {
            return "default";
        }
    }

    private static interface SuperInterface {

        default String superString() {
            return "super";
        }
    }

    /**
     * @version 2013/11/03 16:32:33
     */
    private static class Implementation implements InterfaceMethod, OtherInterface {
    }
}
