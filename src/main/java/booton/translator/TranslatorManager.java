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

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import js.dom.DOMTokenList;
import js.dom.Location;
import js.dom.Window;
import js.lang.Function;
import js.net.WebSocket;
import js.util.ArrayList;
import js.util.jQuery.Listener;
import kiss.I;
import kiss.Manageable;
import kiss.Singleton;
import kiss.Table;
import kiss.model.ClassUtil;

import org.objectweb.asm.Type;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @version 2013/04/13 12:41:47
 */
class TranslatorManager {

    /** The native fields. */
    private static final Map<Class, Set<String>> nativeFields = new ConcurrentHashMap();

    /** The native methods. */
    private static final Table<Integer, Class> nativeMethods = new Table();

    static {
        // built-in native class.
        builtIn(Object.class);
        builtIn(Node.class);
        builtIn(Document.class);
        builtIn(Element.class);
        builtIn(DOMTokenList.class);
        builtIn(WebSocket.class);
        builtIn(Window.class);
        builtIn(Location.class);
        builtIn(Comparator.class);
        builtIn(Runnable.class);
        builtIn(Listener.class);
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

        Set<String> set = new HashSet();

        for (Field field : type.getFields()) {
            set.add(field.getName());
        }
        nativeFields.put(type, set);
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
                        // Methods defined in interface are as native.
                        // Methods defined in class are as native if these have native modifier.
                        if (type.isInterface() || Modifier.isNative(method.getModifiers())) {
                            nativeMethods.push(hash(method.getName(), Type.getMethodDescriptor(method)), nativeClass);
                        }
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
     * @version 2013/01/19 23:52:14
     */
    @Manageable(lifestyle = Singleton.class)
    private static class GeneralTranslator extends Translator<GeneralTranslator> {

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
            return context.get(0) + "." + Javascript.computeMethodName(owner, name, desc) + writeParameter(types, context);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected String translateStaticMethod(Class owner, String name, String desc, Class[] types, List<Operand> context) {
            search(owner, name, types);

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
            StringBuilder builder = new StringBuilder();
            builder.append('(');

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
                    }
                }

                builder.append(operands.get(i));

                if (i + 1 != operands.size()) {
                    builder.append(',');
                }
            }
            builder.append(')');

            return builder.toString();
        }

        /**
         * <p>
         * Search js native method's existence.
         * </p>
         * 
         * @param methodName A method name.
         * @param parameterTypes A method parameters.
         * @return A result.
         */
        private void search(Class classJava, String methodName, Class[] parameterTypes) {
            Class classJS = Javascript.getCompilableClass(classJava);

            if (!classJS.isAnnotationPresent(JavaNative.class) || TranslatorManager.hasTranslator(classJS)) {
                return;
            }

            try {
                Method methodJava = classJava.getDeclaredMethod(methodName, parameterTypes);

                if (Modifier.isNative(methodJava.getModifiers())) {
                    return;
                }

                try {
                    Method methodJS = classJS.getDeclaredMethod(methodName, parameterTypes);
                    Class returnJava = methodJava.getReturnType();
                    Class returnJS = methodJS.getReturnType();

                    if (Javascript.getCompilableClass(returnJava) != returnJS && returnJava != returnJS) {
                        TranslationError error = new TranslationError();
                        error.write("Your defined method has incorrect return type. [", methodJS, "]");
                        error.write("Define a method like the following:");
                        error.writeMethodWithoutBody(methodJava);

                        throw error;
                    }
                } catch (NoSuchMethodException e) {
                    TranslationError error = new TranslationError();
                    error.write("You must define a method at ", classJS.getName(), ".");
                    error.writeMethodWithoutBody(methodJava);

                    throw error;
                }
            } catch (NoSuchMethodException e) {
                // If this exception will be thrown, it is bug of this program. So we must rethrow
                // the wrapped error in here.
                throw I.quiet(e);
            }
        }
    }
}
