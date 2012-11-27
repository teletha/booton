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

        require("npc", "sinobu", "0.9.2");
        require("npc", "antibug", "0.2").atTest();
        require("net.sourceforge.htmlunit", "htmlunit", "2.11").atTest();

        unrequire("org.eclipse.jetty", "*");
    }
}
