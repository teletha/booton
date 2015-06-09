/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.samaple.todo;

import booton.Necessary;
import kiss.Extensible;

/**
 * @version 2015/06/09 11:56:05
 */
@Necessary
public class TodoUIText implements Extensible {

    /**
     * @param size
     * @return
     */
    public String leftTaskIs(int size) {
        return size + " " + (size < 2 ? "item" : "items") + " left";
    }

    /**
     * @version 2015/06/09 12:11:53
     */
    @SuppressWarnings("unused")
    private static class TodoUIText_ja extends TodoUIText {

        /**
         * {@inheritDoc}
         */
        @Override
        public String leftTaskIs(int size) {
            return "残り" + size + "個";
        }
    }
}
