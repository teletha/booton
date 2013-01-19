/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import static js.lang.Global.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import js.application.Application;
import js.application.Header;
import js.application.Header.Menu;
import js.application.PageInfo;
import js.lang.Classes;
import teemowork.model.Patch;

/**
 * @version 2012/12/11 14:23:57
 */
public class Teemowork extends Application {

    /**
     * {@inheritDoc}
     */
    @Override
    public void jsmain() {
        $("body").css("padding", "0px 10%");

        Header nav = new Header();
        nav.add("< ^ v ^ > Teemowork", "test.html");
        nav.add("Patch", "#");

        Menu sub = nav.add("Data", "#");
        sub.add("Champion", "#");
        sub.add("Item", "#");
        sub.add("Mastery", "#");
        sub.add("Rune", "#");

        nav.add("Builder", "#");
        nav.add("About", "#");
        nav.add("Contact", "#");

        System.out.println(Patch.Latest);

        PageInfo info = Classes.createProxy(PageInfo.class, new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("called");
                return "proxy";
            }
        });
        System.out.println(info.path());
    }
}
