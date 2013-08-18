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

import static js.lang.NativeGlobal.*;

import java.util.EventListener;

import jsx.bwt.Listen;
import jsx.bwt.UI;
import jsx.bwt.UIAction;
import jsx.bwt.view.SlidableViewStyle.Shown;
import jsx.bwt.view.SlidableViewStyle.Slider;
import jsx.bwt.view.SlidableViewStyle.ViewableArea;

/**
 * @version 2013/04/19 12:54:30
 */
public class SlidableView extends UI {

    /** The current slide state. */
    private int shown = 0;

    /**
     * <p>
     * Create {@link SlidableView}.
     * </p>
     * 
     * @param content
     */
    public SlidableView(UI content) {
        root.add(ViewableArea.class);
        root.child(Slider.class).append(content);
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
    @Listen(type = UIAction.Click)
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
     * @version 2013/04/07 1:03:07
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
