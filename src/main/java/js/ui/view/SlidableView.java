/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui.view;

import static js.lang.Global.*;

import java.util.EventListener;

import js.ui.Listen;
import js.ui.UI;
import js.ui.UIAction;
import js.ui.view.SlidableViewStyle.Shown;
import js.ui.view.SlidableViewStyle.Slider;
import js.ui.view.SlidableViewStyle.ViewableArea;
import js.util.jQuery;

/**
 * @version 2013/04/04 19:01:02
 */
public class SlidableView extends UI {

    /** The current slide state. */
    private boolean shown = false;

    /**
     * <p>
     * Create {@link SlidableView}.
     * </p>
     * 
     * @param content
     */
    public SlidableView(UI content, jQuery... switchgears) {
        root.addClass(ViewableArea.class);
        root.child(Slider.class).append(content);

        for (jQuery switchgear : switchgears) {
            switchgear.bind(this);
        }
    }

    /**
     * <p>
     * Open slide view.
     * </p>
     */
    public void open() {
        if (!shown) {
            // show slide view
            shown = true;
            root.addClass(Shown.class);

            // notify event
            publish(Listener.class).open();

            // prepare closer
            $(window).bind(this);
        }
    }

    /**
     * <p>
     * Close slide view.
     * </p>
     */
    public void close() {
        if (shown) {
            // hide slide view
            shown = false;
            root.removeClass(Shown.class);

            // notify event
            publish(Listener.class).close();

            // discard coloser
            $(window).unbind(this);
        }
    }

    /**
     * <p>
     * Toggle slide view.
     * </p>
     */
    @Listen(value = UIAction.Click, propagate = false)
    public void toggle() {
        if (shown) {
            close();
        } else {
            open();
        }
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
