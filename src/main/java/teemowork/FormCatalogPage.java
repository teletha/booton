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
import js.ui.model.Property;
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
        if (true) {
            throw new Error();
        }
        model.modeler.test[0] = "acted";
        model.modeler.name = "changed";
        model.type = 10101;
        model.name = " changed !";
        Global.sessionStorage.set(model);

        SomeModel restored = Global.sessionStorage.get(SomeModel.class);
        restored.test();
        restored.modeler.aaa();

        System.out.println(model);

        new Error().printStackTrace();
    }

    /**
     * @version 2013/04/08 23:56:46
     */
    private static class SomeModel {

        @Property
        public String name = "name";

        @Property
        public int type = 10;

        @Property
        public Modeler modeler = new Modeler();

        private void test() {
            System.out.println("invoked " + type + "  " + name);
        }
    }

    private static class Modeler {

        @Property
        public String name = "aa";

        @Property
        public int type = 10;

        @Property
        public String[] test = {"act"};

        private void aaa() {
            System.out.println("nested method " + name + "   " + test[0]);
        }
    }
}
