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

import static teemowork.lol.Status.*;

import java.lang.reflect.Method;
import java.util.List;

import js.application.Page;
import js.application.PageInfo;
import js.bind.Notifiable;
import js.bind.Observable;
import js.bind.Observer;
import js.util.ArrayList;
import js.util.jQuery;
import js.util.jQuery.Event;
import js.util.jQuery.Listener;
import teemowork.lol.Build;
import teemowork.lol.Build.Computed;
import teemowork.lol.Champion;
import teemowork.lol.Skill;
import teemowork.lol.SkillKey;
import teemowork.lol.Status;
import booton.css.CSS;

/**
 * @version 2013/01/10 2:36:58
 */
public class ChampionDetail extends Page {

    /** The displayable status. */
    private static final Status[] VISIBLE = {Health, Hreg, Mana, Mreg, AD, AS, Critical, LS, AP, CDR, SV, AR, MR,
            ARPen, MRPen, MS};

    /** The status box. */
    private List<StatusBox> boxies = new ArrayList();

    /** The your custom build. */
    @Observable
    private final Build build;

    /** The status. */
    private jQuery level;

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
        jQuery icon = root.child(Icon.class)
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

        jQuery skills = root.child(SkillTable.class);

        for (final Skill skill : build.champion.skills) {
            jQuery box = skills.child(SkillRow.class);
            jQuery iconBox = box.child(SkillIconBox.class);
            iconBox.child(SkillStyle.Icon.class).css("background-image", "url(" + skill.getIcon() + ")");

            if (skill.key != SkillKey.Passive) {
                jQuery levels = iconBox.child(SkillStyle.LevelBox.class);

                int size = skill.getMaxLevel();

                for (int i = 0; i < size; i++) {
                    levels.child(size == 3 ? SkillStyle.LevelMark3.class : SkillStyle.LevelMark.class);
                }
            }

            jQuery descriptor = box.child(SkillStyle.DescriptionBox.class);
            descriptor.child(SkillStyle.Name.class).text(skill.name);
            descriptor.child(SkillStyle.Text.class).text(skill.getStatus(build.getVersion()).getDescription());
        }

        for (Status status : VISIBLE) {
            boxies.add(new StatusBox(status, root, build));
        }

        calcurate();
    }

    /**
     * <p>
     * </p>
     */
    private void skillLevelUp() {

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

        for (StatusBox box : boxies) {
            box.calcurate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "Champion/" + build.champion.systemName;
    }

    /**
     * @version 2013/01/21 16:29:15
     */
    private static class StatusBox {

        /** The target to display. */
        private final Status status;

        /** The value for curernt Lv. */
        private jQuery current;

        /** The value for per Lv. */
        private jQuery perLv;

        /** The build. */
        private final Build build;

        /**
         * @param name
         */
        private StatusBox(Status status, jQuery root, Build build) {
            jQuery box = root.child(Box.class);
            box.child(Name.class).text(status.name());

            this.status = status;
            this.current = box.child(Value.class);
            this.perLv = box.child(Value.class);
            this.build = build;

        }

        /**
         * <p>
         * Calcurate status and show it
         * </p>
         */
        private void calcurate() {
            Computed value = build.get(status);

            this.current.text(value.value());
            this.perLv.text("(+" + value.increased + ")");
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

    /**
     * @version 2013/02/06 19:56:37
     */
    private static class StatusStyle {

    }

    /**
     * @version 2013/02/06 18:46:37
     */
    private static class SkillStyle {

        /** The skill icon size. */
        private static final int IconSize = 45;

        /** The level box height. */
        private static final int LevelBoxHeight = 5;

        /**
         * @version 2013/02/06 18:51:27
         */
        private static class Icon extends CSS {

            {
                display.block();
                box.size(IconSize, px);
                background.contain().size(IconSize, px);
                border.radius(10, px).color(50, 50, 50).width(2, px).solid();
                margin.right(5, px);
            }
        }

        /**
         * @version 2013/02/02 11:27:13
         */
        private static class LevelBox extends CSS {

            {
                display.table();
                box.width(IconSize + 2, px).height(LevelBoxHeight, px);
                border.width(1, px).solid().color.black();
            }
        }

        /**
         * @version 2013/02/02 11:27:13
         */
        private static class LevelMark extends CSS {

            {
                display.tableCell();
                box.width(IconSize / 5, px).height(LevelBoxHeight, px);
                borderLeft.solid().color.black().width(1, px);
                background.image(linear(rgba(240, 192, 28, 1), rgba(160, 123, 1, 1)));

                while (firstChild()) {
                    border.none();
                }
            }
        }

        /**
         * @version 2013/02/02 11:27:13
         */
        private static class LevelMark3 extends LevelMark {

            {
                // display.tableCell();
                box.width(IconSize / 3, px);
                // borderLeft.solid().color.black().width(1, px);
                // background.image(linear(rgba(240, 192, 28, 1), rgba(160, 123, 1, 1)));
                //
                // while (firstChild()) {
                // border.none();
                // }
            }
        }

        /**
         * @version 2013/02/02 11:27:13
         */
        private static class DescriptionBox extends CSS {

            {
                display.tableCell();
                text.verticalAlign.top();
            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Name extends CSS {

            {
                display.block();
            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Text extends CSS {

            {

            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Cost extends CSS {

            {

            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Cooldown extends CSS {

            {

            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Range extends CSS {

            {

            }
        }
    }

    /**
     * @version 2013/02/02 11:27:13
     */
    private static class SkillTable extends CSS {

        {
            display.table();
        }
    }

    /**
     * @version 2013/02/02 11:27:13
     */
    private static class SkillRow extends CSS {

        {
            display.tableRow();
        }
    }

    /**
     * @version 2013/02/02 11:27:13
     */
    private static class SkillIconBox extends CSS {

        {
            display.tableCell();
        }
    }
}
