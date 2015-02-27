/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.soeur;

import js.lang.NativeIntl;
import js.lang.NativeIntl.DateTimeFormat.Option;
import js.lang.NativeMap;
import kiss.I;
import kiss.model.Model;
import kiss.model.Property;
import net.sourceforge.htmlunit.corejs.javascript.NativeObject;
import net.sourceforge.htmlunit.corejs.javascript.ScriptableObject;
import net.sourceforge.htmlunit.corejs.javascript.Undefined;

/**
 * @version 2014/04/17 14:47:38
 */
@SuppressWarnings("serial")
public class JavascriptClassDefinition {

    /**
     * @version 2014/04/18 14:09:22
     */
    public static class Helper extends ScriptableObject {

        /**
         * {@inheritDoc}
         */
        @Override
        public String getClassName() {
            return getClass().getSimpleName();
        }

        protected <T> T cast(Object object, Class<T> type) {
            NativeObject base = (NativeObject) object;
            T instance = I.make(type);
            Model model = Model.load(type);

            for (Property property : model.properties) {
                Object value = base.get(property.name);

                if (value == null || value instanceof Undefined) {
                    // do nothing
                } else if (property.isAttribute()) {
                    model.set(instance, property, value);
                } else {
                    model.set(instance, property, cast(value, property.model.type));
                }
            }
            return instance;
        }
    }

    /**
     * @version 2015/02/27 16:04:28
     */
    public static class Map extends Helper {

        /** The delegator. */
        private NativeMap map = new NativeMap();

        public Object jsFunction_get(Object key) {
            return map.get(key);
        }

        public Object jsFunction_set(Object key, Object value) {
            return map.set(key, value);
        }

        public boolean jsFunction_has(Object key) {
            return map.has(key);
        }

        public Object jsFunction_delete(Object key) {
            return map.delete(key);
        }

        public void jsFunction_clear() {
            map.clear();
        }

        public Object jsFunction_keys() {
            return map.keys();
        }

        public int jsGet_size() {
            return map.size();
        }
    }

    /**
     * @version 2014/04/21 13:07:30
     */
    public static class DateTimeFormat extends Helper {

        private NativeIntl.DateTimeFormat format;

        public void jsConstructor(String locale, Object option) {
            if (option instanceof Undefined) {
                format = new NativeIntl.DateTimeFormat(locale);
            } else {
                format = new NativeIntl.DateTimeFormat(locale, cast(option, Option.class));
            }
        }

        public String jsFunction_format(int date) {
            return format.format(date);
        }
    }
}
