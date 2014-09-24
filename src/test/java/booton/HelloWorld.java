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
import jsx.ui.UIManager;
import jsx.ui.Widget;
import jsx.ui.samaple.todo.TodoTasks;
import jsx.ui.samaple.todo.TodoUI;

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

        TodoTasks tasks = new TodoTasks();

        UIManager.render(Global.document.getElementById("Content"), Widget.of(TodoUI.class, tasks));
    }
}
