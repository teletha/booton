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

import javafx.beans.property.BooleanProperty;

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
    ModalWindow(Class<W> widgetType) {
        this.contents = Widget.of(widgetType);

        // lazy initialization
        if (Modal == null) {

        }
    }

    public ModalWindow<W> showWhen(Events show) {
        show.to(v -> {
            Modal = document.createElement("div").add($.Modal);

            // insert into document
            document.getElementById("Content").after(Modal);

            // show modal
            document.documentElement().add($.Hide);
            contents.renderIn(Modal.add($.Show));
        });

        // API definition
        return this;
    }

    public ModalWindow<W> showIf(BooleanProperty condition) {
        condition.addListener((object, oldValue, newValue) -> {
            if (newValue) {
                Modal = document.createElement("div").add($.Modal);

                // insert into document
                document.getElementById("Content").after(Modal);

                // show modal
                document.documentElement().add($.Hide);
                contents.renderIn(Modal.add($.Show));
            } else {
                // hide modal
                document.documentElement().remove($.Hide);
                contents.renderOut(Modal.remove($.Show));

                // remove modal element
                Modal.remove();
            }
        });
        return this;
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
