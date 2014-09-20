/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;

import js.dom.UIAction;
import jsx.event.Publishable;
import kiss.Disposable;
import kiss.Events;
import booton.reactive.css.StyleDefinition;

/**
 * @version 2014/09/01 20:06:01
 */
public abstract class LowLevelWidget<T extends LowLevelWidget<T>> {

    protected BooleanProperty click;

    protected BooleanProperty hover;

    protected final BooleanProperty enable = new SimpleBooleanProperty();

    private Publishable<?> publisher;

    /** The disposable list. */
    private List<Disposable> disposables;

    /**
     * <p>
     * Virtualize this user interface.
     * </p>
     * 
     * @return A single element.
     */
    protected abstract VirtualElement virtualize();

    /**
     * <p>
     * Retrieve the event publisher.
     * </p>
     * 
     * @return
     */
    protected final Publishable<?> publish() {
        if (publisher == null) {
            publisher = new Publishable();
        }
        return publisher;
    }

    /**
     * @return
     */
    public T click(Runnable action) {
        publish().observe(UIAction.Click).to(e -> {
            action.run();
        });

        return (T) this;
    }

    /**
     * @return
     */
    public T dbclick(Runnable action) {
        return (T) this;
    }

    /**
     * @return
     */
    public T hover(Runnable action) {
        return (T) this;
    }

    /**
     * <p>
     * Create {@link Events} for key down.
     * </p>
     * 
     * @return
     */
    public Events<Key> keyDown() {
        return null;
    }

    /**
     * <p>
     * Set key binding aginst the specified action.
     * </p>
     * 
     * @param key A shortcut key stroke.
     * @param action A binding function.
     * @return Chainable API.
     */
    public T shortcut(Key key, Runnable action) {
        if (key != null && action != null) {
            disposer().add(publish().observe(UIAction.KeyUp).filter(e -> e.which == key.code).to(e -> {
                action.run();
            }));
        }
        return (T) this;
    }

    /**
     * @param event
     * @param string
     * @return
     */
    public T validate(Events<Boolean> event, String string) {
        return (T) this;
    }

    /**
     * @param greaterThan
     * @param string
     * @return
     */
    public T validate(ObservableValue<Boolean> event, String string) {
        return (T) this;
    }

    public T enableIf(ObservableValue<Boolean> condition) {
        return (T) this;
    }

    public T enableIf(Events<Boolean> condition) {
        return (T) this;
    }

    public T disableIf(ObservableValue<Boolean> condition) {
        return (T) this;
    }

    public T disableIf(Events<Boolean> condition) {
        return (T) this;
    }

    public T showIf(ObservableValue<Boolean> condition) {
        return (T) this;
    }

    public T showIf(Events<Boolean> condition) {
        return (T) this;
    }

    public T hideIf(ObservableValue<Boolean> condition) {
        return (T) this;
    }

    public T hideIf(Events<Boolean> condition) {
        return (T) this;
    }

    public T style(ObservableValue<StyleDefinition> style) {
        return (T) this;
    }

    /**
     * <p>
     * Helper method to create holder lazily.
     * </p>
     * 
     * @return A cached list.
     */
    private List<Disposable> disposer() {
        if (disposables == null) {
            disposables = new ArrayList();
        }
        return disposables;
    }
}
