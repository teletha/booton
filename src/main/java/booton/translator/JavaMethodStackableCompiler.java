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
import java.util.ArrayDeque;
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
    private static final String stack = "$";

    /** The variable name for label. */
    private static final String jump = "_";

    /** The variable name for label. */
    private static final String root = "_";

    /** The array method name for stack. */
    private static final String popMethodName = "pop";

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

    /** The operand stack. */
    private final ArrayDeque<Operand> operands = new ArrayDeque();

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
        code.write("var ", stack, "=", "[],", jump, "=", "0;").line();
        code.write(root, ":", "while", "(true)", "{");
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
        String variable = variables.name(position);

        code.write(variable, "=", variable, "+", increment, ";").line();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitLdcInsn(Object value) {
        if (value instanceof String) {
            push("\"" + value + "\"");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitVarInsn(int opcode, int index) {
        push(variables.name(index));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitIntInsn(int opecode, int value) {
        switch (opecode) {
        case BIPUSH:
            push(value);
            break;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitInsn(int opecode) {
        switch (opecode) {
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
            push(translator.translateField(owner, name, pop()));
            break;
        }
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

            case IF_ICMPNE:
                code.append(pop(), "!=", pop());
                break;

            case IF_ICMPGE:
                code.append(pop(), "<=", pop());
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
        push(new OperandExpression(value));
    }

    /**
     * <p>
     * Helper method to write push code.
     * </p>
     * 
     * @param value
     */
    private void push(Operand operand) {
        operands.push(operand);
    }

    private Operand pop() {
        return operands.removeLast();
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
