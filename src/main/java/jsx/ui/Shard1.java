/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import kiss.Events;

/**
 * @version 2015/10/07 13:16:57
 */
public abstract class Shard1<M1> {

    private Events<String> modelName;

    private Events<Integer> modelAge;

    protected abstract Events<M1> model1();

    protected abstract void virtulize(M1 model1);
}
