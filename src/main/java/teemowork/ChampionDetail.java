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
import js.math.Mathematics;
import js.util.ArrayList;
import js.util.jQuery;
import js.util.jQuery.Event;
import js.util.jQuery.Listener;
import teemowork.lol.Build;
import teemowork.lol.Build.Computed;
import teemowork.lol.Champion;
import teemowork.lol.Skill;
import teemowork.lol.SkillKey;
import teemowork.lol.SkillStatus;
import teemowork.lol.SkillType;
import teemowork.lol.SkillVariable;
import teemowork.lol.SkillVariableResolver;
import teemowork.lol.Status;
import booton.css.CSS;

/**
 * @version 2013/01/10 2:36:58
 */
public class ChampionDetail extends Page {

    /** The displayable status. */
    private static final Status[] VISIBLE = {Health, Hreg, Mana, Mreg, AD, ARPen, AS, LS, Critical, AP, MRPen, CDR, SV,
            AR, MR, MS};

    /** The status box. */
    private List<StatusView> statuses = new ArrayList();

    /** The skill view. */
    private List<SkillView> skills = new ArrayList();

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

        jQuery statusView = root.child(StatusStyle.View.class);

        for (Status status : VISIBLE) {
            statuses.add(new StatusView(status, statusView));
        }

        jQuery skillView = root.child(SkillStyle.SkillTable.class);

        for (final Skill skill : build.champion.skills) {
            skills.add(new SkillView(skill, skillView.child(SkillStyle.SkillRow.class)));
        }

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

        for (SkillView view : skills) {
            view.update();
        }

        for (StatusView box : statuses) {
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
     * @version 2013/02/09 22:59:04
     */
    private class SkillView {

        /** The target to desiplay. */
        private final Skill skill;

        /** The skill level. */
        private final jQuery[] levels;

        /** The skill text. */
        private final jQuery passive;

        /** The skill text. */
        private final jQuery active;

        /** The cool down. */
        private final jQuery cooldown;

        /** The cost. */
        private final jQuery cost;

        /** The cost. */
        private final jQuery range;

        /**
         * @param skill
         */
        private SkillView(final Skill skill, jQuery root) {
            int size = skill.getMaxLevel();

            this.skill = skill;
            this.levels = new jQuery[size];

            jQuery iconBox = root.child(SkillStyle.IconBox.class);
            iconBox.child(SkillStyle.Icon.class).css("background-image", "url(" + skill.getIcon() + ")");
            iconBox.click(new Listener() {

                @Override
                public void handler(Event event) {
                    event.preventDefault();
                    build.up(skill);
                }
            }).on("contextmenu", new Listener() {

                @Override
                public void handler(Event event) {
                    event.preventDefault();
                    build.down(skill);
                }
            });

            if (skill.key != SkillKey.Passive) {
                jQuery levels = iconBox.child(SkillStyle.LevelBox.class);

                for (int i = 0; i < size; i++) {
                    this.levels[i] = levels.child(size == 3 ? SkillStyle.LevelMark3.class : SkillStyle.LevelMark.class);
                }
            }

            jQuery descriptor = root.child(SkillStyle.DescriptionBox.class);
            descriptor.child(SkillStyle.Name.class).text(skill.name);

            this.range = descriptor.child(ValueStyles.Values.class);
            this.cooldown = descriptor.child(ValueStyles.Values.class);
            this.cost = descriptor.child(ValueStyles.Values.class);

            this.passive = descriptor.child(SkillStyle.Text.class);
            this.active = descriptor.child(SkillStyle.Text.class);
        }

        /**
         * <p>
         * Update this view.
         * </p>
         */
        private void update() {
            SkillStatus status = skill.getStatus(build.getVersion());

            int level = build.getLevel(skill);

            for (int i = 0; i < levels.length; i++) {
                if (i < level) {
                    levels[i].addClass(SkillStyle.Assigned.class);
                } else {
                    levels[i].removeClass(SkillStyle.Assigned.class);
                }
            }

            String costLabel = status.getCostType().name;

            if (status.getType() == SkillType.Toggle) {
                costLabel = "毎秒" + costLabel;
            }

            buildValues(cooldown, "CD", status, CD, build.get(CDR).value);
            buildValues(cost, costLabel, status, Cost, 0);
            cost.append(status.getCostType().unit);
            buildValues(range, "RANGE", status, Range, 0);

            // PASSIVE
            passive.empty();

            if (!status.passive.isEmpty()) {
                passive.child(SkillStyle.Passive.class).text("PASSIVE");

                for (Object token : status.passive) {
                    if (token instanceof SkillVariable) {
                        buildVariable(passive, (SkillVariable) token, level);
                    } else {
                        passive.append(token.toString());
                    }
                }
            }

            // ACTIVE
            active.empty();

            if (status.getType() != SkillType.Active) {
                active.child(SkillStyle.Passive.class).text(status.getType().name().toUpperCase());
            }

            for (Object token : status.active) {
                if (token instanceof SkillVariable) {
                    buildVariable(active, (SkillVariable) token, level);
                } else {
                    active.append(token.toString());
                }
            }
        }

        /**
         * @param root
         * @param label
         * @param skill
         * @param status
         * @param reduction
         */
        private void buildValues(jQuery root, String label, SkillStatus skill, Status status, double reduction) {
            root.empty();

            double base = skill.get(status);
            double diff = skill.get(status.per());

            if (base != 0 || diff != 0) {
                int size = diff == 0 ? 1 : this.skill.getMaxLevel();

                root.child(ValueStyles.Label.class).text(label);

                for (int i = 0; i < size; i++) {
                    double value = status.round((base + diff * i) * (1 - reduction / 100));

                    jQuery element = root.child(ValueStyles.Value.class).text(value == -1 ? "∞" : value);

                    if (size != 1 && i == build.getLevel(this.skill) - 1) {
                        element.addClass(ValueStyles.Current.class);
                    }

                    if (i != size - 1) {
                        root.child(ValueStyles.Separator.class).text("/");
                    }
                }
            }
        }

        /**
         * @param root
         * @param variable
         * @param size
         * @param skillLevel
         */
        private void buildVariable(jQuery root, SkillVariable variable, int skillLevel) {
            SkillVariableResolver resolver = variable.getResolver();
            Status status = variable.getStatus();
            List<SkillVariable> amplifiers = variable.amplifiers;

            if (!resolver.isSkillLevelBased()) {
                skillLevel = resolver.convertLevel(build.getLevel());
            }

            // compute current value
            root.child(SkillStyle.Computed.class)
                    .text(status.format(build.computeVariable(skill, variable, Math.max(1, skillLevel))));

            // All values
            double[] values = resolver.enumerate(skill.getMaxLevel());

            if (1 < values.length || !amplifiers.isEmpty()) {
                root.append("(");

                for (int i = 0; i < values.length; i++) {
                    jQuery value = root.child(SkillStyle.Value.class).text(status.round(values[i]));

                    if (i == skillLevel - 1) {
                        value.addClass(SkillStyle.Current.class);
                    }

                    if (i != values.length - 1) {
                        root.child(SkillStyle.Separator.class).text("/");
                    }
                }

                if (!amplifiers.isEmpty()) {
                    for (SkillVariable amplifier : amplifiers) {
                        writeAmplifier(root, amplifier, skillLevel);
                    }
                }
                root.append(")");
            }
        }

        private void writeAmplifier(jQuery root, SkillVariable amplifier, int skillLevel) {
            jQuery element = root.child(SkillStyle.Amplifier.class);
            element.append("+");

            SkillVariableResolver resolver = amplifier.getResolver();

            if (!resolver.isSkillLevelBased()) {
                skillLevel = resolver.convertLevel(build.getLevel());
            }

            int size = resolver.computeSize(skill.getMaxLevel());

            for (int i = 0; i < size; i++) {
                jQuery value = element.child(SkillStyle.Value.class)
                        .text(Mathematics.round(build.computeVariable(skill, amplifier, i + 1), 3));

                if (size != 1 && i == skillLevel - 1) {
                    value.addClass(SkillStyle.Current.class);
                }

                if (i != size - 1) {
                    element.child(SkillStyle.Separator.class).text("/");
                }
            }

            element.append(amplifier.getStatus().unit);

            if (!amplifier.amplifiers.isEmpty()) {
                element.append("(");
                for (SkillVariable nest : amplifier.amplifiers) {
                    writeAmplifier(element, nest, skillLevel);
                }
                element.append(")");
            }

            element.append(amplifier.getStatus().name);
        }
    }

    /**
     * @version 2013/02/10 11:01:26
     */
    private static class ValueStyles {

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Label extends CSS {

            {
                margin.right(5, px);
                font.size.smaller();
            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Values extends CSS {

            {
                display.inlineBlock();
                margin.left(1, em);
            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Value extends CSS {

            {
                display.inlineBlock();
                text.align.center();
                box.opacity(0.7);
            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Separator extends CSS {

            {
                box.opacity(0.4);
                margin.horizontal(4, px);
            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Current extends CSS {

            {
                font.color(rgba(160, 123, 1, 1));
                box.opacity(1);
            }
        }
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
         * @version 2013/02/02 11:27:13
         */
        private static class SkillTable extends CSS {

            {
                display.tableCell();
            }
        }

        /**
         * @version 2013/02/02 11:27:13
         */
        class SkillRow extends CSS {

            {
                display.block();
                margin.bottom(1, em);
            }
        }

        /**
         * @version 2013/02/06 18:51:27
         */
        private static class Icon extends CSS {

            {
                display.block();
                box.size(IconSize, px);
                background.contain().size(IconSize, px);
                border.radius(10, px).color(50, 50, 50).width(2, px).solid();
            }
        }

        /**
         * @version 2013/02/02 11:27:13
         */
        private static class LevelBox extends CSS {

            {
                display.table();
                box.width(IconSize, px).height(LevelBoxHeight, px);
                border.width(1, px).solid().color.black();
                margin.top(2, px).bottom(5, px);
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
                background.image(linear(rgba(240, 192, 28, 0.5), rgba(160, 123, 1, 0.5)));

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
                box.width(IconSize / 3, px);
            }
        }

        /**
         * @version 2013/02/09 23:26:39
         */
        private static class Assigned extends CSS {

            {
                background.image(linear(rgba(240, 192, 28, 1), rgba(160, 123, 1, 1)));
            }
        }

        /**
         * @version 2013/02/02 11:27:13
         */
        private static class IconBox extends CSS {

            {
                display.tableCell();
                padding.right(IconSize / 5, px);
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
                margin.right(0.5, em);
                font.weight.bold();
            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Text extends CSS {

            {
                display.block();
                margin.top(0.4, em);
                line.height(140, percent);
                font.size.smaller();
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
        private static class Range extends CSS {

            {

            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Computed extends CSS {

            {
                font.weight.bolder();
            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Value extends CSS {

            {
                text.align.center();
            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Separator extends CSS {

            {

            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Current extends CSS {

            {
                font.color(rgba(160, 123, 1, 1));
            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Passive extends CSS {

            {
                margin.right(1, em);
            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Amplifier extends CSS {

            {
                font.color(25, 111, 136);

                while (inBackOf(Value.class)) {
                    margin.left(0.4, em);
                }

                while (inBackOf(Amplifier.class)) {
                    margin.left(0.4, em);
                }
            }
        }
    }

    /**
     * @version 2013/01/21 16:29:15
     */
    private class StatusView {

        /** The target to display. */
        private final Status status;

        /** The value for curernt Lv. */
        private final jQuery current;

        /** The value for per Lv. */
        private final jQuery perLv;

        /**
         * @param name
         */
        private StatusView(Status status, jQuery root) {
            jQuery box = root.child(StatusStyle.Box.class);
            box.child(StatusStyle.Name.class).text(status.name());

            this.status = status;
            this.current = box.child(StatusStyle.Value.class);
            this.perLv = box.child(StatusStyle.Value.class);
        }

        /**
         * <p>
         * Calcurate status and show it
         * </p>
         */
        private void calcurate() {
            Computed value = build.get(status);

            this.current.text(value.value() + status.unit);

            if (status == ARPen) {
                current.append(" | ").append(build.get(ARPenRatio).value() + ARPenRatio.unit);
            }

            if (status == MRPen) {
                current.append(" | ").append(build.get(MRPenRatio).value() + MRPenRatio.unit);
            }
        }
    }

    /**
     * @version 2013/02/11 0:12:14
     */
    private static class StatusStyle {

        /**
         * @version 2013/02/11 0:02:30
         */
        class View extends CSS {

            {
                display.tableCell();
                box.width(13, em);
                text.verticalAlign.top();
            }
        }

        /**
         * @version 2013/01/21 16:33:33
         */
        class Box extends CSS {

            {
                display.block();
                margin.bottom(4, px);
            }
        }

        /**
         * @version 2013/01/21 16:33:33
         */
        class Name extends CSS {

            {
                display.tableCell();
                box.width(5, em);
            }
        }

        /**
         * @version 2013/01/21 16:33:33
         */
        class Value extends CSS {

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
            margin.bottom(1, em);
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
