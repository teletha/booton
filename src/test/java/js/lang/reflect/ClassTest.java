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
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import org.junit.Ignore;
import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/08/02 22:51:26
 */
@SuppressWarnings("unused")
public class ClassTest extends ScriptTester {

    @Test
    public void modifierPrivate() throws Exception {
        test(new Scriptable() {

            int act() {
                int modifier = Private.class.getModifiers();
                assert Modifier.isPrivate(modifier);

                return modifier;
            }
        });
    }

    @Test
    public void modifierPackage() throws Exception {
        test(new Scriptable() {

            int act() {
                int modifier = Package.class.getModifiers();
                assert !Modifier.isPrivate(modifier);
                assert !Modifier.isProtected(modifier);
                assert !Modifier.isPublic(modifier);

                return modifier;
            }
        });
    }

    @Test
    public void modifierProtected() throws Exception {
        test(new Scriptable() {

            int act() {
                int modifier = Protected.class.getModifiers();
                assert Modifier.isProtected(modifier);

                return modifier;
            }
        });
    }

    @Test
    public void modifierPublic() throws Exception {
        test(new Scriptable() {

            int act() {
                int modifier = Public.class.getModifiers();
                assert Modifier.isPublic(modifier);

                return modifier;
            }
        });
    }

    /**
     * @version 2013/08/03 0:25:14
     */
    private static class Private {
    }

    /**
     * @version 2013/08/03 0:25:14
     */
    static class Package {
    }

    /**
     * @version 2013/08/03 0:25:14
     */
    protected static class Protected {
    }

    /**
     * @version 2013/08/03 0:25:14
     */
    public static class Public {
    }

    @Test
    public void superClass1() throws Exception {
        test(new Scriptable() {

            Class act() {
                return Child.class.getSuperclass();
            }
        });
    }

    @Test
    public void superClass2() throws Exception {
        test(new Scriptable() {

            Class act() {
                return Parent.class.getSuperclass();
            }
        });
    }

    @Test
    public void superClass3() throws Exception {
        test(new Scriptable() {

            Class act() {
                return Object.class.getSuperclass();
            }
        });
    }

    /**
     * @version 2013/08/03 2:49:26
     */
    private static class Parent {
    }

    /**
     * @version 2013/08/03 2:49:45
     */
    private static class Child extends Parent {
    }

    @Test
    @Ignore
    public void genericSuperClass1() throws Exception {
        test(new Scriptable() {

            int act() {
                Type type = TypeVariableChild.class.getGenericSuperclass();
                assert type != null;
                assert type instanceof TypeVariable;

                return 1;
            }
        });
    }

    /**
     * @version 2013/08/03 2:49:26
     */
    private static class TypeVariableParent<T> {
    }

    /**
     * @version 2013/08/03 2:49:45
     */
    private static class TypeVariableChild extends TypeVariableParent<Parent> {
    }
}
