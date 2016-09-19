/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.concurrent;

import java.util.ArrayDeque;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/12/30 22:54:07
 */
@SuppressWarnings("serial")
@JavaAPIProvider(java.util.concurrent.ConcurrentLinkedQueue.class)
class ConcurrentLinkedQueue<E> extends ArrayDeque<E> {
}
