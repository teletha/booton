/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.samaple.todo;

/**
 * @version 2014/09/25 16:03:02
 */
public class ImmutableTodoTasks {

    /**
     * @version 2014/09/25 16:03:33
     */
    public static class ImmutableTask {

        public final String text;

        public final boolean completed;

        /**
         * @param text
         * @param completed
         */
        public ImmutableTask(String text, boolean completed) {
            this.text = text;
            this.completed = completed;
        }
    }
}
