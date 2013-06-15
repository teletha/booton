/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt;

import static jsx.bwt.UIAction.*;
import js.util.jQuery;
import kiss.Disposable;

/**
 * @version 2013/06/12 9:11:13
 */
public class WindowManager {

    /** The popup content. */
    private final jQuery content;

    /**
     * 
     */
    private WindowManager(jQuery content) {
        this.content = content;
    }

    @Listen(MouseEnter)
    private void enter() {

    }

    @Listen(MouseLeave)
    private void leave() {

    }

    public static void applyTooltip(jQuery target, jQuery content) {
        if (target != null) {
            target.bind(new WindowManager(content));
        }
    }

    /**
     * <p>
     * Show tooltip.
     * </p>
     * 
     * @return
     */
    public static Disposable showTooltip(jQuery target, jQuery content) {
        return null;
    }
}
