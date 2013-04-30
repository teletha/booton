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
import js.ui.Button;
import js.ui.Input;
import js.ui.Select;
import js.ui.UIEvent;
import js.ui.model.SelectableModel;
import js.util.jQuery;
import js.util.jQuery.Listener;

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

        root.child(new Input<Integer>(model.type));
        root.child(new Input(model.name)).root.click(new Listener() {

            @Override
            public void handler(UIEvent event) {
                model.type = model.type - 1;
            }
        });
        root.child(new Button("Add", new Listener() {

            @Override
            public void handler(UIEvent event) {
                model.type++;
            }
        }));
        model.modeler.name = "changed";
        model.type = 10101;
        Global.sessionStorage.set(model);

        SomeModel restored = Global.sessionStorage.get(SomeModel.class);
        System.out.println(restored);
        restored.test();
        restored.modeler.aaa();
    }

    /**
     * @version 2013/04/08 23:56:46
     */
    private static class SomeModel {

        public String name = "name";

        public int type = 10;

        public Modeler modeler = new Modeler();

        private void test() {
            System.out.println("invoked " + type);
        }
    }

    private static class Modeler {

        public String name = "aa";

        public int type = 10;

        public int[] test = {10, 2};

        private void aaa() {
            System.out.println("nested method " + name);
        }
    }
}
