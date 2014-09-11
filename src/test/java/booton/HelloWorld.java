/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton;

import js.lang.Global;
import booton.reactive.TodoWidget;
import booton.reactive.UIManager;
import booton.reactive.Widget;
import booton.virtual.VirtualStructure;

/**
 * @version 2014/03/08 11:13:39
 */
public class HelloWorld {

    /**
     * <p>
     * Entry point.
     * </p>
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");

        UIManager.render(Global.document.getElementById("Content"), new TodoWidget());
    }

    /**
     * @version 2014/09/09 14:50:03
     */
    private static class Weee extends Widget {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure box) {
            box.hbox("test");
        }
    }
}
