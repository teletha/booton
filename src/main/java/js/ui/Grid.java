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
import js.ui.GridStyle.RenderableItemView;
import js.ui.GridStyle.RootArea;
import js.ui.GridStyle.Spacer;
import js.ui.GridStyle.ViewabletemView;
import js.util.jQuery;
import js.util.jQuery.DebounceListener;
import js.util.jQuery.Event;
import js.util.jQuery.Listener;

/**
 * @version 2013/04/02 15:52:54
 */
public class Grid extends UI {

    /** The viewable item size. */
    private final int viewableItemSize;

    /** The extra renderable item size for top direction. */
    private final int extraTopRenderableItemSize;

    /** The extra renderable item size for bottom direction. */
    private final int extraBottomRenderableItemSize;

    /** The all renderable item size. */
    private final int renderableItemSize;

    /** The item height. */
    private final int itemHeight = 20;

    /** The scrollable item view. */
    private final jQuery viewableItemView;

    /** The scrollable item view. */
    private final jQuery renderableItemView;

    /** The spacer. */
    private final jQuery spacer;

    /** The item list. */
    private jQuery[] items;

    /** The item provider. */
    private ItemProvider provider;

    /**
     * 
     */
    public Grid(int size, int height) {
        root.addClass(RootArea.class);

        this.viewableItemSize = size;
        this.extraBottomRenderableItemSize = 25;
        this.extraTopRenderableItemSize = extraBottomRenderableItemSize + viewableItemSize;
        this.renderableItemSize = extraBottomRenderableItemSize + viewableItemSize + extraTopRenderableItemSize;

        this.viewableItemView = root.addClass(ViewabletemView.class);
        this.renderableItemView = viewableItemView.child(RenderableItemView.class);
        this.spacer = renderableItemView.child(Spacer.class);
        this.items = new jQuery[renderableItemSize];

        for (int i = 0; i < renderableItemSize; i++) {
            items[i] = renderableItemView.child(ItemColumnView.class).css("height", itemHeight + "px").text(i);
        }

        viewableItemView.scroll(new DebounceListener(100, new Listener() {

            @Override
            public void handler(Event event) {
                int top = -renderableItemView.position().top;
                int viewableTopIndex = Math.round(top / itemHeight);
                int renderableTopIndex = Math.max(0, viewableTopIndex - extraTopRenderableItemSize);

                if (provider.countItem() <= viewableTopIndex + viewableItemSize + extraBottomRenderableItemSize) {
                    // 既に最後の要素まで到達可能な範囲にいるので末尾から数えるようにする。
                    renderableTopIndex = provider.countItem() - renderableItemSize;
                }
                System.out.println(top + "  " + viewableTopIndex + "  " + renderableTopIndex);

                for (int i = 0; i < items.length; i++) {
                    items[i].text(renderableTopIndex + i);
                }

                spacer.css("height", renderableTopIndex * itemHeight + "px");
            }
        }));
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
        this.provider = provider;
        viewableItemView.css("height", viewableItemSize * itemHeight + "px");
        renderableItemView.css("height", provider.countItem() * itemHeight + "px");

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
