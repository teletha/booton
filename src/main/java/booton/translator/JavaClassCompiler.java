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

import static org.objectweb.asm.Opcodes.*;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

/**
 * @version 2012/12/03 1:31:30
 */
class JavaClassCompiler extends ClassVisitor {

    /** The java source(byte) code. */
    private final Javascript script;

    /** The javascript object code. */
    private final ScriptBuffer code;

    private boolean isFirst = true;

    /**
     * JavaClassCompiler
     * 
     * @param script The java source(byte) code.
     * @param code The javascript object code.
     */
    JavaClassCompiler(Javascript script, ScriptBuffer code) {
        super(ASM4);

        this.script = script;
        this.code = code;
    }

    /**
     * @see org.objectweb.asm.ClassVisitor#visit(int, int, java.lang.String, java.lang.String,
     *      java.lang.String, java.lang.String[])
     */
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        // do nothing
    }

    /**
     * @see org.objectweb.asm.ClassVisitor#visitEnd()
     */
    public void visitEnd() {
        // do nothing
    }

    /**
     * @see org.objectweb.asm.ClassVisitor#visitAnnotation(java.lang.String, boolean)
     */
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        return null; // do nothing
    }

    /**
     * @see org.objectweb.asm.ClassVisitor#visitAttribute(org.objectweb.asm.Attribute)
     */
    public void visitAttribute(Attribute attribute) {
        // do nothing
    }

    /**
     * @see org.objectweb.asm.ClassVisitor#visitField(int, java.lang.String, java.lang.String,
     *      java.lang.String, java.lang.Object)
     */
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        return null; // do nothing
    }

    /**
     * @see org.objectweb.asm.ClassVisitor#visitInnerClass(java.lang.String, java.lang.String,
     *      java.lang.String, int)
     */
    public void visitInnerClass(String name, String outerName, String innerName, int access) {
        // do nothing
    }

    /**
     * @see org.objectweb.asm.ClassVisitor#visitMethod(int, java.lang.String, java.lang.String,
     *      java.lang.String, java.lang.String[])
     */
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        // ignore serializable related methods
        if (name.equals("writeObject") && desc.equals("(Ljava/io/ObjectOutputStream;)V")) {
            return null;
        }

        if (name.equals("readObject") && desc.equals("(Ljava/io/ObjectInputStream;)V")) {
            return null;
        }

        // ignore compiler generated method (e.g. generics)
        if ((access & (ACC_NATIVE | ACC_ABSTRACT)) == 0) {
            if (isFirst) {
                isFirst = false;
            } else {
                code.append(',');
            }
            System.out.println(script.source + "   " + name);
            return new JavaMethodCompiler(script, code, (access & ACC_STATIC) == 0, name, desc);
        }

        // API definition
        return null;
    }

    /**
     * @see org.objectweb.asm.ClassVisitor#visitOuterClass(java.lang.String, java.lang.String,
     *      java.lang.String)
     */
    public void visitOuterClass(String owner, String name, String desc) {
        // do nothing
    }

    /**
     * @see org.objectweb.asm.ClassVisitor#visitSource(java.lang.String, java.lang.String)
     */
    public void visitSource(String source, String debug) {
        // do nothing
    }
}
