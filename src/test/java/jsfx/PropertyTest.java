/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsfx;

import javafx.beans.binding.MapExpression;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/09/09 22:38:43
 */
@RunWith(ScriptRunner.class)
public class PropertyTest {

    @Test
    public void testname() throws Exception {
        System.out.println(MapExpression.class);
    }

    // @Test
    // public void getBean() throws Exception {
    // ListProperty property = I.make(ListProperty.class);
    // System.out.println(property.getClass());
    // assert property.getBean() == null;
    // System.out.println(property.toString());
    // }
}
