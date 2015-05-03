/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.dynamic;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import kiss.I;

/**
 * @version 2015/05/03 13:31:46
 */
public class OrnamentRepository {

    /** The ornament repository. */
    private static final Map<String[], Ornament> ornaments = new HashMap();

    /**
     * @param definition
     */
    static Ornament getOrnamentBy(Consumer<OrnamentDefinition> definition) {
        return ornaments.computeIfAbsent(MethodAnalyzer.findDescription(definition), key -> {
            try {
                Class<OrnamentDefinition> clazz = (Class) Class.forName(key[0].replaceAll("/", "."));
                Method method = clazz.getDeclaredMethod(key[1]);

                OrnamentDefinition instance = I.make(clazz);

                return null;
            } catch (Exception e) {
                throw I.quiet(e);
            }
        });
    }
}
