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

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import kiss.ClassListener;
import kiss.I;
import kiss.Manageable;
import kiss.Singleton;
import kiss.Table;
import kiss.model.ClassUtil;

import org.objectweb.asm.Type;

import booton.translator.web.JQuery.EventListener;

/**
 * @version 2012/12/02 16:11:18
 */
@Manageable(lifestyle = Singleton.class)
class TranslatorManager implements ClassListener<Translator> {

    /** The special translators. */
    private static final Map<Class, Translator> translators = new ConcurrentHashMap();

    /** The native methods. */
    private static final Table<Integer, Class> natives = new Table();

    static {
        registerNativeMethod(EventListener.class);
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
        if (Translatable.class.isAssignableFrom(type)) {
            return true;
        }

        if (translators.containsKey(type)) {
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
        if (type == Object.class) {
            return I.make(ObjectTranslator.class);
        }

        if (Translatable.class.isAssignableFrom(type)) {
            return I.make(TranslatableTranslator.class);
        }

        Translator translator = translators.get(type);

        if (translator == null) {
            return I.make(GeneralTranslator.class);
        } else {
            return translator;
        }
    }

    /**
     * <p>
     * Detect this is native method or not.
     * </p>
     * 
     * @param owner A method owner.
     * @param name A method name.
     * @param description A method description.
     * @return
     */
    static boolean isNative(Class owner, String name, String description) {
        List<Class> classes = natives.get(name.hashCode() + description.hashCode());

        for (Class clazz : classes) {
            if (clazz.isAssignableFrom(owner)) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Register native methods.
     * </p>
     * 
     * @param nativeClass
     */
    public static void registerNativeMethod(Class nativeClass) {
        if (nativeClass != null) {
            Table<Method, Annotation> annotations = ClassUtil.getAnnotations(nativeClass);

            for (Entry<Method, List<Annotation>> entry : annotations.entrySet()) {
                for (Annotation annotation : entry.getValue()) {
                    if (annotation.annotationType() == JSNative.class) {
                        Method method = entry.getKey();

                        natives.push(method.getName().hashCode() + Type.getMethodDescriptor(method).hashCode(), nativeClass);
                    }
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void load(Class<Translator> clazz) {
        if (clazz != Translator.class) {
            translators.put(ClassUtil.getParameter(clazz, Translator.class)[0], I.make(clazz));
        }
    }

    /**
     * {@inheritDoc}
     */
    public void unload(Class<Translator> clazz) {
        if (clazz != Translator.class) {
            translators.remove(ClassUtil.getParameter(clazz, Translator.class)[0]);
        }
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
        String translateConstructor(Class owner, String desc, Class[] types, List context) {
            // append identifier of constructor method
            context.add(new OperandNumber(Integer.valueOf(Javascript.computeMethodName(owner, "<init>", desc)
                    .substring(1))));

            return "new " + Javascript.computeClassName(owner) + writeParameter(context);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        String translateMethod(Class owner, String name, String desc, Class[] types, List context) {
            return context.get(0) + "." + Javascript.computeMethodName(owner, name, desc) + writeParameter(context);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        String translateStaticMethod(Class owner, String name, String desc, Class[] types, List context) {
            return context.get(0) + "." + Javascript.computeMethodName(owner, name, desc) + writeParameter(context);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        String translateSuperMethod(Class owner, String name, String desc, Class[] types, List context) {
            // append context 'this' of super method
            context.add(1, new OperandExpression("this"));

            return Javascript.computeClassName(owner) + ".prototype." + Javascript.computeMethodName(owner, name, desc) + ".call" + writeParameter(context);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        String translateStaticField(Class owner, String fieldName, boolean isNotStatic) {
            return (isNotStatic ? Javascript.computeClassName(owner) : "this") + "." + fieldName;
        }
    }

    /**
     * @version 2012/12/02 16:34:06
     */
    @Manageable(lifestyle = Singleton.class)
    private static class TranslatableTranslator extends Translator<TranslatableTranslator> {

        /**
         * {@inheritDoc}
         */
        @Override
        String translateConstructor(Class owner, String desc, Class[] types, List<Operand> context) {
            // append identifier of constructor method
            context.add(new OperandNumber(Integer.valueOf(Javascript.computeMethodName(owner, "<init>", desc)
                    .substring(1))));

            return "new " + Javascript.computeClassName(owner) + writeParameter(context);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        String translateMethod(Class owner, String name, String desc, Class[] types, List<Operand> context) {
            StringBuilder builder = new StringBuilder();
            builder.append(context.get(0).toString());
            builder.append('.').append(name).append('(');
            for (int i = 0; i < types.length; i++) {
                builder.append(context.get(i + 1).cast(types[i]));

                if (i != types.length - 1) {
                    builder.append(',');
                }
            }
            builder.append(')');

            return builder.toString();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        String translateStaticMethod(Class owner, String name, String desc, Class[] types, List<Operand> context) {
            StringBuilder builder = new StringBuilder();
            builder.append(name).append('(');
            for (int i = 0; i < types.length; i++) {
                builder.append(context.get(i + 1).cast(types[i]));

                if (i != types.length - 1) {
                    builder.append(',');
                }
            }
            builder.append(')');

            return builder.toString();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        String translateSuperMethod(Class owner, String name, String desc, Class[] types, List<Operand> context) {
            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            throw new Error();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        Object translateField(Class ownerClass, String name, Operand context) {
            return context + "." + name;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        String translateStaticField(Class owner, String fieldName, boolean isNotStatic) {
            return fieldName;
        }
    }

    /**
     * @version 2012/12/05 11:54:43
     */
    private static class ObjectTranslator extends Translator<ObjectTranslator> {

        /**
         * {@inheritDoc}
         */
        @Override
        String translateMethod(Class owner, String name, String description, Class[] types, List<Operand> context) {
            System.out.println(name);
            switch (name) {
            case "equals":
                return "(this==" + context.get(0) + ")";

            default:
                break;
            }
            return super.translateMethod(owner, name, description, types, context);
        }
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
