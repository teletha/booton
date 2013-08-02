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

import java.lang.reflect.Modifier;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/08/03 0:42:29
 */
@SuppressWarnings("unused")
public class ModifierTest extends ScriptTester {

    @Test
    public void Public() throws Exception {
        test(new Scriptable() {

            boolean act() {
                return Modifier.isPublic(Modifier.PUBLIC);
            }
        });
    }

    @Test
    public void Protected() throws Exception {
        test(new Scriptable() {

            boolean act() {
                return Modifier.isProtected(Modifier.PROTECTED);
            }
        });
    }

    @Test
    public void Private() throws Exception {
        test(new Scriptable() {

            boolean act() {
                return Modifier.isPrivate(Modifier.PRIVATE);
            }
        });
    }

    @Test
    public void Static() throws Exception {
        test(new Scriptable() {

            boolean act() {
                return Modifier.isStatic(Modifier.STATIC);
            }
        });
    }

    @Test
    public void Abstract() throws Exception {
        test(new Scriptable() {

            boolean act() {
                return Modifier.isAbstract(Modifier.ABSTRACT);
            }
        });
    }

    @Test
    public void Final() throws Exception {
        test(new Scriptable() {

            boolean act() {
                return Modifier.isFinal(Modifier.FINAL);
            }
        });
    }

    @Test
    public void Interface() throws Exception {
        test(new Scriptable() {

            boolean act() {
                return Modifier.isInterface(Modifier.INTERFACE);
            }
        });
    }

    @Test
    public void ToString() throws Exception {
        test(new Scriptable() {

            String act() {
                return Modifier.toString(Modifier.PUBLIC);
            }
        });
    }
}
