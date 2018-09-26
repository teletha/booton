/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
public class Project extends bee.api.Project {

    {
        String jettyVersion = "9.2.19.v20160908";

        product("npc", "Booton", "0.1");
        producer("Nameless Production Committee");

        require("com.github.teletha", "sinobu", "1.0");
        require("com.github.teletha", "filer", "0.5");
        require("org.ow2.asm", "asm", "6.1.1");
        require("io.github.classgraph", "classgraph", "LATEST");
        require("org.eclipse.jetty.websocket", "websocket-server", jettyVersion);
        require("org.eclipse.jetty", "jetty-servlet", jettyVersion);
        require("org.eclipse.jetty", "jetty-util", jettyVersion);
        require("org.eclipse.jetty", "jetty-http", jettyVersion);
        require("org.openjfx", "javafx-controls", "11");
        require("com.github.teletha", "antibug", "0.6").atTest();
        require("org.junit.vintage", "junit-vintage-engine", "5.1.0").atTest();
        require("junit", "junit", "4.12").atTest();
        require("net.sourceforge.htmlunit", "htmlunit", "2.23").atTest();
    }
}
