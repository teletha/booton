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

import js.util.jQuery;
import js.util.jQuery.Listener;
import jsx.application.Page;
import jsx.application.PageInfo;
import jsx.bwt.Button;
import jsx.bwt.Input;
import jsx.bwt.Selection;
import jsx.bwt.UIEvent;
import jsx.model.Property;
import jsx.model.SelectableModel;

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

        Selection<String> child = root.child(new Selection(selectable));
        child.model.setSelectionIndex(180);

        root.child(new Input(model.type));
        root.child(new Input(model.name));
        root.child(new Button("Add", new Listener() {

            @Override
            public void handler(UIEvent event) {
                model.type++;
                System.out.println(model.type);
                model.name = String.valueOf(model.type);
            }
        }));
        model.type = 111000;

        // model.modeler.test[0] = "acted";
        // model.modeler.name = "changed";
        // model.type = 10101;
        // model.name = " changed !";
        // Global.sessionStorage.set(model);
        //
        // SomeModel restored = Global.sessionStorage.get(SomeModel.class);
        // restored.test();
        // restored.modeler.aaa();
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
