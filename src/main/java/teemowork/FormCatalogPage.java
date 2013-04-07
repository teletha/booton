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
import js.lang.Global;
import js.ui.Select;
import js.ui.model.Selectable;
import js.util.jQuery;

/**
 * @version 2013/04/02 15:53:46
 */
public class FormCatalogPage extends Page {

    /**
     * 
     */
    @PageInfo(path = "GridTest")
    private FormCatalogPage() {
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
        Selectable<String> s = new Selectable<String>();
        for (int i = 0; i < 200; i++) {
            s.add(String.valueOf(i));
        }

        final Select<String> child = root.child(new Select(s));
        child.model.setSelectionIndex(180);

        Global.setTimeout(new Runnable() {

            /**
             * {@inheritDoc}
             */
            @Override
            public void run() {
                child.options.open();
            }
        }, 1000);
    }
}
