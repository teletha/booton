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
import static teemowork.model.Mastery.*;

import java.util.List;

import js.application.Page;
import js.application.PageInfo;
import js.bind.Observer;
import js.math.Mathematics;
import js.util.ArrayList;
import js.util.jQuery;
import js.util.jQuery.Event;
import js.util.jQuery.Listener;
import teemowork.ChampionDetailStyle.Amplifier;
import teemowork.MasteryBuilderStyle.Available;
import teemowork.MasteryBuilderStyle.Completed;
import teemowork.MasteryBuilderStyle.ComputedValue;
import teemowork.MasteryBuilderStyle.Current;
import teemowork.MasteryBuilderStyle.Defense;
import teemowork.MasteryBuilderStyle.Description;
import teemowork.MasteryBuilderStyle.EmptyIcon;
import teemowork.MasteryBuilderStyle.Filter;
import teemowork.MasteryBuilderStyle.Hierarchy;
import teemowork.MasteryBuilderStyle.Level;
import teemowork.MasteryBuilderStyle.MasteryContainer;
import teemowork.MasteryBuilderStyle.MasteryIcon;
import teemowork.MasteryBuilderStyle.Name;
import teemowork.MasteryBuilderStyle.Offense;
import teemowork.MasteryBuilderStyle.Popup;
import teemowork.MasteryBuilderStyle.PopupShow;
import teemowork.MasteryBuilderStyle.Separator;
import teemowork.MasteryBuilderStyle.Sum;
import teemowork.MasteryBuilderStyle.Unavailable;
import teemowork.MasteryBuilderStyle.Utility;
import teemowork.MasteryBuilderStyle.Value;
import teemowork.model.Mastery;
import teemowork.model.MasterySet;
import teemowork.model.Status;
import teemowork.model.Version;
import teemowork.model.variable.Variable;
import teemowork.model.variable.VariableResolver;

/**
 * @version 2013/03/13 14:31:08
 */
public class MasteryBuilder extends Page {

    private static final Mastery[][] OFFENSE = { {SummonersWrath, Fury, Sorcery, Butcher},
            {null, Deadliness, Blast, Destruction}, {Havoc, WeaponExpertise, ArcaneKnowledge, null},
            {Lethality, BruteForce, MentalForce, Spellsword}, {Frenzy, Sunder, Archmage, null},
            {null, Executioner, null, null}};

    private static final Mastery[][] DEFEMSE = { {SummonersResolve, Perseverance, Durability, ToughSkin},
            {Hardiness, Resistance, null, BladedArmor}, {Unyielding, Relentless, VeteransScar, Safeguard},
            {Block, Tenacious, Juggernaut, null}, {Defender, LegendaryArmor, GoodHands, ReinforcedArmor},
            {null, HonorGuard, null, null}};

    private static final Mastery[][] UTILITY = { {SummonersInsight, Wanderer, Meditation, ImprovedRecall},
            {Scout, Mastermind, ExpandedMind, Artificer}, {Greed, RunicAffinity, Vampirism, Biscuiteer},
            {Wealth, Awareness, StrengthOfSpirit, Explorer}, {Pickpocket, Intelligence, null, null},
            {null, Nimble, null, null}};

    private final MasterySet masterySet;

    /** The sum. */
    private jQuery sum;

    /** The offense value. */
    private jQuery offense;

    /** The offense value. */
    private jQuery defense;

    /** The offense value. */
    private jQuery utility;

    /** The view manager. */
    private final List<MasteryView> views = new ArrayList();

    @PageInfo(path = "Mastery")
    public MasteryBuilder() {
        this("");
    }

    @PageInfo(path = "Mastery/*")
    public MasteryBuilder(String levels) {
        masterySet = new MasterySet(levels);
        masterySet.register(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(jQuery root) {
        offense = build(root.child(Offense.class), OFFENSE);
        defense = build(root.child(Defense.class), DEFEMSE);
        utility = build(root.child(Utility.class), UTILITY);

        update();
    }

    /**
     * <p>
     * Helper method to build view.
     * </p>
     * 
     * @param root
     * @param set
     */
    private jQuery build(jQuery root, Mastery[][] set) {
        for (Mastery[] masteries : set) {
            jQuery hierarchy = root.child(Hierarchy.class);

            for (final Mastery mastery : masteries) {
                jQuery parent = hierarchy.child(MasteryContainer.class);
                jQuery icon = parent.child(MasteryIcon.class);

                if (mastery == null) {
                    icon.addClass(EmptyIcon.class);
                } else {
                    views.add(new MasteryView(icon, mastery));
                }
            }
        }
        return root.child(Sum.class);
    }

    /**
     * <p>
     * Update View.
     * </p>
     */
    @Observer
    private void update() {
        for (MasteryView view : views) {
            view.update();
        }
        offense.text("OFFENSE　" + masterySet.getSum(Mastery.Offense));
        defense.text("DEFENSE　" + masterySet.getSum(Mastery.Defense));
        utility.text("UTILITY　" + masterySet.getSum(Mastery.Utility));

        history.replaceState("", "", "#" + getPageId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "Mastery/" + masterySet.toString();
    }

    /**
     * @version 2013/03/13 19:10:27
     */
    private class MasteryView {

        /** The associated mastery. */
        private final Mastery mastery;

        /** The icon element. */
        private final jQuery icon;

        /** The filter element. */
        private final jQuery filter;

        /** The value element. */
        private final jQuery value;

        /** The popup element. */
        private jQuery popup;

        private jQuery text;

        /**
         * <p>
         * Create mastery view.
         * </p>
         * 
         * @param icon
         * @param mastery
         */
        private MasteryView(final jQuery icon, final Mastery mastery) {
            this.mastery = mastery;
            this.icon = icon;
            this.filter = icon.child(Filter.class);
            this.popup = icon.parent().child(Popup.class);

            popup.child(Name.class).text(mastery.name);

            this.text = popup.child(Description.class);

            icon.css("background-image", "url(" + mastery.getIcon() + ")");
            icon.click(new Listener() {

                @Override
                public void handler(Event event) {
                    event.preventDefault();
                    masterySet.up(mastery);
                }
            }).on("contextmenu", new Listener() {

                @Override
                public void handler(Event event) {
                    event.preventDefault();

                    masterySet.down(mastery);
                }
            }).mouseenter(new Listener() {

                @Override
                public void handler(Event event) {
                    popup.addClass(PopupShow.class);
                }
            }).mouseleave(new Listener() {

                @Override
                public void handler(Event event) {
                    popup.removeClass(PopupShow.class);
                }
            });

            jQuery level = icon.child(Level.class);
            this.value = level.child(Value.class).text(0);
            level.child(Separator.class).text("/");
            level.child(Value.class).text(mastery.getMaxLevel());
        }

        /**
         * <p>
         * Update this view.
         * </p>
         */
        public void update() {
            int current = masterySet.getLevel(mastery);

            value.text(current);

            if (current != 0 || masterySet.isAvailable(mastery)) {
                icon.removeClass(Unavailable.class).addClass(Available.class);
            } else {
                icon.removeClass(Available.class).addClass(Unavailable.class);
            }

            if (masterySet.isMax(mastery)) {
                icon.addClass(Completed.class);
            } else {
                icon.removeClass(Completed.class);
            }

            receive();
        }

        /**
         * {@inheritDoc}
         */
        public void receive() {
            text.empty();

            List passive = mastery.getDescriptor(Version.Latest).getPassive();

            if (!passive.isEmpty()) {
                for (Object token : passive) {
                    if (token instanceof Variable) {
                        writeVariable(text, (Variable) token, masterySet.getLevel(mastery));
                    } else {
                        text.append(token.toString());
                    }
                }
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

            // compute current value
            root.child(ComputedValue.class).text(status.format(variable.calculate(Math.max(1, level))));

            // All values
            int size = resolver.estimateSize();

            if (1 < size || !amplifiers.isEmpty()) {
                root.append("(");

                for (int i = 1; i <= size; i++) {
                    jQuery element = root.child(Value.class).text(Mathematics.round(resolver.compute(i), 2));

                    if (i == level) {
                        element.addClass(Current.class);
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

                int size = amplifier.getResolver().estimateSize();

                for (int i = 1; i <= size; i++) {
                    jQuery value = element.child(Value.class).text(Mathematics.round(amplifier.calculate(i), 4));

                    if (size != 1 && i == level) {
                        value.addClass(Current.class);
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
}
