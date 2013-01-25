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

import static teemowork.model.Status.*;

import java.lang.reflect.Method;

import js.application.Page;
import js.application.PageInfo;
import js.bind.Notifiable;
import js.bind.Observable;
import js.bind.Observer;
import js.util.jQuery;
import js.util.jQuery.Event;
import js.util.jQuery.Listener;
import teemowork.model.Build;
import teemowork.model.Champion;
import booton.css.CSS;

/**
 * @version 2013/01/10 2:36:58
 */
public class ChampionDetail extends Page {

    /** The your custom build. */
    @Observable
    private final Build build;

    /** The status. */
    private jQuery level;

    /** The status. */
    private StatusBox health;

    /** The status. */
    private StatusBox mana;

    /** The status. */
    private StatusBox ad;

    /** The status. */
    private StatusBox as;

    /** The status. */
    private StatusBox ms;

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
        this.build = new Build(champion);

        bind(build);
    }

    /**
     * <p>
     * Bind.
     * </p>
     * 
     * @param notifiable
     */
    private void bind(Notifiable notifiable) {
        if (notifiable != null) {
            // collect observer
            for (Method method : getClass().getMethods()) {
                if (method.isAnnotationPresent(Observer.class)) {
                    notifiable.register(this, method);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(jQuery root) {
        jQuery info = root.child(RootPanel.class)
                .css("background-image", "url('" + build.champion.getSplashArt() + "')")
                .child(RootPanelFilter.class);

        jQuery icon = info.child(Icon.class)
                .css("background-image", "url(" + build.champion.getIcon() + ")")
                .click(new Listener() {

                    @Override
                    public void handler(Event event) {
                        event.preventDefault();

                        build.setLevel(build.getLevel() + 1);
                    }
                })
                .on("contextmenu", new Listener() {

                    @Override
                    public void handler(Event event) {
                        event.preventDefault();

                        build.setLevel(build.getLevel() - 1);
                    }
                });

        level = icon.child(Level.class);
        health = new StatusBox("Health", info);
        mana = new StatusBox("Mana", info);
        ad = new StatusBox("AD", info);
        as = new StatusBox("AS", info);
        ms = new StatusBox("MS", info);

        calcurate();
    }

    /**
     * <p>
     * Calcurate current status.
     * </p>
     */
    @Observer
    private void calcurate() {
        // update each status
        level.text(String.valueOf(build.getLevel()));
        health.set(build.get(Health), build.getBase(Health));
        mana.set(build.get(Mana), build.getBase(Mana));
        ad.set(build.get(AD), build.getBase(AD));
        as.set(build.getAS(), build.getASIncreased());
        ms.set(build.get(MS), build.getBase(MS));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "Champion/" + build.champion.name;
    }

    /**
     * @version 2013/01/21 16:29:15
     */
    private static class StatusBox {

        /** The value for curernt Lv. */
        private jQuery current;

        /** The value for per Lv. */
        private jQuery perLv;

        /**
         * @param name
         */
        private StatusBox(String name, jQuery root) {
            jQuery status = root.child(Box.class);
            status.child(Name.class).text(name);
            current = status.child(Value.class);
            perLv = status.child(Value.class);
        }

        /**
         * <p>
         * Set status.
         * </p>
         * 
         * @param current
         * @param per
         */
        private void set(double current, double per) {
            this.current.text(String.valueOf(current));
            this.perLv.text("(+" + per + ")");
        }

        /**
         * @version 2013/01/21 16:33:33
         */
        private static class Box extends CSS {

            {
                display.block();
                box.width(240, px);
            }
        }

        /**
         * @version 2013/01/21 16:33:33
         */
        private static class Name extends CSS {

            {
                display.tableCell();
                box.width(50, px);
            }
        }

        /**
         * @version 2013/01/21 16:33:33
         */
        private static class Value extends CSS {

            {
                display.tableCell();
                box.width(50, px);
            }
        }
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
}
