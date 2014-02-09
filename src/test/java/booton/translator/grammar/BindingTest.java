/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.grammar;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/02/09 14:02:09
 */
@RunWith(ScriptRunner.class)
public class BindingTest {

    @Test
    public void testname() throws Exception {
        StringProperty property1 = new SimpleStringProperty("aaa");
        StringProperty property2 = new AAA();
        System.out.println(property1);
        System.out.println(property2);

        property1.bindBidirectional(property2);
        System.out.println(property1);
        System.out.println(property2);

        property1.set("change");
        System.out.println(property1);
        System.out.println(property2);
        assert property2.get().equals("change");
    }

    private static class AAA extends SimpleStringProperty {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void fireValueChangedEvent() {
            super.fireValueChangedEvent();
            System.out.println("set new balue");
        }

    }
}
