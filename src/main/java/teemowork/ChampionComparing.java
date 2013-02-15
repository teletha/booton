/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import js.application.Page;
import js.application.PageInfo;
import js.util.jQuery;

/**
 * @version 2013/02/15 15:12:54
 */
public class ChampionComparing extends Page {

    /**
     * 
     */
    @PageInfo(path = "ChampionComparing")
    public ChampionComparing() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(jQuery root) {
        System.out.println("test");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "ChampionComparing";
    }
}
