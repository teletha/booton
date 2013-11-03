/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton;

import java.io.PrintWriter;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.Printer;
import org.objectweb.asm.util.TraceMethodVisitor;

import booton.translator.lambda.LambdaTest;

/**
 * @version 2013/10/24 14:44:43
 */
public class BytecodeDump {

    public static void main(String[] args) throws Exception {
        dump(LambdaTest.class, "base");
    }

    /**
     * <p>
     * Dump all code.
     * </p>
     * 
     * @param type
     * @throws Exception
     */
    private static void dump(Class type) throws Exception {
        ASMifier.main(new String[] {"-debug", type.getName()});
    }

    /**
     * <p>
     * Dump method code.
     * </p>
     * 
     * @param type
     * @param methodName
     * @throws Exception
     */
    private static void dump(Class type, String methodName) throws Exception {
        ClassReader reader = new ClassReader(type.getName());
        reader.accept(new Tracer(methodName, new ASMifier(), new PrintWriter(System.out)), 0);
    }

    /**
     * @version 2013/10/30 14:29:06
     */
    private static final class Tracer extends ClassVisitor {

        private final String method;

        /**
         * The print writer to be used to print the class. May be null.
         */
        private final PrintWriter pw;

        /**
         * The object that actually converts visit events into text.
         */
        public final Printer p;

        /**
         * Constructs a new {@link TraceClassVisitor}.
         * 
         * @param cv the {@link ClassVisitor} to which this visitor delegates calls. May be
         *            <tt>null</tt>.
         * @param p the object that actually converts visit events into text.
         * @param pw the print writer to be used to print the class. May be null if you simply want
         *            to use the result via {@link Printer#getText()}, instead of printing it.
         */
        public Tracer(String method, final Printer p, final PrintWriter pw) {
            super(Opcodes.ASM5, null);

            this.method = method;
            this.pw = pw;
            this.p = p;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
            if (!method.equals(name)) {
                return null;
            }

            Printer p = this.p.visitMethod(access, name, desc, signature, exceptions);
            MethodVisitor mv = cv == null ? null : cv.visitMethod(access, name, desc, signature, exceptions);
            return new TraceMethodVisitor(mv, p);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void visitEnd() {
            p.visitClassEnd();

            if (pw != null) {
                p.print(pw);
                pw.flush();
            }
            super.visitEnd();
        }
    }
}
