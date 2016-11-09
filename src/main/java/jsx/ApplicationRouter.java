/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx;

import static js.lang.Global.*;

import java.util.function.Supplier;

import jsx.ui.Widget;

/**
 * @version 2016/11/09 9:18:17
 */
public interface ApplicationRouter {

    /**
     * <p>
     * Cache the widget by the current path.
     * </p>
     * 
     * @param key
     * @param builder
     * @return
     */
    default Widget cache(Supplier<Widget> builder) {
        return Application.cache(builder, this, location.hash);
    }

    /**
     * <p>
     * Cache the widget by the specified keys.
     * </p>
     * 
     * @param key
     * @param builder
     * @return
     */
    default Widget cache(Object key, Supplier<Widget> builder) {
        return Application.cache(builder, this, key);
    }

    /**
     * <p>
     * Cache the widget by the specified keys.
     * </p>
     * 
     * @param key
     * @param builder
     * @return
     */
    default Widget cache(Object key1, Object key2, Supplier<Widget> builder) {
        return Application.cache(builder, this, key1, key2);
    }

    /**
     * <p>
     * Cache the widget by the specified keys.
     * </p>
     * 
     * @param key
     * @param builder
     * @return
     */
    default Widget cache(Object key1, Object key2, Object key3, Supplier<Widget> builder) {
        return Application.cache(builder, this, key1, key2, key3);
    }

    /**
     * <p>
     * Cache the widget by the specified keys.
     * </p>
     * 
     * @param keys
     * @param builder
     * @return
     */
    default Widget cache(Object[] keys, Supplier<Widget> builder) {
        return Application.cache(builder, this, keys);
    }
}
