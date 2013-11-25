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

import static org.objectweb.asm.Opcodes.*;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import kiss.I;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.Printer;

import booton.translator.Node.TryCatchFinally;

/**
 * @version 2013/11/03 10:17:20
 */
public class Debugger extends AnnotationVisitor {

    /** The processing environment. */
    private static final boolean whileTest;

    static {
        boolean flag = false;

        for (StackTraceElement element : new Error().getStackTrace()) {
            if (element.getClassName().startsWith("org.junit.")) {
                flag = true;
                break;
            }
        }
        whileTest = flag;
    }

    /** The Java original class. */
    final Class clazz;

    /** The Java original method name. */
    final String methodName;

    /** The Java original method signature. */
    final String methodDescriptor;

    boolean enable = false;

    boolean beforeLabel = false;

    boolean afterLabel = false;

    boolean asmable = false;

    /** The processing flag. */
    boolean whileProcess = false;

    /**
     * 
     */
    public Debugger(Class clazz, String methodName, String methodDescriptor) {
        super(ASM5);

        this.clazz = clazz;
        this.methodName = methodName;
        this.methodDescriptor = methodDescriptor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visit(String name, Object value) {
        if (name.equals("beforeLabel")) {
            beforeLabel = Boolean.parseBoolean(value.toString());
        } else if (name.equals("afterLabel")) {
            afterLabel = Boolean.parseBoolean(value.toString());
        } else if (name.equals("asm")) {
            asmable = Boolean.parseBoolean(value.toString());
        }
    }

    /**
     * <p>
     * Print method info.
     * </p>
     */
    public void printInfo() {
        System.out.println(clazz.getName() + "#" + methodName + " " + methodDescriptor);
    }

    public void print(Runnable task) {
        if (enable) {
            task.run();
        }
    }

    /**
     * @param message
     */
    public void print(Object message) {
        if (enable) {
            System.out.println(message);
        }
    }

    /**
     * <p>
     * Dump node tree.
     * </p>
     * 
     * @param node
     */
    public void print(Node node) {
        if (node != null) {
            print(Collections.singletonList(node));
        }
    }

    /**
     * <p>
     * Dump node tree.
     * </p>
     * 
     * @param nodes
     */
    public void print(List<Node> nodes) {
        if (enable) {
            System.out.println(format(nodes));
        }
    }

    /**
     * <p>
     * Dump node tree with method info.
     * </p>
     * 
     * @param script A current processing script.
     * @param methodName A original method name.
     * @param nodes A node info.
     */
    public void print(Javascript script, List<Node> nodes) {
        if (enable) {
            if (whileTest) {
                String testClassName = computeTestClassName(script.source);
                String testMethodName = computeTestMethodName(testClassName);

                print(testClassName + " " + (testMethodName == null ? methodName : testClassName));
                print(nodes);

                try {
                    ClassReader reader = new ClassReader(script.source.getName());
                    reader.accept(new ClassTracer(methodName, methodDescriptor, new ASMifier(), new PrintWriter(System.out)), 0);
                } catch (Exception e) {
                    throw I.quiet(e);
                }
            } else {
                print(script.source.getName() + " " + methodName);
                print(nodes);
            }
        }
    }

    /**
     * <p>
     * Compute actual test class name.
     * </p>
     * 
     * @param clazz
     * @return
     */
    private String computeTestClassName(Class clazz) {
        String name = clazz.getName();

        int index = name.indexOf('$');

        if (index != -1) {
            name = name.substring(0, index);
        }
        return name;
    }

    /**
     * <p>
     * Compute actual test method name.
     * </p>
     * 
     * @param testClassName
     * @return
     */
    private String computeTestMethodName(String testClassName) {
        for (StackTraceElement element : new Error().getStackTrace()) {
            if (element.getClassName().equals(testClassName)) {
                return element.getMethodName();
            }
        }
        return null;
    }

    /**
     * <p>
     * Helper method to format node tree.
     * </p>
     * 
     * @param nodes
     * @return
     */
    private String format(List<Node> nodes) {
        Set<TryCatchFinally> tries = new LinkedHashSet();

        for (Node node : nodes) {
            if (node.tries != null) {
                tries.addAll(node.tries);
            }
        }

        // compute max id length
        int max = 1;

        for (Node node : nodes) {
            max = Math.max(max, String.valueOf(node.id).length());
        }

        int incoming = 0;
        int outgoing = 0;
        int backedge = 0;

        for (Node node : nodes) {
            incoming = Math.max(incoming, node.incoming.size() * max + (node.incoming.size() - 1) * 2);
            outgoing = Math.max(outgoing, node.outgoing.size() * max + (node.outgoing.size() - 1) * 2);
            backedge = Math.max(backedge, node.backedges.size() * max + (node.backedges.size() - 1) * 2);
        }

        Formatter format = new Formatter();

        for (Node node : nodes) {
            StringBuilder tryFlow = new StringBuilder();

            for (TryCatchFinally block : tries) {
                if (block.start == node) {
                    tryFlow.append("s");
                } else if (block.end == node) {
                    tryFlow.append("e");
                } else if (block.catcher == node) {
                    tryFlow.append("c");
                } else if (block.exit == node) {
                    tryFlow.append("x");
                } else {
                    tryFlow.append("  ");
                }
            }

            format.write(String.valueOf(node.id), max);
            format.write("  in : ");
            format.formatNode(node.incoming, incoming);
            format.write("out : ");
            format.formatNode(node.outgoing, outgoing);
            format.write("dom : ");
            format.formatNode(list(getDominator(node)), 1);
            if (backedge != 0) {
                format.write("back : ");
                format.formatNode(node.backedges, backedge);
            }
            if (!tries.isEmpty()) {
                format.write("try : ");
                format.write(tryFlow.toString(), tries.size() * 2 + 2);
            }
            format.write("code : ");
            format.formatCodeFragment(node.stack);
            format.write("\r\n");
        }
        return format.toString();
    }

    /**
     * <p>
     * Create single item list.
     * </p>
     * 
     * @param node
     * @return
     */
    private List<Node> list(Node node) {
        if (node == null) {
            return Collections.EMPTY_LIST;
        }
        return Arrays.asList(node);
    }

    /**
     * <p>
     * Helper method to compute dominator node.
     * </p>
     * 
     * @param target
     * @return
     */
    private Node getDominator(Node target) {
        if (whileProcess) {
            return getDominator(target, new HashSet());
        } else {
            return target.getDominator();
        }
    }

    /**
     * Compute the immediate dominator of this node.
     * 
     * @return A dominator node. If this node is root, <code>null</code>.
     */
    private Node getDominator(Node target, Set<Node> nodes) {
        if (!nodes.add(target)) {
            return null;
        }

        // check cache
        // We must search a immediate dominator.
        //
        // At first, we can ignore the older incoming nodes.
        List<Node> candidates = new CopyOnWriteArrayList(target.incoming);

        // compute backedges
        for (Node node : candidates) {
            if (target.backedges.contains(node)) {
                candidates.remove(node);
            }
        }

        int size = candidates.size();

        switch (size) {
        case 0: // this is root node
            return null;

        case 1: // only one incoming node
            return candidates.get(0);

        default: // multiple incoming nodes
            Node candidate = candidates.get(0);

            while (true) {
                boolean result = true;

                for (int i = 1; i < size; i++) {
                    if (!hasDominator(candidates.get(i), candidate, nodes)) {
                        result = false;
                        break;
                    }
                }

                if (result) {
                    return candidate;
                } else {
                    if (candidate == null) {
                        return null;
                    }
                    candidate = getDominator(candidate, nodes);
                }
            }
        }
    }

    /**
     * Helper method to check whether the specified node dominate this node or not.
     * 
     * @param dominator A dominator node.
     * @return A result.
     */
    private boolean hasDominator(Node target, Node dominator, Set<Node> nodes) {
        Node current = target;

        while (current != null) {
            if (current == dominator) {
                return true;
            }
            current = getDominator(current, nodes);
        }

        // Not Found
        return false;
    }

    /**
     * @version 2012/11/30 16:09:26
     */
    private static final class Formatter {

        /** The actual buffer. */
        private final StringBuilder builder = new StringBuilder();

        /** The tab length. */
        private final int tab = 8;

        /**
         * Helper method to write message.
         * 
         * @param message
         */
        private void write(String message) {
            builder.append(message);
        }

        /**
         * Helper method to write message.
         * 
         * @param message
         */
        private void write(String message, int max) {
            builder.append(message);

            // calcurate required tab
            int requireTab = 1;

            while (requireTab * tab <= max) {
                requireTab++;
            }

            // calcurate remaining spaces
            int remaining = requireTab * tab - message.length();
            int actualTab = 0;

            while (0 < remaining - tab * actualTab) {
                actualTab++;
            }

            for (int i = 0; i < actualTab; i++) {
                builder.append('\t');
            }
        }

        /**
         * Helper method to write message.
         * 
         * @param message
         */
        private void formatNode(List<Node> nodes, int max) {
            StringBuilder builder = new StringBuilder("[");

            for (int i = 0; i < nodes.size(); i++) {
                builder.append(String.valueOf(nodes.get(i).id));

                if (i != nodes.size() - 1) {
                    builder.append(",");
                }
            }
            builder.append("]");

            write(builder.toString(), max + 2);
        }

        /**
         * Helper method to format code fragment.
         * 
         * @param operands
         */
        private void formatCodeFragment(List<Operand> operands) {
            for (int i = 0; i < operands.size(); i++) {
                Operand operand = operands.get(i);
                builder.append(operand).append(" [").append(type(operand)).append("]");

                if (i != operands.size() - 1) {
                    builder.append(" ");
                }
            }
        }

        /**
         * <p>
         * Helper method to detect type of {@link Operand}.
         * </p>
         * 
         * @param operand
         * @return
         */
        private String type(Operand operand) {
            if (operand instanceof OperandString) {
                return "String";
            } else if (operand instanceof OperandExpression) {
                return "Expression";
            } else if (operand instanceof OperandCondition) {
                return "Condition";
            } else if (operand instanceof OperandArray) {
                return "Array";
            } else if (operand instanceof OperandNumber) {
                return "Number";
            } else if (operand instanceof OperandEnclose) {
                return type(((OperandEnclose) operand).value) + " in Enclose";
            }
            return "";
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return builder.toString();
        }
    }

    /**
     * @version 2013/10/30 14:29:06
     */
    private static final class ClassTracer extends ClassVisitor {

        /** The target method name. */
        private final String method;

        /** The target method signature. */
        private final String descriptor;

        /**
         * The print writer to be used to print the class. May be null.
         */
        private final PrintWriter writer;

        /**
         * The object that actually converts visit events into text.
         */
        public final Printer printer;

        /**
         * Constructs a new {@link TraceClassVisitor}.
         * 
         * @param cv the {@link ClassVisitor} to which this visitor delegates calls. May be
         *            <tt>null</tt>.
         * @param printer the object that actually converts visit events into text.
         * @param writer the print writer to be used to print the class. May be null if you simply
         *            want to use the result via {@link Printer#getText()}, instead of printing it.
         */
        public ClassTracer(String method, String descriptor, Printer printer, PrintWriter writer) {
            super(Opcodes.ASM5, null);

            this.method = method;
            this.descriptor = descriptor;
            this.writer = writer;
            this.printer = printer;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
            if (!method.equals(name) || !descriptor.equals(desc)) {
                return null;
            }

            Printer printer = this.printer.visitMethod(access, name, desc, signature, exceptions);
            MethodVisitor mv = cv == null ? null : cv.visitMethod(access, name, desc, signature, exceptions);
            return new MethodTracer(mv, printer);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitEnd() {
            // printer.visitClassEnd();

            if (writer != null) {
                printer.print(writer);
                writer.flush();
            }
            super.visitEnd();
        }
    }

    /**
     * @version 2013/11/01 11:15:54
     */
    private static class MethodTracer extends MethodVisitor {

        private final Printer printer;

        /**
         * @param mv
         * @param printer
         */
        private MethodTracer(MethodVisitor mv, Printer printer) {
            super(ASM5, mv);

            this.printer = printer;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public AnnotationVisitor visitAnnotation(final String desc, final boolean visible) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitAttribute(final Attribute attr) {
            printer.visitMethodAttribute(attr);
            super.visitAttribute(attr);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public AnnotationVisitor visitAnnotationDefault() {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public AnnotationVisitor visitParameterAnnotation(final int parameter, final String desc, final boolean visible) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitCode() {
            printer.visitCode();
            super.visitCode();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitFrame(final int type, final int nLocal, final Object[] local, final int nStack, final Object[] stack) {
            printer.visitFrame(type, nLocal, local, nStack, stack);
            super.visitFrame(type, nLocal, local, nStack, stack);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitInsn(final int opcode) {
            printer.visitInsn(opcode);
            super.visitInsn(opcode);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitIntInsn(final int opcode, final int operand) {
            printer.visitIntInsn(opcode, operand);
            super.visitIntInsn(opcode, operand);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitVarInsn(final int opcode, final int var) {
            printer.visitVarInsn(opcode, var);
            super.visitVarInsn(opcode, var);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitTypeInsn(final int opcode, final String type) {
            printer.visitTypeInsn(opcode, type);
            super.visitTypeInsn(opcode, type);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitFieldInsn(final int opcode, final String owner, final String name, final String desc) {
            printer.visitFieldInsn(opcode, owner, name, desc);
            super.visitFieldInsn(opcode, owner, name, desc);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitMethodInsn(final int opcode, final String owner, final String name, final String desc) {
            printer.visitMethodInsn(opcode, owner, name, desc);
            super.visitMethodInsn(opcode, owner, name, desc);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {
            printer.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);
            super.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitJumpInsn(final int opcode, final Label label) {
            printer.visitJumpInsn(opcode, label);
            super.visitJumpInsn(opcode, label);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitLabel(final Label label) {
            printer.visitLabel(label);
            super.visitLabel(label);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitLdcInsn(final Object cst) {
            printer.visitLdcInsn(cst);
            super.visitLdcInsn(cst);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitIincInsn(final int var, final int increment) {
            printer.visitIincInsn(var, increment);
            super.visitIincInsn(var, increment);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitTableSwitchInsn(final int min, final int max, final Label dflt, final Label... labels) {
            printer.visitTableSwitchInsn(min, max, dflt, labels);
            super.visitTableSwitchInsn(min, max, dflt, labels);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitLookupSwitchInsn(final Label dflt, final int[] keys, final Label[] labels) {
            printer.visitLookupSwitchInsn(dflt, keys, labels);
            super.visitLookupSwitchInsn(dflt, keys, labels);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitMultiANewArrayInsn(final String desc, final int dims) {
            printer.visitMultiANewArrayInsn(desc, dims);
            super.visitMultiANewArrayInsn(desc, dims);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitTryCatchBlock(final Label start, final Label end, final Label handler, final String type) {
            printer.visitTryCatchBlock(start, end, handler, type);
            super.visitTryCatchBlock(start, end, handler, type);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitLocalVariable(final String name, final String desc, final String signature, final Label start, final Label end, final int index) {
            printer.visitLocalVariable(name, desc, signature, start, end, index);
            super.visitLocalVariable(name, desc, signature, start, end, index);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitLineNumber(final int line, final Label start) {
            printer.visitLineNumber(line, start);
            super.visitLineNumber(line, start);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitMaxs(final int maxStack, final int maxLocals) {
            printer.visitMaxs(maxStack, maxLocals);
            super.visitMaxs(maxStack, maxLocals);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitEnd() {
            printer.visitMethodEnd();
            super.visitEnd();
        }
    }
}
