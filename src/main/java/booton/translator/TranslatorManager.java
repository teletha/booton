/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import jdk.internal.org.objectweb.asm.Type;
import kiss.I;
import kiss.Manageable;
import kiss.Singleton;
import kiss.Table;

/**
 * @version 2013/11/22 13:19:38
 */
class TranslatorManager {

    /** The ignorable classes. */
    private static final Set<String> ignorables = new HashSet();

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
        ignorables.add(Type.getDescriptor(Path.class));
        ignorables.add(Type.getDescriptor(Reader.class));
        ignorables.add(Type.getDescriptor(Writer.class));

        // nativeMethods.push(hash("toString", "()Ljava/lang/String;"), Object.class);
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
            for (Class type : I.collectTypes(nativeClass)) {
                for (Class interfaceType : type.getInterfaces()) {
                    if (interfaceType == JavascriptNative.class) {
                        // The current class implements it directly.
                        for (Method method : type.getDeclaredMethods()) {
                            // Methods defined in interface are as native.
                            // Methods defined in class are as native if these have native modifier.
                            if (type.isInterface() || Modifier.isNative(method.getModifiers()) || method
                                    .isAnnotationPresent(JavascriptNativeProperty.class)) {
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
        if (JavascriptNative.class.isAssignableFrom(owner)) {
            register(owner);
        }

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
    static boolean isIgnorableMethod(Method method) {
        return isIgnorableMethod(method.getName(), Type.getMethodDescriptor(method));
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
    static boolean isIgnorableMethod(String name, String description) {
        // serialization
        if (name.equals("writeObject") && description.equals("(Ljava/io/ObjectOutputStream;)V")) {
            return true;
        } else if (name.equals("writeExternal") && description.equals("(Ljava/io/ObjectOutput;)V")) {
            return true;
        } else if (name.equals("writeReplace") && description.equals("()Ljava/lang/Object;")) {
            return true;
        } else if (name.equals("readObject") && description.equals("(Ljava/io/ObjectInputStream;)V")) {
            return true;
        } else if (name.equals("readExternal") && description.equals("(Ljava/io/ObjectInput;)V")) {
            return true;
        } else if ((name.equals("readObjectNoData") || name.equals("readResolve")) && description.equals("()V")) {
            return true;
        }

        if (name.equals("$deserializeLambda$") && description.equals("(Ljava/lang/invoke/SerializedLambda;)Ljava/lang/Object;")) {
            return true;
        }

        for (String type : ignorables) {
            if (description.contains(type)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @version 2013/08/27 23:26:48
     */
    @Manageable(lifestyle = Singleton.class)
    private static class GeneralTranslator extends Translator<Object> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected String translateConstructor(Class owner, String desc, Class[] types, List<Operand> context) {
            // append identifier of constructor method
            context.add(new OperandNumber(Integer.valueOf(Javascript.computeMethodName(owner, "<init>", desc).substring(1))));

            return "new " + Javascript.computeClassName(owner) + writeParameter(types, context);
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

            return Javascript.computeClassName(owner) + ".prototype." + Javascript
                    .computeMethodName(owner, name, desc) + ".call" + writeParameter(types, context);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected String translateField(Class ownerClass, String name, Operand context) {
            return context + "." + Javascript.computeFieldName(ownerClass, name);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected String translateStaticField(Class owner, String fieldName) {
            try {
                owner.getDeclaredField(fieldName);
                return Javascript.computeClassName(owner, true) + "." + Javascript.computeFieldName(owner, fieldName);
            } catch (NoSuchFieldException e) {
                return translateStaticField(owner.getSuperclass(), fieldName);
            }
        }
    }
}
