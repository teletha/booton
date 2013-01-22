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

import static booton.translator.OperandCondition.*;
import static org.objectweb.asm.Opcodes.*;
import static org.objectweb.asm.Type.*;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import js.lang.NativeObject;
import kiss.Extensible;
import kiss.I;
import kiss.model.ClassUtil;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import booton.Obfuscator;

/**
 * <p>
 * In general, the compiler converts the short-circuit route, and optimizes the logical expression.
 * Compiler generates goto-label to omit the evaluation of the second operand that becomes
 * unnecessary when first operand is evaluated. If we can't restore the original logical expression
 * completely, garbage goto code will remain.
 * </p>
 * 
 * @version 2013/01/21 11:55:35
 */
class JavaMethodCompiler extends MethodVisitor {

    /**
     * Represents an expanded frame. See {@link ClassReader#EXPAND_FRAMES}.
     */
    private static final int FRAME_NEW = 400;

    /**
     * Represents a compressed frame with complete frame data.
     */
    private static final int FRAME_FULL = 401;

    /**
     * Represents a compressed frame where locals are the same as the locals in the previous frame,
     * except that additional 1-3 locals are defined, and with an empty stack.
     */
    private static final int FRAME_APPEND = 402;

    /**
     * Represents a compressed frame where locals are the same as the locals in the previous frame,
     * except that the last 1-3 locals are absent and with an empty stack.
     */
    private static final int FRAME_CHOP = 403;

    /**
     * Represents a compressed frame with exactly the same locals as the previous frame and with an
     * empty stack.
     */
    private static final int FRAME_SAME = 404;

    /**
     * Represents a compressed frame with exactly the same locals as the previous frame and with a
     * single value on the stack.
     */
    private static final int FRAME_SAME1 = 405;

    /** The frequently used operand for cache. */
    private static final OperandNumber ZERO = new OperandNumber(0);

    /** The frequently used operand for cache. */
    private static final OperandNumber ONE = new OperandNumber(1);

    /** The extra opcode for byte code parsing. */
    private static final int LABEL = 300;

    /** The java source(byte) code. */
    private final Javascript script;

    /** The javascript object code. */
    private final ScriptBuffer code;

    /** The current processing method name. */
    private final String methodName;

    /** The method return type. */
    private final Type returnType;

    /** The local variable manager. */
    private final LocalVariables variables;

    /** The current processing node. */
    private Node current = null;

    /** The all node list for this method. */
    private List<Node> nodes = new ArrayList();

    /** The counter for the current processing node identifier. */
    private int counter = 0;

    /** The counter for construction of the object initialization. */
    private int countInitialization = 0;

    /** The record of recent instructions. */
    private int[] records = new int[8];

    /** The current start position of instruction records. */
    private int recordIndex = 0;

    /** The flag whether the next jump instruction is used for assert statement or not. */
    private boolean assertJump = false;

    /** The pool of try-catch-finally blocks. */
    private Deque<TryCatch> tries = new ArrayDeque();

    /**
     * @param script A target script to compile.
     * @param code A code writer.
     * @param name A method name.
     * @param description A method description.
     * @param isStatic A static flag.
     */
    JavaMethodCompiler(Javascript script, ScriptBuffer code, String name, String description, boolean isStatic) {
        super(ASM4);

        this.script = script;
        this.code = code;
        this.methodName = name;
        this.returnType = Type.getReturnType(description);
        this.variables = new LocalVariables(isStatic);
    }

    /**
     * {@inheritDoc}
     */
    public void visitEnd() {
        // Resolve shorthand syntax sugar of "if" statement.
        for (int i = nodes.size() - 1; 0 <= i; i--) {
            Node node = nodes.get(i);

            if (node.stack.peekFirst() instanceof OperandCondition && node.outgoing.size() == 1) {
                // create condition node
                Node condition = createNode(node);
                Node out = node.outgoing.get(0);
                node.disconnect(out);
                condition.connect(node);
                condition.connect(out);

                condition.stack.add(node.stack.pollFirst().invert());
            }
        }

        // Search all backedge nodes at first.
        searchBackEdge(nodes.get(0), new ArrayDeque());

        // Resolve all try-catch-finally blocks.
        Iterator<TryCatch> iterator = tries.descendingIterator();

        while (iterator.hasNext()) {
            iterator.next().computeTryBlock();
        }

        // NodeDebugger.dump(script, original, nodes);

        // ===============================================
        // Script Code
        // ===============================================
        // write method declaration
        code.append(methodName, ":", "function(", I.join(variables.names(), ","), "){");
        code.mark();
        nodes.get(0).write(code);
        code.optimize();
        code.append('}'); // method end
        code.separator();
    }

    /**
     * <p>
     * Helper method to search all backedge nodes using depth-first search.
     * </p>
     * 
     * @param node A target node to check.
     * @param nodes All passed nodes.
     */
    private void searchBackEdge(Node node, Deque<Node> nodes) {
        // Store the current processing node.
        nodes.add(node);

        // Step into outgoing nodes.
        for (Node out : node.outgoing) {
            if (nodes.contains(out)) {
                out.backedges.add(node);
            } else {
                searchBackEdge(out, nodes);
            }
        }

        // Remove the current processing node.
        nodes.pollLast();
    }

    /**
     * {@inheritDoc}
     */
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        return null; // do nothing
    }

    /**
     * {@inheritDoc}
     */
    public AnnotationVisitor visitAnnotationDefault() {
        return null; // do nothing
    }

    /**
     * {@inheritDoc}
     */
    public void visitAttribute(Attribute attr) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    public void visitCode() {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    public void visitFieldInsn(int opcode, String ownerClassName, String name, String desc) {
        // If this field access instruction is used for assertion, we should skip it to erase
        // compiler generated extra code.
        if (name.equals("$assertionsDisabled")) {
            assertJump = true;
            return;
        }

        // recode current instruction
        record(opcode);

        // compute owner class
        Class owner = convert(ownerClassName);

        // current processing script depends on the owner class
        script.require(owner);

        Translator translator = TranslatorManager.getTranslator(owner);

        switch (opcode) {
        case PUTFIELD:
            // Increment of field doesn't use increment instruction, so we must distinguish
            // increment from addition by pattern matching. Post increment code of field
            // leaves characteristic pattern like the following.
            if (match(ALOAD, DUP, GETFIELD, DUP_X1, ICONST_1, IADD, PUTFIELD)) {
                current.remove(0);

                current.addOperand(new OperandExpression(current.remove(0) + "." + Javascript.computeFieldName(owner, name) + "++"));
            } else {
                current.addExpression(current.remove(1), ".", Javascript.computeFieldName(owner, name), "=", current.remove(0));
            }
            break;

        case GETFIELD:
            current.addOperand(translator.translateField(owner, name, current.remove(0)));
            break;

        case PUTSTATIC:
            current.addExpression(Javascript.computeClassName(owner), ".", Javascript.computeFieldName(owner, name), "=", current.remove(0));
            break;

        case GETSTATIC:
            current.addOperand(translator.translateStaticField(owner, name));
            break;
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
        switch (type) {
        case F_NEW:
            record(FRAME_NEW);
            break;

        case F_FULL:
            record(FRAME_FULL);
            break;

        case F_APPEND:
            record(FRAME_APPEND);
            break;

        case F_CHOP:
            record(FRAME_CHOP);
            break;

        case F_SAME:
            record(FRAME_SAME);
            break;

        case F_SAME1:
            record(FRAME_SAME1);
            break;
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitIincInsn(int position, int increment) {
        // retrieve the local variable name
        String variable = variables.name(position);

        if (increment == 1) {
            // increment
            if (match(ILOAD)) {
                // post increment
                current.addOperand(current.remove(0) + "++");
            } else {
                // pre increment
                current.addExpression("++", variable);
            }
        } else if (increment == -1) {
            // increment
            if (match(ILOAD)) {
                // post increment
                current.addOperand(current.remove(0) + "--");
            } else {
                // pre increment
                current.addExpression("--", variable);
            }
        } else {
            current.addExpression(variable, "=", variable, "+", increment);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitInsn(int opcode) {
        // recode current instruction
        record(opcode);

        switch (opcode) {
        case DUP:
        case DUP2:
            if (!match(NEW, DUP) && !match(NEW, DUP2)) {
                // mark as duplicated operand
                current.stack.peekLast().duplicated = true;
            }
            break;

        case DUP_X1:
        case DUP_X2:
            // These instructions are used for field increment mainly, see visitFieldInsn(PUTFIELD).
            // Skip this instruction to simplify compiler.
            break;

        case DUP2_X1:
        case DUP2_X2:
            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            throw new Error();

        case POP:
        case POP2:
            // One sequence of expressions was finished, so we must write out one remaining
            // operand. (e.g. Method invocation which returns some operands but it is not used ever)
            current.addExpression(current.remove(0));
            break;

        // 0
        case ICONST_0:
        case LCONST_0:
        case FCONST_0:
        case DCONST_0:
            current.addOperand(ZERO);
            break;

        // 1
        case ICONST_1:
        case LCONST_1:
        case FCONST_1:
        case DCONST_1:
            current.addOperand(ONE);
            break;

        // 2
        case ICONST_2:
        case FCONST_2:
            current.addOperand(2);
            break;

        // 3
        case ICONST_3:
            current.addOperand(3);
            break;

        // 4
        case ICONST_4:
            current.addOperand(4);
            break;

        // 5
        case ICONST_5:
            current.addOperand(5);
            break;

        // -1
        case ICONST_M1:
            current.addOperand(-1);
            break;

        // null
        case ACONST_NULL:
            current.addOperand(null); // not "null"
            break;

        // + operand
        case IADD:
        case LADD:
        case FADD:
        case DADD:
            current.join("+");
            break;

        // - operand
        case ISUB:
        case LSUB:
        case FSUB:
        case DSUB:
            current.join("-");
            break;

        // * operand
        case IMUL:
        case LMUL:
        case FMUL:
        case DMUL:
            current.join("*");
            break;

        // / operand
        case IDIV:
        case LDIV:
        case FDIV:
        case DDIV:
            current.join("/");
            break;

        // % operand
        case IREM:
        case LREM:
        case FREM:
        case DREM:
            current.join("%");
            break;

        // & operand
        case IAND:
        case LAND:
            current.join("&");
            break;

        // | operand
        case IOR:
        case LOR:
            current.join("|");
            break;

        // ^ operand
        case IXOR:
        case LXOR:
            current.join("^");
            break;

        // << operand
        case ISHL:
        case LSHL:
            current.join("<<");
            break;

        // >> operand
        case ISHR:
        case LSHR:
            current.join(">>");
            break;

        // >>> operand
        case IUSHR:
        case LUSHR:
            current.join(">>>");
            break;

        case RETURN:
            current.addExpression("return");

            // disconnect the next appearing node from the current node
            current = null;
            break;

        case IRETURN:
            if (match(ICONST_0, IRETURN, LABEL, FRAME_SAME, ICONST_1, IRETURN)) {
                current.remove(0);
                current.remove(0);
                current.remove(0);
                current.remove(0);

                merge();
                dispose(current);
            } else if (match(ICONST_1, IRETURN, LABEL, FRAME_SAME, ICONST_0, IRETURN)) {
                // merge the node sequence of logical expression
                current.remove(0);
                current.remove(0);
                current.remove(0);
                current.remove(0);

                merge();
                dispose(current);

                // invert the latest condition
                if (!current.stack.isEmpty()) {
                    current.stack.peekLast().invert();
                }
            }

            Operand operand = current.remove(0);

            if (returnType == BOOLEAN_TYPE) {
                if (operand.toString().equals("0")) {
                    operand = new OperandExpression("false");
                } else if (operand.toString().equals("1")) {
                    operand = new OperandExpression("true");
                }
            }

            current.addExpression("return ", operand);

            // disconnect the next appearing node from the current node
            current = null;
            break;

        case ARETURN:
        case LRETURN:
        case FRETURN:
        case DRETURN:
            current.addExpression("return ", current.remove(0));

            // disconnect the next appearing node from the current node
            current = null;
            break;

        // write array value by index
        case AALOAD:
        case IALOAD:
        case LALOAD:
        case FALOAD:
        case DALOAD:
            current.addOperand(current.remove(1) + "[" + current.remove(0) + "]");
            break;

        // read array value by index
        case AASTORE:
        case IASTORE:
        case LASTORE:
        case FASTORE:
        case DASTORE:
        case CASTORE:
            Operand contextMaybeArray = current.remove(2);
            Operand value = current.remove(0);

            if (opcode == CASTORE) {
                // convert assign value (int -> char)
                value = value.cast(char.class);
            }

            if (contextMaybeArray instanceof OperandArray) {
                // initialization of syntax sugar
                ((OperandArray) contextMaybeArray).set(current.remove(0), value);
            } else {
                // read by index
                current.addExpression(contextMaybeArray, "[", current.remove(0), "]=", value);
            }
            break;

        // read array length
        case ARRAYLENGTH:
            current.addOperand(current.remove(0) + ".length");
            break;

        // throw
        case ATHROW:
            current.addExpression("throw ", current.remove(0));

            // disconnect the next appearing node from the current node
            current = null;
            break;
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitIntInsn(int opcode, int operand) {
        // recode current instruction
        record(opcode);

        // The opcode of the instruction to be visited. This opcode is either BIPUSH, SIPUSH or
        // NEWARRAY.
        switch (opcode) {
        // When opcode is BIPUSH, operand value should be between Byte.MIN_VALUE and
        // Byte.MAX_VALUE.
        case BIPUSH:
            current.addOperand(operand);
            break;

        // When opcode is SIPUSH, operand value should be between Short.MIN_VALUE and
        // Short.MAX_VALUE.
        case SIPUSH:
            current.addOperand(operand);
            break;

        // When opcode is NEWARRAY, operand value should be one of Opcodes.T_BOOLEAN,
        // Opcodes.T_CHAR, Opcodes.T_FLOAT, Opcodes.T_DOUBLE, Opcodes.T_BYTE, Opcodes.T_SHORT,
        // Opcodes.T_INT or Opcodes.T_LONG.
        case NEWARRAY:
            current.stack.add(new OperandArray(current.remove(0), true));
            break;
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitJumpInsn(int opcode, Label label) {
        // If this jump instruction is used for assertion, we should skip it to erase compiler
        // generated extra code.
        if (assertJump) {
            assertJump = false; // reset flag
            return;
        }

        // recode current instruction
        record(opcode);

        // search node
        Node node = getNode(label);

        switch (opcode) {
        case GOTO:
            connect(label);
            // disconnect the next appearing node from the current node
            current = null;
            return;

        case IFEQ: // == 0
            current.stack.add(new OperandCondition(current.remove(0), EQ, new OperandNumber(0), node));
            connect(label);
            break;

        case IFNE: // != 0
            current.stack.add(new OperandCondition(current.remove(0), NE, new OperandNumber(0), node));
            connect(label);
            break;

        case IFGE: // => 0
            current.stack.add(new OperandCondition(current.remove(0), GE, new OperandNumber(0), node));
            connect(label);
            break;

        case IFLE: // <= 0
            current.stack.add(new OperandCondition(current.remove(0), LE, new OperandNumber(0), node));
            connect(label);
            break;

        case IFNULL: // object == null
            current.stack.add(new OperandCondition(current.remove(0), EQ, new OperandExpression("null"), node));
            connect(label);
            break;

        case IFNONNULL: // object != null
            current.stack.add(new OperandCondition(current.remove(0), NE, new OperandExpression("null"), node));
            connect(label);
            break;

        // ==
        case IF_ACMPEQ:
        case IF_ICMPEQ:
            current.stack.add(new OperandCondition(current.remove(1), EQ, current.remove(0), node));
            connect(label);
            break;

        // !=
        case IF_ACMPNE:
        case IF_ICMPNE:
            current.stack.add(new OperandCondition(current.remove(1), NE, current.remove(0), node));
            connect(label);
            break;

        case IF_ICMPGE: // int => int
            current.stack.add(new OperandCondition(current.remove(1), GE, current.remove(0), node));
            connect(label);
            break;

        case IF_ICMPGT: // int > int
            current.stack.add(new OperandCondition(current.remove(1), GT, current.remove(0), node));
            connect(label);
            break;

        case IF_ICMPLE: // int <= int
            current.stack.add(new OperandCondition(current.remove(1), LE, current.remove(0), node));
            connect(label);
            break;

        case IF_ICMPLT: // int < int
            current.stack.add(new OperandCondition(current.remove(1), LT, current.remove(0), node));
            connect(label);
            break;

        default:
            break;
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitLabel(Label label) {
        // recode current instruction
        record(LABEL);

        // Basically, visitLabel method is called each expression. But the following patterns are
        // exception so we must deal with them.
        //
        // Logical Expression Result with Return
        // A logical expression result (e.g. return i == 1;) is represented as [ICONST_0, IRETURN,
        // LABEL, ICONST_1, IRETURN] in bytecode.
        //
        // Logical Expression Result
        // A logical expression result (e.g. boolean b = (i == 1);) is represented as [ICONST_0,
        // GOTO, LABEL, ICONST_1, LABEL] in bytecode.
        //
        // Ternary Operator
        // Ternary operator (e.g. int i = (j == 0) ? 0 : 1;) is represented as [LABEL,
        // THEN_EXPRESSION, GOTO, LABEL, ELSE_EXPRESSION, LABEL] in bytecode.

        // build new node
        current = connect(label);

        // store the node in appearing order
        nodes.add(current);

        if (1 < nodes.size()) {
            current.previous = nodes.get(nodes.size() - 2);

            if (current.previous.stack.size() != 0) {
                resolveLabel();
            }
        }
    }

    /**
     * <p>
     * Helper method to resolve conditional operands.
     * </p>
     */
    private void resolveLabel() {
        Operand first = peek(0);
        Operand second = peek(1);
        Operand third = peek(2);

        if (first instanceof OperandCondition) {
            merge();
        } else if (second instanceof OperandCondition) {
            merge();

            dispose(current);
        } else if (third instanceof OperandCondition) {
            if (first instanceof OperandExpression && first.toString().equals(";")) {
                // do nothing
            } else {
                // =======================
                // Conditional Operator
                // =======================
                first = current.remove(0);
                second = current.remove(0);
                third = current.remove(0);

                if (first == ONE && second == ZERO) {
                    current.addOperand(third);
                } else if (first == ZERO && second == ONE) {
                    current.addOperand(third.invert());
                } else {
                    current.addOperand("(" + third.invert() + "?" + second + ":" + first + ")");
                }

                // resolve recursively
                resolveLabel();
            }
        }
    }

    /**
     * Peek operand from latest.
     * 
     * @param index
     * @return
     */
    private Operand peek(int index) {
        Node current = this.current;

        while (current != null) {
            for (int i = current.stack.size() - 1; -1 < i; --i) {
                if (index-- == 0) {
                    return current.stack.get(i);
                }
            }
            current = current.previous;
        }
        return null;
    }

    /**
     * <p>
     * Helper method to dispose the current processing node.
     * </p>
     */
    private void dispose(Node target) {
        int index = nodes.indexOf(target);

        if (0 < index && index + 1 < nodes.size()) {
            nodes.get(index + 1).previous = index < 1 ? null : nodes.get(index - 1);
        }

        // Merge the current processing node
        nodes.remove(target);

        // Remove it from outgoings of all previous-sibling nodes.
        for (Node node : nodes) {
            node.incoming.remove(target);
            node.outgoing.remove(target);
        }

        for (Node out : target.outgoing) {
            for (Node in : target.incoming) {
                if (!in.outgoing.contains(out)) {
                    in.outgoing.add(out);
                }
            }
        }

        for (Node in : target.incoming) {
            for (Node out : target.outgoing) {
                if (!out.incoming.contains(in)) {
                    out.incoming.add(in);
                }
            }
        }

        // Copy all operands to the previous node
        if (target.previous != null) {
            target.previous.stack.addAll(target.stack);
        }

        // Delete all operands from the current processing node
        target.stack.clear();

        if (target == current) {
            current = target.previous;
        }
    }

    /**
     * <p>
     * Helper method to merge all conditional operands.
     * </p>
     */
    private void merge() {
        Set<Node> group = new HashSet();
        group.add(current);

        boolean found = false;

        // Decide target node
        Node target = current.previous;

        // Merge the sequencial conditional operands in this node from right to left.
        for (int i = target.stack.size() - 1; 0 <= i; i--) {
            Operand operand = target.stack.get(i);

            if (operand instanceof OperandCondition) {
                OperandCondition condition = (OperandCondition) operand;

                if (!found) {
                    found = true;

                    // This is first operand condition.
                    group.add(condition.transition);

                    // Set next appering node for grouping.
                    condition.next = current;
                } else if (group.contains(condition.transition)) {
                    // Merge two adjucent conditional operands.
                    target.stack.set(i, new OperandCondition(condition, (OperandCondition) target.stack.remove(i + 1)));
                } else {
                    return; // Stop here.
                }
            } else {
            }
        }

        // Merge this node and the specified node.
        // Rearch the start of node
        if (target.previous != null) {
            Operand operand = target.previous.stack.peekLast();

            if (operand instanceof OperandCondition) {
                OperandCondition condition = (OperandCondition) operand;

                if (group.contains(condition.transition)) {
                    dispose(target);

                    // Merge recursively
                    merge();
                }
            }
        }
    }

    /**
     * Connect the current node and the specified labed node.
     * 
     * @param label
     * @return
     */
    private Node connect(Label label) {
        // search cached node
        Node node = getNode(label);

        if (current != null) {
            // connect nodes each other
            if (!current.outgoing.contains(node)) {
                current.outgoing.add(node);
                node.incoming.add(current);
            }
        }

        // API definition
        return node;
    }

    /**
     * <p>
     * This parameter must be a non null Integer, a Float, a Long, a Double a String (or a Type for
     * .class constants, for classes whose version is 49.0 or more).
     * </p>
     * 
     * @see org.objectweb.asm.MethodVisitor#visitLdcInsn(java.lang.Object)
     */
    public void visitLdcInsn(Object constant) {
        if (constant instanceof String) {
            current.stack.add(new OperandString((String) constant));
        } else if (constant instanceof Type) {
            String className = ((Type) constant).getInternalName();

            // add class operand
            Class clazz = convert(className);
            Literal literal = findLiteral(clazz);

            if (literal == null) {
                // Booton support class literal in javascript runtime.
                current.addOperand(Javascript.computeClassName(clazz) + ".$");

                script.require(clazz);
            } else {
                // Provide class literal support by user.
                current.addOperand(literal.write(clazz));
            }
        } else {
            current.addOperand(constant);
        }
    }

    /**
     * <p>
     * Helper method to find literal writer.
     * </p>
     * 
     * @param clazz
     * @return
     */
    private Literal findLiteral(Class clazz) {
        for (Class extensionPoint : ClassUtil.getTypes(clazz)) {
            if (Arrays.asList(extensionPoint.getInterfaces()).contains(Extensible.class)) {
                Literal literal = I.find(Literal.class, extensionPoint);

                if (literal != null) {
                    return literal;
                }
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
        // Compiler generated code (i.e. synthetic method) doesn't have local variable operand.
        // So we shouldn't use this method to salvage infomation.
    }

    /**
     * {@inheritDoc}
     */
    public void visitLookupSwitchInsn(Label label, int[] values, Label[] labels) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    public void visitMaxs(int maxStack, int maxLocals) {
        variables.max = maxLocals;
    }

    /**
     * {@inheritDoc}
     */
    public void visitMethodInsn(int opcode, String className, String methodName, String desc) {
        // recode current instruction
        record(opcode);

        // compute owner class
        Class owner = convert(className);

        // current processing script depends on the owner class
        script.require(owner);

        // compute parameter types
        Type[] types = Type.getArgumentTypes(desc);
        Class[] parameters = new Class[types.length];

        for (int i = 0; i < types.length; i++) {
            parameters[i] = convert(types[i]);
        }

        // copy latest operands for this method invocation
        ArrayList<Operand> contexts = new ArrayList(parameters.length + 1);

        for (int i = 0; i < parameters.length; i++) {
            contexts.add(0, current.remove(0));
        }

        // write mode
        boolean immediately = Type.getReturnType(desc) == Type.VOID_TYPE;

        // retrieve translator for this method owner
        Translator translator = TranslatorManager.getTranslator(owner);

        switch (opcode) {
        // Invoke instance method; special handling for superclass constructor, private method,
        // and instance initialization method invocations
        case INVOKESPECIAL:
            // push "this" operand
            contexts.add(0, current.remove(0));

            // Analyze method argument
            if (!methodName.equals("<init>")) {
                if (owner == script.source) {
                    // private method invocation
                    current.addOperand(translator.translateMethod(owner, methodName, desc, parameters, contexts));
                } else {
                    // super method invocation
                    current.addOperand(translator.translateSuperMethod(owner, methodName, desc, parameters, contexts));
                }
            } else {
                // constructor
                if (countInitialization != 0) {
                    // instance initialization method invocation
                    current.addOperand(translator.translateConstructor(owner, desc, parameters, contexts));

                    countInitialization--;

                    // don't write
                    immediately = false;
                } else {
                    if (!className.equals("java/lang/Object")) {
                        current.addOperand(translator.translateSuperMethod(owner, methodName, desc, parameters, contexts));
                    }
                }
            }
            break;

        case INVOKEVIRTUAL: // method call
        case INVOKEINTERFACE: // interface method call
            // push "this" operand
            contexts.add(0, current.remove(0));

            // translate
            current.addOperand(translator.translateMethod(owner, methodName, desc, parameters, contexts));
            break;

        case INVOKESTATIC: // static method call
            // push class operand
            contexts.add(0, new OperandExpression(Javascript.computeClassName(owner)));

            // translate
            current.addOperand(translator.translateStaticMethod(owner, methodName, desc, parameters, contexts));
            break;
        }

        // if this method (not constructor and not static initializer) return void, we must
        // write out the expression of method invocation immediatly.
        if (immediately && current.stack.size() != 0) {
            current.addExpression(current.remove(0));
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitMultiANewArrayInsn(String desc, int dimension) {
        // remove needless operands
        for (int i = 0; i < dimension - 1; i++) {
            current.remove(0);
        }
        current.stack.add(new OperandArray(current.remove(0), false));
    }

    /**
     * {@inheritDoc}
     */
    public AnnotationVisitor visitParameterAnnotation(int arg0, String arg1, boolean arg2) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public void visitTableSwitchInsn(int min, int max, Label defaultLable, Label[] labels) {
    }

    /**
     * {@inheritDoc}
     */
    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        TryCatch current = new TryCatch(start, end, handler, type);

        for (TryCatch block : tries) {
            if (block.handler == current.handler) {
                return;
            }
        }
        tries.add(current);
    }

    /**
     * {@inheritDoc}
     */
    public void visitTypeInsn(int opcode, String type) {
        // recode current instruction
        record(opcode);

        switch (opcode) {
        case NEW:
            countInitialization++;

            current.addOperand("new " + Javascript.computeClassName(convert(type)));
            break;

        case ANEWARRAY:
            current.stack.add(new OperandArray(current.remove(0), false));
            break;

        case CHECKCAST:

            break;

        case INSTANCEOF:
            Class clazz = convert(type);

            // load source
            script.require(clazz);

            if (clazz == Object.class || clazz == NativeObject.class) {
                current.addOperand(current.remove(0) + " instanceof Object");
            } else if (clazz.isInterface()) {
                current.addOperand(Javascript.computeClass(clazz) + "." + Javascript.computeMethodName(assignable) + "(" + current.remove(0) + ".$.$)");
            } else {
                current.addOperand(current.remove(0) + " instanceof " + Javascript.computeClassName(clazz));
            }
            break;
        }
    }

    private static final Method assignable;

    static {
        try {
            assignable = Class.class.getMethod("isAssignableFrom", Class.class);
        } catch (Exception e) {
            throw I.quiet(e);
        }

    }

    /**
     * {@inheritDoc}
     */
    public void visitVarInsn(int opcode, int position) {
        // recode current instruction
        record(opcode);

        // check caught exception variable
        if (match(FRAME_SAME1, ASTORE) || match(FRAME_FULL, ASTORE)) {
            return;
        }

        // retrieve local variable name
        String variable = variables.name(position, opcode);

        switch (opcode) {
        case ALOAD:
        case ILOAD:
        case FLOAD:
        case LLOAD:
        case DLOAD:
            current.addOperand(variable);
            break;

        case ASTORE:
        case ISTORE:
        case LSTORE:
        case FSTORE:
        case DSTORE:
            // Increment not-int type doesn't use Iinc instruction, so we must distinguish increment
            // from addition by pattern matching. Post increment code of non-int type leaves
            // characteristic pattern like the following.
            if (match(FLOAD, DUP, FCONST_1, FADD, FSTORE) || match(DLOAD, DUP2, DCONST_1, DADD, DSTORE) || match(LLOAD, DUP2, LCONST_1, LADD, LSTORE)) {
                current.remove(0);
                current.remove(0);

                current.addOperand(variable + "++");
            } else {
                // When some method which straddles multi lines returns value, we should use operand
                // from previous node.
                if (current.stack.size() == 0) {
                    current.stack.addAll(current.previous.stack);
                    current.previous.stack.clear();
                }

                // retrieve and remove it
                Operand operand = current.stack.pollLast();

                current.addExpression(variable, "=", operand);

                if (operand.duplicated) {
                    operand.duplicated = false;

                    // duplicate pointer
                    current.addOperand(variable);
                }
            }
            break;
        }
    }

    /**
     * <p>
     * Retrieve the asossiated node of the specified label.
     * </p>
     * 
     * @param label A label for node.
     * @return An asossiated and cached node.
     */
    private final Node getNode(Label label) {
        // search cached node
        if (label.info == null) {
            label.info = new Node(counter++);
        }

        // API definition
        return (Node) label.info;
    }

    /**
     * <p>
     * Create new node before the specified node.
     * </p>
     * 
     * @param next A index node.
     * @return A created node.
     */
    private final Node createNode(Node next) {
        Node node = new Node(counter++);

        // switch previous node
        Node previous = next.previous;
        node.previous = previous;
        next.previous = node;

        ArrayList<Node> list = new ArrayList(next.incoming);

        for (Node incoming : list) {
            incoming.disconnect(next);
            incoming.connect(node);
        }

        // insert to node list
        nodes.add(nodes.indexOf(next), node);

        return node;
    }

    /**
     * Record the current instruction.
     */
    private final void record(int opcode) {
        records[recordIndex++] = opcode;

        if (recordIndex == 8) {
            recordIndex = 0; // loop index
        }
    }

    /**
     * Pattern matching for the recent instructions.
     * 
     * @param first A oldest instruction.
     * @param second A middle instruction.
     * @param third A latest instruction.
     * @return A result.
     */
    private final boolean match(int... opcodes) {
        for (int i = 0; i < opcodes.length; i++) {
            if (records[(recordIndex + i + 8 - opcodes.length) % 8] != opcodes[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Convert parameter type to class.
     * 
     * @param type A parameter {@link Type}.
     * @return A parameter {@link Class}.
     */
    private final Class convert(Type type) {
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
    private final Class convert(String className) {
        try {
            return Class.forName(className.replace('/', '.'));
        } catch (ClassNotFoundException e) {
            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            throw new Error(e);
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
        private int max = 0;

        /** The ignorable variable index. */
        private final List<Integer> ignores = new ArrayList();

        /**
         * @param isStatic
         */
        private LocalVariables(boolean isStatic) {
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
    }

    /**
     * @version 2010/01/27 16:04:09
     */
    class TryCatch {

        /** The start node. */
        final Node start;

        /** The end node. */
        Node end;

        /** The handler node. */
        Node handler;

        /** The following node. */
        Node next;

        /** The exception type. */
        final String exception;

        /** The nodes within try block. */
        final List<Node> tries = new ArrayList();

        /**
         * @param start
         * @param end
         * @param handler
         * @param exception
         */
        TryCatch(Label start, Label end, Label handler, String exception) {
            this.start = getNode(start);
            this.end = getNode(end);
            this.handler = getNode(handler);
            this.exception = exception == null ? null : Javascript.computeClassName(convert(exception));
        }

        /**
         * <p>
         * Assign this try-catch block to nodes.
         * </p>
         */
        private void computeTryBlock() {
            if (!handler.incoming.contains(start)) {
                handler.incoming.add(start);
            }

            // Node following = end.outgoing.get(0);
            //
            // for (Node node : following.incoming) {
            // node.disconnect(following);
            // }

            handler = nodes.get(nodes.indexOf(handler) + 1);

            if (end.outgoing.size() != 0) {
                next = end.outgoing.get(0);
            }
            start.addCatch(this);
        }

        private void resolve() {
            if (start == null) {
                if (end == null) {
                    // // try-finally
                    //
                    // // The base node has only finally node (don't have catch node).
                    // // So, we must recalculate the position of correct finally end node.
                    // Node follower = end.previous.outgoing.get(0);
                    //
                    // int i = nodes.indexOf(end);
                    // int j = nodes.indexOf(follower);
                    //
                    // start = follower;
                    // end = nodes.get(2 * j - i - 2);
                    // for (; i < j;) {
                    // nodes.remove(--j);
                    // }
                    //
                    // base.addFinally(this);
                    // } else {
                    // // try-catch-finally
                    //
                    // Node follower = end;
                    //
                    // end = start.previous.outgoing.size() == 0 ? start.previous :
                    // start.previous.outgoing.get(0);
                    // start = follower;
                    //
                    // base.addFinally(this);
                }
            } else {
                // try-catch
                // if (!start.incoming.contains(base)) {
                // start.incoming.add(base);
                // }
                //
                // start = nodes.get(nodes.indexOf(start) + 1);
                // end = end.outgoing.size() == 0 ? end : end.outgoing.get(0);
                // base.addCatch(this);
            }
        }
    }
}
