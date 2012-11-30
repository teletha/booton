/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import org.junit.Test;

import booton.translator.api.ObjectScript;

/**
 * @version 2012/11/30 15:32:58
 */
public class ClassTest extends ScriptTranslatorTestcase {

    @Test
    public void ClassLiteral() {
        assertScript(new ClassLiteral());
    }

    /**
     * @version 2009/08/21 3:46:13
     */
    private static class ClassLiteral implements ObjectScript<String> {

        public String execute(String value) {
            return "";
        }
    }
}
