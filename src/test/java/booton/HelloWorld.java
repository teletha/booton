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
import jsx.ui.TodoUI;
import jsx.ui.UIManager;

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

        UIManager.render(Global.document.getElementById("Content"), new TodoUI());
    }
}
