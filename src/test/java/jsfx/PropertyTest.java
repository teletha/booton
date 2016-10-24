/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsfx;

import javafx.beans.property.ListProperty;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;
import kiss.I;

/**
 * @version 2014/09/09 22:38:43
 */
@RunWith(ScriptRunner.class)
public class PropertyTest {

    @Test
    public void getBean() throws Exception {
        ListProperty property = I.make(ListProperty.class);
        assert property.getBean() == null;
    }
}
