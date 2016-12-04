/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.soeur;

import static com.gargoylesoftware.htmlunit.javascript.configuration.BrowserName.*;

import com.gargoylesoftware.htmlunit.javascript.SimpleScriptable;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxClass;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxClasses;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxConstructor;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxFunction;
import com.gargoylesoftware.htmlunit.javascript.configuration.WebBrowser;

import net.sourceforge.htmlunit.corejs.javascript.Scriptable;

/**
 * A JavaScript object for {@code CSS}.
 *
 * @author Ahmed Ashour
 */
@JsxClasses({@JsxClass(isJSObject = false, browsers = {@WebBrowser(FF), @WebBrowser(CHROME)}),
        @JsxClass(browsers = {@WebBrowser(IE), @WebBrowser(EDGE)})})
public class CSSS extends SimpleScriptable {

    /**
     * Default constructor.
     */
    @JsxConstructor
    public CSSS() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object get(final String name, final Scriptable start) {
        if ("prototype".equals(name)) {
            return NOT_FOUND;
        }
        return super.get(name, start);
    }

    /**
     * @param name
     * @param value
     * @return
     */
    @JsxFunction
    public static boolean supports(String name, String value) {
        return true;
    }
}
