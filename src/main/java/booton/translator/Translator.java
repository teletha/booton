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
import java.lang.reflect.Modifier;
import java.util.List;

import kiss.Manageable;
import kiss.Singleton;

import org.objectweb.asm.Type;

/**
 * <p>
 * Public {@link Translator} API.
 * </p>
 * 
 * @version 2012/12/02 16:41:59
 */
@Manageable(lifestyle = Singleton.class)
public class Translator<T> {

    /** The quote literal. */
    protected static final String Q = "\"";

    /** The current processing method expression. */
    protected String that;

    /** The current processing method context stack. */
    private List<Operand> context;

    /** The current processing method paramter types. */
    private Class[] types;

    /**
     * <p>
     * Translate a constructor invocation to javascript expression.
     * </p>
     * 
     * @param owner A constructor owner.
     * @param description A constructor description.
     * @param types A constructor parameter types.
     * @param context A operand stacks.
     * @return A translated expression.
     */
    String translateConstructor(Class owner, String description, Class[] types, List<Operand> context) {
        return write(search(owner.getSimpleName(), types), context);
    }

    /**
     * <p>
     * Translate a method invocation to javascript expression.
     * </p>
     * 
     * @param owner A method owner.
     * @param name A method name.
     * @param description A method description.
     * @param types A method parameter types.
     * @param context A operand stacks.
     * @return A translated expression.
     */
    String translateMethod(Class owner, String name, String description, Class[] types, List<Operand> context) {
        if (name.equals("equals") && description.equals("(Ljava/lang/Object;)Z")) {
            return context.get(0) + ".equals(" + context.get(1) + ")";
        }
        return write(search(name, types), context);
    }

    /**
     * <p>
     * Translate a static method invocation to javascript expression.
     * </p>
     * 
     * @param owner A method owner.
     * @param name A method name.
     * @param description A method description.
     * @param types A method parameter types.
     * @param context A operand stacks.
     * @return A translated expression.
     */
    String translateStaticMethod(Class owner, String name, String description, Class[] types, List<Operand> context) {
        return write(search(name, types), context);
    }

    /**
     * <p>
     * Translate a super method invocation to javascript expression.
     * </p>
     * 
     * @param owner A method owner.
     * @param name A method name.
     * @param description A method description.
     * @param types A method parameter types.
     * @param context A operand stacks.
     * @return A translated expression.
     */
    String translateSuperMethod(Class owner, String name, String description, Class[] types, List<Operand> context) {
        return write(search(owner.getSimpleName(), types), context);
    }

    /**
     * <p>
     * Translate a field access invocation.
     * </p>
     * 
     * @param ownerClass A field owner.
     * @param name A field name.
     * @param context A operand stack.
     * @return A translated expression.
     */
    Object translateField(Class ownerClass, String name, Operand context) {
        return context + "." + Javascript.computeFieldName(ownerClass, name);
    }

    /**
     * <p>
     * Translate a static field access invocation.
     * </p>
     * 
     * @param ownerClass A field owner.
     * @param name A field name.
     * @param isNotStatic A operand stack.
     * @return A translated expression.
     */
    String translateStaticField(Class owner, String name, boolean isNotStatic) {
        return writeFieldAccess(name);
    }

    /**
     * <p>
     * Translate the specified field invocation.
     * </p>
     * 
     * @param fieldName
     * @return
     */
    private String writeFieldAccess(String fieldName) {
        try {
            Field field = getClass().getDeclaredField(fieldName);

            if (field.isSynthetic() || field.getType() != String.class) {
                throw new Error();
            }

            field.setAccessible(true);

            return (String) field.get(this);
        } catch (Exception e) {
            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            throw new Error(e);
        }
    }

    /**
     * <p>
     * Search translator method's existence.
     * </p>
     * 
     * @param methodName A method name.
     * @param parameterTypes A method parameters.
     * @return A result.
     */
    private Method search(String methodName, Class[] parameterTypes) {
        Class translator = getClass();

        if (translator == Translator.class) {
            return null; // use generic translator
        }

        try {
            Method method = getClass().getMethod(methodName, parameterTypes);

            // ===============================
            // Validation
            // ===============================
            // if (method.isBridge() || method.isSynthetic()) {
            // TranslationError error = new TranslationError();
            // System.out.println(method.isBridge());
            // error.write("Translation method is system defined. [", translator.getName(), "]");
            // error.writeMethod(method);
            //
            // throw error;
            // }

            if (!Modifier.isPublic(method.getModifiers())) {
                TranslationError error = new TranslationError();
                error.write("Translation method must be public. [", translator.getName(), "]");
                error.writeMethod(method);

                throw error;
            }

            if (method.getReturnType() != String.class) {
                TranslationError error = new TranslationError();
                error.write("Translation method must return String type. [", translator.getName(), "]");
                error.writeMethod(method);

                throw error;
            }

            // make accesible
            method.setAccessible(true);

            return method;
        } catch (NoSuchMethodException e) {
            TranslationError error = new TranslationError();
            error.write("You must define a translator method at ", translator.getName(), ".");
            error.writeMethod(Modifier.PUBLIC, methodName, String.class, parameterTypes);

            throw error;
        } catch (Exception e) {
            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            throw new Error(e);
        }
    }

    /**
     * <p>
     * Translate the specified method invocation (include constructor call) to the user defined
     * javascript expression. If the suitable translation method is not found,
     * {@link NoSuchMethodException} will be thrown.
     * </p>
     * 
     * @param methodName A method name that byte code want to invoke.
     * @param types A prameter types of the specified method.
     * @param context A current processing operands for the specified method.
     * @return A javascript expression.
     */
    private String write(Method translator, List<Operand> context) {
        // translate special method invocation
        this.types = translator.getParameterTypes();
        this.context = context;
        this.that = context.get(0).toString();

        // build dummy parameters
        Object[] dummy = new Object[types.length];

        for (int i = 0; i < dummy.length; i++) {
            switch (Type.getType(types[i]).getSort()) {
            case Type.CHAR:
                dummy[i] = ' ';
                break;

            case Type.INT:
            case Type.LONG:
            case Type.FLOAT:
            case Type.DOUBLE:
            case Type.SHORT:
            case Type.BYTE:
                dummy[i] = 0;
                break;

            case Type.BOOLEAN:
                dummy[i] = true;
                break;

            default:
                dummy[i] = null;
            }
        }

        try {
            return (String) translator.invoke(this, dummy);
        } catch (Exception e) {
            // If this exception will be thrown, it is bug of this program. So we must rethrow
            // the wrapped error in here.
            throw new Error(e);
        } finally {
            // clear context data
            this.types = null;
            this.context = null;
            this.that = null;
        }
    }

    /**
     * Helper method to write the specified parameter as expression.
     * 
     * @param index
     * @return
     */
    protected final String param(int index) {
        return getOperand(index).toString();
    }

    /**
     * Helper method to write the specified parameter as Regular Expression literal.
     * 
     * @param index
     * @return
     */
    protected final String regex(int index) {
        return regex(index, null);
    }

    /**
     * Helper method to write the specified parameter as Regular Expression literal.
     * 
     * @param index
     * @return
     */
    protected final String regex(int index, String options) {
        // normalize options expression
        if (options == null) {
            options = "";
        }

        Operand regex = getOperand(index);

        if (regex instanceof OperandString) {
            return "/" + ((OperandString) regex).expression + "/" + options;
        } else {
            return "new RegExp(" + regex + ",\"" + options + "\")";
        }
    }

    /**
     * Helper method to write the specified parameter as expression.
     * 
     * @param index
     * @return
     */
    private Operand getOperand(int index) {
        return context.get(index + 1).cast(types[index]);
    }
}