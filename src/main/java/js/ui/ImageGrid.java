/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import js.util.HashMap;
import booton.css.CSS;
import booton.css.Value;
import booton.translator.web.jQuery;
import booton.translator.web.jQuery.Event;
import booton.translator.web.jQuery.Listener;
import booton.util.Font;

/**
 * @version 2012/12/19 9:51:49
 */
public abstract class ImageGrid<T> extends UI {

    protected static enum N {
        a;
    }

    /** The image elements. */
    private Map<T, jQuery> images = new HashMap();

    /** The image sources. */
    private Collection<T> sources;

    /**
     * Create image grid.
     * 
     * @param parent
     */
    public ImageGrid() {
        sources = sources();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void compose(jQuery parent) {
        root.css("line-height", "0").css("width", "700px").css("margin", "0 auto");

        final jQuery search = root.child("input").css("display", "block");
        search.keyup(new Listener() {

            @Override
            public void handler(Event event) {
                String name = search.val().toLowerCase().replace("\\s", "");

                for (Entry<T, jQuery> entry : images.entrySet()) {
                    if (getTitle(entry.getKey()).toLowerCase().contains(name)) {
                        entry.getValue().removeClass("unselected");
                    } else {
                        entry.getValue().addClass("unselected");
                    }
                }
            }
        });

        for (T source : sources) {

            jQuery image = root.child(Style.class).css("background-image", "url(" + getImageURI(source) + ")");
            image.child("span").text(getTitle(source));

            images.put(source, image);
        }

        parent.append(root);
    }

    /**
     * <p>
     * Set image sources.
     * </p>
     * 
     * @return
     */
    protected abstract Collection<T> sources();

    /**
     * <p>
     * Find name of the specified source.
     * </p>
     * 
     * @param source A images source.
     * @return
     */
    protected abstract String getTitle(T source);

    /**
     * <p>
     * Find uri of the specified image source.
     * </p>
     * 
     * @param source A images source.
     * @return
     */
    protected abstract String getImageURI(T source);

    /**
     * @version 2012/12/19 12:59:03
     */
    private static class Style extends CSS<Style> {

        private Font Yanone = new Font("http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz");

        {
            display.inlineBlock();
            box.size(70, px);
            outline.none();
            background.color.transparent().noRepeat().top().left().contain();
            position.relative();
            transition.property.all().duration(0.2, s).timing.easeInOut();

            cover();

            while (rule(".unselected")) {
                box.opacity(0);
                margin.right(-70, px);
            }

            while (rule("span")) {
                font.weight.bold().size(18, px).family(Yanone);
                line.height(20, px);
                padding.size(5, px);
                text.align.center().shadow(1, px, 1, px, 1, px, rgba(0, 0, 0, 0.1));
                background.color(255, 255, 255, 0.6);
                border.radius(5, px);
                pointerEvents.none();
                position.bottom(100, px);
                box.opacity(0).shadow(1, px, 1, px, 2, px, rgba(0, 0, 0, 0.1));
                transition.property.all().duration(0.2, s).timing.easeInOut().delay(0.15, s);

                bubble(100, 4, 10);
            }

            while (rule(":hover span")) {
                box.opacity(0.9);
                position.bottom(70, px);
            }
        }

        /**
         * Apply screen cover.
         */
        private void cover() {
            Value width = box.width();
            Value height = box.height();

            while (after()) {
                content.text("");
                display.block();
                position.absolute();
                box.width(width.size, width.unit).height(height.size, height.unit).opacity(0.15);
                background.color.white();
            }

            while (rule(":hover::after")) {
                box.opacity(0);
            }
        }

        /**
         * @version 2012/12/20 11:27:57
         */
        private static class TextStyle extends CSS<TextStyle> {

            private Font Yanone = new Font("http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz");

            {
                font.weight.bold().size(18, px).family(Yanone);
                line.height(20, px);
                padding.size(5, px);
                text.align.center().shadow(1, px, 1, px, 1, px, rgba(0, 0, 0, 0.1));
                background.color(255, 255, 255, 0.6);
                border.radius(5, px);
                pointerEvents.none();
                position.bottom(100, px);
                box.opacity(0).shadow(1, px, 1, px, 2, px, rgba(0, 0, 0, 0.1));
                transition.property.all().duration(0.2, s).timing.easeInOut().delay(0.15, s);

                bubble(100, 4, 10);
            }
        }
    }
}
