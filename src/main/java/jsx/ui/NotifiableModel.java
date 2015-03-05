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

import java.util.List;
import java.util.function.Consumer;

/**
 * @version 2015/03/05 9:44:28
 */
public abstract class NotifiableModel<M extends NotifiableModel> {

    /** The event listeners. */
    private List<Consumer<M>> listeners;

    public void listen(Consumer<M> listener) {

    }
}
