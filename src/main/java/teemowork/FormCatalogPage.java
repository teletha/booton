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
import js.ui.Bindable;
import js.ui.Input;
import js.ui.Listen;
import js.ui.Select;
import js.ui.UIAction;
import js.ui.model.SelectableModel;
import js.util.jQuery;

/**
 * @version 2013/04/02 15:53:46
 */
public class FormCatalogPage extends Page {

    SomeModel model = new SomeModel();

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
        SelectableModel<String> selectable = new SelectableModel<String>();
        for (int i = 0; i < 200; i++) {
            selectable.add(String.valueOf(i));
        }

        Select<String> child = root.child(new Select(selectable));
        child.model.setSelectionIndex(180);

        Input<Integer> input = root.child(new Input(model.type));
        Input<String> input2 = root.child(new Input(model.name));

        input2.form.bind(this);
    }

    @Listen(UIAction.Blur)
    private void confirm() {
        System.out.println("current value is " + model.name);
    }

    /**
     * @version 2013/04/08 23:56:46
     */
    private static class SomeModel {

        @Bindable
        public String name = "base";

        @Bindable
        public int type = 1;
    }
}
