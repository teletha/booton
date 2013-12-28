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

import java.util.function.Consumer;

import js.dom.DocumentFragment;
import js.dom.UIEvent;
import jsx.application.Page;
import jsx.application.PageInfo;
import jsx.bwt.Button;
import jsx.bwt.Input;
import jsx.bwt.Select;
import jsx.model.SelectableModel;
import teemowork.model.Version;

/**
 * @version 2013/04/02 15:53:46
 */
public class FormCatalogPage extends Page {

    SomeModel model = new SomeModel();

    /**
     * 
     */
    @PageInfo(path = "GridTest")
    public FormCatalogPage() {
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
    public void load(DocumentFragment root) {
        SelectableModel<String> selectable = new SelectableModel<String>();

        for (int i = 0; i < 200; i++) {
            selectable.add(String.valueOf(i));
        }

        Select<String> child = root.child(new Select(selectable));
        child.model.setSelectionIndex(180);

        root.child(new Input(model.type));
        root.child(new Input(model.name));
        root.child(new Button("Add", new Consumer<UIEvent>() {

            @Override
            public void accept(UIEvent event) {
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

        root.child(new Select(Version.class));
    }

    /**
     * @version 2013/04/08 23:56:46
     */
    private static class SomeModel {

        public String name = "name";

        public int type = 10;

        public Modeler modeler = new Modeler();

        private void test() {
            System.out.println("invoked " + type + "  " + name);
        }
    }

    private static class Modeler {

        public String name = "aa";

        public int type = 10;

        public String[] test = {"act"};

        private void aaa() {
            System.out.println("nested method " + name + "   " + test[0]);
        }
    }
}
