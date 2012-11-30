/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import static java.nio.charset.StandardCharsets.*;
import static junit.framework.Assert.*;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.MathContext;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import kiss.I;
import net.sourceforge.htmlunit.corejs.javascript.Context;
import net.sourceforge.htmlunit.corejs.javascript.NativeArray;
import net.sourceforge.htmlunit.corejs.javascript.Script;
import net.sourceforge.htmlunit.corejs.javascript.ScriptableObject;
import net.sourceforge.htmlunit.corejs.javascript.UniqueTag;

import org.objectweb.asm.Type;

import booton.translator.api.BooleanScript;
import booton.translator.api.DoubleScript;
import booton.translator.api.IntScript;
import booton.translator.api.LogicalExpressionScript;
import booton.translator.api.ObjectScript;
import booton.translator.api.ShortScript;
import booton.translator.api.ThrowableScript;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * @version 2012/11/30 12:42:56
 */
public class ScriptTranslatorTestcase {

    /** The script engine manager. */
    private static Context context;

    /** The global scope. */
    private static ScriptableObject global;

    /** The compiled booton script. */
    private static Script booton;

    // initialization
    static {
        try {
            // build client
            WebClient client = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);

            // build dummy page
            HtmlPage dummy = (HtmlPage) client.getPage(I.locate("src/test/resources/empty.html").toUri().toURL());

            // build script engine
            context = client.getJavaScriptEngine().getContextFactory().enterContext();

            global = dummy.getScriptObject();

            // define console
            String[] names = {"log"};
            global.defineFunctionProperties(names, ScriptTranslatorTestcase.class, ScriptableObject.DONTENUM);

            // compile boot script
            booton = context.compileReader(Files.newBufferedReader(I.locate("src/main/resources/boot.js"), UTF_8), "boot.js", 1, null);
            // booton = context.compileReader(new
            // FileReader(I.locate("src/main/javascript/booton.js").toFile()), "booton.js", 1,
            // null);

        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * @param script
     */
    protected void test(ShortScript script) {
        test((short) -2, (short) 2, script);
    }

    /**
     * @param script
     * @param start
     * @param end
     */
    protected void test(short start, short end, ShortScript script) {
        // check range
        if (end <= start) {
            throw new IllegalArgumentException("The end parameter must be greater than start parameter.");
        }

        // build inputs
        List<Short> inputs = new ArrayList();

        for (short i = 0; i <= end - start; i++) {
            inputs.add(Integer.valueOf(start + i).shortValue());
        }

        // delegate
        assertScript(inputs, script);
    }

    /**
     * @param script
     */
    protected void test(IntScript script) {
        test(-2, 2, script);
    }

    /**
     * @param script
     * @param start
     * @param end
     */
    protected void test(int start, int end, IntScript script) {
        // check range
        if (end <= start) {
            throw new IllegalArgumentException("The end parameter must be greater than start parameter.");
        }

        // build inputs
        List<Integer> inputs = new ArrayList();

        for (int i = 0; i <= end - start; i++) {
            inputs.add(start + i);
        }

        // delegate
        assertScript(inputs, script);
    }

    /**
     * @param script
     */
    protected void test(DoubleScript script) {
        test(-2, 2, script);
    }

    /**
     * @param script
     * @param start
     * @param end
     */
    protected void test(double start, double end, DoubleScript script) {
        // check range
        if (end <= start) {
            throw new IllegalArgumentException("The end parameter must be greater than start parameter.");
        }

        // build inputs
        List<Double> inputs = new ArrayList();

        for (double i = 0; i <= end - start; i++) {
            inputs.add(start + i);
        }

        // delegate
        assertScript(inputs, script);
    }

    /**
     * @param script
     * @param start
     * @param end
     */
    protected void test(BooleanScript script) {
        assertScript(Arrays.asList(true, false), script);
    }

    /**
     * @param script
     */
    protected void assertScript(LogicalExpressionScript script) {
        assertScript(-2, 2, script);
    }

    /**
     * @param script
     * @param start
     * @param end
     */
    protected void assertScript(int start, int end, LogicalExpressionScript script) {
        // check range
        if (end <= start) {
            throw new IllegalArgumentException("The end parameter must be greater than start parameter.");
        }

        // build inputs
        List<Integer> inputs = new ArrayList();

        for (int i = 0; i <= end - start; i++) {
            inputs.add(start + i);
        }

        // delegate
        assertScript(inputs, script);
    }

    /**
     * @param script
     */
    protected <T> void test(ObjectScript<T> script) {
        test((T) null, script);
    }

    /**
     * @param start
     * @param end
     * @param script
     */
    protected <T> void test(T input, ObjectScript<T> script) {
        assertScript(Collections.singletonList(input), script);
    }

    /**
     * @param script
     */
    protected <T> void assertScript(ThrowableScript<T> script) {
        assertScript((T) null, script);
    }

    /**
     * @param start
     * @param end
     * @param script
     */
    protected <T> void assertScript(T input, ThrowableScript<T> script) {
        assertScript(Collections.singletonList(input), script);
    }

    /**
     * @param <T>
     * @param inputs
     * @param script
     */
    private <T> void assertScript(List<T> inputs, Object script) {
        // prepare result store
        List results = new ArrayList();

        Class source = script.getClass();
        Constructor constructor = null;
        Method execute = null;

        // execute as Java
        try {
            // search constructor
            constructor = script.getClass().getDeclaredConstructors()[0];

            // search method
            Method[] methods = script.getClass().getMethods();

            for (Method method : methods) {
                if (method.getName().equals("act")) {
                    execute = method;
                    execute.setAccessible(true);
                    break;
                }
            }

            // invoke it and store result
            for (T input : inputs) {
                try {
                    results.add(execute.invoke(script, input));
                } catch (InvocationTargetException e) {
                    results.add(((InvocationTargetException) e).getTargetException());
                }
            }
        } catch (Exception e) {
            throw I.quiet(e);
        }

        // execute as Javascript
        StringBuilder scriptExpression = new StringBuilder();

        try {
            Javascript.getScript(script.getClass()).writeAll(scriptExpression);

            booton.exec(context, global);
            context.evaluateString(global, scriptExpression.toString(), script.getClass().getSimpleName(), 1, null);

            // invoke it and compare result
            for (int i = 0; i < inputs.size(); i++) {
                StringBuilder builder = new StringBuilder();
                builder.append("try {");
                builder.append("new ");
                builder.append(Javascript.computeClassName(source));
                builder.append("(");
                builder.append(Javascript.computeMethodName(source, "<init>", Type.getConstructorDescriptor(constructor))
                        .substring(1));
                builder.append(").");
                builder.append(Javascript.computeMethodName(source, "act", Type.getMethodDescriptor(execute)));
                builder.append("(");

                if (inputs.get(i) instanceof String) {
                    builder.append("\"").append(inputs.get(i)).append("\"");
                } else {
                    builder.append(inputs.get(i));
                }
                builder.append(");");
                builder.append("} catch(e) {e}");

                // execute and compare it to the java result
                assertObject(results.get(i), context.evaluateString(global, builder.toString(), "", 1, null));
            }
        } catch (Exception e) {
            System.out.println(scriptExpression);
            throw I.quiet(e);
        }
    }

    /**
     * Assert each items in array.
     * 
     * @param java
     * @param js
     */
    private void assertArray(Object java, Object js) {
        assertTrue(js instanceof NativeArray);

        NativeArray array = (NativeArray) js;

        // check array size
        assertEquals(Array.getLength(java), array.getLength());

        // check each items
        for (int i = 0; i < array.getLength(); i++) {
            assertObject(Array.get(java, i), array.get(i, global));
        }
    }

    /**
     * Assert that java object equals to javascript object.
     * 
     * @param java
     * @param js
     */
    private void assertObject(Object java, Object js) {
        if (java == null) {
            assertTrue(js instanceof UniqueTag || js == null);
        } else {
            if (js.getClass().getSimpleName().equals("NativeError")) {
                // Internal javascript error was thrown (e.g. invalid syntax error, property was not
                // found). So we must report as error for developer's feedback.
                throw new RuntimeException(js.toString());
            }

            Class type = java.getClass();

            if (type.isArray()) {
                assertArray(java, js);
            } else if (type == Integer.class) {
                // ========================
                // INT
                // ========================
                int value = ((Integer) java).intValue();

                if (js instanceof Double) {
                    assert value == ((Double) js).intValue();
                } else if (js instanceof UniqueTag) {
                    assert value == 0;
                } else {
                    assert value == ((Integer) js).intValue();
                }
            } else if (type == Long.class) {
                // ========================
                // LONG
                // ========================
                long value = ((Long) java).longValue();

                if (js instanceof UniqueTag) {
                    assert value == 0L;
                } else {
                    assert value == ((Double) js).longValue();
                }
            } else if (type == Float.class) {
                // ========================
                // FLOAT
                // ========================
                java = new BigDecimal((Float) java).round(new MathContext(3));
                js = new BigDecimal((Double) js).round(new MathContext(3));

                assert java.equals(js);
            } else if (type == Double.class) {
                // ========================
                // DOUBLE
                // ========================
                java = new BigDecimal((Double) java).round(new MathContext(3));
                js = new BigDecimal((Double) js).round(new MathContext(3));

                assert java.equals(js);
            } else if (type == Short.class) {
                // ========================
                // SHORT
                // ========================
                assert ((Short) java).doubleValue() == ((Double) js).doubleValue();
            } else if (type == Byte.class) {
                // ========================
                // BYTE
                // ========================
                assert ((Byte) java).doubleValue() == ((Double) js).doubleValue();
            } else if (type == Boolean.class) {
                // ========================
                // BOOLEAN
                // ========================
                if (js instanceof Double) {
                    js = ((Double) js).intValue() != 0;
                }
                assert java.equals(js);
            } else if (type == String.class) {
                // ========================
                // STRING
                // ========================
                assert js.toString().equals(java);
            } else if (type == Character.class) {
                // ========================
                // CHARACTER
                // ========================
                if (js instanceof Double) {
                    // numeric characters (i.e. 0, 1, 2...)
                    js = Character.valueOf((char) (((Double) js).intValue() + 48));
                }
                assert ((Character) java).toString().equals(js.toString());
            } else if (Throwable.class.isAssignableFrom(type)) {
                // ========================
                // THROWABLE
                // ========================
                assertException((Throwable) java, js);
            } else {
                // some object

                // If this exception will be thrown, it is bug of this program. So we must rethrow
                // the wrapped error in here.
                throw new Error(js.getClass() + " " + java.getClass() + "  " + java + "  " + js);
            }
        }
    }

    /**
     * Assert the specified javascript object is exception.
     * 
     * @param exception
     * @param js
     */
    private void assertException(Throwable exception, Object js) {
        // An expected error (not native Error object) was thrown. This is successful.
        if (js instanceof String) {
            String message = exception.getMessage();

            if (message == null) {
                assertEquals("", js);
            } else {
                assertEquals(message, js);
            }
        } else {
            // Some error object was thrown certainly, but we cant check in detail.
        }
    }

    public static void log(String message) {
        System.out.println(message);
    }
}
