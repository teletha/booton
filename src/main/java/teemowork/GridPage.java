/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import js.application.Page;
import js.application.PageInfo;
import js.ui.Input;
import js.ui.view.ScrollableListView;
import js.ui.view.ScrollableListView.ItemProvider;
import js.util.jQuery;

/**
 * @version 2013/04/02 15:53:46
 */
public class GridPage extends Page {

    /**
     * 
     */
    @PageInfo(path = "GridTest")
    private GridPage() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "GridTest";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(jQuery root) {
        root.append(new Input());
        root.append(new ScrollableListView(10, 20).provide(new ItemProvider() {

            /**
             * {@inheritDoc}
             */
            @Override
            public int countItem() {
                return 800;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public Object item(int index) {
                return index;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void render(int index, jQuery element, Object model) {
                element.text(index);
            }
        }));
    }
}
