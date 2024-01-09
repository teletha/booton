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

import js.lang.NativeIntl;
import js.lang.NativeIntl.DateTimeFormat.Option;
import js.lang.NativeMap;
import js.lang.NativeSet;
import kiss.I;
import kiss.Model;
import kiss.Property;
import net.sourceforge.htmlunit.corejs.javascript.Context;
import net.sourceforge.htmlunit.corejs.javascript.Function;
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
            Model<T> model = Model.of(type);

            for (Property property : model.properties()) {
                Object value = base.get(property.name);

                if (value == null || value instanceof Undefined) {
                    // do nothing
                } else if (property.model.atomic) {
                    model.set(instance, property, value);
                } else {
                    model.set(instance, property, cast(value, property.model.type));
                }
            }
            return instance;
        }
    }

    /**
     * @version 2015/02/28 14:29:23
     */
    public static class Set extends Helper {

        /** The delegator. */
        private NativeSet set = new NativeSet();

        /**
         * <p>
         * Returns the number of key/value pairs in {@link NativeMap}.
         * </p>
         * 
         * @return
         */
        public int jsGet_size() {
            return set.size();
        }

        /**
         * <p>
         * Adds the value to {@link NativeSet}.
         * </p>
         * 
         * @param value The value of the element to add to the {@link NativeSet}.
         */
        public Set jsFunction_add(Object value) {
            set.add(value);

            return this;
        }

        /**
         * <p>
         * Sets the value for the key in {@link NativeSet}.
         * </p>
         * 
         * @param value
         */
        public boolean jsFunction_delete(Object value) {
            return set.delete(value);
        }

        /**
         * <p>
         * Removes all elements from a {@link NativeSet} object.
         * </p>
         */
        public void jsFunction_clear() {
            set.clear();
        }

        /**
         * <p>
         * Returns a boolean asserting whether the value has been added to {@link NativeSet} or not.
         * </p>
         * 
         * @param value The value to test for presence in the {@link NativeSet}.
         * @return Returns true if an element with the specified value exists in the
         *         {@link NativeSet} otherwise false.
         */
        public boolean jsFunction_has(Object value) {
            return set.has(value);
        }

        /**
         * <p>
         * Executes a provided function once per each value in the {@link NativeMap}.
         * </p>
         * 
         * @param consumer Function to execute for each element.
         */
        public void jsFunction_forEach(Function consumer) {
            set.forEach(value -> consumer.call(Context.enter(), this, this, new Object[] {value}));
        }
    }

    /**
     * @version 2015/02/27 16:04:28
     */
    public static class Map extends Helper {

        /** The delegator. */
        private NativeMap map = new NativeMap();

        /**
         * Delegation method.
         */
        public Object jsFunction_get(Object key) {
            return map.get(key);
        }

        /**
         * Delegation method.
         */
        public void jsFunction_set(Object key, Object value) {
            map.set(key, value);
        }

        /**
         * Delegation method.
         */
        public boolean jsFunction_has(Object key) {
            return map.has(key);
        }

        /**
         * Delegation method.
         */
        public Object jsFunction_delete(Object key) {
            return map.delete(key);
        }

        /**
         * Delegation method.
         */
        public void jsFunction_clear() {
            map.clear();
        }

        /**
         * <p>
         * Executes a provided function once per each key/value pair in the Map object, in insertion
         * order.
         * </p>
         *
         * @param consumer A consumer to execute for each element.
         */
        public void jsFunction_forEach(Function consumer) {
            map.forEach((value, key) -> consumer.call(Context.enter(), this, this, new Object[] {value, key}));
        }

        /**
         * Delegation method.
         */
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

    /**
     * @version 2015/08/07 23:30:23
     */
    public static class Performance extends Helper {

        /**
         * <p>
         * Wait script execution.
         * </p>
         */
        public double jsFunction_now() {
            return System.nanoTime();
        }
    }
}
