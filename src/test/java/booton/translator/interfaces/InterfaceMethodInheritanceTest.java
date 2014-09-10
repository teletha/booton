/*
 * Copyright (C) 2014 Nameless Production Committee
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
 * @version 2014/09/10 11:22:36
 */
@RunWith(ScriptRunner.class)
public class InterfaceMethodInheritanceTest {

    @Test
    public void defaultMethodFromOutside() {
        Actual actual = new Actual();
        assert actual.outside().equals("access");
    }

    /**
     * @version 2014/09/10 11:23:30
     */
    private static interface MethodHolder {

        default String outside() {
            return "access";
        }
    }

    /**
     * @version 2014/09/10 11:24:39
     */
    private static interface Aggregater extends MethodHolder {
    }

    /**
     * @version 2014/09/10 11:25:40
     */
    private static class Actual implements Aggregater {
    }
}
