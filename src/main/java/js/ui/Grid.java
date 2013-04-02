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

import js.ui.GridStyle.ItemColumnView;
import js.ui.GridStyle.RootArea;
import js.ui.GridStyle.ScrollableItemView;
import js.ui.GridStyle.ScrollableItemViewSpacer;
import js.ui.GridStyle.ViewabletemView;
import js.util.jQuery;
import js.util.jQuery.Event;
import js.util.jQuery.Listener;
import js.util.jQuery.Offset;

/**
 * @version 2013/04/02 15:52:54
 */
public class Grid extends UI {

    /** The viewable item size. */
    private final int viewableItemSize;

    /** The maximum viewable item size. */
    private final int viewableItemMaximumSize;

    /** The item height. */
    private final int height = 20;

    /** The scrollable item view. */
    private jQuery viewableItemView;

    /** The scrollable item view. */
    private jQuery scrollableItemView;

    /** The spacer. */
    private jQuery scrollableItemViewSpacer;

    /**
     * 
     */
    public Grid(int viewableItemSize, int height) {
        root.addClass(RootArea.class);

        this.viewableItemSize = viewableItemSize;
        this.viewableItemMaximumSize = viewableItemSize * 3;
        this.viewableItemView = root.child(ViewabletemView.class);
        this.scrollableItemView = viewableItemView.child(ScrollableItemView.class);
        this.scrollableItemViewSpacer = scrollableItemView.child(ScrollableItemViewSpacer.class);

        for (int i = 0; i < viewableItemMaximumSize; i++) {
            scrollableItemView.child(ItemColumnView.class).css("height", height + "px").text(i);
        }

        viewableItemView.scroll(new Listener() {

            @Override
            public void handler(Event event) {
                Offset offset = scrollableItemView.position();
                System.out.println(offset);
                scrollableItemViewSpacer.css("height", (-offset.top - 20 * Grid.this.height) + "px");
            }
        });
    }

    /**
     * <p>
     * Set item provider.
     * </p>
     * 
     * @param provider
     * @return
     */
    public Grid provide(ItemProvider provider) {
        viewableItemView.css("height", viewableItemSize * height + "px");
        scrollableItemView.css("height", provider.countItem() * height + "px");

        // API definition
        return this;
    }

    /**
     * @version 2013/04/02 15:57:52
     */
    public static interface ItemProvider {

        /**
         * <p>
         * Count a number of model items.
         * </p>
         * 
         * @return A number of model items.
         */
        int countItem();

    }

    /**
     * @version 2013/04/02 16:04:20
     */
    private static class EmptyItemProvider implements ItemProvider {

        /**
         * {@inheritDoc}
         */
        @Override
        public int countItem() {
            return 0;
        }
    }
}
