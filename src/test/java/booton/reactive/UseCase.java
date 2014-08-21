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

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;

/**
 * @version 2014/08/21 13:31:48
 */
public class UseCase extends Reactive {

    public final ListProperty<String> todos = new SimpleListProperty();

    /** The input field. */
    Input input = new Input();

    /** The add button. */
    Button add = new Button() {

        {
            click.to(e -> {
                todos.add(input.value());
                input.clear();
            });
        }
    };

    /**
     * {@inheritDoc}
     */
    @Override
    protected void template() {
        hbox(todos, todo -> {
            text(todo, "!");
        });
        hbox(input, add);
    }
}
