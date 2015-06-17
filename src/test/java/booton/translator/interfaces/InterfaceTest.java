/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.interfaces;

import org.junit.Test;

import booton.soeur.ScriptTester;
import booton.soeur.Scriptable;

/**
 * @version 2012/12/05 11:09:45
 */
@SuppressWarnings("unused")
public class InterfaceTest extends ScriptTester {

    @Test
    public void singleInterfaceMethod() throws Exception {
        test(new Scriptable() {

            String act() {
                Interface1 byInterface = new Class1();

                return byInterface.interfaceMethod();
            }
        });
    }

    /**
     * @version 2012/12/04 9:59:51
     */
    private static interface Interface1 {

        String interfaceMethod();
    }

    /**
     * @version 2012/12/05 10:46:21
     */
    private static class Class1 implements Interface1 {

        @Override
        public String interfaceMethod() {
            return "Class1";
        }
    }

    @Test
    public void multipleInterfaceMethods() throws Exception {
        test(new Scriptable() {

            String act() {
                Interface2 byInterface = new Class2();

                return byInterface.interfaceMethod();
            }
        });

        test(new Scriptable() {

            String act() {
                Interface2 byInterface = new Class2();

                return byInterface.anotherInterfaceMethod();
            }
        });
    }

    /**
     * @version 2012/12/04 9:59:51
     */
    private static interface Interface2 {

        String interfaceMethod();

        String anotherInterfaceMethod();
    }

    /**
     * @version 2012/12/05 10:49:31
     */
    private static class Class2 implements Interface2 {

        @Override
        public String interfaceMethod() {
            return "Class2";
        }

        @Override
        public String anotherInterfaceMethod() {
            return "Class2 Another";
        }
    }

    @Test
    public void sameInterfaceMethod() throws Exception {
        test(new Scriptable() {

            String act() {
                Interface1 byInterface = new Class3();

                return byInterface.interfaceMethod();
            }
        });

        test(new Scriptable() {

            String act() {
                Interface2 byInterface = new Class3();

                return byInterface.interfaceMethod();
            }
        });

        test(new Scriptable() {

            String act() {
                Interface2 byInterface = new Class3();

                return byInterface.anotherInterfaceMethod();
            }
        });
    }

    /**
     * @version 2012/12/05 10:52:26
     */
    public static class Class3 implements Interface1, Interface2 {

        @Override
        public String anotherInterfaceMethod() {
            return "Another";
        }

        @Override
        public String interfaceMethod() {
            return "Same";
        }
    }

    @Test
    public void shadowInterfaceMethod() throws Exception {
        test(new Scriptable() {

            String act() {
                Interface1 byInterface = new Child();

                return byInterface.interfaceMethod();
            }
        });
    }

    /**
     * @version 2012/12/05 10:54:46
     */
    private static class NotInterface {

        public String classMethod() {
            return "Class";
        }

        public String interfaceMethod() {
            return "NotInterface";
        }
    }

    /**
     * @version 2012/12/05 10:54:46
     */
    private static class Child extends NotInterface implements Interface1 {

        public String childMethod() {
            return "Child";
        }
    }
}
