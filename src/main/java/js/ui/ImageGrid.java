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

import js.ui.ImageGridStyle.Container;
import js.ui.ImageGridStyle.IconImage;
import js.ui.ImageGridStyle.ImageSet;
import js.ui.ImageGridStyle.Input;
import js.ui.ImageGridStyle.Root;
import js.ui.ImageGridStyle.Title;
import js.ui.ImageGridStyle.Unselected;
import js.util.HashMap;
import js.util.jQuery;
import js.util.jQuery.Listener;

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
        root.addClass(Root.class);

        final jQuery search = $("<input type='text'>");
        search.appendTo(root);

        search.addClass(Input.class);
        search.keyup(new Listener() {

            @Override
            public void handler(UIEvent event) {
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

        jQuery set = root.child(ImageSet.class);

        for (final T source : sources) {
            jQuery container = set.child(Container.class);
            jQuery image = container.child(IconImage.class);

            apply(source, image);

            container.child(Title.class).text(getTitle(source));

            image.click(new Listener() {

                @Override
                public void handler(UIEvent event) {
                    select(source);
                }
            });

            images.put(source, image);
        }
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
     * Apply image to the element.
     * </p>
     * 
     * @param source A image source.
     * @param element A images element.
     * @return
     */
    protected abstract void apply(T source, jQuery element);

    /**
     * <p>
     * Activate this method when some source is seleted by pointer event.
     * </p>
     * 
     * @param source
     */
    protected abstract void select(T source);
}
