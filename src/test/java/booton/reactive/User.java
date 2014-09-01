/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive;

import java.util.Objects;

/**
 * @version 2014/08/22 7:44:00
 */
public class User {

    /**
     * Helper method to type the text value into the specified {@link Input} ui.
     * 
     * @param value
     * @param target
     */
    public static final void type(Input input, Object... strokes) {
        Objects.nonNull(input);

        for (Object stroke : strokes) {
            if (stroke instanceof Key) {
                input.publish(stroke);
            } else {
                input.value.setValue(input.value.get() + stroke);
            }
        }
    }
}
