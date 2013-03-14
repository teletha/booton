/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import booton.translator.JavascriptNative;

/**
 * @version 2012/12/26 14:14:29
 */
public abstract class History implements JavascriptNative {

    /**
     * <p>
     * Goes to the previous page in session history, the same action as when the user clicks the
     * browser's Back button. Equivalent to history.go(-1).
     * </p>
     */
    public native void back();

    /**
     * <p>
     * Goes to the next page in session history, the same action as when the user clicks the
     * browser's Forward button; this is equivalent to history.go(1).
     * </p>
     */
    public native void forward();

    /**
     * <p>
     * Loads a page from the session history, identified by its relative location to the current
     * page, for example -1 for the previous page or 1 for the next page. When integerDelta is out
     * of bounds (e.g. -1 when there are no previously visited pages in the session history), the
     * method doesn't do anything and doesn't raise an exception. Calling go() without parameters or
     * with a non-integer argument has no effect.
     * </p>
     */
    public native void go(int step);

    /**
     * <p>
     * Pushes the given data onto the session history stack with the specified title and, if
     * provided, URL. The data is treated as opaque by the DOM; you may specify any JavaScript
     * object that can be serialized. Note that Firefox currently ignores the title parameter; for
     * more information, see <a
     * href="https://developer.mozilla.org/en/DOM/Manipulating_the_browser_history">manipulating the
     * browser history</a>.
     * </p>
     */
    public native void pushState(Object data, String title, String url);

    /**
     * <p>
     * Updates the most recent entry on the history stack to have the specified data, title, and, if
     * provided, URL. The data is treated as opaque by the DOM; you may specify any JavaScript
     * object that can be serialized. Note that Firefox currently ignores the title parameter; for
     * more information, see manipulating the browser history.
     * </p>
     */
    public native void replaceState(Object data, String title, String url);
}
