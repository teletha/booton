/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import booton.translator.Translator;
import kiss.I;

/**
 * @version 2014/09/13 9:44:24
 */
class LocalId {

    /** The class name. */
    private static final String CLASS = StructureDSL.class.getName();

    /**
     * <p>
     * Generate local id.
     * </p>
     * 
     * @return A generated local id.
     */
    static final int generate() {
        Error error = new Error();
        StackTraceElement[] elements = error.getStackTrace();

        for (int i = 0; i < elements.length; i++) {
            StackTraceElement e = elements[i];
            StackTraceElement n = elements[i + 1];

            if (e.getClassName().startsWith(CLASS) && !n.getClassName().startsWith(CLASS)) {
                return elements[i + 1].getLineNumber();
            }
        }

        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * <p>
     * Find line number of the current context.
     * </p>
     */
    static int findContextLineNumber() {
        Error error = new Error();
        StackTraceElement[] elements = error.getStackTrace();

        for (int i = 0; i < elements.length; i++) {
            StackTraceElement e = elements[i];
            StackTraceElement n = elements[i + 1];

            if (e.getClassName().startsWith(CLASS) && !n.getClassName().startsWith(CLASS)) {
                LineInfo info = LineInfo.of(n.getClassName());

                return info.lines.getOrDefault(n.getLineNumber(), 0);
            }
        }

        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * @version 2014/10/08 12:07:42
     */
    private static class LineInfo {

        /** The cache of {@link LineInfo}. */
        private static final Map<String, LineInfo> infos = new HashMap();

        /** The line mapping. */
        private final Map<Integer, Integer> lines = new HashMap();

        /**
         * @param className
         */
        private LineInfo(String className) {
            try {
                ClassLineSearch search = new ClassLineSearch(lines);
                ClassReader reader = new ClassReader(className);
                reader.accept(search, ClassReader.SKIP_FRAMES);
            } catch (Exception e) {
                throw I.quiet(e);
            }
        }

        /**
         * <p>
         * Find {@link LineInfo} by class name.
         * </p>
         * 
         * @param className
         * @return
         */
        private static LineInfo of(String className) {
            LineInfo info = infos.get(className);

            if (info == null) {
                info = new LineInfo(className);
                infos.put(className, info);
            }
            return info;
        }
    }

    /**
     * @version 2014/10/08 11:28:33
     */
    private static class ClassLineSearch extends ClassVisitor {

        /** The line mapping. */
        private final Map<Integer, Integer> lines;

        /**
         * 
         */
        private ClassLineSearch(Map<Integer, Integer> lines) {
            super(ASM5);

            this.lines = lines;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            return new MethodLineSearch(lines);
        }
    }

    /**
     * @version 2014/10/08 11:31:02
     */
    private static class MethodLineSearch extends MethodVisitor {

        /** Reusable type. */
        private static final Type Declarables = Type.getType(StructureDSL.class);

        /** The line mapping. */
        private final Map<Integer, Integer> lines;

        /** The latest line number. */
        private int latestLineNumber;

        /** The latest {@link VirtualStructure} field access line number. */
        private int latestFieldAccessLineNumber;

        /**
         * 
         */
        private MethodLineSearch(Map<Integer, Integer> lines) {
            super(ASM5);

            this.lines = lines;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitFieldInsn(int opcode, String owner, String name, String desc) {
            if (opcode == GETFIELD && owner.equals(Declarables.getInternalName())) {
                this.latestFieldAccessLineNumber = latestLineNumber;
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitLineNumber(int line, Label start) {
            this.latestLineNumber = line;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean interfaceOwner) {
            if (owner.startsWith(Declarables.getInternalName())) {
                lines.put(latestLineNumber, latestFieldAccessLineNumber);
            }
        }
    }

    /**
     * @version 2014/09/13 9:36:39
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<LocalId> {

        /**
         * <p>
         * Generate local id.
         * </p>
         * 
         * @return A generated local id.
         */
        public String generate() {
            return "0";
        }

        /**
         * <p>
         * Find line number of the current context.
         * </p>
         */
        public String findContextLineNumber() {
            return "0";
        }
    }
}
