/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt.view;

import static js.lang.Global.*;

import java.util.EventListener;

import jsx.bwt.UI;
import jsx.bwt.view.SlidableViewStyle.Shown;

/**
 * @version 2013/06/10 0:16:05
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
            root.add(Shown.class);

            // notify event
            publish(Listener.class).open();

            // prepare closer
            window.bind(this);
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
            root.remove(Shown.class);

            // notify event
            publish(Listener.class).close();

            // discard closer
            window.unbind(this);
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
     * @version 2013/06/10 14:12:29
     */
    public interface Listener extends EventListener {

        /**
         * <p>
         * Receive open event.
         * </p>
         */
        void open();

        /**
         * <p>
         * Receive close event.
         * </p>
         */
        void close();
    }
}
