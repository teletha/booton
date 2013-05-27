/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.live;

import js.ui.model.Property;

/**
 * @version 2013/05/26 11:31:27
 */
public class ClientStackTrace {

    /** The class name. */
    @Property
    public String className;

    /** The method name. */
    @Property
    public String methodName;

    /** The file name. */
    @Property
    public String file;

    /** The line number. */
    @Property
    public int line;
}