/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
public class Project extends bee.api.Project {

    {
        product("npc", "Booton", "0.1");
        producer("Nameless Production Committee");

        require("npc", "sinobu", "0.9.4");
        require("org.eclipse.jetty", "jetty-server", "8.1.15.v20140411");
        require("org.eclipse.jetty", "jetty-websocket", "8.1.15.v20140411");
        require("org.eclipse.jetty", "jetty-servlet", "8.1.15.v20140411");
        require("npc", "antibug", "0.3").atTest();
        require("net.sourceforge.htmlunit", "htmlunit", "2.15").atTest();
    }
}
