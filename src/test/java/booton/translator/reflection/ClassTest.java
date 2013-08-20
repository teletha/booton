/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.reflection;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/05/06 20:25:44
 */
@SuppressWarnings("unused")
public class ClassTest extends ScriptTester {

    @Test
    public void primitiveInt() throws Exception {
        test(new Scriptable() {

            Class act() throws Exception {
                return int.class;
            }
        });
    }

    @Test
    public void primitiveLong() throws Exception {
        test(new Scriptable() {

            Class act() throws Exception {
                return long.class;
            }
        });
    }

    @Test
    public void primitiveFloat() throws Exception {
        test(new Scriptable() {

            Class act() throws Exception {
                return float.class;
            }
        });
    }

    @Test
    public void primitiveDouble() throws Exception {
        test(new Scriptable() {

            Class act() throws Exception {
                return double.class;
            }
        });
    }

    @Test
    public void primitiveBoolean() throws Exception {
        test(new Scriptable() {

            Class act() throws Exception {
                return boolean.class;
            }
        });
    }

    @Test
    public void primitiveByte() throws Exception {
        test(new Scriptable() {

            Class act() throws Exception {
                return byte.class;
            }
        });
    }

    @Test
    public void primitiveShort() throws Exception {
        test(new Scriptable() {

            Class act() throws Exception {
                return short.class;
            }
        });
    }

    @Test
    public void primitiveChar() throws Exception {
        test(new Scriptable() {

            Class act() throws Exception {
                return char.class;
            }
        });
    }

    @Test
    public void primitiveIntArray() throws Exception {
        test(new Scriptable() {

            Class act() throws Exception {
                return int[].class;
            }
        });
    }

    @Test
    public void primitiveDoubleArray() throws Exception {
        test(new Scriptable() {

            Class act() throws Exception {
                return double[].class;
            }
        });
    }

    @Test
    public void primitiveArrayClassLiteralIsSingleton1() throws Exception {
        test(new Scriptable() {

            boolean act() throws Exception {
                return short[].class == short[].class;
            }
        });
    }

    @Test
    public void primitiveArrayClassLiteralIsSingleton2() throws Exception {
        test(new Scriptable() {

            boolean act() throws Exception {
                boolean[] array = {};
                return array.getClass() == boolean[].class;
            }
        });
    }

    @Test
    public void primitiveArrayClassLiteralIsSingleton3() throws Exception {
        test(new Scriptable() {

            boolean act() throws Exception {
                long[] array = {};
                return array.getClass() == long[].class;
            }
        });
    }

    @Test
    public void object() throws Exception {
        test(new Scriptable() {

            Class act() throws Exception {
                return Object.class;
            }
        });
    }

    @Test
    public void objectClassLiteralIsSingleton() throws Exception {
        test(new Scriptable() {

            boolean act() throws Exception {
                return Parent.class == Parent.class;
            }
        });
    }

    @Test
    public void objectArray() throws Exception {
        test(new Scriptable() {

            Class act() throws Exception {
                return Object[].class;
            }
        });
    }

    @Test
    public void objectArrayClassLiteralIsSingleton() throws Exception {
        test(new Scriptable() {

            boolean act() throws Exception {
                return Parent[].class == Parent[].class;
            }
        });
    }

    @Test
    public void NewInstance() throws Exception {
        test(new Scriptable() {

            int act() throws Exception {
                return Parent.class.newInstance().value;
            }
        });
    }

    @Test
    public void GetMethods() throws Exception {
        test(new Scriptable() {

            int act() throws Exception {
                return Parent.class.getDeclaredMethods().length;
            }
        });
    }

    @Test
    public void GetMethodsOverride() throws Exception {
        test(new Scriptable() {

            int act() throws Exception {
                return Child.class.getDeclaredMethods().length;
            }
        });
    }

    @Test
    public void IsAssignableFrom() throws Exception {
        test(new Scriptable() {

            boolean act() throws Exception {
                return Parent.class.isAssignableFrom(Child.class);
            }
        });
    }

    @Test
    public void IsAssignableFromInvalidClass() throws Exception {
        test(new Scriptable() {

            boolean act() throws Exception {
                return Parent.class.isAssignableFrom(AnyoneElse.class);
            }
        });
    }

    @Test
    public void IsAssignableFromSameClass() throws Exception {
        test(new Scriptable() {

            boolean act() throws Exception {
                return Parent.class.isAssignableFrom(Parent.class);
            }
        });
    }

    @Test
    public void GetSuperclass() throws Exception {
        test(new Scriptable() {

            Class act() throws Exception {
                return Child.class.getSuperclass();
            }
        });
    }

    /**
     * @version 2013/01/18 11:14:22
     */
    public static class Parent {

        private int value = 10;

        public int method() {
            return 1;
        }
    }

    /**
     * @version 2013/01/18 11:14:22
     */
    public static class Child extends Parent {

        @Override
        public int method() {
            return 10;
        }
    }

    /**
     * @version 2013/01/18 23:25:39
     */
    public static class AnyoneElse {

        private int value = 10;

        public int method() {
            return 1;
        }
    }
}
