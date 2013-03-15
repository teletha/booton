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
import js.util.ArrayList;
import js.util.jQuery;
import js.util.jQuery.Event;
import js.util.jQuery.Listener;
import teemowork.MasteryBuilderStyle.Available;
import teemowork.MasteryBuilderStyle.Completed;
import teemowork.MasteryBuilderStyle.Defense;
import teemowork.MasteryBuilderStyle.EmptyIcon;
import teemowork.MasteryBuilderStyle.Filter;
import teemowork.MasteryBuilderStyle.Hierarchy;
import teemowork.MasteryBuilderStyle.Level;
import teemowork.MasteryBuilderStyle.MasteryContainer;
import teemowork.MasteryBuilderStyle.MasteryIcon;
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
            this.popup = icon.parent().child(Popup.class).text(mastery.name);
            this.filter = icon.child(Filter.class);

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
            }).dblclick(new Listener() {

                @Override
                public void handler(Event event) {
                    event.preventDefault();
                    event.stopPropagation();
                }
            });

            jQuery level = icon.child(Level.class);
            this.value = level.child(Value.class).text(0);
            level.child(Separator.class).text("/");
            level.child(Value.class).text(mastery.level);
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
        }
    }
}
