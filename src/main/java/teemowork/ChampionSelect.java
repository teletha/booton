/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import java.util.Collection;

import js.dom.DocumentFragment;
import js.dom.Element;
import jsx.application.Application;
import jsx.application.Page;
import jsx.application.PageInfo;
import jsx.bwt.ImageGrid;
import teemowork.model.Champion;

/**
 * @version 2012/12/26 13:06:59
 */
public class ChampionSelect extends Page {

    /** The champion viewer. */
    private ImageGrid champions = new ImageGrid<Champion>() {

        @Override
        protected Collection<Champion> sources() {
            return Champion.getAll();
        }

        @Override
        protected String getTitle(Champion source) {
            return source.name;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void apply(Champion source, Element element) {
            source.applyIcon(element);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void select(Champion source) {
            Application.show(new ChampionDetail(source.systemName));
        }
    };

    @PageInfo(path = "")
    public ChampionSelect() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(DocumentFragment root) {
        root.child(champions);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "";
    }
}
