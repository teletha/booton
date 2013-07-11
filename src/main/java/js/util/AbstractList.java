/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.List;

import booton.translator.JavaAPIProvider;

/**
 * @version 2012/12/09 23:04:18
 */
@JavaAPIProvider(java.util.AbstractList.class)
abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {
}
