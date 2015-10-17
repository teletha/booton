/*
 * Copyright (C) 2015 Nameless Production Committee
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
import jsx.style.StyleDescriptor;
import jsx.ui.Style;
import jsx.ui.Widget;
import jsx.ui.piece.UI.Modal.Builder;
import jsx.ui.piece.UI.Modal.Closer;
import jsx.ui.piece.UI.Modal.Opener;
import kiss.Binary;
import kiss.Events;
import kiss.I;
import kiss.Observer;
import kiss.Ternary;

/**
 * @version 2015/10/09 15:28:40
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
    public static final <E extends Enum> Select<E> select(Class<E> enumClass) {
        ListProperty<E> items = I.make(ListProperty.class);

        for (Enum constant : enumClass.getEnumConstants()) {
            items.add((E) constant);
        }
        return select(items);
    }

    /**
     * <p>
     * Create {@link Select} box with the specified values.
     * </p>
     * 
     * @param values
     */
    public static final <M> Select<M> select(ListProperty<M> values) {
        return new Select(values);
    }

    /**
     * <p>
     * Create {@link ModalWindow} for the specified {@link Widget}.
     * </p>
     * 
     * @param widgetType
     * @return
     */
    public static final Modal.Opener modal() {
        return new ModalMaker();
    }

    /**
     * @version 2015/10/16 23:15:05
     */
    interface Modal {

        /**
         * @version 2015/10/16 23:15:35
         */
        interface Opener {

            /**
             * <p>
             * Alias method for {@link #openWhen(Events)}.
             * </p>
             * 
             * @param opener A open timing for the modal contents.
             * @return A contents builder.
             */
            default <O> Builder<O> open(Events<O> opener) {
                return openWhen(opener);
            }

            /**
             * <p>
             * Configure the open timing for the modal contents.
             * </p>
             * 
             * @param opener A open timing for the modal contents.
             * @return A contents builder.
             */
            <O> Builder<O> openWhen(Events<O> opener);
        }

        /**
         * @version 2015/10/16 23:17:32
         */
        interface Builder<O> {

            /**
             * <p>
             * Configure the modal contents.
             * </p>
             * 
             * @param builder
             * @return
             */
            default <W extends Widget> Closer<O, W> show(Class<W> contents) {
                return show(Widget.of(contents));
            }

            /**
             * <p>
             * Configure the modal contents.
             * </p>
             * 
             * @param contents
             * @return
             */
            default <W extends Widget> Closer<O, W> show(W contents) {
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
            <W extends Widget> Closer<O, W> show(Function<O, W> contents);
        }

        /**
         * @version 2015/10/16 23:19:22
         */
        interface Closer<O, W> {

            /**
             * <p>
             * Alias method for {@link #closeWhen(Function)}.
             * </p>
             * 
             * @param closer A close timing for the modal contents.
             * @return A user action.
             */
            default <C> Events<Ternary<O, W, C>> close(Events<C> closer) {
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
            default <C> Events<Ternary<O, W, C>> closeWhen(Events<C> closer) {
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
            <C> Events<Ternary<O, W, C>> closeWhen(Function<W, Events<C>> closer);
        }
    }

    /**
     * @version 2015/10/16 23:30:34
     */
    @SuppressWarnings("hiding")
    private static class ModalMaker<O, W extends Widget, C> implements Opener, Builder<O>, Closer<O, W> {

        private Events<O> opener;

        private Function<O, W> builder;

        /** The special element for modal contents. */
        private Element Modal;

        private final List<Observer> observers = new ArrayList();

        /**
         * {@inheritDoc}
         */
        @Override
        public <T> Builder<T> openWhen(Events<T> opener) {
            this.opener = (Events) Objects.requireNonNull(opener);

            return (Builder<T>) this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public <W extends Widget> Closer<O, W> show(Function<O, W> builder) {
            this.builder = (Function) Objects.requireNonNull(builder);

            return (Closer<O, W>) this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public <C> Events<Ternary<O, W, C>> closeWhen(Function<W, Events<C>> closer) {
            Objects.requireNonNull(closer);

            Events<O> open = opener;
            // Events<W> content = open.map(builder).sideEffect(this::open);
            // Events<C> close = content.flatMap(closer).sideEffect(this::close);

            Events<Binary<O, W>> content = open.map(v -> I.pair(v, builder.apply(v))).sideEffect(this::open);
            Events<Ternary<O, W, C>> close = content.flatMap(v -> closer.apply(v.e).map(x -> v.ò(x)));
            close.to(this::close);

            return close;
            // return open.combine(content, close);

            // opener.to(opening -> {
            // W widget = builder.apply(opening);
            //
            // open(widget);
            //
            // closer.apply(widget).take(1).to(closing -> {
            // close(widget);
            //
            // Ternary<O, W, C> context = I.pair(opening, widget, closing);
            //
            // for (Observer observer : observers) {
            // observer.accept(context);
            // }
            // });
            // });
            // return new Events(observers);
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

            w = widget;
        }

        /**
         * <p>
         * Open modal contents area.
         * </p>
         * 
         * @param widget A contents.
         */
        private void open(Binary<O, W> widget) {
            System.out.println("show modal " + widget.a + "  " + widget.e);
            Modal = document.createElement("div").add($.Modal);

            // insert into document
            document.getElementById("Content").after(Modal);

            // show modal
            document.documentElement().add($.Hide);

            widget.e.renderIn(Modal.add($.Show));
        }

        Widget w;

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

        private <C> void close(C widget) {
            // hide modal
            document.documentElement().remove($.Hide);
            w.renderOut(Modal.remove($.Show));

            // remove modal element
            Modal.remove();
        }

        private <C> void close(Ternary<O, W, C> widget) {
            // hide modal
            document.documentElement().remove($.Hide);
            widget.e.renderOut(Modal.remove($.Show));

            // remove modal element
            Modal.remove();
        }

        /**
         * @version 2015/10/16 14:46:30
         */
        private static class $ extends StyleDescriptor {

            static Style Modal = () -> {
                display.none();
            };

            static Style Show = () -> {
                display.flex().justifyContent.center();
                box.size(100, percent).zIndex(100);
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
