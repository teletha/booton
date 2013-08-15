/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import js.lang.Function;
import kiss.I;
import kiss.Manageable;
import kiss.Singleton;
import kiss.Table;
import kiss.model.ClassUtil;

import org.objectweb.asm.Type;

/**
 * @version 2013/08/15 16:10:55
 */
class TranslatorManager {

    /** The native classes. */
    private static final Set<Class> natives = new HashSet();

    /** The native fields. */
    private static final Map<Class, Set<String>> nativeFields = new ConcurrentHashMap();

    /** The native methods. */
    private static final Table<Integer, Class> nativeMethods = new Table();

    /** The native accessor methods. */
    private static final Table<Integer, Class> nativeAccessorMethods = new Table();

    /** The native accessor methods. */
    private static final Map<Integer, String> nativeAccessorMethodNames = new HashMap();

    static {
        // built-in native class.
        builtIn(Object.class);
        builtIn(Comparator.class);
        builtIn(Runnable.class);
    }

    /**
     * <p>
     * Register the given class as native.
     * </p>
     * 
     * @param type
     */
    private static void builtIn(Class type) {
        for (Method method : type.getDeclaredMethods()) {
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
        if (natives.add(nativeClass)) {
            for (Class type : ClassUtil.getTypes(nativeClass)) {
                for (Class interfaceType : type.getInterfaces()) {
                    if (interfaceType == JavascriptNative.class) {
                        // The current class implements it directly.
                        for (Method method : type.getDeclaredMethods()) {
                            // Methods defined in interface are as native.
                            // Methods defined in class are as native if these have native modifier.
                            if (type.isInterface() || Modifier.isNative(method.getModifiers()) || method.isAnnotationPresent(JavascriptNativeProperty.class)) {
                                nativeMethods.push(hash(method.getName(), Type.getMethodDescriptor(method)), nativeClass);
                            }

                            JavascriptNativePropertyAccessor accessor = method.getAnnotation(JavascriptNativePropertyAccessor.class);

                            if (accessor != null) {
                                Integer hash = hash(method.getName(), Type.getMethodDescriptor(method));
                                String name = accessor.value();

                                if (name.length() == 0) {
                                    name = method.getName();
                                }
                                nativeAccessorMethods.push(hash, type);
                                nativeAccessorMethodNames.put(hash, name);
                            }
                        }

                        Set<String> set = new HashSet();

                        for (Field field : type.getDeclaredFields()) {
                            if (field.isAnnotationPresent(JavascriptNativeProperty.class)) {
                                set.add(field.getName());
                            }
                        }
                        nativeFields.put(type, set);
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
        if (JavascriptNative.class.isAssignableFrom(type)) {
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
    private static String getNativeAccessor(Class owner, String name, String description) {
        Integer hash = hash(name, description);
        List<Class> classes = nativeAccessorMethods.get(hash);

        for (Class clazz : classes) {
            if (clazz.isAssignableFrom(owner)) {
                return nativeAccessorMethodNames.get(hash);
            }
        }
        return null;
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
     * <p>
     * Detect this is {@link Serializable} related method or not.
     * </p>
     * 
     * @param method A method to test.
     * @return A result.
     */
    static boolean isSerializerMethod(Method method) {
        return isSerializerMethod(method.getName(), Type.getMethodDescriptor(method));
    }

    /**
     * <p>
     * Detect this is {@link Serializable} related method or not.
     * </p>
     * 
     * @param name A method name.
     * @param description A method signature.
     * @return A result.
     */
    static boolean isSerializerMethod(String name, String description) {
        if (name.equals("writeObject") && description.equals("(Ljava/io/ObjectOutputStream;)V")) {
            return true;
        }

        if (name.equals("readObject") && description.equals("(Ljava/io/ObjectInputStream;)V")) {
            return true;
        }
        return false;
    }

    /**
     * @version 2013/01/19 23:52:14
     */
    @Manageable(lifestyle = Singleton.class)
    private static class GeneralTranslator extends Translator<Object> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected String translateConstructor(Class owner, String desc, Class[] types, List<Operand> context) {
            // append identifier of constructor method
            Operand id;

            Method functional = findFunctionMethod(owner);

            if (functional == null) {
                id = new OperandNumber(Integer.valueOf(Javascript.computeMethodName(owner, "<init>", desc).substring(1)));
            } else {
                id = new OperandString(Javascript.computeMethodName(functional));
            }
            context.add(id);

            return "new " + Javascript.computeClassName(owner) + writeParameter(types, context);
        }

        /**
         * <p>
         * Search single function method.
         * </p>
         * 
         * @param clazz
         * @return
         */
        private Method findFunctionMethod(Class clazz) {
            if (Function.class.isAssignableFrom(clazz)) {
                for (Class type : ClassUtil.getTypes(clazz)) {
                    Method method = getFunctionMethod(type);

                    if (method != null) {
                        return method;
                    }
                }
            }
            return null;
        }

        /**
         * <p>
         * Check whether the specified class implements {@link Function} directly or not.
         * </p>
         * 
         * @param clazz A target class to check.
         * @return A result.
         */
        private Method getFunctionMethod(Class clazz) {
            for (Class type : clazz.getInterfaces()) {
                if (type == Function.class) {
                    List<Method> userDefined = new ArrayList();
                    Method[] methods = clazz.getDeclaredMethods();

                    for (Method method : methods) {
                        if (!method.isSynthetic() && !method.isBridge()) {
                            userDefined.add(method);
                        }
                    }
                    return userDefined.size() == 1 ? userDefined.get(0) : null;
                }
            }
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected String translateMethod(Class owner, String name, String desc, Class[] types, List<Operand> context) {
            String accessor = getNativeAccessor(owner, name, desc);

            if (accessor != null) {
                if (types.length == 0) {
                    // getter
                    return context.get(0) + "." + accessor;
                } else {
                    // setter
                    return context.get(0) + "." + accessor + "=" + writeParameter(types, context, false);
                }
            }
            return context.get(0) + "." + Javascript.computeMethodName(owner, name, desc) + writeParameter(types, context);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected String translateStaticMethod(Class owner, String name, String desc, Class[] types, List<Operand> context) {
            return context.get(0) + "." + Javascript.computeMethodName(owner, name, desc) + writeParameter(types, context);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected String translateSuperMethod(Class owner, String name, String desc, Class[] types, List<Operand> context) {
            // append context 'this' of super method
            context.add(1, new OperandExpression("this"));

            return Javascript.computeClassName(owner) + ".prototype." + Javascript.computeMethodName(owner, name, desc) + ".call" + writeParameter(types, context);
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
        private static String writeParameter(Class[] types, List<Operand> operands) {
            return writeParameter(types, operands, true);
        }

        /**
         * Helper method to write parameter expression.
         * 
         * @param operands
         * @return
         */
        private static String writeParameter(Class[] types, List<Operand> operands, boolean useBracket) {
            StringBuilder builder = new StringBuilder();
            if (useBracket) builder.append('(');

            for (int i = 1; i < operands.size(); i++) {
                if (i - 1 < types.length) {
                    Class type = types[i - 1];

                    if (type == boolean.class) {
                        Operand operand = operands.get(i);

                        if (operand instanceof OperandNumber) {
                            OperandNumber number = (OperandNumber) operand;

                            if (number.value.intValue() == 0) {
                                operands.set(i, new OperandExpression(false));
                            } else {
                                operands.set(i, new OperandExpression(true));
                            }
                        }
                    } else if (type == char.class) {
                        operands.set(i, operands.get(i).cast(char.class));
                    }
                }

                builder.append(operands.get(i).disclose());

                if (i + 1 != operands.size()) {
                    builder.append(',');
                }
            }
            if (useBracket) builder.append(')');

            return builder.toString();
        }
    }
}
