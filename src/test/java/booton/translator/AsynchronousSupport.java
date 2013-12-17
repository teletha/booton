/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import kiss.I;
import net.sourceforge.htmlunit.corejs.javascript.ScriptableObject;
import net.sourceforge.htmlunit.corejs.javascript.annotations.JSStaticFunction;
import booton.util.Asynchronous;

/**
 * @version 2013/12/17 16:25:15
 */
public class AsynchronousSupport extends ScriptableObject {

    /**
     * 
     */
    public AsynchronousSupport() {
    }

    /**
     * <p>
     * {@link Thread#sleep(long)} is not supported in javascript runtime environment. Use this
     * method in test.
     * </p>
     * 
     * @param time
     */
    @JSStaticFunction
    public static void await(int time) {
        try {
            System.out.println("wait");
            Thread.sleep(1000);
            System.out.println("waited");
        } catch (InterruptedException e) {
            throw I.quiet(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getClassName() {
        return Asynchronous.name;
    }
}