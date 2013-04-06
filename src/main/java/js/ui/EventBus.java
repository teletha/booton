/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui;

import java.lang.reflect.Method;

/**
 * @version 2013/04/07 2:36:42
 */
public class EventBus {

    /**
     * <p>
     * Register event listener.
     * </p>
     */
    public void register(Object subscriber) {
        for (Method method : subscriber.getClass().getMethods()) {
            if (method.isAnnotationPresent(Subscriber.class)) {
                System.out.println(method);
                System.out.println(Subscriber.class);

                Class[] parameters = method.getParameterTypes();
                System.out.println(parameters);
            }
        }
    }
}
