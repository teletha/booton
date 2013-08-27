/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import static js.lang.Global.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 2013/01/18 21:54:32
 */
public class Classes {

    /**
     * <p>
     * Find all sub class of the specified class.
     * </p>
     * 
     * @param type A type to search.
     * @return A list of found classes.
     */
    public static <T> List<Class<? extends T>> find(Class<T> type) {
        List<Class<? extends T>> matched = new ArrayList();

        for (String name : boot.keys()) {
            Class clazz = boot.getPropertyAs(NativeObject.class, name).getPropertyAs(Class.class, "$");

            if (type != clazz && type.isAssignableFrom(clazz)) {
                matched.add(clazz);
            }
        }
        return matched;
    }
}
