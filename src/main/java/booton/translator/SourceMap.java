/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 2015/02/05 16:10:14
 */
public class SourceMap {

    /** File version (always the first entry in the object) and must be a positive integer. */
    public int version = 3;

    /** An optional name of the generated code that this source map is associated with */
    public String file;

    /**
     * An optional source root, useful for relocating source files on a server or removing repeated
     * values in the “sources” entry. This value is prepended to the individual entries in the
     * “source” field. .
     */
    public String sourceRoot;

    /** An optional name of the generated code that this source map is associated with. */
    public final List<String> sources = new ArrayList();

    /**
     * An optional list of source content, useful when the “source” can’t be hosted. The contents
     * are listed in the same order as the sources in line 5. “null” may be used if some original
     * sources should be retrieved by name.
     */
    public final List<String> sourcesContent = new ArrayList();

    /** A list of symbol names used by the “mappings” entry. */
    public final List<String> names = new ArrayList();

    /** The A string with the encoded mapping data. */
    public String mappings;
}
