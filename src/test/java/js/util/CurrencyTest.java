/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.lang.reflect.Method;
import java.util.Currency;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2015/08/08 11:15:39
 */
@RunWith(ScriptRunner.class)
public class CurrencyTest {

    @Test
    public void testname() throws Exception {
        Currency currency = Currency.getInstance("USD");

        for (Method method : currency.getClass().getMethods()) {
            String name = method.getName();

            if (name.startsWith("get") && method.getParameterCount() == 0) {
                // System.out.println(name.substring(3) + " " + method.invoke(currency));
            }
        }
    }
}
