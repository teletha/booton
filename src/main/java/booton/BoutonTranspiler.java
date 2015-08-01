/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton;

import java.nio.file.Path;

/**
 * Booton code transplie environment and runtime.
 * 
 * @version 2015/08/01 14:44:59
 */
public class BoutonTranspiler {

    /** Flag for profiling at compile phase. */
    public boolean profile = true;

    /** Flag for code compression. */
    public boolean compression = true;

    /** Location of html file. */
    public Path html;

    /** Location of javascript file. */
    public Path javascript;

    /** Location of css file. */
    public Path css;
}
