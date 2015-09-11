/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 2015/09/11 16:25:56
 */
class ValueStyleMemo {

    /** The cache repository. */
    static final Map<Object, Style> cache = new HashMap();
}
