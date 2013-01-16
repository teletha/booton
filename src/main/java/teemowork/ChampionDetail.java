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

import js.Observable;
import js.Page;
import js.PageInfo;
import teemowork.model.Build;
import teemowork.model.Champion;
import teemowork.model.ChampionStatus;
import booton.css.CSS;
import booton.translator.web.jQuery;
import booton.translator.web.jQuery.Event;
import booton.translator.web.jQuery.Listener;

/**
 * @version 2013/01/10 2:36:58
 */
public class ChampionDetail extends Page {

    /** The chmapion. */
    private final Champion champion;

    /** The your custom build. */
    @Observable
    private Build build;

    /** The current level. */
    private int currentLevel;

    private jQuery level;

    /** The status. */
    private jQuery health;

    // /** The status. */
    // private Text mana = new Text() {
    //
    // /**
    // * {@inheritDoc}
    // */
    // @Override
    // protected Object text() {
    // return build.getMana();
    // }
    // };

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
        jQuery info = root.child(RootPanel.class)
                .css("background-image", "url('" + champion.getSplashArt() + "')")
                .child(RootPanelFilter.class);

        jQuery icon = info.child(Icon.class)
                .css("background-image", "url(" + champion.getIcon() + ")")
                .click(new Listener() {

                    @Override
                    public void handler(Event event) {
                        event.preventDefault();

                        setLevel(currentLevel + 1);
                    }
                })
                .on("contextmenu", new Listener() {

                    @Override
                    public void handler(Event event) {
                        event.preventDefault();

                        setLevel(currentLevel - 1);
                    }
                });

        level = icon.child(Level.class);
        health = info.child(Status.class).text("Health").child(Value.class);
        // mana = info.child(Status.class).text("Mana").child(Value.class);

        // initialize
        setLevel(1);
    }

    /**
     * <p>
     * Set champion level.
     * </p>
     * 
     * @param level
     */
    private void setLevel(int level) {
        if (level < 1 || 18 < level) {
            return;
        }

        // new level
        this.currentLevel = level;

        // display
        this.level.text(String.valueOf(level));

        // update each status
        ChampionStatus status = champion.getStatus();

        health.text(String.valueOf(status.getHealth(level)));
        // mana.text(String.valueOf(status.getMana(level)));
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
    private static class RootPanel extends CSS {

        {
            display.block();
            box.width(100, percent).height(900, px);
            background.contain().noRepeat();
            border.radius(10, px);
        }
    }

    /**
     * @version 2013/01/15 13:54:32
     */
    private static class RootPanelFilter extends CSS {

        {
            display.block();
            box.size(100, percent);
            background.color(255, 255, 255, 0.8);
            padding.horizontal(20, px).vertical(20, px);
        }
    }

    /**
     * @version 2013/01/15 13:19:52
     */
    private static class Icon extends CSS {

        {
            display.block();
            box.size(70, px);
            background.contain().size(80, px).horizontal(-5, px).vertical(-5, px);
            border.radius(10, px).color(50, 50, 50).width(2, px).solid();
            position.relative();
        }
    }

    /**
     * @version 2013/01/15 13:19:52
     */
    private static class Level extends CSS {

        {
            display.block();
            box.size(22, px);
            font.size(20, px).color(240, 240, 240).weight.bold().family("Arial");
            text.align.center().shadow(0, px, 0, px, 1, px, rgba(0, 0, 0, 1));
            position.absolute().bottom(4, px).right(4, px);
            userSelect.none();
            cursor.defaults();

            while (selection()) {
                background.color.transparent();
            }
        }
    }

    /**
     * @version 2013/01/15 13:19:52
     */
    private static class Status extends CSS {

        {

        }
    }

    /**
     * @version 2013/01/15 13:19:52
     */
    private static class Value extends CSS {

        {

        }
    }
}
