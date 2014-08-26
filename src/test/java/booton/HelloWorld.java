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

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import kiss.I;

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

        StringProperty p = new SimpleStringProperty();

        I.observe(p).buffer(2, 1).to(v -> System.out.println(v));

        p.set("1");
        p.set("2");
        p.set("3");
        p.set("4");
    }
}
