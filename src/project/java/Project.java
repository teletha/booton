/*
 * Copyright (C) 2012 Teemowork Development Team
 * 
 * Licensed under the MPL License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *          http://opensource.org/licenses/MPL-2.0
 */
public class Project extends bee.api.Project {

    {
        product("teemowork", "Teemowork", "0.1");

        require("npc", "sinobu", "0.9.3");
        require("com.netflix.rxjava", "rxjava-core", "0.15.1");
        require("org.eclipse.jetty", "jetty-server", "8.1.7.v20120910");
        require("org.eclipse.jetty", "jetty-websocket", "8.1.7.v20120910");
        require("org.eclipse.jetty", "jetty-servlet", "8.1.7.v20120910");
        require("npc", "antibug", "0.3").atTest();
        require("net.sourceforge.htmlunit", "htmlunit", "2.13").atTest();

        require("com.google.inject", "guice", "4.0-beta");
    }
}
