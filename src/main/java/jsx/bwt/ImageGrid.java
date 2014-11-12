/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt;

import static jsx.bwt.ImageGridStyle2.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import js.dom.Element;
import js.dom.UIAction;
import jsx.bwt.ImageGridStyle.InputStyle;
import jsx.event.SubscribeUI;

/**
 * @version 2013/07/31 3:21:20
 */
public abstract class ImageGrid<T> extends UI {

    /** The image elements. */
    private Map<T, Element> images = new HashMap();

    /** The image sources. */
    private Collection<T> sources;

    private Input input;

    private Element search = root.child("input", InputStyle.class).attr("type", "text").subscribe(this);

    /**
     * Filter image by user input.
     */
    @SubscribeUI(type = UIAction.KeyUp)
    protected void search() {
        String name = search.val().toLowerCase().replace("\\s", "");

        for (Entry<T, Element> entry : images.entrySet()) {
            if (getTitle(entry.getKey()).toLowerCase().contains(name)) {
                entry.getValue().remove(Unselected);
            } else {
                entry.getValue().add(Unselected);
            }
        }
    }

    /**
     * Create image grid.
     * 
     * @param parent
     */
    public ImageGrid() {
        sources = sources();
        root.add(Root);

        Element set = root.child(ImageSet);

        for (final T source : sources) {
            Element container = set.child(Container);
            Element image = container.child(IconImage);

            apply(source, image);

            container.child(Title).text(getTitle(source));

            image.observe(UIAction.Click).to(value -> {
                select(source);
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
    protected abstract void apply(T source, Element element);

    /**
     * <p>
     * Activate this method when some source is seleted by pointer event.
     * </p>
     * 
     * @param source
     */
    protected abstract void select(T source);
}
