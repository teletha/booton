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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import js.dom.Element;
import js.dom.Element.EventListener;
import jsx.bwt.ImageGridStyle.Container;
import jsx.bwt.ImageGridStyle.IconImage;
import jsx.bwt.ImageGridStyle.ImageSet;
import jsx.bwt.ImageGridStyle.Input;
import jsx.bwt.ImageGridStyle.Root;
import jsx.bwt.ImageGridStyle.Title;
import jsx.bwt.ImageGridStyle.Unselected;

/**
 * @version 2013/07/05 15:02:47
 */
public abstract class ImageGrid<T> extends UI {

    /** The image elements. */
    private Map<T, Element> images = new HashMap();

    /** The image sources. */
    private Collection<T> sources;

    private Element search = rootElement.child("input", Input.class).attr("type", "text").bind(this);

    /**
     * Filter image by user input.
     */
    @Listen(UIAction.KeyUp)
    private void search() {
        System.out.println("aa");
        String name = search.val().toLowerCase().replace("\\s", "");

        for (Entry<T, Element> entry : images.entrySet()) {
            if (getTitle(entry.getKey()).toLowerCase().contains(name)) {
                entry.getValue().remove(Unselected.class);
            } else {
                entry.getValue().add(Unselected.class);
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
        rootElement.add(Root.class);

        Element set = rootElement.child(ImageSet.class);

        for (final T source : sources) {
            Element container = set.child(Container.class);
            Element image = container.child(IconImage.class);

            apply(source, image);

            container.child(Title.class).text(getTitle(source));

            image.on(UIAction.Click, new EventListener() {

                @Override
                public void handleEvent(UIEvent event) {
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
