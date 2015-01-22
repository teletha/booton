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

import static jdk.internal.org.objectweb.asm.Opcodes.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import kiss.I;

/**
 * @version 2015/01/22 11:43:57
 */
class JavaMethodInliner {

    /** The code manager. */
    private static final Map<String, InlineCode> inlines = new HashMap();

    /**
     * @param name
     * @param desc
     * @return
     */
    public static boolean isInlinable(String name, Class type) {
        return name.startsWith("access$") && type == void.class;
    }

    /**
     * @param owner
     * @param methodName
     * @param desc
     */
    public static void inline(Class owner, String methodName, String desc) {
        InlineCode inlined = inlines.computeIfAbsent(owner + "#" + methodName + desc, key -> {
            return new InlineCode(owner, methodName, desc);
        });
    }

    /**
     * @param owner
     * @param methodName
     * @param returnType
     * @param types
     * @return
     */
    public static boolean tryInline(Class owner, String methodName, String methodDescription, Class returnType, Class[] types) {
        // exclude non compiler generated methods
        if (!methodName.startsWith("access$")) {
            return false;
        }

        // exclude methods with return value
        if (returnType != void.class) {
            return false;
        }

        InlineCode inlined = inlines.computeIfAbsent(owner + "#" + methodName + methodDescription, key -> {
            return new InlineCode(owner, methodName, methodDescription);
        });

        return false;
    }

    /**
     * @version 2015/01/22 11:45:26
     */
    private static class InlineCode {

        /**
         * @param owner
         * @param methodName
         * @param methodDescription
         */
        public InlineCode(Class source, String methodName, String methodDescription) {
            try {
                new ClassReader(source.getName()).accept(new InlineClassParser(this, methodName, methodDescription), 0);
            } catch (IOException e) {
                throw I.quiet(e);
            }

        }
    }

    /**
     * @version 2015/01/22 12:22:21
     */
    private static class InlineClassParser extends ClassVisitor {

        /** The code holder. */
        private final InlineCode inline;

        /** The method name. */
        private final String name;

        /** The method description. */
        private final String desc;

        /**
         * @param name
         * @throws IOException
         */
        private InlineClassParser(InlineCode inline, String name, String desc) throws IOException {
            super(ASM5);

            this.inline = inline;
            this.name = name;
            this.desc = desc;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            if (this.name.equals(name) && this.desc.equals(desc)) {
                return new InlineMethodParser(inline);
            }
            return null;
        }
    }

    /**
     * @version 2015/01/22 12:22:21
     */
    private static class InlineMethodParser extends MethodVisitor {

        /**
         * @param name
         * @throws IOException
         */
        private InlineMethodParser(InlineCode inline) {
            super(ASM5);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitFieldInsn(int opcode, String ownerClassName, String name, String desc) {
            System.out.println("visit field " + ownerClassName + " " + name + "  " + desc);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitVarInsn(int opcode, int position) {
            System.out.println("visit var " + position);
        }
    }
}
