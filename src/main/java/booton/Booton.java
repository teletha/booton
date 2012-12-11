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

import java.nio.file.Files;
import java.nio.file.Path;

import js.ui.Application;
import kiss.I;
import kiss.XML;

import org.objectweb.asm.Type;

import teemowork.Teemowork;
import booton.translator.Javascript;

/**
 * @version 2012/12/10 23:06:05
 */
public class Booton {

    /** The application class. */
    private final Class<? extends Application> application;

    /**
     * <p>
     * Booton web application builder.
     * </p>
     */
    public Booton(Class<? extends Application> application) {
        this.application = application;
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
            // loca application extensions
            I.load(application, true);

            buildHTML(output.resolve("test.html"));
            buildCSS(output.resolve("test.css"));
            buildJS(output.resolve("test.js"));
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

        head.child("link").attr("type", "text/css").attr("rel", "stylesheet").attr("href", "bootstrap.css");
        head.child("link").attr("type", "text/css").attr("rel", "stylesheet").attr("href", "test.css");
        head.child("script").attr("type", "text/javascript").attr("src", "jquery.js").text("/* */");
        head.child("script").attr("type", "text/javascript").attr("src", "bootstrap.js").text("/* */");
        head.child("script").attr("type", "text/javascript").attr("src", "boot.js").text("/* */");
        head.child("script").attr("type", "text/javascript").attr("src", "test.js").text("/* */");

        html.child("body");

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

        for (CSS css : I.find(CSS.class)) {
            css.to(builder);
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
}
