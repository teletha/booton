/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.piece;

import static js.lang.Global.*;

import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SetProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import js.dom.Element;
import jsx.style.Style;
import jsx.style.StyleDSL;
import jsx.ui.Widget;
import kiss.Events;
import kiss.I;
import kiss.Observer;
import kiss.Ⅲ;

/**
 * @version 2015/10/18 22:10:18
 */
public class UI {

    /**
     * <p>
     * Create UI {@link Button}.
     * </p>
     * 
     * @return
     */
    public static final Button button() {
        return new Button();
    }

    /**
     * <p>
     * Create {@link Input} form field with empty value.
     * </p>
     */
    public static final Input input() {
        return input((StringProperty) null);
    }

    /**
     * <p>
     * Create {@link Input} form field with the specified value.
     * </p>
     */
    public static final Input input(String value) {
        return input(new SimpleStringProperty(value));
    }

    /**
     * <p>
     * Create {@link Input} form field with the specified value.
     * </p>
     */
    public static final Input input(StringProperty value) {
        if (value == null) {
            value = new SimpleStringProperty();
        }
        return new Input(value);
    }

    /**
     * <p>
     * Create text {@link Output} with the specified value.
     * </p>
     * 
     * @param text
     */
    public static final Output output(String text) {
        return output(new SimpleStringProperty(text));
    }

    /**
     * <p>
     * Create text {@link Output} with the specified value.
     * </p>
     * 
     * @param text
     */
    public static final Output output(IntegerProperty value) {
        return new Output(value);
    }

    /**
     * <p>
     * Create text {@link Output} with the specified value.
     * </p>
     * 
     * @param text
     */
    public static final Output output(StringProperty text) {
        return new Output(text);
    }

    /**
     * <p>
     * Create {@link Checkbox} with the specified value.
     * </p>
     * 
     * @param value
     */
    public static final <T> CheckBox checkbox(SetProperty<T> group, T value, String label) {
        if (group == null) {
            group = I.make(SetProperty.class);
        }

        CheckBox box = new CheckBox(group, value, label);

        return box;
    }

    /**
     * <p>
     * Create {@link Checkbox} with the specified value.
     * </p>
     * 
     * @param value
     */
    public static final <T> CheckBox checkbox(Property<Boolean> group, T value, String label) {
        CheckBox box = new CheckBox(group, value, label);

        return box;
    }

    /**
     * <p>
     * Create {@link RadioBox} with the specified value.
     * </p>
     * 
     * @param value
     */
    public static final <T> RadioBox<T> radiobox(Property<T> group, T value, String label) {
        RadioBox box = new RadioBox(group, value, label);

        return box;
    }

    /**
     * <p>
     * Create {@link Select} box with the specified values.
     * </p>
     * 
     * @param values
     */
    public static final <E extends Enum> Select<E> select(Class<E> enumClass, Property<E> selection) {
        return select(enumClass.getEnumConstants(), selection);
    }

    /**
     * <p>
     * Create {@link Select} box with the specified values.
     * </p>
     * 
     * @param values
     */
    public static final <M> Select<M> select(M[] values, Property<M> selection) {
        ListProperty<M> items = I.make(ListProperty.class);
        items.addAll(values);

        return select(items, selection);
    }

    /**
     * <p>
     * Create {@link Select} box with the specified values.
     * </p>
     * 
     * @param values
     */
    public static final <M> Select<M> select(ListProperty<M> values, Property<M> selection) {
        return new Select(values, selection);
    }

    /**
     * <p>
     * Create {@link Modal} area for the specified {@link Widget}.
     * </p>
     * 
     * @return Chainable API.
     */
    public static final ModalOpener modal() {
        return new ModalMaker();
    }

    /**
     * @version 2015/10/16 23:15:35
     */
    public interface ModalOpener {

        /**
         * <p>
         * Alias method for {@link #openWhen(Events)}.
         * </p>
         * 
         * @param opener A open timing for the modal contents.
         * @return A contents builder.
         */
        default <O> ModalBuilder<O> open(Events<O> opener) {
            return openWhen(opener);
        }

        /**
         * <p>
         * Configure the open timing for the modal contents.
         * </p>
         * 
         * @param opener A open timing for the modal contents.
         * @return A contents builder.s
         */
        <O> ModalBuilder<O> openWhen(Events<O> opener);
    }

    /**
     * @version 2015/10/16 23:17:32
     */
    public interface ModalBuilder<O> {

        /**
         * <p>
         * Configure the modal contents.
         * </p>
         * 
         * @param builder
         * @return
         */
        default <W extends Widget> ModalCloser<O, W> show(Class<W> contents) {
            return show(I.make(contents));
        }

        /**
         * <p>
         * Configure the modal contents.
         * </p>
         * 
         * @param contents
         * @return
         */
        default <W extends Widget> ModalCloser<O, W> show(W contents) {
            return show(o -> contents);
        }

        /**
         * <p>
         * Configure the modal contents.
         * </p>
         * 
         * @param contents
         * @return
         */
        <W extends Widget> ModalCloser<O, W> show(Function<O, W> contents);
    }

    /**
     * @version 2015/10/16 23:19:22
     */
    public interface ModalCloser<O, W> {

        /**
         * <p>
         * Alias method for {@link #closeWhen(Function)}.
         * </p>
         * 
         * @param closer A close timing for the modal contents.
         * @return A user action.
         */
        default <C> Events<Ⅲ<O, W, C>> close(Events<C> closer) {
            return closeWhen(closer);
        }

        /**
         * <p>
         * Alias method for {@link #closeWhen(Function)}.
         * </p>
         * 
         * @param closer A close timing for the modal contents.
         * @return A user action.
         */
        default <C> Events<Ⅲ<O, W, C>> closeWhen(Events<C> closer) {
            return closeWhen(w -> closer);
        }

        /**
         * <p>
         * Configure the close timing for the modal contents.
         * </p>
         * 
         * @param closer A close timing for the modal contents.
         * @return A user action.
         */
        <C> Events<Ⅲ<O, W, C>> closeWhen(Function<W, Events<C>> closer);
    }

    /**
     * @version 2015/10/18 22:09:32
     */
    @SuppressWarnings("hiding")
    private static class ModalMaker<O, W extends Widget, C> implements ModalOpener, ModalBuilder<O>, ModalCloser<O, W> {

        /** The open event. */
        private Events<O> opener;

        /** The build event. */
        private Function<O, W> builder;

        /** The special element for modal contents. */
        private Element Modal;

        /** The list of event listeners. */
        private final List<Observer> observers = new ArrayList();

        /**
         * {@inheritDoc}
         */
        @Override
        public <T> ModalBuilder<T> openWhen(Events<T> opener) {
            this.opener = (Events) Objects.requireNonNull(opener);

            return (ModalBuilder<T>) this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public <W extends Widget> ModalCloser<O, W> show(Function<O, W> builder) {
            this.builder = (Function) Objects.requireNonNull(builder);

            return (ModalCloser<O, W>) this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public <C> Events<Ⅲ<O, W, C>> closeWhen(Function<W, Events<C>> closer) {
            Objects.requireNonNull(closer);

            // =====================================
            // Ideal Code
            // =====================================
            // Events<O> open = opener;
            // Events<Binary<O, W>> build = open.map(v -> I.pair(v, builder.apply(v)));
            // Events<Ternary<O, W, C>> close = build.flatMapLatest(v -> closer.apply(v.e).map(x ->
            // v.ò(x)));
            //
            // build.to(v -> open(v.e));
            // close.to(v -> close(v.e));
            //
            // return close;

            // =====================================
            // Optimized Code
            // =====================================
            opener.to(opening -> {
                W widget = builder.apply(opening);

                open(widget);

                closer.apply(widget).take(1).to(closing -> {
                    close(widget);

                    Ⅲ<O, W, C> context = I.pair(opening, widget, closing);

                    for (Observer observer : observers) {
                        observer.accept(context);
                    }
                });
            });
            return new Events(observers);
        }

        /**
         * <p>
         * Open modal contents area.
         * </p>
         * 
         * @param widget A contents.
         */
        private void open(Widget widget) {
            Modal = document.createElement("div").add($.Modal);

            // insert into document
            document.getElementById("Content").after(Modal);

            // show modal
            document.documentElement().add($.Hide);

            widget.renderIn(Modal.add($.Show));
        }

        /**
         * <p>
         * Close modal contents area.
         * </p>
         * 
         * @param widget A contents.
         */
        private void close(Widget widget) {
            // hide modal
            document.documentElement().remove($.Hide);
            widget.renderOut(Modal.remove($.Show));

            // remove modal element
            Modal.remove();
        }

        /**
         * @version 2015/10/16 14:46:30
         */
        private static class $ extends StyleDSL {

            static Style Modal = () -> {
                display.none();
            };

            static Style Show = () -> {
                display.flex().justifyContent.center();
                display.size(100, percent).zIndex(100);
                background.color(rgba(255, 255, 255, 0.9));
                position.fixed().top(0, px).left(0, px);
                overflow.y.auto();
                pointerEvents.auto();
                padding.vertical(2, em);
            };

            static Style Hide = () -> {
                overflow.hidden();
            };
        }
    }
}
