/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui;

import static js.lang.Global.*;
import js.util.jQuery;
import js.util.jQuery.Event;
import js.util.jQuery.Listener;

/**
 * @version 2013/04/04 13:10:36
 */
public class PopupPanel extends UI {

    /** The content to popup. */
    private final UI content;

    /** The singlton opener. */
    private final Opener opener = new Opener();

    private boolean closed = true;

    /**
     * <p>
     * Create {@link PopupPanel}.
     * </p>
     * 
     * @param content
     */
    public PopupPanel(UI content) {

        this.content = content;

        root.append(content);
    }

    /**
     * <p>
     * Register as popup opener.
     * </p>
     * 
     * @param element
     */
    public void registerAsOpener(jQuery element) {
        element.click(opener);
    }

    public void open() {
        content.root.slideToggle(200);

        $(window).one("click", new Listener() {

            @Override
            public void handler(Event event) {
                content.root.slideToggle(100);
            }
        });
    }

    public void close() {

    }

    public void toggle() {
        if (closed) {
            open();
        } else {
            close();
        }
    }

    /**
     * @version 2013/04/04 13:46:24
     */
    private class Opener implements Listener {

        /**
         * {@inheritDoc}
         */
        @Override
        public void handler(Event event) {
            event.stopPropagation();

            open();
        }
    }
}
