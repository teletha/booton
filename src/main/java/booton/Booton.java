/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton;

import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import js.application.Application;
import js.application.ApplicationTheme;
import kiss.I;
import kiss.XML;

import org.objectweb.asm.Type;

import teemowork.Teemowork;
import booton.css.CSS;
import booton.translator.Javascript;
import booton.util.Font;

/**
 * @version 2012/12/10 23:06:05
 */
public class Booton {

    /** The application class. */
    private final Class<? extends Application> application;

    /** The application design. */
    private final Class<? extends ApplicationTheme> design;

    /**
     * <p>
     * Booton web application builder.
     * </p>
     */
    public Booton(Class<? extends Application> application) {
        this(application, null);
    }

    /**
     * <p>
     * Booton web application builder.
     * </p>
     */
    public Booton(Class<? extends Application> application, Class<? extends ApplicationTheme> design) {
        this.application = application;
        this.design = design == null ? ApplicationTheme.class : design;
    }

    /**
     * <p>
     * Build application.
     * </p>
     */
    public void build() {
        build(null);
    }

    /**
     * <p>
     * Build application.
     * </p>
     * 
     * @param output An output location
     */
    public void build(Path output) {
        // normalize output directory
        if (output == null) {
            output = I.locate("");
        }

        if (Files.isRegularFile(output)) {
            output = output.getParent();
        }

        try {
            // load built-in library
            I.load(Application.class, true);

            // load application extensions
            I.load(application, true);

            buildHTML(output.resolve("test.html"));
            buildJS(output.resolve("test.js"));
            buildCSS(output.resolve("test.css"));
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    /**
     * <p>
     * Build html file.
     * </p>
     * 
     * @param file
     */
    private void buildHTML(Path file) throws Exception {
        StringBuilder builder = new StringBuilder();
        builder.append("try {new ");
        builder.append(Javascript.computeClassName(application));
        builder.append("(0).");
        builder.append(Javascript.computeMethodName(application, "jsmain", Type.getMethodDescriptor(application.getDeclaredMethod("jsmain"))));
        builder.append("(");
        builder.append(");");
        builder.append("} catch(e) {console.log(e)}");

        XML html = I.xml("html");
        XML head = html.child("head");
        head.child("meta").attr("charset", "utf-8");
        head.child("link").attr("type", "text/css").attr("rel", "stylesheet").attr("href", "normalize.css");
        head.child("link").attr("type", "text/css").attr("rel", "stylesheet").attr("href", "test.css");
        head.child("script").attr("type", "text/javascript").attr("src", "jquery.js").text("/* */");
        head.child("script").attr("type", "text/javascript").attr("src", "boot.js").text("/* */");
        head.child("script").attr("type", "text/javascript").attr("src", "test.js").text("/* */");

        XML body = html.child("body");
        body.child("header").attr("id", "Header");
        body.child("div").attr("id", "Content");
        body.child("footer").attr("id", "Footer");

        html.child("script").attr("type", "text/javascript").text(builder.toString());

        html.to(Files.newBufferedWriter(file, I.$encoding));
    }

    /**
     * <p>
     * Build css file.
     * </p>
     * 
     * @param file
     */
    private void buildCSS(Path file) throws Exception {
        StringBuilder builder = new StringBuilder();

        for (Class<? extends CSS> rules : styles) {
            CSS css = I.make(rules);
            System.out.println(css.getClass());
            for (Field field : css.getClass().getDeclaredFields()) {
                if (field.getType() == Font.class) {
                    field.setAccessible(true);

                    try {
                        builder.append("@import url(" + ((Font) field.get(css)).uri + ");\r\n");
                    } catch (Exception e) {
                        throw I.quiet(e);
                    }
                }
            }
        }

        for (Class<? extends CSS> rules : styles) {
            builder.append(I.make(rules).toString());
        }
        Files.write(file, builder.toString().getBytes(I.$encoding));
    }

    /**
     * <p>
     * Build javascript file.
     * </p>
     * 
     * @param file
     */
    private void buildJS(Path file) throws Exception {
        Javascript js = Javascript.getScript(application);
        js.writeTo(file);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Booton booton = new Booton(Teemowork.class);
        booton.build();
    }

    /** The rule sets. */
    private static final Set<Class<? extends CSS>> styles = new HashSet();

    /**
     * <p>
     * </p>
     * 
     * @param clazz
     */
    public static Class requireCSS(Class clazz) {
        CSS css = I.find(CSS.class, clazz);

        if (css != null) {
            clazz = css.getClass();
        }
        styles.add(clazz);

        return clazz;
    }

}
