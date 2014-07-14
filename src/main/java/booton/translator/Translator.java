/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import static booton.translator.Javascript.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import jdk.internal.org.objectweb.asm.Type;
import js.lang.NativeFunction;
import kiss.Extensible;
import kiss.Manageable;
import kiss.Singleton;
import kiss.model.ClassUtil;

/**
 * <p>
 * Public {@link Translator} API.
 * </p>
 * 
 * @version 2014/05/26 16:51:05
 */
@Manageable(lifestyle = Singleton.class)
public class Translator<T> implements Extensible {

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
        return search(owner.getSimpleName(), description, types).write(context);
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
        return search(name, description, types).write(context);
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
        return search(name, description, types).write(context);
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
        return search(owner.getSimpleName(), description, types).write(context);
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
        return writeFieldAccess(name);
    }

    /**
     * <p>
     * Translate a static field access invocation.
     * </p>
     * 
     * @param ownerClass A field owner.
     * @param name A field name.
     * @return A translated expression.
     */
    String translateStaticField(Class owner, String name) {
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
     * @param description A method description.
     * @param parameterTypes A method parameters.
     * @return A result.
     */
    private Writer search(String methodName, String description, Class[] parameterTypes) {
        Class translator = getClass();

        if (translator == Translator.class) {
            return null; // use generic translator
        }

        try {
            Method method = getClass().getMethod(methodName, parameterTypes);

            if (method.getDeclaringClass() == Object.class) {
                throw new NoSuchMethodException();
            }

            // ===============================
            // Validation
            // ===============================
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

            return new CodeWriter(this, method);
        } catch (NoSuchMethodException e) {
            // Find translation class.
            Class type = ClassUtil.getParameter(getClass(), Translator.class)[0];

            // Search JavaAPIProvider.
            if (JavaAPIProviders.hasProvider(type)) {
                // Validate API
                JavaAPIProviders.validateMethod(type, methodName, description);

                // Use API provider.
                Class provider = JavaAPIProviders.convert(type);

                Javascript.require(provider);

                return new NativeWriter(provider, methodName, description, parameterTypes);
            }

            // Search translator of parent type
            Class parant = type.getSuperclass();

            if (parant != null && parant != Object.class) {
                Translator parentTranslator = TranslatorManager.getTranslator(parant);

                if (parameterTypes != null) {
                    return parentTranslator.search(methodName, description, parameterTypes);
                }
            }

            // There is no way to translate.
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
     * Helper method to write the specified parameter as expression.
     * 
     * @param index A index of parameters.
     * @return
     */
    protected final String param(int index) {
        return getOperand(index).toString();
    }

    /**
     * Helper method to write the specified parameter as Regular Expression literal.
     * 
     * @param index A index of parameters.
     * @return
     */
    protected final String regex(int index) {
        return regex(index, null);
    }

    /**
     * Helper method to infer type of the specified parameter.
     * 
     * @param index A index of parameters.
     * @return
     */
    protected final Class type(int index) {
        Class type = types[index];

        if (type != Object.class) {
            return type;
        } else {
            return getOperand(index).infer().type();
        }
    }

    /**
     * Helper method to create binded function of the specified parameter.
     * 
     * @param index A index of parameters.
     * @return
     */
    protected final String function(int index) {
        return "boot.bind(\"" + computeMethodName(NativeFunction.findSAM(type(index))) + "\"," + param(index) + ")";
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
        return "new RegExp(" + getOperand(index) + ",\"" + options + "\")";
    }

    /**
     * Helper method to convert to 64bit primitive long.
     * 
     * @param value
     * @return
     */
    protected final String long64(String value) {
        return writeMethodCode(PrimitiveLong, "fromNumber", double.class, value);
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

    /**
     * Helper method to write parameter expression.
     * 
     * @param operands
     * @return
     */
    static String writeParameter(Class[] types, List<Operand> operands) {
        return writeParameter(types, operands, true);
    }

    /**
     * Helper method to write parameter expression.
     * 
     * @param operands
     * @return
     */
    static String writeParameter(Class[] types, List<Operand> operands, boolean useBracket) {
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

    /**
     * @version 2013/08/16 23:33:50
     */
    private static interface Writer {

        /**
         * <p>
         * Translate the specified method invocation (include constructor call) to the user defined
         * javascript expression. If the suitable translation method is not found,
         * {@link NoSuchMethodException} will be thrown.
         * </p>
         * 
         * @param context A current processing operands for the specified method.
         * @return A javascript expression.
         */
        String write(List<Operand> context);
    }

    /**
     * @version 2013/09/07 2:07:07
     */
    private static class CodeWriter implements Writer {

        /** The code translator. */
        private final Translator translator;

        /** The code translation method. */
        private final Method method;

        /**
         * @param translator
         * @param method
         */
        private CodeWriter(Translator translator, Method method) {
            this.translator = translator;
            this.method = method;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String write(List<Operand> context) {
            // translate special method invocation
            translator.types = method.getParameterTypes();
            translator.context = context;
            translator.that = context.get(0).toString();

            // build dummy parameters
            Object[] dummy = new Object[translator.types.length];

            for (int i = 0; i < dummy.length; i++) {
                switch (Type.getType(translator.types[i]).getSort()) {
                case Type.CHAR:
                    dummy[i] = ' ';
                    break;

                case Type.INT:
                case Type.LONG:
                case Type.FLOAT:
                case Type.DOUBLE:
                    dummy[i] = 0;
                    break;

                case Type.SHORT:
                    dummy[i] = (short) 0;
                    break;

                case Type.BYTE:
                    dummy[i] = (byte) 0;
                    break;

                case Type.BOOLEAN:
                    dummy[i] = true;
                    break;

                default:
                    dummy[i] = null;
                }
            }

            try {
                return (String) method.invoke(translator, dummy);
            } catch (Exception e) {
                // If this exception will be thrown, it is bug of this program. So we must rethrow
                // the wrapped error in here.
                throw new Error(e);
            } finally {
                // clear context data
                translator.types = null;
                translator.context = null;
                translator.that = null;
            }
        }
    }

    /**
     * @version 2013/08/16 23:32:09
     */
    private static class NativeWriter implements Writer {

        /** The method owner. */
        private final Class owner;

        /** The method name. */
        private final String name;

        /** The method description. */
        private final String description;

        /** The parameter types. */
        private final Class[] parameters;

        /**
         * @param owner
         * @param name
         * @param description
         * @param parameters
         */
        private NativeWriter(Class owner, String name, String description, Class[] parameters) {
            this.owner = owner;
            this.name = name;
            this.description = description;
            this.parameters = parameters;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String write(List<Operand> context) {
            return context.get(0) + "." + Javascript.computeMethodName(owner, name, description) + writeParameter(parameters, context);
        }
    }
}