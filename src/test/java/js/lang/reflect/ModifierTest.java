/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.reflect;

import static java.lang.reflect.Modifier.*;

import java.lang.reflect.Modifier;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/09/01 22:44:29
 */
@RunWith(ScriptRunner.class)
public class ModifierTest {

    @Test
    public void modifiers() throws Exception {
        assert isPublic(PUBLIC);
        assert isProtected(PROTECTED);
        assert isPrivate(PRIVATE);
        assert isStatic(STATIC);
        assert isAbstract(ABSTRACT);
        assert isFinal(FINAL);
        assert isInterface(INTERFACE);
        assert isNative(NATIVE);
        assert isSynchronized(SYNCHRONIZED);
        assert isStrict(STRICT);
        assert isTransient(TRANSIENT);
        assert isVolatile(VOLATILE);
        assert !isNative(PUBLIC | FINAL | STATIC | SYNCHRONIZED);
    }

    @Test
    public void strnigize() throws Exception {
        assert Modifier.toString(PUBLIC).equals("public");
        assert Modifier.toString(PUBLIC | FINAL).equals("public final");
    }
}
