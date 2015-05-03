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

import java.util.function.Consumer;

/**
 * @version 2015/05/03 13:32:12
 */
public interface Ornamental<T extends Ornamental> {

    public default T style(Consumer<OrnamentDefinition> definition) {
        OrnamentRepository.getOrnamentBy(definition);

        return (T) this;
    }
}
