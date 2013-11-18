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

import java.lang.reflect.AnnotatedElement;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

import booton.translator.Node.Switch;

/**
 * @version 2013/01/21 15:29:47
 */
class JavaClassCompiler extends ClassVisitor {

    private final static Set<Class> ignores = new HashSet();

    static {
        ignores.add(AnnotatedElement.class);
        ignores.add(Function.class);
    }

    /** The java source(byte) code. */
    private final Javascript script;

    /** The javascript object code. */
    private final ScriptWriter code;

    /**
     * JavaClassCompiler
     * 
     * @param script The java source(byte) code.
     * @param code The javascript object code.
     */
    JavaClassCompiler(Javascript script, ScriptWriter code) {
        super(ASM5);

        this.script = script;
        this.code = code;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        if (!script.source.isInterface()) {
            // In Java, initial value for primitives are defined in Java specification. But in
            // Javascript, initial value (in property) will be "undefined". So we must declare
            // uninitialized primiteve field explicitly.
            //
            // Skip final field, it is assured that the constructor will initialize it.
            // Skip javascript native class, we have no permission to modify its prototype.
            if ((access & ACC_FINAL) == 0) {
                name = Javascript.computeFieldName(script.source, name);

                if ((access & ACC_STATIC) != 0) {
                    name = "_" + name;
                }

                switch (desc) {
                case "I": // int
                case "J": // long
                case "F": // float
                case "D": // double
                case "B": // byte
                case "S": // short
                    code.append(name, ":0").separator();
                    break;

                case "C": // char
                    code.append(name, ":").string("\0").separator();
                    break;

                case "Z": // boolean
                    code.append(name, ":false").separator();
                    break;
                }
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        // ignore serializable related methods and file system related methods
        if (TranslatorManager.isIgnorableMethod(name, desc)) {
            return null;
        }

        // ignore compiler generated method (e.g. ygenerics)
        if ((access & (ACC_NATIVE | ACC_ABSTRACT)) != 0) {
            return null;
        }

        if (script.source.isInterface() && !ignores.contains(script.source) && script.source.getName()
                .startsWith("java.")) {
            // System.out.println(script.source + "#" + name);
            return null;
        }

        if (script.source == AnnotatedElement.class && !name.equals("isAnnotationPresent")) {
            return null;
        }

        // ignore compiler generated method for enum switch
        if (Switch.isEnumSwitchTable(name, desc)) {
            return null;
        }

        // debug code
        code.debug(script.source, name, desc);

        // static modifier
        boolean isStatic = (access & ACC_STATIC) != 0;

        // compute method name
        String computed = Javascript.computeMethodName(script.source, name, desc);

        if (isStatic) {
            computed = "_" + computed;
        }

        // start compiling method
        return new JavaMethodCompiler(script, code, name, computed, desc, isStatic);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitEnd() {
        code.optimize();
    }
}
