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

import static org.objectweb.asm.Opcodes.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import kiss.I;
import kiss.Interceptor;
import kiss.Table;
import kiss.model.Model;
import kiss.model.Property;
import antibug.bytecode.Agent;
import antibug.bytecode.Agent.Translator;

/**
 * @version 2013/10/11 9:53:52
 */
public class Binds extends Interceptor<Bind> {

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
    private static final Map<Object, Table<String, Binds>> contexts = new ConcurrentHashMap();

    /**
     * <p>
     * The redefined classes.
     * </p>
     * TODO Memory Leak
     */
    private static final Set<Class> rewrites = new CopyOnWriteArraySet();

    /** The code rewriter. */
    private static final Agent agent = new Agent(BindingCodeWriter.class);

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
                        Table<String, Binds> binds = contexts.get(param);

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
                            agent.transform(model.type);
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
        Table<String, Binds> binds = contexts.get(model);

        if (binds != null) {
            for (Binds bind : binds.get(property)) {
                bind.recall();
            }
        }
    }

    /**
     * <p>
     * Invoke the method.
     * </p>
     */
    final void recall() {
        try {
            super.invoke(params);
        } catch (Throwable e) {
            throw I.quiet(e);
        }
    }

    /**
     * @version 2013/10/11 9:54:41
     */
    private static final class BindingCodeWriter extends Translator {

        /** The current processing model. */
        private Model model;

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitCode() {
            super.visitCode();

            try {
                model = kiss.model.Model.load(Class.forName(className.replace('/', '.')));
            } catch (ClassNotFoundException e) {
                throw I.quiet(e);
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitFieldInsn(int opcode, String owner, String name, String desc) {
            super.visitFieldInsn(opcode, owner, name, desc);

            if (opcode == PUTFIELD && model.getProperty(name) != null) {
                mv.visitVarInsn(ALOAD, 0);
                mv.visitLdcInsn(name);
                mv.visitMethodInsn(INVOKESTATIC, "jsx/bwt/Binds", "recall", "(Ljava/lang/Object;Ljava/lang/String;)V");
            }
        }
    }
}
