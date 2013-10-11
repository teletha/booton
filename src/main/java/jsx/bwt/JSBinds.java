/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import js.lang.Global;
import js.lang.NativeFunction;
import js.lang.NativeObject;
import js.lang.reflect.Reflections;
import kiss.I;
import kiss.Interceptor;
import kiss.Table;
import kiss.model.Model;
import kiss.model.Property;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/10/11 10:37:56
 */
@JavaAPIProvider(Binds.class)
public class JSBinds extends Interceptor<Bind> {

    /**
     * <p>
     * The binding context checksums.
     * </p>
     * TODO Memory Leak
     */
    private static final Set<Integer> checksums = new CopyOnWriteArraySet();

    /**
     * <p>
     * The local store for binding contexts.
     * </p>
     * TODO Memory Leak
     */
    private static final Map<Object, Table<String, JSBinds>> contexts = new ConcurrentHashMap();

    /**
     * <p>
     * The redefined classes.
     * </p>
     * TODO Memory Leak
     */
    private static final Set<Class> rewrites = new CopyOnWriteArraySet();

    /** The parameter store. */
    private Object[] params;

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object invoke(Object... params) {
        Integer checksum = that.hashCode() ^ annotation.hashCode() ^ Arrays.hashCode(params);

        if (checksums.add(checksum)) {
            // first call for the current context.

            // store parameters to recall
            this.params = params;
            // collect model
            for (Object param : params) {
                if (param != null) {
                    Model model = Model.load(param.getClass());

                    // exclude GUI Widget
                    if (model.properties.size() != 0) {
                        // register as model state listener
                        Table<String, JSBinds> binds = contexts.get(param);

                        if (binds == null) {
                            binds = new Table();
                            contexts.put(param, binds);
                        }

                        // collect bindable properties
                        for (Property property : model.properties) {
                            binds.push(property.name, this);
                        }

                        // rewrite model code to publish their state modification
                        if (rewrites.add(model.type)) {
                            NativeObject prototype = Reflections.getPrototype(model.type);

                            for (Property property : model.properties) {

                                String name = property.name;
                                name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
                                name = (property.model.type == boolean.class ? "is" : "set").concat(name);

                                try {
                                    name = Reflections.getPropertyName(model.type.getMethod(name, property.model.type));
                                    NativeFunction function = new NativeFunction(new BindingFunction());
                                    function.setProperty("$A", prototype.getProperty(name));
                                    function.setProperty("$B", property.name);
                                    System.out.println(function.hashCode() + "  " + property.name);

                                    prototype.setProperty(name, function);
                                } catch (Exception e) {
                                    throw I.quiet(e);
                                }
                            }
                        }
                    }
                }
            }
        }
        return super.invoke(params);
    }

    /**
     * <p>
     * Note: This is internal method to reacll binding method.
     * </p>
     * 
     * @param model A event publisher.
     * @param property A event type.
     */
    public static final void recall(Object model, String property) {
        Table<String, JSBinds> binds = contexts.get(model);

        if (binds != null) {
            System.out.println(property);
            new Error().printStackTrace();
            for (JSBinds bind : binds.get(property)) {
                bind.recall();
            }
        }
    }

    /**
     * <p>
     * Invoke the method.
     * </p>
     */
    private final void recall() {
        try {
            System.out.println("recall with " + Arrays.toString(params));
            super.invoke(params);
            System.out.println("recalled");
        } catch (Throwable e) {
            throw I.quiet(e);
        }
    }

    /**
     * @version 2013/09/26 14:55:33
     */
    private static class BindingFunction {

        /**
         * <p>
         * Invoke interceptor entry point.
         * </p>
         * 
         * @param params
         * @return
         */
        @SuppressWarnings("unused")
        private void invoke() {
            System.out.println(hashCode() + "  " + Global.getContextFuntion().getPropertyAs(String.class, "$B"));
            // call original function
            Global.getContextFuntion().getPropertyAs(NativeFunction.class, "$A").apply(this, Global.getArgumentArray());

            // recall binding function
            recall(this, Global.getContextFuntion().getPropertyAs(String.class, "$B"));
        }
    }
}
