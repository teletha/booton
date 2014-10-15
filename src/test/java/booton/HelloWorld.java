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
import js.lang.NativeCSSRuleList;
import js.lang.NativeCSSStyleSheetList;
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

        NativeCSSStyleSheetList styleSheets = Global.document.styleSheets();

        for (int i = 0; i < styleSheets.length(); i++) {
            NativeCSSRuleList rules = styleSheets.item(i).getRules();

            for (int j = 0; j < rules.length(); j++) {
                System.out.println(rules.item(j).getCSSText());
            }
        }

        TodoTasks tasks = new TodoTasks();

        TodoUI widget = Widget.of(TodoUI.class, tasks);
        widget.renderIn(Global.document.getElementById("Content"));
    }
}
