/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.virtual;

import java.util.Objects;

import booton.reactive.Key;
import js.dom.UIAction;
import js.dom.UIEvent;
import jsx.event.Publishable;

/**
 * @version 2014/08/22 7:44:00
 */
public class User {

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
                type(input.publisher, (Key) stroke);
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
    private static final void type(Publishable publishable, Key key) {
        UIAction[] actions = {UIAction.KeyDown, UIAction.KeyPress, UIAction.KeyUp};

        for (UIAction action : actions) {
            UIEvent event = new UIEvent();
            event.action = action;
            event.which = key.code;

            publishable.publish(event);
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
        event.action = UIAction.Click;

        button.publisher.publish(event);
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
}
