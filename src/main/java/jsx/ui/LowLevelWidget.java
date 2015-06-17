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

import static js.dom.UIAction.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;

import js.dom.UIEvent;
import jsx.style.Style;
import kiss.Disposable;
import kiss.Events;

/**
 * @version 2014/10/10 9:24:46
 */
public abstract class LowLevelWidget<T extends LowLevelWidget<T>> extends Widget {

    /** The disposable list. */
    private List<Disposable> disposables;

    private BooleanProperty hover;

    protected final Property<Style> rootStyle = new SimpleObjectProperty();

    public BooleanProperty hover() {
        if (hover == null) {
            hover = new SimpleBooleanProperty(false);

            on(MouseEnter).to(v -> hover.set(true));
            on(MouseLeave).to(v -> hover.set(false));
        }
        return hover;
    }

    private final Events<UIEvent> click = on(Click).filter(this::isValid);

    private final Events<UIEvent> dbclick = on(DoubleClick).filter(this::isValid);

    /**
     * @return
     */
    public T click(Runnable action) {
        click.to(e -> action.run());

        return (T) this;
    }

    /**
     * @return
     */
    public T dbclick(Runnable action) {
        dbclick.to(e -> action.run());

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

            Events<UIEvent> keyPress = on(KeyPress).filter(byKey);
            Events<UIEvent> keyUp = on(KeyUp).filter(byKey);
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

    public T showIf(BooleanSupplier condition) {
        return (T) this;
    }

    public T hideIf(ObservableValue<Boolean> condition) {
        return (T) this;
    }

    public T style(Style style) {
        rootStyle.setValue(style);

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
