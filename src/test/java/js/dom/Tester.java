/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import static js.lang.Global.*;

/**
 * @version 2013/10/20 10:02:05
 */
public class Tester {

    /**
     * <p>
     * Emulate user click action.
     * </p>
     * 
     * @param element
     */
    public static void click(Element element) {
        if (element != null) {
            UIEvent event = document.createEvent("UIEvent");
            event.initEvent("click", true, true);

            element.dispatchEvent(event);
        }
    }

    /**
     * <p>
     * Emulate user mouse down action.
     * </p>
     * 
     * @param element
     */
    public static void mouseDown(Element element) {
        if (element != null) {
            UIEvent event = document.createEvent("UIEvent");
            event.initEvent("mousedown", true, true);

            element.dispatchEvent(event);
        }
    }
}
