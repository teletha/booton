/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx;

import java.lang.reflect.Constructor;

/**
 * @version 2013/05/05 17:55:10
 */
public class Boot {

    /**
     * <p>
     * </p>
     * 
     * @param model
     * @return
     */
    public static <T> T getInstance(Class<T> model) {
        Constructor instantiator = getMiniConstructor(model);
        instantiator.setAccessible(true);

        try {
            return (T) instantiator.newInstance();
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    /**
     * <p>
     * Helper method to find the constructor which has minimum parameters. If the given class is
     * interface, primitive types, array class or <code>void</code>, <code>null</code> will be
     * return.
     * </p>
     * 
     * @param <T> A class type.
     * @param clazz A target class.
     * @return A minimum constructor or <code>null</code>.
     */
    public static <T> Constructor<T> getMiniConstructor(Class<T> clazz) {
        // the candidate of minimum constructor
        Constructor mini = null;

        for (Constructor constructor : clazz.getDeclaredConstructors()) {
            // test parameter size
            if (mini == null || constructor.getParameterTypes().length < mini.getParameterTypes().length) {
                mini = constructor;
            }
        }

        // API definition
        return mini;
    }

}
