/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.bind;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 2013/01/20 15:26:26
 */
public abstract class Notifiable {

    /** The observer list. */
    private final List<Observer> observers = new ArrayList();

    /**
     * <p>
     * Bind.
     * </p>
     * 
     * @param notifiable
     */
    public void register(Object observer) {
        if (observer != null) {
            // collect observer
            for (Method method : observer.getClass().getMethods()) {
                if (method.isAnnotationPresent(js.bind.Observer.class)) {
                    register(observer, method);
                }
            }
        }
    }

    /**
     * <p>
     * Register observer of thi object.
     * </p>
     * 
     * @param observer
     * @param method
     */
    public void register(Object observer, Method method) {
        observers.add(new Observer(observer, method));
    }

    /**
     * <p>
     * Fire event.
     * </p>
     */
    protected void fire() {
        for (Observer observer : observers) {
            try {
                observer.handler.invoke(observer.observer);
            } catch (Exception e) {
                throw new Error();
            }
        }
    }

    /**
     * @version 2013/01/20 15:29:17
     */
    private static class Observer {

        /** The observer. */
        private final Object observer;

        /** The observer method. */
        private Method handler;

        /**
         * @param observer
         * @param handler
         */
        private Observer(Object observer, Method handler) {
            this.observer = observer;
            this.handler = handler;
        }
    }
}
