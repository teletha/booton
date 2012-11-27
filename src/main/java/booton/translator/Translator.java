/*
 * Copyright (C) 2009 Nameless Production Committee.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
 * @version 2009/08/08 10:48:22
 */
@Manageable(lifestyle = Singleton.class)
public class Translator<T> {

    protected static final String Q = "\"";

    /** The current processing method expression. */
    protected String that;

    private List<Operand> context;

    private Class[] types;

    /**
     * <p>
     * Translate the specified method to the javascript expression.
     * </p>
     * 
     * @param name
     * @param types
     * @param context
     * @return
     */
    String translateMethod(Class owner, String name, String desc, Class[] types, List<Operand> context) {
        try {
            return translateMethodCall(name, types, context);
        } catch (NoSuchMethodException e) {
            return context.get(0) + "." + Javascript.computeMethodName(owner, name, desc) + build(context);
        }
    }

    /**
     * <p>
     * Translate the specified method to the javascript expression.
     * </p>
     * 
     * @param name
     * @param types
     * @param context
     * @return
     */
    String translateStaticMethod(Class owner, String name, String desc, Class[] types, List<Operand> context) {
        try {
            return translateMethodCall(name, types, context);
        } catch (NoSuchMethodException e) {
            return context.get(0) + "." + Javascript.computeMethodName(owner, name, desc) + build(context);
        }
    }

    /**
     * <p>
     * Translate the specified method to the javascript expression.
     * </p>
     * 
     * @param name
     * @param types
     * @param context
     * @return
     */
    String translateConstructor(Class owner, String desc, Class[] types, List<Operand> context) {
        try {
            return translateMethodCall(owner.getSimpleName(), types, context);
        } catch (NoSuchMethodException e) {
            // append identifier of constructor method
            context.add(new OperandNumber(Integer.valueOf(Javascript.computeMethodName(owner, "<init>", desc)
                    .substring(1))));

            return "new " + Javascript.computeClassName(owner) + build(context);
        }
    }

    /**
     * <p>
     * Translate the specified method to the javascript expression.
     * </p>
     * 
     * @param name
     * @param types
     * @param context
     * @return
     */
    String translateSuperMethod(Class owner, String methodName, String desc, Class[] types, List<Operand> context) {
        try {
            return translateMethodCall(owner.getSimpleName(), types, context);
        } catch (NoSuchMethodException e) {
            // append context 'this' of super method
            context.add(1, new OperandExpression("this"));

            return Javascript.computeClassName(owner) + ".prototype." + Javascript.computeMethodName(owner, methodName, desc) + ".call" + build(context);
        }
    }

    String translateStaticField(Class owner, String fieldName, boolean isNotStatic) {
        try {
            return translatefieldAccess(fieldName);
        } catch (NoSuchFieldException e) {
            return (isNotStatic ? Javascript.computeClassName(owner) : "this") + "." + fieldName;
        }
    }

    private String translatefieldAccess(String fieldName) throws NoSuchFieldException {
        Field field = getClass().getDeclaredField(fieldName);

        if (field.isSynthetic() || field.getType() != String.class) {
            throw new NoSuchFieldException();
        }

        try {
            return (String) field.get(this);
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
     * @throws NoSuchMethodException A suitable translation method is not found.
     */
    private String translateMethodCall(String methodName, Class[] types, List<Operand> context)
            throws NoSuchMethodException {
        // search translation method
        Method method = getClass().getDeclaredMethod(methodName, types);

        if (method.isBridge() || method.isSynthetic() || !Modifier.isPublic(method.getModifiers()) || method.getReturnType() != String.class) {
            throw new NoSuchMethodException();
        }

        // translate special method invocation
        this.types = types;
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
                dummy[i] = 0;
                break;

            default:
                dummy[i] = null;
            }
        }

        try {
            return (String) method.invoke(this, dummy);
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
     * Helper method to build parameter expression.
     * 
     * @param operands
     * @return
     */
    private String build(List<Operand> operands) {
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
}
