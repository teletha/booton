/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

/**
 * @version 2013/08/18 16:29:00
 */
public class Global {

    /**
     * <p>
     * Calls a function or executes a code snippet after specified delay.
     * </p>
     * 
     * @param function A callable function.
     * @param delay A delay time.
     * @return A timeout id.
     */
    public static long setTimeout(Runnable runnable, long delay) {
        return NativeGlobal.setTimeout(new NativeFunction(runnable).bind(runnable), delay);
    }

    /**
     * <p>
     * Clears the delay set by setTimeout().
     * </p>
     * 
     * @param timeoutId The ID of the timeout you wish to clear, as returned by setTimeout().
     */
    public static void clearTimeout(long timeoutId) {
        NativeGlobal.clearTimeout(timeoutId);
    }
}
