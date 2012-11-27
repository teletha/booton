/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import java.nio.file.Files;
import java.nio.file.Path;

import kiss.I;
import kiss.XML;

import org.objectweb.asm.Type;

import booton.translator.Javascript;

/**
 * @version 2012/11/27 18:13:20
 */
public class SiteBuilder {

    public static void main(String[] args) throws Exception {
        Path htmlPath = I.locate("test.html");
        Path jsPath = I.locate("test.js");

        // JS builder
        Javascript js = Javascript.getScript(Champion.class);
        js.writeAll(Files.newBufferedWriter(jsPath, I.$encoding));

        StringBuilder builder = new StringBuilder();
        builder.append("try {");
        builder.append(Javascript.computeClassName(Champion.class));
        builder.append(".");
        builder.append(Javascript.computeMethodName(Champion.class, "jsmain", Type.getMethodDescriptor(Champion.class.getMethod("jsmain"))));
        builder.append("(");
        builder.append(");");
        builder.append("} catch(e) {console.log(e)}");

        XML html = I.xml("html");
        XML head = html.child("head");
        head.child("meta").attr("charset", "utf-8");
        head.child("script").attr("type", "text/javascript").attr("src", "boot.js").text("/* */");
        head.child("script").attr("type", "text/javascript").attr("src", "test.js").text("/* */");
        head.child("script").attr("type", "text/javascript").text(builder.toString());

        XML body = html.child("body");
        body.child("p").text("test");

        html.to(Files.newBufferedWriter(htmlPath, I.$encoding));

    }
}
