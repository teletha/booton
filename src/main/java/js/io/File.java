/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.io;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/09/24 16:46:03
 */
@JavaAPIProvider(java.io.File.class)
class File {

    /**
     * The system-dependent default name-separator character. This field is initialized to contain
     * the first character of the value of the system property <code>file.separator</code>. On UNIX
     * systems the value of this field is <code>'/'</code>; on Microsoft Windows systems it is
     * <code>'\\'</code>.
     *
     * @see java.lang.System#getProperty(java.lang.String)
     */
    public static final char separatorChar = '/';

    /**
     * The system-dependent default name-separator character, represented as a string for
     * convenience. This string contains a single character, namely
     * <code>{@link #separatorChar}</code>.
     */
    public static final String separator = "/";
}
