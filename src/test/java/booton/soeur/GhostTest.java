/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.soeur;

import static java.nio.charset.StandardCharsets.*;

import java.lang.reflect.Method;
import java.nio.file.Files;

import js.lang.BooleanTest;
import kiss.I;

import org.junit.Test;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import booton.live.ClientStackTrace;
import booton.translator.Javascript;

/**
 * @version 2014/03/09 16:04:56
 */
public class GhostTest {

    @Test
    public void testname() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, I.locate("")
                .toAbsolutePath()
                .resolve("phantomjs.exe")
                .toString());
        PhantomJSDriver driver = new PhantomJSDriver(caps);

        String boot = new String(Files.readAllBytes(I.locate("boot.js")), UTF_8);

        Class source = BooleanTest.class;
        Method method = source.getMethod("parse");
        Javascript script = Javascript.getScript(source);

        // compile as Javascript
        String compiled = script.write();

        // script engine read it

        // write test script
        String wraped = Javascript.writeMethodCode(Throwable.class, "wrap", Object.class, "e");
        String encode = Javascript.writeMethodCode(ClientStackTrace.class, "encode", Throwable.class, wraped);
        String invoker = "try {" + Javascript.writeMethodCode(source, method.getName()) + ";} catch(e) {" + encode + ";}";

        Object result = driver.executeScript(invoker);
        System.out.println(boot + compiled + result);
    }
}
