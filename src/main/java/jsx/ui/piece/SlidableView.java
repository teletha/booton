/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.piece;

import static js.lang.Global.*;

import jsx.ui.Widget;

/**
 * @version 2015/03/06 14:35:20
 */
public class SlidableView extends Widget {

    /** The current slide state. */
    private int shown = 0;

    /**
     * <p>
     * Create {@link SlidableView}.
     * </p>
     * 
     * @param content
     */
    public SlidableView(Widget content) {
        // root.add(ViewableArea);
        // root.child(Slider).append(content);
    }

    /**
     * <p>
     * Open slide view.
     * </p>
     */
    public void open() {
        if (shown++ == 0) {
            // // show slide view
            // root.add(Shown);
            //
            // // notify event
            // publish(new Open());
            //
            // // prepare closer
            // window.subscribe(this);
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
            // root.remove(Shown);
            //
            // // notify event
            // publish(new Close());

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
     * {@inheritDoc}
     */
    @Override
    protected void virtualize2() {
    }
}
