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

import js.Page;
import js.PageInfo;
import teemowork.model.Champion;
import booton.css.CSS;
import booton.translator.web.jQuery;

/**
 * @version 2013/01/10 2:36:58
 */
public class ChampionDetail extends Page {

    /** The chmapion. */
    private final Champion champion;

    /**
     * Build page.
     * 
     * @param champion
     */
    @PageInfo(path = "Champion/*")
    public ChampionDetail(String name) {
        this(Champion.getByName(name));
    }

    /**
     * Build page.
     * 
     * @param champion
     */
    public ChampionDetail(Champion champion) {
        if (champion == null) {
            throw new Error();
        }
        this.champion = champion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(jQuery root) {
        jQuery info = root.child(Detail.class)
                .css("background-image", "url(" + champion.getSplashArt() + ")")
                .child(Filter.class);

        info.child(Name.class).text(champion.name);
        info.child(Status.class).text("ad");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "Champion/" + champion.name;
    }

    /**
     * @version 2013/01/15 13:19:52
     */
    private static class Detail extends CSS {

        {
            display.block();
            box.width(100, percent).height(600, px);
            background.cover();
            border.radius(10, px);
        }
    }

    /**
     * @version 2013/01/15 13:54:32
     */
    private static class Filter extends CSS {

        {
            display.block();
            box.size(100, percent);
            background.color(255, 255, 255, 0.3);
        }
    }

    /**
     * @version 2013/01/15 13:19:52
     */
    private static class Name extends CSS {

        {

        }
    }

    /**
     * @version 2013/01/15 13:19:52
     */
    private static class Status extends CSS {

        {

        }
    }
}
