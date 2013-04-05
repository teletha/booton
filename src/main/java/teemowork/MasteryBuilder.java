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
import js.application.Page;
import js.application.PageInfo;
import js.bind.Subscriber;
import js.dom.Image;
import js.ui.Select;
import js.ui.model.Selectable;
import js.util.jQuery;
import js.util.jQuery.Event;
import js.util.jQuery.Listener;
import teemowork.MasteryBuilderStyle.Completed;
import teemowork.MasteryBuilderStyle.Defense;
import teemowork.MasteryBuilderStyle.EmptyPane;
import teemowork.MasteryBuilderStyle.IconImage;
import teemowork.MasteryBuilderStyle.Information;
import teemowork.MasteryBuilderStyle.LevelPane;
import teemowork.MasteryBuilderStyle.LevelSeparator;
import teemowork.MasteryBuilderStyle.LevelValue;
import teemowork.MasteryBuilderStyle.MasteryName;
import teemowork.MasteryBuilderStyle.MasteryPane;
import teemowork.MasteryBuilderStyle.Offense;
import teemowork.MasteryBuilderStyle.PopupPane;
import teemowork.MasteryBuilderStyle.RankPane;
import teemowork.MasteryBuilderStyle.ResetButton;
import teemowork.MasteryBuilderStyle.SumPoint;
import teemowork.MasteryBuilderStyle.Unavailable;
import teemowork.MasteryBuilderStyle.Utility;
import teemowork.model.Describable;
import teemowork.model.DescriptionView;
import teemowork.model.Mastery;
import teemowork.model.MasterySet;
import teemowork.model.Version;

/**
 * @version 2013/03/23 14:06:31
 */
public class MasteryBuilder extends Page implements Subscriber {

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

    private final Selectable<MasterySet> set = new Selectable();

    private final MasterySet masterySet;

    /** The sum. */
    private jQuery sum;

    /** The offense value. */
    private jQuery offense;

    /** The offense value. */
    private jQuery defense;

    /** The offense value. */
    private jQuery utility;

    /** The reset button. */
    private jQuery reset;

    /** The add button. */
    private jQuery add;

    private jQuery name;

    private Select<MasterySet> menu;

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
        jQuery infomation = root.child(Information.class);
        menu = infomation.child(new Select(set));
        menu.model.add(masterySet);

        reset = infomation.child(ResetButton.class).click(new Listener() {

            @Override
            public void handler(Event event) {
                masterySet.reset();
                menu.model.add(new MasterySet("02t4w002005m9s001ls"));
                menu.model.add(new MasterySet("09tz400200b8jk001ls"));
            }
        });

        add = infomation.child(ResetButton.class).text("ADD");

        offense = build(root.child(Offense.class), OFFENSE);
        defense = build(root.child(Defense.class), DEFEMSE);
        utility = build(root.child(Utility.class), UTILITY);

        masterySet.publish();
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
            jQuery rank = root.child(RankPane.class);

            for (final Mastery mastery : masteries) {
                jQuery pane = rank.child(MasteryPane.class);

                if (mastery == null) {
                    pane.addClass(EmptyPane.class);
                } else {
                    masterySet.register(new MasteryView(pane, mastery));
                }
            }
        }
        return root.child(SumPoint.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receive() {
        reset.text(30 - masterySet.getSum());

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
     * @version 2013/03/23 14:05:25
     */
    private class MasteryView implements Subscriber {

        private final int size = 45;

        /** The associated mastery. */
        private final Mastery mastery;

        /** The root element. */
        private final jQuery root;

        /** The icon image. */
        private final Image image;

        /** The value element. */
        private final jQuery currentLevel;

        /** The popup element. */
        private final jQuery popup;

        /**
         * <p>
         * Create mastery view.
         * </p>
         * 
         * @param root
         * @param mastery
         */
        private MasteryView(final jQuery root, final Mastery mastery) {
            this.root = root;
            this.mastery = mastery;

            // Icon Pane
            image = root.image(IconImage.class).src(mastery.getSpriteImage()).clip(mastery.id * size, 0, size, size);

            // Mastery Level Pane
            jQuery levelPane = root.child(LevelPane.class);
            currentLevel = levelPane.child(LevelValue.class).text(0);
            levelPane.child(LevelSeparator.class).text("/");
            levelPane.child(LevelValue.class).text(mastery.getMaxLevel());

            // Mastery Description Pane
            popup = root.child(PopupPane.class);
            popup.child(MasteryName.class).text(mastery.name);
            masterySet.register(new MasteryDescriptionView(popup, mastery));

            // Event Handlers
            root.click(new Listener() {

                @Override
                public void handler(Event event) {
                    event.preventDefault();
                    masterySet.up(mastery);
                }
            }).contextmenu(new Listener() {

                @Override
                public void handler(Event event) {
                    event.preventDefault();
                    masterySet.down(mastery);
                }
            });
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void receive() {
            int current = masterySet.getLevel(mastery);

            // Update current level
            currentLevel.text(current);

            // Switch enable / disable
            if (current != 0 || masterySet.isAvailable(mastery)) {
                image.saturate(0.8);
                root.removeClass(Unavailable.class);
            } else {
                image.grayscale(0.4);
                root.addClass(Unavailable.class);
            }

            // Switch complete / incomplete
            if (masterySet.isMax(mastery)) {
                root.addClass(Completed.class);
            } else {
                root.removeClass(Completed.class);
            }
        }

        /**
         * @version 2013/03/23 12:30:51
         */
        private class MasteryDescriptionView extends DescriptionView {

            /**
             * @param root
             * @param describable
             */
            private MasteryDescriptionView(jQuery root, Describable describable) {
                super(root, describable, true);
            }

            /**
             * {@inheritDoc}
             */
            @Override
            protected int getLevel() {
                return masterySet.getLevel(mastery);
            }

            /**
             * {@inheritDoc}
             */
            @Override
            protected Version getVersion() {
                return Version.Latest;
            }
        }
    }
}
