/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.dynamic;

import java.lang.reflect.Method;
import java.util.function.Consumer;

import sun.reflect.ConstantPool;

import kiss.I;

/**
 * @version 2015/05/03 13:46:15
 */
class MethodAnalyzer {

    /** The accessible internal method for lambda info. */
    private static final Method findConstants;

    static {
        try {
            // reflect lambda info related methods
            findConstants = Class.class.getDeclaredMethod("getConstantPool");
            findConstants.setAccessible(true);
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    public static String[] findDescription(Consumer methodReference) {
        try {
            ConstantPool constantPool = (ConstantPool) findConstants.invoke(methodReference.getClass());

            // for (int i = 0; i < 30; i++) {
            // try {
            // String[] memberRefInfoAt = constantPool.getMemberRefInfoAt(i);
            // System.out.println(i + " " + Arrays.toString(memberRefInfoAt));
            // } catch (Exception e) {
            //
            // }
            // }

            // MethodInfo
            // [0] : Declared Class Name (internal qualified name)
            // [1] : Method Name
            // [2] : Method Descriptor (internal qualified signature)
            return constantPool.getMemberRefInfoAt(17);
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }
}
