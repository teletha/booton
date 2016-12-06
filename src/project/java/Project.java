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
        String jettyVersion = "9.4.0.RC2";

        product("npc", "Booton", "0.1");
        producer("Nameless Production Committee");

        require("npc", "sinobu", "1.0");
        require("net.sourceforge.htmlunit", "htmlunit", "2.23").atTest();
        require("org.eclipse.jetty.websocket", "websocket-server", jettyVersion);
        require("org.eclipse.jetty", "jetty-servlet", jettyVersion);
        require("org.eclipse.jetty", "jetty-util", jettyVersion);
        require("org.eclipse.jetty", "jetty-http", jettyVersion);
        require("npc", "antibug", "0.3").atTest();

    }
}
