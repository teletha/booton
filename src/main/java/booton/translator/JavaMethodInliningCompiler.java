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
import jdk.internal.org.objectweb.asm.MethodVisitor;

/**
 * @version 2015/01/22 12:07:14
 */
class JavaMethodInliningCompiler extends MethodVisitor {

    /**
     * @param script
     * @param name
     * @param desc
     */
    JavaMethodInliningCompiler(Javascript script, String name, String desc) {
        super(ASM5);

        System.out.println(script.source + "  @@@  " + name + "  " + desc);
    }

}
