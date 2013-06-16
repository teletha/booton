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

import static js.lang.Global.*;
import static jsx.bwt.UIAction.*;
import js.util.jQuery;
import js.util.jQuery.Offset;
import jsx.bwt.view.PopupViewStyle;
import kiss.Disposable;

/**
 * @version 2013/06/12 9:11:13
 */
public class WindowManager {

    /** The popup area. */
    private static jQuery popup;

    /** The popup target. */
    private final jQuery target;

    /** The popup content. */
    private final jQuery content;

    /**
     * 
     */
    private WindowManager(jQuery target, jQuery content) {
        if (popup == null) {
            popup = $("<div>").add(PopupViewStyle.Bottom.class);
            $("body").append(popup);
        }

        this.target = target;
        this.content = content;
    }

    @Listen(MouseEnter)
    private void enter() {
        popup.append(content);
        popup.add(PopupViewStyle.Show.class);

        Offset offset = target.position();
        popup.css("top", offset.top + target.outerHeight() + 15 + "px")
                .css("left", offset.left - popup.outerWidth() / 2 + target.outerWidth() / 2 + "px");
    }

    @Listen(MouseLeave)
    private void leave() {
        popup.remove(PopupViewStyle.Show.class);
        content.remove();
    }

    public static void applyTooltip(jQuery target, jQuery content) {
        if (target != null && content != null) {
            target.bind(new WindowManager(target, content));
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
