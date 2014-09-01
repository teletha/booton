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

import java.util.function.Consumer;

/**
 * @version 2014/09/01 16:57:43
 */
public class FunctionHelper {

    public static <P> Runnable $(Consumer<P> consumer, P param) {
        return () -> {
            consumer.accept(param);
        };
    }
}
