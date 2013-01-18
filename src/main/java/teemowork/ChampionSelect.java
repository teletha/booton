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

import js.Application;
import js.Page;
import js.PageInfo;
import js.ui.ImageGrid;
import js.util.jQuery;
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

        @Override
        protected String getImageURI(Champion source) {
            return source.getIcon();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void select(Champion source) {
            Application.show(new ChampionDetail(source.name));
        }
    };

    @PageInfo(path = "")
    public ChampionSelect() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(jQuery root) {
        champions.compose(root);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "";
    }
}
