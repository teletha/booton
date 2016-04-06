/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import java.util.Objects;

import js.dom.User;
import js.dom.UIEvent;
import jsx.ui.piece.Button;
import jsx.ui.piece.Input;

/**
 * @version 2015/10/05 2:00:58
 */
public class UserBot {

    /**
     * <p>
     * Helper method to input the text value into the specified {@link Input} ui.
     * </p>
     * 
     * @param input A target {@link Input} ui.
     * @param strokes A sequence of user kye strokes.
     * @return An input result to test.
     */
    public static final InputResult input(Input input, Object... strokes) {
        type(input, strokes);

        return new InputResult(input);
    }

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
                type(input, (Key) stroke);
            } else {
                input.value.setValue(input.value.get() + stroke);
            }
        }
    }

    /**
     * <p>
     * Emulate key event.
     * </p>
     * 
     * @param key
     * @return
     */
    private static final void type(Input input, Key key) {
        User[] actions = {User.KeyDown, User.KeyPress, User.KeyUp};

        for (User action : actions) {
            UIEvent event = new UIEventMockForInput(input);
            event.type = action.name;
            event.which = key.code;

            // input.publish(event);
        }
    }

    /**
     * <p>
     * Emulate button click event.
     * </p>
     * 
     * @param delete
     */
    public static void click(Button button) {
        Objects.nonNull(button);

        UIEvent event = new UIEvent();
        event.type = User.Click.name;

        // button.publish(event);
    }

    /**
     * <p>
     * Emulate button click event.
     * </p>
     * 
     * @param delete
     */
    public static void click(Input button) {
        Objects.nonNull(button);

        UIEvent event = new UIEvent();
        event.type = User.Click.name;

        // button.publish(event);
    }

    /**
     * @version 2014/09/02 9:49:58
     */
    public static class InputResult {

        /** The target ui. */
        private final Input input;

        /**
         * @param input
         */
        private InputResult(Input input) {
            this.input = input;
        }

        /**
         * <p>
         * Validate user input result.
         * </p>
         * 
         * @param expectedText An expected text in input field.
         */
        public void willBe(String expectedText) {
            assert input.value.get().equals(expectedText);
        }

        /**
         * <p>
         * Validate user input result.
         * </p>
         * 
         * @param expectedText An expected text in input field.
         */
        public void willBeEmpty() {
            willBe("");
        }
    }

    /**
     * @version 2014/10/04 1:19:17
     */
    private static class UIEventMockForInput extends UIEvent {

        /** The UI holder. */
        private final Input input;

        /**
         * @param input
         */
        private UIEventMockForInput(Input input) {
            this.input = input;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String value() {
            return input.value.get();
        }
    }
}
