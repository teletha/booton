/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.builtin;

import js.lang.NativeObject;
import jsx.Util;
import jsx.model.Property;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/05/15 11:21:34
 */
@RunWith(ScriptRunner.class)
public class JSONTest {

    @Test
    public void write() throws Exception {
        Model model = new Model();
        model.intValue = -10;
        model.stringValue = "changed";

        String text = Util.write(model);
        Model restored = Util.read(Model.class, text);

        assert restored != model;
        assert restored.intValue == -100;
        assert restored.stringValue.equals("changed");
    }

    /**
     * @version 2013/05/15 11:21:32
     */
    private static class Model extends NativeObject {

        @Property
        private int intValue;

        @Property
        private String stringValue;
    }
}
