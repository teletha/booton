/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/12/31 20:53:17
 */
@JavaAPIProvider(java.util.LinkedList.class)
class LinkedList<E> extends ArrayDeque<E> {
}
