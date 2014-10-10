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

import static js.dom.UIAction.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ObservableValue;

import js.dom.UIAction;
import js.dom.UIEvent;
import jsx.event.Publishable;
import jsx.ui.VirtualStructure.ContainerDescriptor;
import kiss.Disposable;
import kiss.Events;
import booton.reactive.css.StyleDefinition;

/**
 * @version 2014/09/01 20:06:01
 */
public abstract class LowLevelWidget<T extends LowLevelWidget<T>> {

    public BooleanProperty click;

    public BooleanProperty hover;

    /** The holder of event listeners. */
    Publishable<?> events;

    /** The disposable list. */
    private List<Disposable> disposables;

    /**
     * @return
     */
    protected abstract String virtualizeName();

    /**
     * @param descriptor
     */
    protected abstract void virtualizeStructure(ContainerDescriptor descriptor);

    /**
     * <p>
     * Retrieve the event publisher.
     * </p>
     * 
     * @return
     */
    protected final Publishable<?> event() {
        if (events == null) {
            events = new Publishable();
        }
        return events;
    }

    /**
     * @return
     */
    public T click(Runnable action) {
        event().observe(UIAction.Click).filter(this::isValid).to(e -> action.run());

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
            Predicate<UIEvent> byKey = e -> e.which == key.code;

            Events<UIEvent> keyPress = event().observe(KeyPress).filter(byKey);
            Events<UIEvent> keyUp = event().observe(KeyUp).filter(byKey);
            // All js environment never fire keypress event in IME mode.
            // So the following code can ignore key event while IME is on.
            Events<UIEvent> keyInput = keyUp.skipUntil(keyPress).take(1).repeat();

            // activate shortcut command
            disposeLater(keyInput.filter(this::isValid).to(e -> action.run()));
        }
        return (T) this;
    }

    public T enableIf(ObservableValue<Boolean> condition) {

        return (T) this;
    }

    public T enableIf(Events<Boolean> condition) {
        return (T) this;
    }

    public T disableIf(Supplier<Boolean> condition) {
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

    public T popupIf(Events<Boolean> condition, Widget widget) {
        return (T) this;
    }

    /**
     * <p>
     * Helper method to create cleanup holder.
     * </p>
     */
    protected final void disposeLater(Disposable disposable) {
        if (disposables == null) {
            disposables = new ArrayList();
        }
        disposables.add(disposable);
    }

    protected boolean isValid(UIEvent e) {
        return true;
    }
}
