/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.util;

import js.lang.Global;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/12/16 10:57:35
 */
@JavaAPIProvider(Unsupported.class)
class JSUnsupported {

    /**
     * <p>
     * {@link Thread#sleep(long)} is not supported in javascript runtime environment. Use this
     * method in test.
     * </p>
     * 
     * @param time
     */
    public static void async(long time, Runnable action) {
        Global.setTimeout(action, time);
    }
}
