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

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import kiss.ClassListener;
import kiss.I;
import kiss.Manageable;
import kiss.Singleton;
import kiss.model.ClassUtil;

/**
 * @version 2012/12/02 16:11:18
 */
@Manageable(lifestyle = Singleton.class)
class TranslatorManager implements ClassListener<Translator> {

    /** The supecial translators. */
    private static final Map<Class, Translator> translators = new ConcurrentHashMap();

    /**
     * <p>
     * Detect special translator.
     * </p>
     * 
     * @param type
     * @return
     */
    static boolean hasTranslator(Class type) {
        if (type.isAnnotationPresent(Translatable.class)) {
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
        if (type.isAnnotationPresent(Translatable.class)) {
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
        public String translateMethod(Class owner, String name, String desc, Class[] types, List context) {
            return context.get(0) + "." + Javascript.computeMethodName(owner, name, desc) + writeParameter(context);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String translateStaticMethod(Class owner, String name, String desc, Class[] types, List context) {
            return context.get(0) + "." + Javascript.computeMethodName(owner, name, desc) + writeParameter(context);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String translateConstructor(Class owner, String desc, Class[] types, List context) {
            // append identifier of constructor method
            context.add(new OperandNumber(Integer.valueOf(Javascript.computeMethodName(owner, "<init>", desc)
                    .substring(1))));

            return "new " + Javascript.computeClassName(owner) + writeParameter(context);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String translateSuperMethod(Class owner, String name, String desc, Class[] types, List context) {
            // append context 'this' of super method
            context.add(1, new OperandExpression("this"));

            return Javascript.computeClassName(owner) + ".prototype." + Javascript.computeMethodName(owner, name, desc) + ".call" + writeParameter(context);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String translateStaticField(Class owner, String fieldName, boolean isNotStatic) {
            return (isNotStatic ? Javascript.computeClassName(owner) : "this") + "." + fieldName;
        }

        /**
         * Helper method to write parameter expression.
         * 
         * @param operands
         * @return
         */
        private String writeParameter(List<Operand> operands) {
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

    /**
     * @version 2012/12/02 16:34:06
     */
    @Manageable(lifestyle = Singleton.class)
    private static class TranslatableTranslator extends Translator<TranslatableTranslator> {

        /**
         * {@inheritDoc}
         */
        @Override
        public String translateConstructor(Class owner, String desc, Class[] types, List<Operand> context) {
            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            throw new Error();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String translateMethod(Class owner, String name, String desc, Class[] types, List<Operand> context) {
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
        public String translateStaticMethod(Class owner, String name, String desc, Class[] types, List<Operand> context) {
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
        public String translateStaticField(Class owner, String fieldName, boolean isNotStatic) {
            return fieldName;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String translateSuperMethod(Class owner, String name, String desc, Class[] types, List<Operand> context) {
            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            throw new Error();
        }
    }
}
