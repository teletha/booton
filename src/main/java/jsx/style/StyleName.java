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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import kiss.I;
import booton.BootonConfiguration;
import booton.translator.Javascript;
import booton.translator.Translator;

/**
 * @version 2014/10/31 9:51:37
 */
public class StyleName {

    /** The configuration. */
    private static final BootonConfiguration config = I.make(BootonConfiguration.class);

    /** The style classes. */
    private static final Set<String> classes = new HashSet();

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
        String className = style.getClass().getName();
        int index = className.indexOf("$$");

        if (index != -1) {
            className = className.substring(0, index);
        }

        if (classes.add(className)) {
            try {
                Class clazz = Class.forName(className);

                for (Field field : clazz.getDeclaredFields()) {
                    if (field.getType() == StyleClass.class && Modifier.isStatic(field.getModifiers())) {
                        field.setAccessible(true);

                        String styleName;

                        if (config.compression) {
                            // If this exception will be thrown, it is bug of this program. So we
                            // must
                            // rethrow the wrapped error in here.
                            throw new Error();
                        } else {
                            styleName = field.getDeclaringClass().getName() + "___" + field.getName();
                            styleName = styleName.replaceAll("\\.", "_");
                        }
                        css.put((StyleClass) field.get(null), styleName);
                    }
                }
            } catch (Exception e) {
                throw I.quiet(e);
            }
        }
        return css.get(style);
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
