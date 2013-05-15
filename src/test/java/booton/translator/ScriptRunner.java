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

import java.lang.reflect.Constructor;
import java.nio.file.Files;

import kiss.I;
import net.sourceforge.htmlunit.corejs.javascript.Context;
import net.sourceforge.htmlunit.corejs.javascript.EvaluatorException;
import net.sourceforge.htmlunit.corejs.javascript.Script;
import net.sourceforge.htmlunit.corejs.javascript.ScriptableObject;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.objectweb.asm.Type;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * @version 2013/05/15 16:25:29
 */
public class ScriptRunner extends BlockJUnit4ClassRunner {

    /** The line feed. */
    private static final String END = "\r\n";

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
            WebClient client = new WebClient(BrowserVersion.FIREFOX_10);
            client.getWebConsole().setLogger(new Logger() {

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
            });

            // build dummy page
            HtmlPage dummy = (HtmlPage) client.getPage(I.locate("src/test/resources/empty.html").toUri().toURL());

            // build script engine
            engine = client.getJavaScriptEngine().getContextFactory().enterContext();
            global = dummy.getScriptObject();

            // compile boot script
            booton = engine.compileReader(Files.newBufferedReader(I.locate("boot.js").toAbsolutePath(), UTF_8), "boot.js", 1, null);
            booton.exec(engine, global);
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * @param klass
     * @throws InitializationError
     */
    public ScriptRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void runChild(FrameworkMethod method, RunNotifier notifier) {
        super.runChild(method, notifier);

        Class source = method.getMethod().getDeclaringClass();
        Constructor constructor = searchInstantiator(source);

        StringBuilder script = new StringBuilder();

        // invoke as Javascript
        Javascript.getScript(source).writeTo(script, Character.class);

        try {
            // compile as Javascript and script engine read it
            engine.evaluateString(global, script.toString(), source.getSimpleName(), 1, null);

            String className = Javascript.computeClassName(source);
            String descriptor = Type.getConstructorDescriptor(constructor);
            String constructorName = Javascript.computeMethodName(source, "<init>", descriptor).substring(1);
            String methodName = Javascript.computeMethodName(method.getMethod());

            // invoke it and compare result
            Object input = NONE;

            // write test script
            StringBuilder invoker = new StringBuilder();
            invoker.append("try {");
            invoker.append("news ").append(className).append("(").append(constructorName).append(").");
            invoker.append(methodName).append("(");
            if (input != NONE) {
                if (input instanceof String) {
                    invoker.append('"').append(input).append('"');
                } else if (input instanceof Character) {
                    Class type = Class.forName("js.lang.JSChar");

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
                engine.evaluateString(global, invoker.toString(), "", 1, null);
            } catch (AssertionError e) {
                StringBuilder builder = new StringBuilder();
                builder.append("Compiling script is success but execution results of Java and JS are different.")
                        .append(END);

                if (input != NONE) {
                    builder.append("Input value : ").append(input).append(END);
                }
                throw new AssertionError(builder.toString(), e);
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
            notifier.fireTestFailure(new Failure(Description.createTestDescription(source, method.getName()), error));
            throw error;
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
}
