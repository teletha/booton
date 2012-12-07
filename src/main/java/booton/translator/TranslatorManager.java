/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import kiss.I;
import kiss.Manageable;
import kiss.Singleton;
import kiss.Table;
import kiss.model.ClassUtil;
import kiss.model.Model;

import org.objectweb.asm.Type;

/**
 * @version 2012/12/06 18:28:56
 */
class TranslatorManager {

    /** The native fields. */
    private static final Map<Class, Set<String>> nativeFields = new ConcurrentHashMap();

    /** The native methods. */
    private static final Table<Integer, Class> nativeMethods = new Table();

    static {
        // Object class is built-in native class.
        for (Method method : Object.class.getMethods()) {
            nativeMethods.push(hash(method.getName(), Type.getMethodDescriptor(method)), Object.class);
        }
    }

    /**
     * <p>
     * Register the given class as native.
     * </p>
     * 
     * @param nativeClass A target class to register.
     */
    private static void register(Class nativeClass) {
        for (Class type : ClassUtil.getTypes(nativeClass)) {
            for (Class interfaceType : type.getInterfaces()) {
                if (interfaceType == JavascriptNative.class) {
                    // The current class implements it directly.
                    for (Method method : type.getDeclaredMethods()) {
                        nativeMethods.push(hash(method.getName(), Type.getMethodDescriptor(method)), nativeClass);
                    }

                    Set<String> set = new HashSet();

                    for (Field field : type.getDeclaredFields()) {
                        set.add(field.getName());
                    }
                    nativeFields.put(type, set);
                }
            }
        }
    }

    /**
     * <p>
     * Calcurate fingerprint for the method.
     * </p>
     * 
     * @param name A method name.
     * @param desciption A method description.
     * @return
     */
    private static Integer hash(String name, String desciption) {
        return name.hashCode() ^ desciption.hashCode();
    }

    /**
     * <p>
     * Detect special translator.
     * </p>
     * 
     * @param type
     * @return
     */
    static boolean hasTranslator(Class type) {
        if (I.find(Translator.class, type) != null) {
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Retrieve a special translator for the specified type.
     * </p>
     * 
     * @param type
     * @return
     */
    static Translator getTranslator(Class type) {
        // search user defined translator
        Translator translator = I.find(Translator.class, type);

        if (translator != null) {
            return translator;
        }

        // javascript native class
        if (JavascriptNative.class.isAssignableFrom(type) && !nativeFields.containsKey(type)) {
            register(type);
        }

        // normal translator
        return I.make(GeneralTranslator.class);
    }

    /**
     * <p>
     * Detect this is native method or not.
     * </p>
     * 
     * @param owner A method owner.
     * @param name A method name.
     * @param description A method description.
     * @return A result.
     */
    static boolean isNativeMethod(Class owner, String name, String description) {
        List<Class> classes = nativeMethods.get(hash(name, description));

        for (Class clazz : classes) {
            if (clazz.isAssignableFrom(owner)) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Substitute class for script.
     * </p>
     * 
     * @param type
     * @return
     */
    static Class substitute(Class type) {
        Substitutable substitutable = I.find(Substitutable.class, type);

        if (substitutable == null) {
            return type;
        } else {
            return Model.load(substitutable.getClass()).type;
        }
    }

    /**
     * <p>
     * Detect this is native field or not.
     * </p>
     * 
     * @param owner A field owner.
     * @param name A field name.
     * @return A result.
     */
    static boolean isNativeField(Class owner, String name) {
        Set<String> fields = nativeFields.get(owner);

        return fields != null && fields.contains(name);
    }

    /**
     * @version 2012/12/02 16:20:23
     */
    @Manageable(lifestyle = Singleton.class)
    private static class GeneralTranslator extends Translator<GeneralTranslator> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected String translateConstructor(Class owner, String desc, Class[] types, List<Operand> context) {
            // append identifier of constructor method
            context.add(new OperandNumber(Integer.valueOf(Javascript.computeMethodName(owner, "<init>", desc)
                    .substring(1))));

            return "new " + Javascript.computeClassName(owner) + writeParameter(context);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected String translateMethod(Class owner, String name, String desc, Class[] types, List<Operand> context) {
            return context.get(0) + "." + Javascript.computeMethodName(owner, name, desc) + writeParameter(context);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected String translateStaticMethod(Class owner, String name, String desc, Class[] types, List<Operand> context) {
            return context.get(0) + "." + Javascript.computeMethodName(owner, name, desc) + writeParameter(context);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected String translateSuperMethod(Class owner, String name, String desc, Class[] types, List<Operand> context) {
            // append context 'this' of super method
            context.add(1, new OperandExpression("this"));

            return Javascript.computeClassName(owner) + ".prototype." + Javascript.computeMethodName(owner, name, desc) + ".call" + writeParameter(context);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected String translateStaticField(Class owner, String fieldName) {
            return Javascript.computeClassName(owner) + "." + Javascript.computeFieldName(owner, fieldName);
        }

        /**
         * Helper method to write parameter expression.
         * 
         * @param operands
         * @return
         */
        private static String writeParameter(List<Operand> operands) {
            StringBuilder builder = new StringBuilder();
            builder.append('(');

            for (int i = 1; i < operands.size(); i++) {
                builder.append(operands.get(i));

                if (i + 1 != operands.size()) {
                    builder.append(',');
                }
            }
            builder.append(')');

            return builder.toString();
        }
    }
}
