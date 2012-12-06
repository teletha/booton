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

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import kiss.ClassListener;
import kiss.I;
import kiss.Manageable;
import kiss.Singleton;
import kiss.model.ClassUtil;

import org.objectweb.asm.Type;

/**
 * @version 2012/12/02 16:11:18
 */
@Manageable(lifestyle = Singleton.class)
class TranslatorManager implements ClassListener<JavascriptNative> {

    /** The native classes. */
    private static final Map<Class, JavascriptNativeClassTranslator> natives = new ConcurrentHashMap();

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
        if (type == Object.class) {
            return I.make(ObjectTranslator.class);
        }

        // search user defined translator
        Translator translator = I.find(Translator.class, type);

        if (translator != null) {
            return translator;
        }

        if (JavascriptNative.class.isAssignableFrom(type)) {
            translator = natives.get(type);

            if (translator == null) {
                translator = new JavascriptNativeClassTranslator(type);
                natives.put(type, (JavascriptNativeClassTranslator) translator);
            }
            return translator;
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
     * @return
     */
    static boolean isNative(Class owner, String name, String description) {
        JavascriptNativeClassTranslator translator = natives.get(owner);

        if (translator == null) {
            return false;
        } else {
            return translator.natives.contains(JavascriptNativeClassTranslator.hash(name, description));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(Class clazz) {
        System.out.println(clazz);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void unload(Class clazz) {
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
        protected String translateConstructor(Class owner, String desc, Class[] types, List context) {
            // append identifier of constructor method
            context.add(new OperandNumber(Integer.valueOf(Javascript.computeMethodName(owner, "<init>", desc)
                    .substring(1))));

            return "new " + Javascript.computeClassName(owner) + writeParameter(context);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected String translateMethod(Class owner, String name, String desc, Class[] types, List context) {
            return context.get(0) + "." + Javascript.computeMethodName(owner, name, desc) + writeParameter(context);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected String translateStaticMethod(Class owner, String name, String desc, Class[] types, List context) {
            return context.get(0) + "." + Javascript.computeMethodName(owner, name, desc) + writeParameter(context);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected String translateSuperMethod(Class owner, String name, String desc, Class[] types, List context) {
            // append context 'this' of super method
            context.add(1, new OperandExpression("this"));

            return Javascript.computeClassName(owner) + ".prototype." + Javascript.computeMethodName(owner, name, desc) + ".call" + writeParameter(context);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected String translateStaticField(Class owner, String fieldName, boolean isNotStatic) {
            return (isNotStatic ? Javascript.computeClassName(owner) : "this") + "." + fieldName;
        }
    }

    /**
     * @version 2012/12/02 16:34:06
     */
    @Manageable(lifestyle = Singleton.class)
    private static class JavascriptNativeClassTranslator extends Translator<JavascriptNativeClassTranslator> {

        /** The fingerprint for native methods. */
        private final Set<Integer> natives = new HashSet();

        /**
         * @param type
         */
        private JavascriptNativeClassTranslator(Class clazz) {
            for (Class type : ClassUtil.getTypes(clazz)) {
                for (Class interfaceType : type.getInterfaces()) {
                    if (interfaceType == JavascriptNative.class) {
                        // The current class implements it directly.
                        for (Method method : type.getDeclaredMethods()) {
                            natives.add(hash(method.getName(), Type.getMethodDescriptor(method)));
                        }
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
         * Helper method to write method call.
         * </p>
         * 
         * @param name A method name.
         * @param types A method parameter types.
         * @param context A current oeprand stack.
         * @param isStatic Flag.
         * @return
         */
        private static String write(String name, Class[] types, List<Operand> context, boolean isStatic) {
            StringBuilder builder = new StringBuilder();
            if (!isStatic) builder.append(context.get(0).toString()).append('.');
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
            if (natives.contains(hash(name, desc))) {
                return write(name, types, context, false);
            } else {
                return super.translateMethod(owner, name, desc, types, context);
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected String translateStaticMethod(Class owner, String name, String desc, Class[] types, List<Operand> context) {
            if (natives.contains(hash(name, desc))) {
                return write(name, types, context, true);
            } else {
                return super.translateMethod(owner, name, desc, types, context);
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected String translateSuperMethod(Class owner, String name, String desc, Class[] types, List<Operand> context) {
            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            throw new Error();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected Object translateField(Class ownerClass, String name, Operand context) {
            return context + "." + name;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected String translateStaticField(Class owner, String fieldName, boolean isNotStatic) {
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
        protected String translateMethod(Class owner, String name, String description, Class[] types, List<Operand> context) {
            switch (name) {
            case "equals":
                return context.get(0) + ".equals(" + context.get(1) + ")";

            case "getClass":
                return "this";

            case "hashCode":
                return context.get(0) + ".hashCode()";

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
