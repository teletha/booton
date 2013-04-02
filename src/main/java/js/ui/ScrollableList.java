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

import java.util.List;

import js.ui.ScrollableListStyle.ItemColumnView;
import js.ui.ScrollableListStyle.RenderableItemView;
import js.ui.ScrollableListStyle.Spacer;
import js.ui.ScrollableListStyle.ViewabletemView;
import js.util.ArrayList;
import js.util.jQuery;
import js.util.jQuery.DebounceListener;
import js.util.jQuery.Event;
import js.util.jQuery.Listener;

/**
 * @version 2013/04/02 15:52:54
 */
public class ScrollableList extends UI {

    /** The viewable item size. */
    private final int viewableItemSize;

    /** The scrollable item view. */
    private final jQuery viewableItemView;

    /** The scrollable item view. */
    private final jQuery renderableItemView;

    /** The spacer. */
    private final jQuery spacer;

    /** The extra renderable item size for top direction. */
    private int extraTopRenderableItemSize;

    /** The extra renderable item size for bottom direction. */
    private int extraBottomRenderableItemSize;

    /** The all renderable item size. */
    private int renderableItemSize;

    /** The item height. */
    private int itemHeight = 20;

    /** The item list. */
    private List<jQuery> items = new ArrayList();

    /** The item provider. */
    private ItemProvider provider;

    /**
     * 
     */
    public ScrollableList(int size, int height) {
        this.viewableItemSize = size;
        this.viewableItemView = root.addClass(ViewabletemView.class).scroll(new DebounceListener(100, new Renderer()));
        this.renderableItemView = viewableItemView.child(RenderableItemView.class);
        this.spacer = renderableItemView.child(Spacer.class);
    }

    /**
     * <p>
     * Set item provider.
     * </p>
     * 
     * @param provider
     * @return
     */
    public ScrollableList provide(ItemProvider provider) {
        this.provider = provider;

        // Configure viewable and renderable item size.
        int size = provider.countItem();
        this.extraBottomRenderableItemSize = 25;
        this.extraTopRenderableItemSize = extraBottomRenderableItemSize + viewableItemSize;
        this.renderableItemSize = Math.min(size, extraBottomRenderableItemSize + viewableItemSize + extraTopRenderableItemSize);

        // Add or remove item elements for new item provider.
        int diff = items.size() - renderableItemSize;

        if (diff < 0) {
            // increase items
            for (int i = diff; i < 0; i++) {
                items.add(renderableItemView.child(ItemColumnView.class).css("height", itemHeight + "px"));
            }
        } else if (0 < diff) {
            // decrease items
            for (int i = 0; i < diff; i++) {
                items.remove(0);
            }
        }

        // Configure viewable and renderable view's height.
        renderableItemView.css("height", size * itemHeight + "px");
        viewableItemView.css("max-height", viewableItemSize * itemHeight + "px");

        // Trigger scroll event to force item rendering.
        viewableItemView.scroll();

        // API definition
        return this;
    }

    /**
     * @version 2013/04/02 23:50:57
     */
    private class Renderer implements Listener {

        /** The last rendered index. */
        private int lastRenderedTopIndex = -1;

        /**
         * {@inheritDoc}
         */
        @Override
        public void handler(Event event) {
            int viewableTopIndex = Math.round(-renderableItemView.position().top / itemHeight);
            int renderableTopIndex = Math.max(0, viewableTopIndex - extraTopRenderableItemSize);

            // 既に最後の要素まで到達可能な範囲にいたら末尾から数えるようにする。
            if (provider.countItem() <= viewableTopIndex + viewableItemSize + extraBottomRenderableItemSize) {
                renderableTopIndex = provider.countItem() - renderableItemSize;
            }

            // 以前と同じインデックスから始まるようなら再レンダリングする必要はない
            if (lastRenderedTopIndex != renderableTopIndex) {
                lastRenderedTopIndex = renderableTopIndex; // update

                // re-rendering
                spacer.css("height", renderableTopIndex * itemHeight + "px");

                for (int i = 0; i < items.size(); i++) {
                    provider.render(items.get(i), provider.item(renderableTopIndex + i));
                }
            }
        }
    }

    /**
     * @version 2013/04/02 15:57:52
     */
    public static interface ItemProvider<M> {

        /**
         * <p>
         * Count a number of model items.
         * </p>
         * 
         * @return A number of model items.
         */
        int countItem();

        /**
         * <p>
         * Retrieve item by the specified index.
         * </p>
         * 
         * @param index A index to search.
         * @return A item in the specified index.
         */
        M item(int index);

        /**
         * <p>
         * Render the model to the given element.
         * </p>
         * 
         * @param element A element to render.
         * @param model A rendering item.
         */
        void render(jQuery element, M model);
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

        /**
         * {@inheritDoc}
         */
        @Override
        public Object item(int index) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void render(jQuery element, Object model) {
        }
    }
}
