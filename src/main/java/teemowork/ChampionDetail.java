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

import static js.lang.Global.*;
import static teemowork.model.Status.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import js.bind.Notifiable;
import js.bind.Observer;
import js.math.Mathematics;
import js.util.jQuery;
import js.util.jQuery.Listener;
import jsx.application.Page;
import jsx.application.PageInfo;
import jsx.bwt.UI;
import jsx.bwt.UIEvent;
import teemowork.ChampionDetailStyle.Active;
import teemowork.ChampionDetailStyle.Amplifier;
import teemowork.ChampionDetailStyle.Assigned;
import teemowork.ChampionDetailStyle.ChampionIcon;
import teemowork.ChampionDetailStyle.ComputedValue;
import teemowork.ChampionDetailStyle.Current;
import teemowork.ChampionDetailStyle.DescriptionBox;
import teemowork.ChampionDetailStyle.IconBox;
import teemowork.ChampionDetailStyle.ItemIcon;
import teemowork.ChampionDetailStyle.ItemIconBase;
import teemowork.ChampionDetailStyle.ItemViewBox;
import teemowork.ChampionDetailStyle.Level;
import teemowork.ChampionDetailStyle.LevelBox;
import teemowork.ChampionDetailStyle.LevelMark;
import teemowork.ChampionDetailStyle.LevelMark3;
import teemowork.ChampionDetailStyle.Name;
import teemowork.ChampionDetailStyle.NormalValue;
import teemowork.ChampionDetailStyle.Passive;
import teemowork.ChampionDetailStyle.Separator;
import teemowork.ChampionDetailStyle.SkillIcon;
import teemowork.ChampionDetailStyle.SkillRow;
import teemowork.ChampionDetailStyle.SkillStatusValue;
import teemowork.ChampionDetailStyle.SkillStatusValues;
import teemowork.ChampionDetailStyle.SkillTable;
import teemowork.ChampionDetailStyle.StatusBox;
import teemowork.ChampionDetailStyle.StatusLabel;
import teemowork.ChampionDetailStyle.StatusName;
import teemowork.ChampionDetailStyle.StatusValue;
import teemowork.ChampionDetailStyle.StatusViewBox;
import teemowork.ChampionDetailStyle.Text;
import teemowork.ChampionDetailStyle.UpperInfo;
import teemowork.model.Build;
import teemowork.model.Build.Computed;
import teemowork.model.Champion;
import teemowork.model.DependencyManager;
import teemowork.model.Item;
import teemowork.model.Skill;
import teemowork.model.SkillDescriptor;
import teemowork.model.SkillKey;
import teemowork.model.SkillType;
import teemowork.model.Status;
import teemowork.model.Version;
import teemowork.model.variable.Variable;
import teemowork.model.variable.VariableResolver;

/**
 * @version 2013/01/10 2:36:58
 */
public class ChampionDetail extends Page {

    /** The displayable status. */
    private static final Status[] VISIBLE = {Health, Hreg, Mana, Mreg, AD, ARPen, AS, LS, Critical, AP, MRPen, CDR, SV,
            AR, MR, MS, Range, Tenacity};

    /** The status box. */
    private List<StatusView> statuses = new ArrayList();

    /** The item box. */
    private List<ItemBox> items = new ArrayList();

    /** The your custom build. */
    private final Build build;

    /** The status. */
    private jQuery level;

    /** The skill view. */
    private jQuery skillView;

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
        jQuery upper = root.child(UpperInfo.class);

        // Icon
        jQuery icon = upper.child(ChampionIcon.class).click(new Listener() {

            @Override
            public void handler(UIEvent event) {
                event.preventDefault();

                build.setLevel(build.getLevel() + 1);
            }
        }).on("contextmenu", new Listener() {

            @Override
            public void handler(UIEvent event) {
                event.preventDefault();

                build.setLevel(build.getLevel() - 1);
            }
        });
        build.champion.applyIcon(icon);

        // Level
        level = icon.child(Level.class);

        // Items
        jQuery itemViewBox = upper.child(ItemViewBox.class);

        for (int i = 0; i < 6; i++) {
            items.add(itemViewBox.child(new ItemBox(build.getItem(i))));
        }

        jQuery statusView = root.child(StatusViewBox.class);

        for (Status status : VISIBLE) {
            statuses.add(new StatusView(status, statusView));
        }
        skillView = root.child(SkillTable.class);

        $(window).keypress(new Listener() {

            @Override
            public void handler(UIEvent event) {
                switch (event.which) {
                case 113:// Q
                    build.active(SkillKey.Q);
                    break;

                case 119:// W
                    build.active(SkillKey.W);
                    break;

                case 101:// E
                    build.active(SkillKey.E);
                    break;

                case 114:// R
                    build.active(SkillKey.R);
                    break;

                default:
                    break;
                }
            }
        });

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

        skillView.empty();

        for (Skill skill : build.champion.skills) {
            new SkillView(skill, skillView.child(SkillRow.class)).update();
        }

        for (StatusView box : statuses) {
            box.calcurate();
        }

        for (ItemBox box : items) {
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

        /** The icon element. */
        private final jQuery icon;

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

            jQuery iconBox = root.child(IconBox.class);
            icon = iconBox.child(SkillIcon.class).css("background-image", "url(" + skill.getIcon() + ")");
            iconBox.click(new Listener() {

                @Override
                public void handler(UIEvent event) {
                    event.preventDefault();
                    build.up(skill);
                }
            }).on("contextmenu", new Listener() {

                @Override
                public void handler(UIEvent event) {
                    event.preventDefault();
                    build.down(skill);
                }
            });

            if (skill.key != SkillKey.Passive) {
                jQuery levels = iconBox.child(LevelBox.class);

                for (int i = 0; i < size; i++) {
                    this.levels[i] = levels.child(size == 3 ? LevelMark3.class : LevelMark.class);
                }
            }

            jQuery descriptor = root.child(DescriptionBox.class);
            descriptor.child(Name.class).text(skill.name);

            this.range = descriptor.child(SkillStatusValues.class);
            this.cooldown = descriptor.child(SkillStatusValues.class);
            this.cost = descriptor.child(SkillStatusValues.class);

            this.passive = descriptor.child(Text.class);
            this.active = descriptor.child(Text.class);
        }

        /**
         * <p>
         * Update this view.
         * </p>
         */
        private void update() {
            SkillDescriptor status = skill.getDescriptor(build.getVersion());

            int level = build.getLevel(skill);

            for (int i = 0; i < levels.length; i++) {
                if (i < level) {
                    levels[i].add(Assigned.class);
                } else {
                    levels[i].remove(Assigned.class);
                }
            }

            if (build.isActive(skill)) {
                icon.add(Active.class);
            } else {
                icon.remove(Active.class);
            }

            write(cooldown, status, status.getCooldown());
            write(cost, status, status.getCost());
            write(range, status, status.getRange());

            // avoid circular dependency
            DependencyManager.use(skill);

            // PASSIVE
            passive.empty();

            if (!status.getPassive().isEmpty()) {
                passive.child(Passive.class).text("PASSIVE");

                for (Object token : status.getPassive()) {
                    if (token instanceof Variable) {
                        writeVariable(passive, (Variable) token, level);
                    } else {
                        passive.append(token.toString());
                    }
                }
            }

            // ACTIVE
            active.empty();

            SkillType type = status.getType();

            if (type != SkillType.Active && type != SkillType.OnHitEffectable) {
                active.child(Passive.class).text(status.getType().name().toUpperCase());
            }

            for (Object token : status.getActive()) {
                if (token instanceof Variable) {
                    writeVariable(active, (Variable) token, level);
                } else {
                    active.append(token.toString());
                }
            }

            if (type == SkillType.OnHitEffectable) {
                active.append("このスキルはOn-Hit Effectの影響を受ける。");
            }

            // avoid circular dependency
            DependencyManager.unuse(skill);

        }

        /**
         * <p>
         * Write skill related status.
         * </p>
         * 
         * @param root A element to write.
         * @param skill A current processing skill.
         * @param variable A target skill variable.
         */
        private void write(jQuery root, SkillDescriptor skill, Variable variable) {
            root.empty();

            if (variable != null) {
                Status status = variable.getStatus();
                VariableResolver resolver = variable.getResolver();

                int level = build.getLevel(this.skill);

                if (!resolver.isSkillLevelBased()) {
                    level = resolver.convertLevel(build);
                }

                // write label
                String label = status.name;

                if (status != Range && status != CD && skill.getType() == SkillType.Toggle) {
                    label = "毎秒" + label;
                }
                root.child(StatusLabel.class).text(label);

                // write values
                int size = resolver.estimateSize();

                for (int i = 1; i <= size; i++) {
                    double value = status.round(variable.calculate(i, build));
                    jQuery element = root.child(SkillStatusValue.class).text(value == -1 ? "∞" : value);

                    if (size != 1 && i == level) {
                        element.add(Current.class);
                    }

                    if (i != size) {
                        root.child(Separator.class).text("/");
                    }
                }

                // write amplifiers
                writeAmplifier(root, variable.getAmplifiers(), 0);

                // write unit
                root.append(status.getUnit());
            }
        }

        /**
         * <p>
         * </p>
         * 
         * @param root
         * @param variable
         * @param level
         */
        private void writeVariable(jQuery root, Variable variable, int level) {
            VariableResolver resolver = variable.getResolver();
            Status status = variable.getStatus();
            List<Variable> amplifiers = variable.getAmplifiers();

            if (!resolver.isSkillLevelBased()) {
                level = resolver.convertLevel(build);
            }

            // compute current value
            root.child(ComputedValue.class).text(status.format(variable.calculate(Math.max(1, level), build)));

            // All values
            int size = resolver.estimateSize();

            if (1 < size || !amplifiers.isEmpty()) {
                root.append("(");

                for (int i = 1; i <= size; i++) {
                    jQuery element = root.child(NormalValue.class).text(Mathematics.round(resolver.compute(i), 2));

                    if (i == level) {
                        element.add(Current.class);
                    }

                    if (i != size) {
                        root.child(Separator.class).text("/");
                    }
                }

                writeAmplifier(root, amplifiers, level);
                root.append(")");
            }
        }

        /**
         * <p>
         * Write skill amplifier.
         * </p>
         * 
         * @param root A element to write.
         * @param amplifiers A list of skill amplifiers.
         * @param level A current skill level.
         */
        private void writeAmplifier(jQuery root, List<Variable> amplifiers, int level) {
            for (Variable amplifier : amplifiers) {
                jQuery element = root.child(Amplifier.class);
                element.append("+");

                VariableResolver resolver = amplifier.getResolver();

                if (!resolver.isSkillLevelBased()) {
                    level = resolver.convertLevel(build);
                }

                int size = resolver.estimateSize();

                for (int i = 1; i <= size; i++) {
                    jQuery value = element.child(NormalValue.class)
                            .text(Mathematics.round(amplifier.calculate(i, build), 4));

                    if (size != 1 && i == level) {
                        value.add(Current.class);
                    }

                    if (i != size) {
                        element.child(Separator.class).text("/");
                    }
                }

                element.append(amplifier.getStatus().getUnit());
                if (!amplifier.getAmplifiers().isEmpty()) {
                    element.append("(");
                    writeAmplifier(element, amplifier.getAmplifiers(), level);
                    element.append(")");
                }
                element.append(amplifier.getStatus().name);
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

        /**
         * @param name
         */
        private StatusView(Status status, jQuery root) {
            jQuery box = root.child(StatusBox.class);
            box.child(StatusName.class).text(status.name());

            this.status = status;
            this.current = box.child(StatusValue.class);
        }

        /**
         * <p>
         * Calcurate status and show it
         * </p>
         */
        private void calcurate() {
            Computed value = build.get(status);

            this.current.text(value.value() + status.getUnit());

            if (status == ARPen) {
                current.append(" | ").append(build.get(ARPenRatio).value() + ARPenRatio.getUnit());
            }

            if (status == MRPen) {
                current.append(" | ").append(build.get(MRPenRatio).value() + MRPenRatio.getUnit());
            }
        }
    }

    /**
     * @version 2013/03/13 10:41:24
     */
    private class ItemBox extends UI {

        /** The item. */
        private Item item;

        /** The root element. */
        private final jQuery icon;

        /**
         * @param item
         */
        public ItemBox(Item item) {
            this.item = item;
            this.icon = root.add(ItemIconBase.class).child(ItemIcon.class);
        }

        /**
         * <p>
         * Calcurate status and show it
         * </p>
         */
        private void calcurate() {
            if (item != null) {
                item.applyIcon(icon);

                ItemView view = new ItemView(item, item.getDescriptor(Version.Latest), build);
                view.root.css("max-width", "350px");

                setTooltip(view);
            }
        }
    }
}
