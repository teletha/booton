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

import js.lang.NativeMap;
import net.sourceforge.htmlunit.corejs.javascript.Scriptable;
import net.sourceforge.htmlunit.corejs.javascript.ScriptableObject;
import net.sourceforge.htmlunit.corejs.javascript.annotations.JSFunction;

/**
 * @version 2014/04/17 14:47:38
 */
public class JavascriptClassDefinition {

    /**
     * @version 2014/04/17 14:49:58
     */
    private static interface ScriptableInterface extends Scriptable {

        /**
         * {@inheritDoc}
         */
        @Override
        public default String getClassName() {
            String name = getClass().getSuperclass().getSimpleName();

            if (name.startsWith("Native")) {
                name = name.substring(6);
            }
            return name;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public default Object get(String name, Scriptable start) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public default Object get(int index, Scriptable start) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public default boolean has(String name, Scriptable start) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public default boolean has(int index, Scriptable start) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public default void put(String name, Scriptable start, Object value) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public default void put(int index, Scriptable start, Object value) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public default void delete(String name) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public default void delete(int index) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public default Scriptable getPrototype() {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public default void setPrototype(Scriptable prototype) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public default Scriptable getParentScope() {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public default void setParentScope(Scriptable parent) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public default Object[] getIds() {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public default Object getDefaultValue(Class<?> hint) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public default boolean hasInstance(Scriptable instance) {
            return false;
        }
    }

    /**
     * @version 2014/04/17 14:48:11
     */
    public static class JSMap extends ScriptableObject {

        /** The delegator. */
        private NativeMap map = new NativeMap();

        /**
         * {@inheritDoc}
         */
        @Override
        public String getClassName() {
            return "Map";
        }

        /**
         * {@inheritDoc}
         */
        @JSFunction("get")
        public Object getJS(Object key) {
            return map.get(key);
        }

        /**
         * {@inheritDoc}
         */
        @JSFunction
        public Object set(Object key, Object value) {
            return map.set(key, value);
        }

        /**
         * {@inheritDoc}
         */
        @JSFunction
        public boolean has(Object key) {
            return map.has(key);
        }

        /**
         * {@inheritDoc}
         */
        @JSFunction
        public Object delete(Object key) {
            return map.delete(key);
        }

        /**
         * {@inheritDoc}
         */
        @JSFunction("size")
        public int sizeJS() {
            return map.size();
        }
    }
}
