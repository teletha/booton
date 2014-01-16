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

import java.util.ArrayList;
import java.util.List;

import js.dom.Element;
import js.dom.UIAction;
import jsx.bwt.UI;
import jsx.bwt.view.ScrollableListViewStyle.ItemColumnView;
import jsx.bwt.view.ScrollableListViewStyle.RenderableItemView;
import jsx.bwt.view.ScrollableListViewStyle.Spacer;
import jsx.bwt.view.ScrollableListViewStyle.ViewabletemView;
import jsx.event.SubscribeUI;

/**
 * @version 2013/07/29 2:00:26
 */
public class ScrollableListView extends UI {

    /** The item height. */
    private final int itemHeight;

    /** The viewable item size. */
    private final int viewableItemSize;

    /** The scrollable item view. */
    private final Element viewableItemView;

    /** The scrollable item view. */
    private final Element renderableItemView;

    /** The spacer. */
    private final Element spacer;

    /** The item list. */
    private final List<Element> items = new ArrayList();

    /** The extra renderable item size for top direction. */
    private int extraTopRenderableItemSize;

    /** The extra renderable item size for bottom direction. */
    private int extraBottomRenderableItemSize;

    /** The all renderable item size. */
    private int renderableItemSize;

    /** The last rendered index. */
    private int lastRenderedTopIndex = -1;

    /** The item provider. */
    private ItemRenderer renderer = new EmptyItemRenderer();

    /**
     * <p>
     * Constructor for {@link ScrollableListView}.
     * </p>
     * 
     * @param viewableItemSize
     * @param itemHeight
     */
    public ScrollableListView(int viewableItemSize, int itemHeight) {
        this.itemHeight = itemHeight;
        this.viewableItemSize = viewableItemSize;

        this.viewableItemView = root.add(ViewabletemView.class).on(this);
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
    public ScrollableListView provide(ItemRenderer provider) {
        this.renderer = provider;

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

        // Force item rendering.
        render();

        // API definition
        return this;
    }

    /**
     * <p>
     * Render all list items.
     * </p>
     */
    @SubscribeUI(type = UIAction.Scroll, debounce = 100)
    private void render() {
        int viewableTopIndex = Math.round(-renderableItemView.position().top() / itemHeight);
        int renderableTopIndex = Math.max(0, viewableTopIndex - extraTopRenderableItemSize);

        // 既に最後の要素まで到達可能な範囲にいたら末尾から数えるようにする。
        if (renderer.countItem() <= viewableTopIndex + viewableItemSize + extraBottomRenderableItemSize) {
            renderableTopIndex = renderer.countItem() - renderableItemSize;
        }

        // 以前と同じインデックスから始まるようなら再レンダリングする必要はない
        if (lastRenderedTopIndex != renderableTopIndex) {
            lastRenderedTopIndex = renderableTopIndex; // update

            // re-rendering
            spacer.css("height", renderableTopIndex * itemHeight + "px");

            for (int i = 0; i < items.size(); i++) {
                render(renderableTopIndex + i);
            }
        }
    }

    /**
     * <p>
     * Render list item if it is renderable.
     * </p>
     * 
     * @param index A item index to render.
     */
    public void render(int index) {
        if (lastRenderedTopIndex <= index && index < lastRenderedTopIndex + renderableItemSize) {
            renderer.renderItem(index, items.get(index - lastRenderedTopIndex));
        }
    }

    /**
     * <p>
     * Render list item if it is renderable.
     * </p>
     * 
     * @param index A item index to render.
     */
    public Element item(int index) {
        if (lastRenderedTopIndex <= index && index < lastRenderedTopIndex + renderableItemSize) {
            return items.get(index - lastRenderedTopIndex);
        } else {
            return null;
        }
    }

    /**
     * @version 2013/04/02 15:57:52
     */
    public static interface ItemRenderer {

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
         * Render the item model to the given element.
         * </p>
         * 
         * @param index A index of item.
         * @param element A element to render.
         */
        void renderItem(int index, Element element);
    }

    /**
     * @version 2013/04/02 16:04:20
     */
    private static class EmptyItemRenderer implements ItemRenderer {

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
        public void renderItem(int index, Element element) {
        }
    }
}
