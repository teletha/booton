/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.bwt;

import static org.objectweb.asm.Opcodes.*;

import java.beans.Introspector;
import java.lang.invoke.MethodHandle;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import kiss.I;
import kiss.Interceptor;
import kiss.Table;
import kiss.model.Model;
import kiss.model.Property;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import antibug.bytecode.Agent;
import antibug.bytecode.Agent.Translator;

/**
 * @version 2013/08/02 10:57:26
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

                    if (model.properties.size() == 1) {
                        // register as model state listener
                        Table<String, Binds> binds = contexts.get(param);

                        if (binds == null) {
                            binds = new Table();
                            contexts.put(param, binds);
                        }

                        // collect bindable properties
                        for (String property : collectProperies(model)) {
                            binds.push(property, this);
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
     * Collect calling properties of the specified model in the current method.
     * </p>
     * 
     * @param model
     * @return
     */
    private Set<String> collectProperies(Model model) {
        try {
            MethodSeach seacher = new MethodSeach(name, method, model);
            ClassReader reader = new ClassReader(Model.load(that.getClass()).type.getName());
            reader.accept(seacher, ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);

            return seacher.properties;
        } catch (Exception e) {
            throw I.quiet(e);
        }
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
     * @version 2013/08/02 11:53:30
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
                model = Model.load(Class.forName(className.replace('/', '.')));
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
                mv.visitMethodInsn(INVOKESTATIC, "js/bwt/Binds", "recall", "(Ljava/lang/Object;Ljava/lang/String;)V");
            }
        }
    }

    /**
     * @version 2013/08/02 11:53:43
     */
    private static class MethodSeach extends ClassVisitor {

        /** The method name. */
        private final String name;

        /** The method description. */
        private final String desc;

        /** The target model name. */
        private final Model model;

        /** The internal model name. */
        private final String modelInternl;

        /** The property names. */
        private final Set<String> properties = new HashSet();

        /**
         * 
         */
        private MethodSeach(String name, MethodHandle method, Model model) {
            super(ASM4);

            this.name = name;
            this.desc = method.type().dropParameterTypes(0, 1).toMethodDescriptorString();
            this.model = model;
            this.modelInternl = Type.getType(model.type).getInternalName();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            if (this.name.equals(name) && this.desc.equals(desc)) {
                return new PropertySearch();
            }
            return null;
        }

        /**
         * @version 2013/08/02 11:53:47
         */
        private class PropertySearch extends MethodVisitor {

            /**
             * 
             */
            protected PropertySearch() {
                super(ASM4);
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void visitMethodInsn(int opcode, String owner, String name, String desc) {
                if (modelInternl.equals(owner) && Type.getArgumentTypes(desc).length == 0) {
                    Type returnType = Type.getReturnType(desc);
                    String prefix = "get";

                    if (returnType == Type.BOOLEAN_TYPE) {
                        prefix = "is";
                    }

                    if (name.startsWith(prefix)) {
                        Property property = model.getProperty(Introspector.decapitalize(name.substring(prefix.length())));

                        if (property != null) {
                            properties.add(property.name);
                        }
                    }
                }
            }
        }
    }
}
