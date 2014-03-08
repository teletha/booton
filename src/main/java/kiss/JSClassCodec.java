/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package kiss;

import kiss.model.Codec;
import booton.translator.JavaAPIProvider;

/**
 * @version 2014/03/07 20:21:02
 */
@JavaAPIProvider(ClassCodec.class)
class JSClassCodec extends Codec<Class> {

    /**
     * {@inheritDoc}
     */
    @Override
    public String encode(Class value) {
        return super.encode(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class decode(String value) {
        return super.decode(value);
    }
}
