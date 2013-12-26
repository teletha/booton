/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.event;

import java.lang.annotation.Annotation;

import kiss.Extensible;

/**
 * @version 2013/12/26 9:28:21
 */
public abstract class ListenerContainerDetail<A extends Annotation> implements Extensible {

    protected abstract Annotation[] values(A annotation);
}
