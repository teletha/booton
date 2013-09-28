/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.flow;

import static java.lang.reflect.Modifier.*;

import java.lang.reflect.Method;

import kiss.model.ClassUtil;

import org.junit.Ignore;
import org.junit.Test;

import booton.Person;
import booton.translator.Debuggable;
import booton.translator.Param;
import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/09/26 10:31:14
 */
@SuppressWarnings("unused")
public class ForTest extends ScriptTester {

    @Test
    public void normal() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                for (int i = 0; i < 3; i++) {
                    value++;
                }

                return value;
            }
        });
    }

    @Test
    public void withoutInitialize() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                int i = 0;
                value++;

                for (; i < 3; i++) {
                    value++;
                }

                return value;
            }
        });
    }

    @Test
    public void withoutUpdate() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 10) int value) {
                for (int i = 0; i < 8;) {
                    i = value;
                    value += 2;

                    if (value == 5) {
                        break;
                    }
                }

                return value;
            }
        });
    }

    @Test
    public void afterProcess() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                String name = "act";

                for (int i = 0; i < name.length(); i++) {
                    value++;
                }

                return value;
            }
        });
    }

    @Test
    public void noneReturnCodeAfterLoopWillConfuseCompiler() throws Exception {
        test(new Scriptable() {

            String act() {
                int m = 0;

                for (int i = 0; i < 3; i++) {
                    m++;
                }
                String.valueOf(m); // noise

                return String.valueOf(m);
            }
        });
    }

    @Test
    public void breakNoLabel() {
        test(new Scriptable() {

            public int act(@Param(from = 8, to = 10) int value) {
                for (int i = 0; i < 3; i++) {
                    value++;

                    if (value == 10) {
                        value--;
                        break;
                    }
                }
                return value;
            }
        });
    }

    @Test
    public void continueNoLabel() {
        test(new Scriptable() {

            public int act(@Param(from = 8, to = 10) int value) {
                for (int i = 0; i < 3; i++) {
                    value++;

                    if (value == 10) {
                        continue;
                    }
                    value++;
                }
                return value;
            }
        });
    }

    @Test
    public void continueNest() throws Exception {
        test(new Scriptable() {

            int act(int value) {
                root: for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (i == 1) {
                            continue root;
                        }
                    }
                    value++;
                }
                return value;
            }
        });
    }

    @Test
    public void continueWithLogicalExpression() throws Exception {
        test(new Scriptable() {

            @Debuggable
            int act(int value) {
                for (int i = 0; i < 3; i++) {
                    value++;

                    if (i == -1 || value % 5 == 0) {
                        continue;
                    }
                    value++;
                }
                return value;
            }
        });
    }

    @Test
    @Ignore
    public void continueMultiple() throws Exception {
        test(new Scriptable() {

            @Debuggable
            int act() {
                int value = 0;

                for (Class clazz : ClassUtil.getTypes(Person.class)) {
                    for (Method method : clazz.getDeclaredMethods()) {
                        // exclude the method which modifier is final, static, private or native
                        if (((STATIC | PRIVATE | NATIVE) & method.getModifiers()) != 0) {
                            continue;
                        }

                        // exclude the method which is created by compiler
                        if (method.isBridge() || method.isSynthetic()) {
                            continue;
                        }
                        System.out.println("@@@@@@@@@@@");
                        // if (method.getAnnotations().length != 0) {
                        // intercepts.add(method);
                        // }

                        int length = 1;
                        String prefix = "set";
                        String name = method.getName();

                        if (method.getGenericReturnType() != Void.TYPE) {
                            length = 0;
                            prefix = name.charAt(0) == 'i' ? "is" : "get";
                        }

                        // exclude the method (by name)
                        if (name.length() <= prefix.length() || !name.startsWith(prefix) || Character.isLowerCase(name.charAt(prefix.length()))) {
                            continue;
                        }

                        // exclude the method (by parameter signature)
                        if (method.getGenericParameterTypes().length != length) {
                            continue;
                        }
                        value++;
                    }
                }
                return value;
            }
        });
    }
}
