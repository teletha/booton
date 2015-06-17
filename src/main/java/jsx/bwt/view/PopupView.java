/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt.view;

import static js.lang.Global.*;
import static jsx.bwt.view.SlidableViewStyle.*;
import jsx.bwt.UI;

/**
 * @version 2013/10/10 13:42:34
 */
public class PopupView extends UI {

    /** The current popup state. */
    private int shown = 0;

    /**
     * <p>
     * Create {@link PopupView}.
     * </p>
     * 
     * @param content
     */
    public PopupView(UI content) {

    }

    /**
     * <p>
     * Open slide view.
     * </p>
     */
    public void open() {
        if (shown++ == 0) {
            // fit to parent box
            String left = root.parent().css("border-left-width");
            String right = root.parent().css("border-right-width");
            String bottom = root.parent().css("border-bottom-width");

            root.css("top", "calc(100% + " + bottom + ")")
                    .css("left", "-" + left)
                    .css("width", "calc(100% + " + right + " + " + left + ")");

            // show slide view
            root.add(Shown);

            // notify event
            publish(new Open());

            // prepare closer
            window.subscribe(this);
        }
    }

    /**
     * <p>
     * Close slide view.
     * </p>
     */
    public void close() {
        if (2 <= shown) {
            // hide slide view
            shown = 0;
            root.remove(Shown);

            // notify event
            publish(new Close());

            // discard closer
            window.unsubscribe(this);
        }
    }

    /**
     * <p>
     * Toggle slide view.
     * </p>
     */
    public void toggle() {
        if (2 <= shown) {
            close();
        } else {
            open();
        }
    }

    /**
     * <p>
     * Retrieve slide view condition.
     * </p>
     * 
     * @return
     */
    public boolean isOpen() {
        return shown != 0;
    }

    /**
     * @version 2013/10/10 13:36:42
     */
    public static class Open {
    }

    /**
     * @version 2013/10/10 13:36:58
     */
    public static class Close {
    }
}
