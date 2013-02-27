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

import static js.lang.Global.*;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import js.util.HashMap;
import js.util.jQuery;
import js.util.jQuery.Event;
import js.util.jQuery.Listener;
import booton.css.CSS;
import booton.css.Value;
import booton.util.Font;

/**
 * @version 2012/12/19 9:51:49
 */
public abstract class ImageGrid<T> extends UI {

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

        final jQuery search = $("<input type='text'>");
        search.appendTo(root);

        search.addClass(Input.class).css("display", "block");
        search.keyup(new Listener() {

            @Override
            public void handler(Event event) {
                String name = search.val().toLowerCase().replace("\\s", "");

                for (Entry<T, jQuery> entry : images.entrySet()) {
                    if (getTitle(entry.getKey()).toLowerCase().contains(name)) {
                        entry.getValue().removeClass(Unselected.class);
                    } else {
                        entry.getValue().addClass(Unselected.class);
                    }
                }
            }
        });

        for (final T source : sources) {
            jQuery image = root.child(Image.class).css("background-image", "url(" + getImageURI(source) + ")");
            image.child("span").addClass(Title.class).text(getTitle(source));

            image.click(new Listener() {

                @Override
                public void handler(Event event) {
                    select(source);
                }
            });

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
     * <p>
     * Activate this method when some source is seleted by pointer event.
     * </p>
     * 
     * @param source
     */
    protected abstract void select(T source);

    /**
     * @version 2012/12/19 12:59:03
     */
    private static class Image extends CSS {

        private static int imageSize = 70;

        {
            display.inlineBlock();
            box.size(imageSize, px);
            outline.none();
            background.color.transparent().top().left().contain();
            position.relative();
            transition.property.all().duration(0.2, s).timing.easeInOut();

            cover();
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
                box.width(width).height(height).opacity(0.15);
                background.color.white();

                while (parentHover()) {
                    box.opacity(0);
                }
            }
        }
    }

    /**
     * @version 2012/12/23 16:35:59
     */
    private static class Title extends CSS {

        private Font Yanone = new Font("http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz");

        {
            Value boxWidth = new Value(Image.imageSize + 30, px);
            Value borderWidth = new Value(4, px);

            font.weight.bold().size(18, px).family(Yanone);
            line.height(20, px);
            padding.size(5, px);
            text.align.center().shadow(1, px, 1, px, 1, px, rgba(0, 0, 0, 0.1f));
            background.color(255, 255, 255, 0.6f);
            pointerEvents.none();
            box.opacity(0).shadow(1, px, 1, px, 2, px, rgba(0, 0, 0, 0.1f)).width(boxWidth);
            transition.property.all().duration(0.2, s).timing.easeInOut().delay(0.15, s);
            position.absolute().left(50, percent).bottom(boxWidth);
            margin.left(boxWidth.divide(-2));
            border.width(borderWidth).solid().color(5, 5, 5).radius(5, px);

            bubble(Image.imageSize + 30, 4, 10);

            while (parentHover()) {
                box.opacity(0.9);
                position.bottom(Image.imageSize, px);
            }
        }
    }

    /**
     * @version 2012/12/23 16:36:42
     */
    private static class Unselected extends CSS {

        {
            box.opacity(0);
            margin.right(-70, px);
        }
    }

    /**
     * @version 2012/12/25 21:15:42
     */
    private static class Input extends CSS {

        {
            display.inlineBlock();
            box.height(20, px).width(200, px).shadowInset(0, px, 1, px, 1, px, rgba(0, 0, 0, 0.075f));
            padding.vertical(4, px).horizontal(6, px);
            margin.bottom(10, px);
            font.size(14, px).color(85, 85, 85);
            line.height(20, px);
            text.verticalAlign.middle();
            border.radius(4, px).width(1, px).solid().color(204, 204, 204);
            background.color(255, 255, 255);
            transition.property.all().duration(0.2, s).timing.linear();

            while (focus()) {
                border.color(82, 168, 236, 0.8f);
                outline.none();
                box.shadowInset(0, px, 1, px, 1, px, rgba(0, 0, 0, 0.075f))
                        .shadow(0, px, 0, px, 8, px, rgba(82, 168, 236, 0.6f));
            }
        }
    }
}
