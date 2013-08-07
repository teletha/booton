/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import static java.nio.charset.StandardCharsets.*;

import java.lang.annotation.Annotation;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import kiss.I;
import net.sourceforge.htmlunit.corejs.javascript.ConsString;
import net.sourceforge.htmlunit.corejs.javascript.EvaluatorException;
import net.sourceforge.htmlunit.corejs.javascript.NativeArray;
import net.sourceforge.htmlunit.corejs.javascript.NativeObject;
import net.sourceforge.htmlunit.corejs.javascript.Undefined;
import net.sourceforge.htmlunit.corejs.javascript.UniqueTag;
import booton.live.ClientStackTrace;
import booton.live.ClientStackTrace2;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine;

/**
 * @version 2013/08/03 20:53:27
 */
public class ScriptTester {

    /** The line feed. */
    private static final String END = "\r\n";

    /** No parameter. */
    private static final Object NONE = new Object();

    /** The testable client. */
    private static WebClient client;

    /** The dummy page for test. */
    private static HtmlPage html;

    /** The javascript runtime. */
    private static JavaScriptEngine engine;

    /** The defined classes. */
    private static Set<Class> defined = new HashSet();

    static {
        try {
            // build client
            client = new WebClient(BrowserVersion.FIREFOX_17);
            client.getWebConsole().setLogger(new Debugger());

            // build dummy page
            html = (HtmlPage) client.getPage(I.locate("src/test/resources/empty.html").toUri().toURL());

            // build script engine
            engine = client.getJavaScriptEngine();

            // compile and load boot script
            engine.execute(html, engine.compile(html, new String(Files.readAllBytes(I.locate("boot.js")), UTF_8), "boot.js", 1));
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * Hide constructor.
     */
    protected ScriptTester() {
    }

    /**
     * <p>
     * Compile specified class and evaluate it.
     * </p>
     * 
     * @param scriptable A target scriptable source.
     */
    protected final void test(Scriptable scriptable) {
        execute(searchInvocation(scriptable.getClass()));
    }

    /**
     * <p>
     * Compile specified class and evaluate it.
     * </p>
     * 
     * @param scriptable A target scriptable source.
     */
    final void execute(Method method) {
        // search invocation
        Class source = method.getDeclaringClass();
        Constructor constructor = searchInstantiator(source);
        Object[] parameter = constructor.getParameterTypes().length == 0 ? new Object[0] : new Object[] {this};

        // prepare input and result store
        List inputs = prepareInputs(method);
        List results = new ArrayList();

        // invoke as Java
        try {
            for (Object input : inputs) {
                Object result;

                // create scriptable instance for each tests
                Object instance = constructor.newInstance(parameter);

                try {
                    if (input == NONE) {
                        result = method.invoke(instance);
                    } else {
                        result = method.invoke(instance, input);
                    }
                } catch (InvocationTargetException e) {
                    throw I.quiet(((InvocationTargetException) e).getTargetException());
                }
                results.add(result);
            }
        } catch (Exception e) {
            throw I.quiet(e);
        }

        StringBuilder script = new StringBuilder();

        // invoke as Javascript
        Javascript.getScript(source).writeTo(script, defined, Character.class);

        try {
            // compile as Javascript and script engine read it
            engine.execute(html, script.toString(), source.getSimpleName(), 1);

            String className = Javascript.computeClassName(source);
            String constructorName = Javascript.computeMethodName(constructor).substring(1);
            String methodName = Javascript.computeMethodName(method);

            // invoke it and compare result
            for (int i = 0; i < inputs.size(); i++) {
                Object input = inputs.get(i);

                // write test script
                StringBuilder invoker = new StringBuilder();
                invoker.append("try {");
                invoker.append("new ").append(className).append("(").append(constructorName).append(").");
                invoker.append(methodName).append("(");
                if (input != NONE) {
                    if (input instanceof String) {
                        invoker.append('"').append(input).append('"');
                    } else if (input instanceof Character) {
                        Class type = Class.forName("js.lang.JSCharacter");

                        invoker.append("new " + Javascript.computeClassName(type) + "(\"" + input + "\",0)");
                    } else if (input instanceof Class) {
                        invoker.append(Javascript.computeClass((Class) input));
                    } else {
                        invoker.append(input);
                    }
                }
                invoker.append(");");
                invoker.append("} catch(e) {e}");

                try {
                    // execute and compare it to the java resul
                    assertObject(results.get(i), engine.execute(html, invoker.toString(), "", 1));
                } catch (AssertionError e) {
                    StringBuilder builder = new StringBuilder();
                    builder.append("Compiling script is success but execution results of Java and JS are different.")
                            .append(END);

                    if (input != NONE) {
                        builder.append("Input value : ").append(input).append(END);
                    }
                    throw new AssertionError(builder.toString(), e);
                }
            }
        } catch (AssertionError e) {
            throw e; // rethrow assertion error
        } catch (Throwable e) {
            TranslationError error = new TranslationError(e);
            error.write(e.getMessage());
            error.write(END, "Test Code :");
            error.write(script.substring(script.indexOf("boot.define(\"" + Javascript.computeSimpleClassName(source) + "\",")));

            if (e instanceof EvaluatorException) {
                EvaluatorException exception = (EvaluatorException) e;

                int index = exception.columnNumber();
                String code = exception.lineSource();
                error.write(END, "Around Cause :");
                error.write(code.substring(Math.max(0, index - 20), Math.min(index + 20, code.length())));
            }
            throw error;
        }
    }

    /**
     * <p>
     * Compile specified class and evaluate it.
     * </p>
     * 
     * @param scriptable A target scriptable source.
     */
    final Object executeAsJavascript(Method method) {
        try {
            Class source = method.getDeclaringClass();
            StringBuilder script = new StringBuilder();

            // invoke as Javascript
            Javascript.getScript(source).writeTo(script, defined, Character.class, ClientStackTrace.class);

            // compile as Javascript and script engine read it
            engine.execute(html, script.toString(), source.getSimpleName(), 1);

            String className = Javascript.computeClassName(source);
            String constructorName = Javascript.computeMethodName(searchInstantiator(source)).substring(1);
            String methodName = Javascript.computeMethodName(method);

            String clientStackTrace = Javascript.computeClassName(ClientStackTrace.class);
            String encode = Javascript.computeMethodName(ClientStackTrace.class.getMethod("encode", Throwable.class));

            // write test script
            StringBuilder invoker = new StringBuilder();
            invoker.append("try {");
            invoker.append("new ").append(className).append("(").append(constructorName).append(").");
            invoker.append(methodName).append("();} catch(e) {" + clientStackTrace + "." + encode + "(e)" + ";}");

            Object result = engine.execute(html, invoker.toString(), "", 1);

            if (result == null || result instanceof Undefined || result instanceof UniqueTag) {
                return null;
            } else {
                // some error
                throw I.quiet(ClientStackTrace2.decode((String) result, Javascript.getScript(source).toString()));
            }
        } catch (Exception e) {
            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            Javascript.getScript(method.getDeclaringClass())
                    .writeTo(I.locate("E:\\text.js"), Character.class, ClientStackTrace.class);
            throw new Error(e);
        }
    }

    /**
     * <p>
     * Search instantiator.
     * </p>
     * 
     * @param source
     * @return
     */
    private Constructor searchInstantiator(Class source) {
        // search method
        root: for (Constructor constructor : source.getDeclaredConstructors()) {
            if (!constructor.isSynthetic()) {
                for (Class parameter : constructor.getParameterTypes()) {
                    if (parameter != getClass()) {
                        continue root;
                    }
                }
                constructor.setAccessible(true);

                return constructor;
            }
        }

        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error("Test class must extend ScriptTester.");
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
     * <p>
     * Prepare input values for test automatically.
     * </p>
     * 
     * @param method A target method.
     * @return A built-in values.
     */
    private List prepareInputs(Method method) {
        Class[] params = method.getParameterTypes();

        if (params.length == 0) {
            return Collections.singletonList(NONE);
        }

        Class type = params[0];
        Annotation[] annotations = method.getParameterAnnotations()[0];

        if (annotations.length == 1 && annotations[0] instanceof Param) {
            return prepareInputs(type, (Param) annotations[0]);
        }

        if (type == boolean.class) {
            return Arrays.asList(true, false);
        } else if (type == char.class) {
            return Arrays.asList('2', 'B', 'a', '$', '@', 'c', 'a', 't');
        } else if (type == int.class) {
            return Arrays.asList(0, 1, 2, 3, -1, -2, -3);
        } else if (type == long.class) {
            return Arrays.asList(0L, 1L, 2L, 123456789L, -1L, -2L, -123456789L);
        } else if (type == float.class) {
            return Arrays.asList(0F, 1F, 0.2F, -1.3464F);
        } else if (type == double.class) {
            return Arrays.asList(0D, 1D, -5.4D, 1.239754297642323D, 100.3D);
        } else if (type == short.class) {
            return Arrays.asList((short) 0, (short) 1, (short) 2, (short) -1, (short) -2);
        } else if (type == byte.class) {
            return Arrays.asList((byte) 0, (byte) 1, (byte) 2, (byte) -1, (byte) -2);
        } else if (type == String.class) {
            return Arrays.asList("", "a", "some value");
        } else if (type == Class.class) {
            return Arrays.asList(method.getDeclaringClass(), int.class);
        } else {
            return Arrays.asList(null, "String", 1);
        }
    }

    /**
     * <p>
     * Prepare user specified input values for test.
     * </p>
     * 
     * @param type A parameter type.
     * @param method A target method.
     * @return A user specified values.
     */
    private List prepareInputs(Class type, Param param) {
        if (type == boolean.class) {
            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            throw new Error();
        } else if (type == char.class) {
            return asList(param.chars());
        } else if (type == int.class) {
            int from = param.from();
            int to = param.to();

            if (from != to) {
                List inputs = new ArrayList();

                for (int i = from; i <= to; i++) {
                    inputs.add(i);
                }
                return inputs;
            }

            return asList(param.ints());
        } else if (type == long.class) {
            return asList(param.longs());
        } else if (type == float.class) {
            return asList(param.floats());
        } else if (type == double.class) {
            return asList(param.doubles());
        } else if (type == short.class) {
            return asList(param.shorts());
        } else if (type == byte.class) {
            return asList(param.bytes());
        } else if (type == String.class) {
            return asList(param.strings());
        } else {
            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            throw new Error();
        }
    }

    /**
     * <p>
     * Helper method to prepare user specified inputs.
     * </p>
     * 
     * @param array
     * @return
     */
    private List asList(Object array) {
        List inputs = new ArrayList();

        for (int i = 0; i < Array.getLength(array); i++) {
            inputs.add(Array.get(array, i));
        }
        return inputs;
    }

    /**
     * Assert that java object equals to javascript object.
     * 
     * @param java
     * @param js
     */
    private void assertObject(Object java, Object js) {
        if (java == null) {
            assert js instanceof UniqueTag || js instanceof Undefined || js == null;
        } else {
            if (js.getClass().getSimpleName().equals("NativeError")) {
                // Internal javascript error was thrown (e.g. invalid syntax error, property was not
                // found). So we must report as error for developer's feedback.
                throw new Error(js.toString());
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
                } else if (js instanceof Long) {
                    assert value == ((Long) js).intValue();
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
                if (js instanceof NativeObject) {
                    js = NativeObject.callMethod((NativeObject) js, "toString", new Object[] {});
                }
                assert ((Character) java).toString().equals(js.toString());
            } else if (Throwable.class.isAssignableFrom(type)) {
                // ========================
                // THROWABLE
                // ========================
                assertException((Throwable) java, js);
            } else if (type == Class.class) {
                // ========================
                // Class
                // ========================
                assertClass((Class) java, js);
            } else {
                // some object

                // If this exception will be thrown, it is bug of this program. So we must rethrow
                // the wrapped error in here.
                throw new Error(js.getClass() + " " + java.getClass() + "  " + java + "  " + js);
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
            assertObject(Array.get(java, i), array.get(i, null));
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

    /**
     * Assert the specified javascript object is Class.
     * 
     * @param exception
     * @param js
     */
    private void assertClass(Class clazz, Object js) {
        String prefix = "";

        while (clazz.isArray()) {
            prefix += "[";
            clazz = clazz.getComponentType();
        }

        String computedJavaClassName = prefix + Javascript.computeSimpleClassName(clazz);
        NativeObject object = (NativeObject) js;

        for (Object id : object.getAllIds()) {
            Object jsClassName = object.get(id);

            if (jsClassName instanceof String || jsClassName instanceof ConsString) {
                assert computedJavaClassName.equals(jsClassName.toString());
                return;
            }
        }
        throw new AssertionError("Class name is not found.");
    }

    /**
     * @version 2013/08/03 20:44:05
     */
    private static class Debugger implements Logger {

        /**
         * {@inheritDoc}
         */
        @Override
        public void warn(Object message) {
            log(message);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void trace(Object message) {
            log(message);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void info(Object message) {
            log(message);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void error(Object message) {
            log(message);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void debug(Object message) {
            log(message);
        }

        /**
         * <p>
         * Rewrite console message to {@link System.out}.
         * </p>
         * 
         * @param message
         */
        private void log(Object message) {
            System.out.println(message);
        }
    }
}
