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
import js.ui.Publishable;
import js.ui.Select;
import js.ui.model.Bindable;
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
        Selectable<String> selectable = new Selectable<String>();
        for (int i = 0; i < 200; i++) {
            selectable.add(String.valueOf(i));
        }

        Select<String> child = root.child(new Select(selectable));
        child.model.setSelectionIndex(180);

        SomeModel model = new SomeModel();

        Input input = root.child(new Input(model.name));
        model.name = "AAAA";
        System.out.println(model.name);
    }

    /**
     * @version 2013/04/08 23:56:46
     */
    private static class SomeModel extends Publishable {

        @Bindable
        public String name;
    }
}
