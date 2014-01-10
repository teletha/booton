/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.rx;

import java.util.ArrayList;

import kiss.Disposable;

/**
 * @version 2014/01/10 13:44:31
 */
@SuppressWarnings("serial")
class DelegatableDisposer extends ArrayList<Disposable> implements Disposable {

    /**
     * {@inheritDoc}
     */
    @Override
    public void dispose() {
        for (Disposable disposable : this) {
            disposable.dispose();
        }
    }
}
