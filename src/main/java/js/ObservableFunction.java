/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js;

import java.util.List;

import js.util.ArrayList;

/**
 * @version 2013/01/16 11:42:32
 */
public class ObservableFunction {

    /** The observers of this function. */
    private List<ObservableFunction> observers = new ArrayList();

    /** The binding state. */
    private boolean whileUpdate = false;

    /**
     * <p>
     * Register observer of this function.
     * </p>
     * 
     * @param observer
     */
    public void register(ObservableFunction observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    public void fire() {
        if (!whileUpdate) {
            whileUpdate = true;

            if (observers.isEmpty()) {
                recall();
            } else {
                for (ObservableFunction observer : observers) {
                    observer.fire();
                }
            }

            whileUpdate = false;
        }
    }

    public native void recall();
}
