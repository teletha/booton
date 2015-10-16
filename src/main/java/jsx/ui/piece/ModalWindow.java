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

import java.util.Objects;
import java.util.function.BiConsumer;

import js.dom.Element;
import jsx.style.StyleDescriptor;
import jsx.ui.Style;
import jsx.ui.Widget;
import kiss.Events;

/**
 * @version 2015/10/16 14:38:27
 */
public class ModalWindow<W extends Widget> extends Widget {

    /** The actual {@link Widget} contents. */
    public final W contents;

    /** The special element for modal contents. */
    private Element Modal;

    /**
     * @param widgetType
     */
    <S, H> ModalWindow(W widget, Events<S> show, Events<H> hide, BiConsumer<S, H> process) {
        Objects.nonNull(widget);
        Objects.nonNull(show);
        Objects.nonNull(hide);

        this.contents = widget;

        show.to(v -> {
            Modal = document.createElement("div").add($.Modal);

            // insert into document
            document.getElementById("Content").after(Modal);

            // show modal
            document.documentElement().add($.Hide);
            contents.renderIn(Modal.add($.Show));
        });

        hide.to(v -> {
            // hide modal
            document.documentElement().remove($.Hide);
            contents.renderOut(Modal.remove($.Show));

            // remove modal element
            Modal.remove();
        });

        show.combine(hide).to(v -> process.accept(v.a, v.e));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize() {
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
