/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.sample.beans;

import java.util.List;
import java.util.Map;

/**
 * @version 2013/10/02 12:23:28
 */
public class Collections {

    private List<String> list;

    private Map<String, String> map;

    /**
     * Get the strings property of this {@link Collections}.
     * 
     * @return The strings property.
     */
    public List<String> getList() {
        return list;
    }

    /**
     * Set the strings property of this {@link Collections}.
     * 
     * @param strings The strings value to set.
     */
    public void setList(List<String> strings) {
        this.list = strings;
    }

    /**
     * Get the map property of this {@link Collections}.
     * 
     * @return The map property.
     */
    public Map<String, String> getMap() {
        return map;
    }

    /**
     * Set the map property of this {@link Collections}.
     * 
     * @param map The map value to set.
     */
    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
