/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import js.lang.Function;
import booton.translator.JavascriptNative;

/**
 * @version 2013/04/01 15:38:17
 */
public abstract class Raphael implements JavascriptNative {

    public native Raphael path(String path);

    public native Raphael attr(String name, String value);

    public native Raphael hover(RaphaelListener in, RaphaelListener out);

    /**
     * @param i
     * @param j
     * @param k
     * @param l
     * @return
     */
    public native Raphael rect(int i, int j, int k, int l);

    public native Raphael show();

    public native Raphael hide();

    /**
     * @version 2012/12/02 23:08:01
     */
    public static interface RaphaelListener extends Function {

        /**
         * <p>
         * Handle registered event.
         * </p>
         * 
         * @param event
         * @return
         */
        void handleEvent();
    }
}
