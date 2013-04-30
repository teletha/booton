/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.primitive;

import org.junit.Test;

import booton.translator.Debuggable;
import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/04/13 14:40:19
 */
@SuppressWarnings("unused")
public class PrimitiveAndWrapperClassTest extends ScriptTester {

    @Test
    public void IntegerPrimitive() throws Exception {
        test(new Scriptable() {

            Class act() {
                return int.class;
            }
        });
    }

    @Test
    public void IntegerWrapper() throws Exception {
        test(new Scriptable() {

            Class act() {
                return Integer.class;
            }
        });
    }

    @Test
    public void IntegerPrimitiveAndWrapper() throws Exception {
        test(new Scriptable() {

            boolean act() {
                assert Integer.class != int.class;
                return Integer.class == int.class;
            }
        });
    }

    @Test
    public void LongPrimitive() throws Exception {
        test(new Scriptable() {

            Class act() {
                return long.class;
            }
        });
    }

    @Test
    public void LongWrapper() throws Exception {
        test(new Scriptable() {

            Class act() {
                return Long.class;
            }
        });
    }

    @Test
    public void LongPrimitiveAndWrapper() throws Exception {
        test(new Scriptable() {

            boolean act() {
                assert Long.class != long.class;
                return Long.class == long.class;
            }
        });
    }

    @Test
    public void FloatPrimitive() throws Exception {
        test(new Scriptable() {

            Class act() {
                return float.class;
            }
        });
    }

    @Test
    public void FloatWrapper() throws Exception {
        test(new Scriptable() {

            Class act() {
                return Float.class;
            }
        });
    }

    @Test
    public void FloatPrimitiveAndWrapper() throws Exception {
        test(new Scriptable() {

            boolean act() {
                assert Float.class != float.class;
                return Float.class == float.class;
            }
        });
    }

    @Test
    public void DoublePrimitive() throws Exception {
        test(new Scriptable() {

            Class act() {
                return double.class;
            }
        });
    }

    @Test
    public void DoubleWrapper() throws Exception {
        test(new Scriptable() {

            Class act() {
                return Double.class;
            }
        });
    }

    @Test
    public void DoublePrimitiveAndWrapper() throws Exception {
        test(new Scriptable() {

            boolean act() {
                assert Double.class != double.class;
                return Double.class == double.class;
            }
        });
    }

    @Test
    public void ShortPrimitive() throws Exception {
        test(new Scriptable() {

            Class act() {
                return short.class;
            }
        });
    }

    @Test
    public void ShortWrapper() throws Exception {
        test(new Scriptable() {

            Class act() {
                return Short.class;
            }
        });
    }

    @Test
    public void ShortPrimitiveAndWrapper() throws Exception {
        test(new Scriptable() {

            boolean act() {
                assert Short.class != short.class;
                return Short.class == short.class;
            }
        });
    }

    @Test
    public void BytePrimitive() throws Exception {
        test(new Scriptable() {

            Class act() {
                return byte.class;
            }
        });
    }

    @Test
    public void ByteWrapper() throws Exception {
        test(new Scriptable() {

            Class act() {
                return Byte.class;
            }
        });
    }

    @Test
    public void BytePrimitiveAndWrapper() throws Exception {
        test(new Scriptable() {

            boolean act() {
                assert Byte.class != byte.class;
                return Byte.class == byte.class;
            }
        });
    }

    @Test
    public void BooleanPrimitive() throws Exception {
        test(new Scriptable() {

            Class act() {
                return boolean.class;
            }
        });
    }

    @Test
    public void BooleanWrapper() throws Exception {
        test(new Scriptable() {

            Class act() {
                return Boolean.class;
            }
        });
    }

    @Test
    public void BooleanPrimitiveAndWrapper() throws Exception {
        test(new Scriptable() {

            boolean act() {
                assert Boolean.class != boolean.class;
                return Boolean.class == boolean.class;
            }
        });
    }

    @Test
    public void IntegerPrimitiveArray() throws Exception {
        test(new Scriptable() {

            @Debuggable
            Class act() {
                int[] values = new int[1];
                values[0] = 10;
                return values.getClass();
            }
        });
    }
}
