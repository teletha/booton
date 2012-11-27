/*
 * Copyright (C) 2008 Nameless Production Committee.
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

import static org.objectweb.asm.Opcodes.*;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

/**
 * DOCUMENT.
 * 
 * @version 2008/11/17 12:58:13
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
        // ignore compiler generated method (e.g. generics)
        if ((access & ACC_NATIVE) == 0) {
            if (isFirst) {
                isFirst = false;
            } else {
                code.append(',');
            }

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
