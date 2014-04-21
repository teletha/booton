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
import js.lang.NativeMap;
import net.sourceforge.htmlunit.corejs.javascript.ScriptableObject;

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
    }

    /**
     * @version 2014/04/17 14:48:11
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

        public int jsGet_size() {
            return map.size();
        }
    }

    /**
     * @version 2014/04/21 13:07:30
     */
    public static class DateTimeFormat extends Helper {

        private NativeIntl.DateTimeFormat format = new NativeIntl.DateTimeFormat("en");

        public void jsConstructor_DateTimeFormat() {
            System.out.println("a");
        }

        public String jsFunction_format(int date) {
            return format.format(date);
        }
    }
}
