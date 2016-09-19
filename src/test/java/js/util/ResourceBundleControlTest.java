/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle.Control;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/03/12 8:59:12
 */
@RunWith(ScriptRunner.class)
@Ignore
public class ResourceBundleControlTest {

    @Test
    public void toResourceName() throws Exception {
        Control control = Control.getControl(Control.FORMAT_CLASS);
        assert control.toResourceName("en", "US").equals("en.US");

        control = Control.getControl(Control.FORMAT_PROPERTIES);
        assert control.toResourceName("en", "US").equals("en.US");

        control = Control.getControl(Control.FORMAT_DEFAULT);
        assert control.toResourceName("en", "US").equals("en.US");
    }

    @Test
    public void toBundleName() throws Exception {
        Control control = Control.getControl(Control.FORMAT_CLASS);
        assert control.toBundleName("base", Locale.US).equals("base_en_US");

        control = Control.getControl(Control.FORMAT_PROPERTIES);
        assert control.toBundleName("base", Locale.US).equals("base_en_US");

        control = Control.getControl(Control.FORMAT_DEFAULT);
        assert control.toBundleName("base", Locale.US).equals("base_en_US");
    }

    @Test
    public void getCandidateLocales() throws Exception {
        List<Locale> locales = Control.getControl(Control.FORMAT_CLASS).getCandidateLocales("base", Locale.US);
        assert locales.size() == 3;
        assert locales.get(0) == Locale.US;
        assert locales.get(1) == Locale.ENGLISH;
        assert locales.get(2) == Locale.ROOT;
    }
}
