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

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/02/26 14:27:45
 */
@RunWith(ScriptRunner.class)
public class BindingTest {

    @Test
    public void bindBidirectional() throws Exception {
        StringProperty property1 = new SimpleStringProperty("value1");
        StringProperty property2 = new SimpleStringProperty("value2");
        assert property1.get().equals("value1");
        assert property2.get().equals("value2");

        property2.set("change value2");
        assert property1.get().equals("value1");
        assert property2.get().equals("change value2");

        // bind
        property1.bindBidirectional(property2);
        assert property1.get().equals("change value2");
        assert property2.get().equals("change value2");

        property2.set("change from property2");
        assert property1.get().equals("change from property2");
        assert property2.get().equals("change from property2");

        property1.set("change from property1");
        assert property1.get().equals("change from property1");
        assert property2.get().equals("change from property1");
    }
}
