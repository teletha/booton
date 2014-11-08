/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import java.util.HashMap;
import java.util.Map;

import booton.Obfuscator;
import booton.translator.Javascript;
import booton.translator.Translator;

/**
 * @version 2014/10/31 9:51:37
 */
public class StyleName {

    /** The class id for css. */
    private static final Map<StyleClass, String> css = new HashMap();

    /**
     * <p>
     * Compute style class name.
     * </p>
     * 
     * @param style A target style class.
     * @return A computed style name.
     */
    public static String name(StyleClass style) {
        String name = css.get(style);

        if (name == null) {
            name = "STYLE" + Obfuscator.mung52(css.size());
            css.put(style, name);
        }
        return name;
    }

    /**
     * @version 2014/10/31 9:54:35
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<StyleName> {

        /**
         * <p>
         * Compute style class name.
         * </p>
         * 
         * @param style A target style class.
         * @return A computed style name.
         */
        public String name(StyleClass style) {
            return Javascript.writeMethodCode(StyleClass.class, "intern", param(0));
        }
    }
}
