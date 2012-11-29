/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.api;

import static java.nio.charset.StandardCharsets.*;
import static junit.framework.Assert.*;

import java.lang.reflect.Array;
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
import net.sourceforge.htmlunit.corejs.javascript.NativeFunction;
import net.sourceforge.htmlunit.corejs.javascript.NativeObject;
import net.sourceforge.htmlunit.corejs.javascript.Script;
import net.sourceforge.htmlunit.corejs.javascript.ScriptableObject;
import net.sourceforge.htmlunit.corejs.javascript.UniqueTag;

import org.objectweb.asm.Type;

import booton.translator.Javascript;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * @version 2012/11/30 0:26:51
 */
public class CompilableTester {

    /** No parameter. */
    private static final Object NONE = new Object();

    /** The script engine manager. */
    private static Context engine;

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
            engine = client.getJavaScriptEngine().getContextFactory().enterContext();
            global = dummy.getScriptObject();

            // compile boot script
            booton = engine.compileReader(Files.newBufferedReader(I.locate("src/main/resources/boot.js"), UTF_8), "boot.js", 1, null);
            booton.exec(engine, global);
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * <p>
     * Compile specified class and evaluate it.
     * </p>
     * 
     * @param compilable A target compilable source.
     */
    protected final void evaluate(Compilable compilable) {
        evaluate(compilable, Collections.singletonList(NONE));
    }

    /**
     * <p>
     * Compile specified class and evaluate it.
     * </p>
     * 
     * @param compilable A target compilable source.
     */
    private <T> void evaluate(Compilable compilable, List<T> inputs) {
        // search invocation
        Class source = compilable.getClass();
        String constructor = Type.getConstructorDescriptor(source.getDeclaredConstructors()[0]);
        Method method = searchInvocation(source);

        // prepare result store
        List results = new ArrayList();

        // invoke as Java
        try {
            for (T input : inputs) {
                Object result;

                try {
                    if (input == NONE) {
                        result = method.invoke(compilable);
                    } else {
                        result = method.invoke(compilable, input);
                    }
                } catch (InvocationTargetException e) {
                    result = ((InvocationTargetException) e).getTargetException();
                }
                results.add(result);
            }
        } catch (Exception e) {
            throw I.quiet(e);
        }

        // invoke as Javascript
        StringBuilder scriptExpression = new StringBuilder();

        try {
            // compile as Javascript and script engine read it
            engine.evaluateString(global, Javascript.getScript(source).toString(), source.getSimpleName(), 1, null);

            // invoke it and compare result
            for (int i = 0; i < inputs.size(); i++) {
                T input = inputs.get(i);
                String className = Javascript.computeClassName(source);
                String constructorName = Javascript.computeMethodName(source, "<init>", constructor).substring(1);
                String methodName = Javascript.computeMethodName(source, method.getName(), Type.getMethodDescriptor(method));

                // write test script
                StringBuilder invoker = new StringBuilder();
                invoker.append("try {");
                invoker.append("new ").append(className).append("(").append(constructorName).append(").");
                invoker.append(methodName).append("(");
                if (input != NONE) {
                    if (input instanceof String) {
                        invoker.append('"').append(input).append('"');
                    } else {
                        invoker.append(input);
                    }
                }
                invoker.append(");");
                invoker.append("} catch(e) {e}");

                // execute and compare it to the java resul
                assertObject(results.get(i), engine.evaluateString(global, invoker.toString(), "", 1, null));
            }
        } catch (Exception e) {
            System.out.println(scriptExpression);
            throw I.quiet(e);
        }
    }

    /**
     * <p>
     * Search invocation.
     * </p>
     * 
     * @param source
     * @return
     */
    private Method searchInvocation(Class source) {
        // search method
        for (Method method : source.getDeclaredMethods()) {
            if (method.getName().equals("act")) {
                method.setAccessible(true);

                return method;
            }
        }

        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error("Compilable class must implement act method.");
    }

    /**
     * Assert that java object equals to javascript object.
     * 
     * @param java
     * @param js
     */
    private void assertObject(Object java, Object js) {
        if (java == null) {
            assert js instanceof UniqueTag || js == null;
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
                int value = ((Integer) java).intValue();

                if (js instanceof Double) {
                    assertEquals(value, ((Double) js).intValue());
                } else if (js instanceof UniqueTag) {
                    assertEquals(value, 0);
                } else {
                    assertEquals(value, ((Integer) js).intValue());
                }
            } else if (type == Long.class) {
                long value = ((Long) java).longValue();

                if (js instanceof UniqueTag) {
                    assertEquals(value, 0L);
                } else {
                    assertEquals(value, ((Double) js).longValue());
                }
            } else if (type == Float.class) {
                java = new BigDecimal((Float) java).round(new MathContext(3));
                js = new BigDecimal((Double) js).round(new MathContext(3));

                assertEquals(java, js);
            } else if (type == Double.class) {
                java = new BigDecimal((Double) java).round(new MathContext(3));
                js = new BigDecimal((Double) js).round(new MathContext(3));

                assertEquals(java, js);
            } else if (type == Short.class) {
                assertEquals(((Short) java).doubleValue(), (Double) js, 0D);
            } else if (type == Byte.class) {
                assertEquals(((Byte) java).doubleValue(), (Double) js, 0D);
            } else if (type == Boolean.class) {
                if (js instanceof Double) {
                    js = ((Double) js).intValue() != 0;
                }
                assertEquals(((Boolean) java), (Boolean) js);
            } else if (type == String.class) {
                assert js.toString().equals(java);
            } else if (Throwable.class.isAssignableFrom(type)) {
                assertException((Throwable) java, js);
            } else {
                // some object
                System.out.println(js.getClass());
                assertTrue(js instanceof NativeObject);

                NativeObject object = (NativeObject) js;
                System.out.println(Arrays.toString(object.getPrototype().getIds()));

                System.out.println(object.getPrototype().get("constructor", global));

                NativeFunction value = (NativeFunction) object.getPrototype().get("constructor", global);
                System.out.println(value.getFunctionName());

            }
        }
    }

    /**
     * Assert each items in array.
     * 
     * @param java
     * @param js
     */
    private void assertArray(Object java, Object js) {
        assert js instanceof NativeArray;

        NativeArray array = (NativeArray) js;

        // check array size
        assert Array.getLength(java) == array.getLength();

        // check each items
        for (int i = 0; i < array.getLength(); i++) {
            assertObject(Array.get(java, i), array.get(i, global));
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
                assert js.equals("");
            } else {
                assert js.equals(message);
            }
        } else {
            // Some error object was thrown certainly, but we cant check in detail.
        }
    }
}
