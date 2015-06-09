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

import static jsx.ui.TextHelper.*;

import javafx.beans.binding.IntegerExpression;
import javafx.beans.binding.StringExpression;

import booton.Necessary;
import kiss.Extensible;

/**
 * @version 2015/06/09 11:56:05
 */
@Necessary
public class TodoUIText implements Extensible {

    /**
     * <p>
     * Label of the button which selects all items.
     * </p>
     * 
     * @return
     */
    public String selectAll() {
        return "All";
    }

    /**
     * <p>
     * Label of the button which selects all completed items.
     * </p>
     * 
     * @return
     */
    public String selectCompleted() {
        return "Complete";
    }

    /**
     * <p>
     * Label of the button which selects all completed items.
     * </p>
     * 
     * @return
     */
    public String selectIncompleted() {
        return "Active";
    }

    /**
     * @param size
     * @return
     */
    public String leftTaskIs(int size) {
        return size + " " + (size < 2 ? "item" : "items") + " left";
    }

    /**
     * <p>
     * LAbel of the button which clear all completed items.
     * </p>
     * 
     * @param size A number of completed items.
     * @return
     */
    public StringExpression clearCompleted(IntegerExpression size) {
        return $("Clear completed (", size, ")");
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
        public String selectAll() {
            return "全て";
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String selectCompleted() {
            return "完了済み";
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String selectIncompleted() {
            return "やるべきこと";
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String leftTaskIs(int size) {
            return "残りのタスク " + size;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public StringExpression clearCompleted(IntegerExpression size) {
            return $("完了済みタスク(", size, ")を消去");
        }

    }
}
