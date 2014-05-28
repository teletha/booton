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

import static jdk.internal.org.objectweb.asm.Opcodes.*;
import static jdk.internal.org.objectweb.asm.Type.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jdk.internal.org.objectweb.asm.Label;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;
import kiss.I;
import booton.Obfuscator;

/**
 * @version 2014/05/27 15:45:59
 */
class JavaMethodStackableCompiler extends MethodVisitor {

    /** The variable name for stack. */
    private static final String stack = "_";

    /** The variable name for label. */
    private static final String jump = "$";

    /** The variable name for stack. */
    private static final String local = "L";

    /** The java source(byte) code. */
    private final Javascript script;

    /** The javascript object code. */
    private final ScriptWriter code;

    /** The current processing method name. */
    private final String methodName;

    /** The method return type. */
    private final Type returnType;

    /** The method return type. */
    private final Type[] parameterTypes;

    /** The local variable manager. */
    private final LocalVariables variables;

    /** The label counter. */
    private int counter = 0;

    /** The stack index. */
    private int index = 0;

    /**
     * @param script
     * @param code
     * @param name
     * @param computed
     * @param desc
     */
    JavaMethodStackableCompiler(Javascript script, ScriptWriter code, String name, String computed, String description, boolean isStatic) {
        super(ASM5);

        this.script = script;
        this.code = code;
        this.methodName = name;
        this.returnType = Type.getReturnType(description);
        this.parameterTypes = Type.getArgumentTypes(description);
        this.variables = new LocalVariables(Type.getArgumentTypes(description).length, isStatic);

        Type[] parameters = Type.getArgumentTypes(description);

        if (!isStatic) {
            variables.type(0).type(script.source);
        }

        for (int i = 0; i < parameters.length; i++) {
            variables.type(isStatic ? i : i + 1).type(convert(parameters[i]));
        }

        // write method declaration
        code.mark();
        code.append(computed, ":", "function(", I.join(",", variables.names()), "){");
        code.append("var ", stack, "=", "[],", local, "=", "[", isStatic ? "" : "this", "],", jump, "=", "0;");
        code.write("while", "(true)", "{");
        code.write("switch(", jump, ")", "{");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitEnd() {
        code.append("}");
        code.append("}");
        code.append('}'); // method end
        code.separator();

        System.out.println(code.toFragment());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitLabel(Label label) {
        code.append("case ", node(label).id, ":").line();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitIincInsn(int position, int increment) {
        code.append(local, "[", position, "]", "=", local, "[", position, "]", "+", increment, ";");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitLdcInsn(Object value) {
        if (value instanceof String) {
            push("\"" + value + "\"");
        } else if (value instanceof Integer) {
            push(value);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitIntInsn(int opecode, int operand) {
        switch (opecode) {
        case BIPUSH:
        case SIPUSH:
            push(operand);
            break;

        // When opcode is NEWARRAY, operand value should be one of Opcodes.T_BOOLEAN,
        // Opcodes.T_CHAR, Opcodes.T_FLOAT, Opcodes.T_DOUBLE, Opcodes.T_BYTE, Opcodes.T_SHORT,
        // Opcodes.T_INT or Opcodes.T_LONG.
        case NEWARRAY:
            Class type = null;

            switch (operand) {
            case T_INT:
                type = int[].class;
                break;

            case T_LONG:
                type = long[].class;
                break;

            case T_FLOAT:
                type = float[].class;
                break;

            case T_DOUBLE:
                type = double[].class;
                break;

            case T_BOOLEAN:
                type = boolean[].class;
                break;

            case T_BYTE:
                type = byte[].class;
                break;

            case T_CHAR:
                type = char[].class;
                break;

            case T_SHORT:
                type = short[].class;
                break;

            default:
                // If this exception will be thrown, it is bug of this program. So we must rethrow
                // the wrapped error in here.
                throw new Error();
            }

            Javascript.require(type);
            push(new OperandArray(new OperandExpression(pop()), type));
            break;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitInsn(int opecode) {
        switch (opecode) {
        case DUP:
            code.append(stack, ".dup(", index - 1, ",", index - 1, ");");
            index++;
            break;

        case DUP2:
            code.append(stack, ".dup2(", index - 1, ",", index - 2, ");");
            index += 2;
            break;

        case DUP_X2:
            code.append(stack, ".dup(", index - 1, ",", index - 3, ");");
            index++;
            break;

        case ICONST_0:
            push("0");
            break;

        case ICONST_1:
            push("1");
            break;

        case ICONST_2:
            push("2");
            break;

        case ICONST_3:
            push("3");
            break;

        case ICONST_4:
            push("4");
            break;

        case ICONST_5:
            push("5");
            break;

        case ICONST_M1:
            push("-1");
            break;

        case IADD:
            push(pop() + "+" + pop());
            break;

        case ISUB:
            push(pop() + "-" + pop());
            break;

        case IMUL:
            push(pop() + "*" + pop());
            break;

        case IDIV:
            push(pop() + "/" + pop());
            break;

        // read array length
        case ARRAYLENGTH:
            push(pop() + ".length");
            break;

        // write array value by index
        case IALOAD:
        case AALOAD:
        case BALOAD:
        case LALOAD:
        case FALOAD:
        case DALOAD:
        case CALOAD:
        case SALOAD:
            String index = pop();
            String array = pop();
            push(array + "[" + index + "]");
            break;

        // read array value by index
        case AASTORE:
        case BASTORE:
        case IASTORE:
        case LASTORE:
        case FASTORE:
        case DASTORE:
        case CASTORE:
        case SASTORE:
            String value = pop();
            index = pop();
            array = pop();
            code.append(array, "[", index, "]=", value, ";");
            break;

        case ARETURN:
        case IRETURN:
        case LRETURN:
        case FRETURN:
        case DRETURN:
            code.append("return ", pop(), ";");
            break;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitFieldInsn(int opcode, String ownerClassName, String name, String desc) {
        // compute owner class
        Class owner = convert(ownerClassName);

        // current processing script depends on the owner class
        Javascript.require(owner);

        // Field type
        Class type = convert(Type.getType(desc));
        Translator translator = TranslatorManager.getTranslator(owner);

        switch (opcode) {
        case GETFIELD:
            push(translator.translateField(owner, name, new OperandExpression(pop())));
            break;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitMethodInsn(int opcode, String className, String methodName, String desc, boolean access) {
        // compute owner class
        Class owner = convert(className);

        // current processing script depends on the owner class
        Javascript.require(owner);

        // compute parameter types
        Type[] types = Type.getArgumentTypes(desc);
        Class[] parameters = new Class[types.length];

        for (int i = 0; i < types.length; i++) {
            parameters[i] = convert(types[i]);
        }

        // write mode
        Class returnType = convert(Type.getReturnType(desc));
        boolean immediately = returnType == void.class;

        // copy latest operands for this method invocation
        ArrayList<Operand> contexts = new ArrayList(parameters.length + 1);

        for (int i = 0; i < parameters.length; i++) {
            contexts.add(0, new OperandExpression(pop()));
        }

        // retrieve translator for this method owner
        Translator translator = TranslatorManager.getTranslator(owner);

        switch (opcode) {
        // Invoke instance method; special handling for superclass constructor, private method,
        // and instance initialization method invocations
        case INVOKESPECIAL:
            contexts.add(0, new OperandExpression(pop()));

            // Analyze method argument
            if (!methodName.equals("<init>")) {
                if (owner == script.source) {
                    // private method invocation
                    push(translator.translateMethod(owner, methodName, desc, parameters, contexts));
                } else {
                    // super method invocation
                    push(translator.translateSuperMethod(owner, methodName, desc, parameters, contexts));
                }
            } else {
                // constructor

            }
            break;

        case INVOKEVIRTUAL: // method call
        case INVOKEINTERFACE: // interface method call
            break;

        case INVOKESTATIC: // static method call
            break;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitMultiANewArrayInsn(String desc, int dimension) {
        // remove needless operands
        for (int i = 0; i < dimension - 1; i++) {
            pop();
        }
        push(new OperandArray(new OperandExpression(pop()), convert(desc)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitJumpInsn(int opcode, Label label) {
        if (opcode != GOTO) {
            code.write("if", "(");

            switch (opcode) {
            case IFGE:
                code.append("0", "<=", pop());
                break;

            case IFGT:
                code.append("0", "<", pop());
                break;

            case IFLE:
                code.append(pop(), "<=", "0");
                break;

            case IFLT:
                code.append(pop(), "<", "0");
                break;

            case IF_ICMPEQ:
                code.append(pop(), "==", pop());
                break;

            case IF_ICMPNE:
                code.append(pop(), "!=", pop());
                break;

            case IF_ICMPGE:
                code.append(pop(), "<=", pop());
                break;

            case IF_ICMPGT:
                code.append(pop(), "<", pop());
                break;

            case IF_ICMPLE:
                code.append(pop(), "=>", pop());
                break;

            case IF_ICMPLT:
                code.append(pop(), ">", pop());
                break;
            }
            code.write(")", "{");
        }

        code.append(jump, "=", node(label).id, ";");
        code.append("continue", ";");
        if (opcode != GOTO) code.write("}");
        code.line();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitTypeInsn(int opcode, String type) {
        switch (opcode) {
        case NEW:
            // if (assertNew) {
            // assertNew = false;
            // current = createNode();
            // current.number = current.previous.number;
            // }
            // countInitialization++;
            //
            // current.addOperand("new " + Javascript.computeClassName(convert(type)));
            break;

        case ANEWARRAY:
            if (type.charAt(0) == '[') {
                type = "[" + type;
            } else {
                type = "[L" + type + ";";
            }
            push(new OperandArray(new OperandExpression(pop()), convert(type)));
            break;

        case CHECKCAST:
            break;

        case INSTANCEOF:
            // Class clazz = convert(type);
            //
            // // load source
            // Javascript.require(clazz);
            //
            // String code;
            //
            // if (clazz == Object.class || clazz == NativeObject.class) {
            // code = current.remove(0) + " instanceof Object";
            // } else if (clazz == String.class) {
            // code = "boot.isString(" + current.remove(0) + ")";
            // } else if (clazz.isInterface() || clazz.isArray()) {
            // code = Javascript.writeMethodCode(Class.class, "isInstance",
            // Javascript.computeClass(clazz), Object.class, current.remove(0));
            // } else {
            // code = current.remove(0) + " instanceof " + Javascript.computeClassName(clazz);
            // }
            // current.addOperand(code, boolean.class);
            break;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitVarInsn(int opcode, int index) {
        switch (opcode) {
        case ASTORE:
        case ISTORE:
        case LSTORE:
        case FSTORE:
        case DSTORE:
            code.append(local, "[" + index + "]=", pop(), ";");
            break;

        case ALOAD:
        case ILOAD:
        case FLOAD:
        case LLOAD:
        case DLOAD:
            push(local + "[" + index + "]");
            break;
        }

    }

    /**
     * <p>
     * Helper method to write push code.
     * </p>
     * 
     * @param value
     */
    private void push(int value) {
        push(String.valueOf(value));
    }

    /**
     * <p>
     * Helper method to write push code.
     * </p>
     * 
     * @param value
     */
    private void push(Object value) {
        push(String.valueOf(value));
    }

    /**
     * <p>
     * Helper method to write push code.
     * </p>
     * 
     * @param value
     */
    private void push(String value) {
        code.append(stack, "[", index++, "]=", value + ";");
    }

    private String pop() {
        return stack + "[" + --index + "]";
    }

    /**
     * <p>
     * Helper method to find node by label.
     * </p>
     * 
     * @param label
     * @return
     */
    private Node node(Label label) {
        Node node = (Node) label.info;

        if (node == null) {
            node = new Node(counter++);
            label.info = node;
        }
        return node;
    }

    /**
     * Convert parameter type to class.
     * 
     * @param type A parameter {@link Type}.
     * @return A parameter {@link Class}.
     */
    static final Class convert(Type type) {
        switch (type.getSort()) {
        case INT:
            return int.class;

        case Type.LONG:
            return long.class;

        case Type.FLOAT:
            return float.class;

        case Type.DOUBLE:
            return double.class;

        case CHAR:
            return char.class;

        case BYTE:
            return byte.class;

        case SHORT:
            return short.class;

        case BOOLEAN:
            return boolean.class;

        case VOID:
            return void.class;

        case ARRAY:
            return Array.newInstance(convert(type.getElementType()), new int[type.getDimensions()]).getClass();

        default:
            try {
                return Class.forName(type.getClassName());
            } catch (ClassNotFoundException e) {
                // If this exception will be thrown, it is bug of this program. So we must
                // rethrow the wrapped error in here.
                throw new Error(e);
            }
        }
    }

    /**
     * <p>
     * Helper method to convert the specified class name to {@link Class}.
     * </p>
     * 
     * @param className A fully qualified internal class name.
     * @return Java class.
     */
    static final Class convert(String className) {
        if (className == null) {
            return null;
        }

        try {
            return Class.forName(className.replace('/', '.'));
        } catch (ClassNotFoundException e) {
            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            throw new Error(e);
        }
    }

    /**
     * @version 2014/05/27 16:46:52
     */
    private static class Node {

        /** The node id. */
        private final int id;

        /**
         * @param id
         */
        private Node(int id) {
            this.id = id;
        }
    }

    /**
     * <p>
     * Manage local variables.
     * </p>
     * 
     * @version 2013/01/21 11:09:48
     */
    private static class LocalVariables {

        /** The current processing method is static or not. */
        private final boolean isStatic;

        /** The max size of variables. */
        private final int max;

        /** The ignorable variable index. */
        private final List<Integer> ignores = new ArrayList();

        /** The local type mapping. */
        private final Map<Integer, InferredType> types = new HashMap();

        /**
         * @param isStatic
         */
        private LocalVariables(int size, boolean isStatic) {
            this.max = size + 1;
            this.isStatic = isStatic;
        }

        /**
         * <p>
         * Compute the identified qualified local variable name for ECMAScript.
         * </p>
         * 
         * @param order An order by which this variable was declared.
         * @return An identified local variable name for ECMAScript.
         */
        private String name(int order) {
            return name(order, 0);
        }

        /**
         * <p>
         * Compute the identified qualified local variable name for ECMAScript.
         * </p>
         * 
         * @param order An order by which this variable was declared.
         * @return An identified local variable name for ECMAScript.
         */
        private String name(int order, int opcode) {
            // ignore long or double second index
            switch (opcode) {
            case LLOAD:
            case LSTORE:
            case DLOAD:
            case DSTORE:
                ignores.add(order + 1);
                break;
            }

            // order 0 means "this", but static method doesn't have "this" variable
            if (!isStatic) {
                order--;
            }

            if (order == -1) {
                return "this";
            }

            // Compute local variable name
            return Obfuscator.mung32(order);
        }

        /**
         * <p>
         * List up all valid variable names.
         * </p>
         * 
         * @return
         */
        private List<String> names() {
            List<String> names = new ArrayList();

            for (int i = isStatic ? 0 : 1; i < max; i++) {
                if (!ignores.contains(i)) {
                    names.add(name(i));
                }
            }
            return names;
        }

        /**
         * <p>
         * Find {@link InferredType} for the specified position.
         * </p>
         * 
         * @param position
         * @return
         */
        private InferredType type(int position) {
            InferredType type = types.get(position);

            if (type == null) {
                type = new InferredType();
                types.put(position, type);
            }
            return type;
        }
    }
}
