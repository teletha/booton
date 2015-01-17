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
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;

import js.dom.UIAction;
import js.dom.UIEvent;
import jsx.event.Publishable;
import jsx.style.Style;
import kiss.Disposable;
import kiss.Events;
import booton.reactive.css.StyleDefinition;

/**
 * @version 2014/10/10 9:24:46
 */
public abstract class LowLevelWidget<T extends LowLevelWidget<T>> {

    /** The holder of event listeners. */
    Publishable<?> events;

    /** The holder of styles. */
    List<Style> styles;

    /** The disposable list. */
    private List<Disposable> disposables;

    /**
     * <p>
     * Describe the element name.
     * </p>
     * 
     * @return A element name.
     */
    protected abstract String virtualizeName();

    /**
     * <p>
     * Describe the element structure.
     * </p>
     * 
     * @param $〡 Domain Specific Language for virtual elements.
     */
    protected abstract void virtualizeStructure(VirtualStructure $〡);

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

    private BooleanProperty hover;

    public BooleanProperty hover() {
        if (hover == null) {
            hover = new SimpleBooleanProperty(false);

            event().observe(MouseEnter).to(v -> hover.set(true));
            event().observe(MouseLeave).to(v -> hover.set(false));
        }
        return hover;
    }

    /**
     * @return
     */
    public T click(Runnable action) {
        disposeLater(event().observe(UIAction.Click).filter(this::isValid).to(e -> action.run()));

        return (T) this;
    }

    /**
     * @return
     */
    public T dbclick(Runnable action) {
        disposeLater(event().observe(UIAction.DoubleClick).filter(this::isValid).to(e -> action.run()));

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

    public T disableIf(Supplier<Boolean> condition) {
        return (T) this;
    }

    public T disableIf(ObservableValue<Boolean> condition) {
        return (T) this;
    }

    public T showIf(ObservableValue<Boolean> condition) {
        return (T) this;
    }

    public T hideIf(ObservableValue<Boolean> condition) {
        return (T) this;
    }

    /**
     * @param championIconBox
     * @return
     */
    public T style(Style... styles) {
        if (this.styles == null) {
            this.styles = new ArrayList();
        }

        for (Style style : styles) {
            this.styles.add(style);
        }

        return (T) this;
    }

    public T styleIf(ObservableValue<Boolean> condition, Style onStyle) {
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

    /**
     * <p>
     * Check whether this {@link LowLevelWidget} is valid or not.
     * </p>
     * 
     * @param e Ignore this value.
     * @return A result.
     */
    protected boolean isValid(UIEvent e) {
        return true;
    }
}
