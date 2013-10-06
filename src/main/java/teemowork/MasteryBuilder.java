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
import js.dom.DocumentFragment;
import js.dom.Element;
import js.dom.EventListener;
import js.dom.Image;
import jsx.application.Page;
import jsx.application.PageInfo;
import jsx.bwt.Button;
import jsx.bwt.Select;
import jsx.bwt.Subscribe;
import jsx.bwt.UIAction;
import jsx.bwt.UIEvent;
import jsx.model.SelectableModel;
import kiss.I;
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

    private MasteryManager set;

    private final MasterySet masterySet;

    /** The sum. */
    private Element sum;

    /** The offense value. */
    private Element offense;

    /** The offense value. */
    private Element defense;

    /** The offense value. */
    private Element utility;

    /** The reset button. */
    private Button reset;

    /** The add button. */
    private Button add;

    private Element name;

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
    public void load(DocumentFragment root) {
        // set = localStorage.get(MasteryManager.class);

        if (set == null) {
            set = new MasteryManager();
        }

        Element infomation = root.child(Information.class);
        menu = infomation.child(new Select(set));
        menu.model.register(this);

        reset = infomation.child(new Button("30", new EventListener() {

            @Override
            public void handleEvent(UIEvent event) {
                masterySet.reset();
            }
        }));

        add = infomation.child(new Button("ADD", new EventListener() {

            @Override
            public void handleEvent(UIEvent event) {
                menu.model.add(new MasterySet(masterySet.getCode()));
            }
        }));

        offense = build(root.child(Offense.class), OFFENSE);
        defense = build(root.child(Defense.class), DEFEMSE);
        utility = build(root.child(Utility.class), UTILITY);

        masterySet.publish(masterySet);
    }

    /**
     * <p>
     * Helper method to build view.
     * </p>
     * 
     * @param root
     * @param set
     */
    private Element build(Element root, Mastery[][] set) {
        for (Mastery[] masteries : set) {
            Element rank = root.child(RankPane.class);

            for (final Mastery mastery : masteries) {
                Element pane = rank.child(MasteryPane.class);

                if (mastery == null) {
                    pane.add(EmptyPane.class);
                } else {
                    masterySet.register(new MasteryView(pane, mastery));
                }
            }
        }
        return root.child(SumPoint.class);
    }

    /**
     * 
     */
    @Subscribe(MasterySet.class)
    public void receive() {
        reset.label(String.valueOf(30 - masterySet.getSum()));

        offense.text("OFFENSE　" + masterySet.getSum(Mastery.Offense));
        defense.text("DEFENSE　" + masterySet.getSum(Mastery.Defense));
        utility.text("UTILITY　" + masterySet.getSum(Mastery.Utility));

        history.replaceState("", "", "#" + getPageId());

        System.out.println("save");
        StringBuilder builder = new StringBuilder();
        I.write(set, builder, true);
        System.out.println(builder.toString());
        localStorage.set(set);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "Mastery/" + masterySet.toString();
    }

    @Subscribe(jsx.model.SelectableModel.Select.class)
    private void select(jsx.model.SelectableModel.Select<MasterySet> event) {
        masterySet.setCode(event.item.getCode());
    }

    /**
     * @version 2013/03/23 14:05:25
     */
    private class MasteryView {

        private final int size = 45;

        /** The associated mastery. */
        private final Mastery mastery;

        /** The root element. */
        private final Element root;

        /** The icon image. */
        private final Image image;

        /** The value element. */
        private final Element currentLevel;

        /** The popup element. */
        private final Element popup;

        /**
         * <p>
         * Create mastery view.
         * </p>
         * 
         * @param root
         * @param mastery
         */
        private MasteryView(final Element root, final Mastery mastery) {
            this.root = root;
            this.mastery = mastery;

            // Icon Pane
            image = root.image(IconImage.class).src(mastery.getSpriteImage()).clip(mastery.id * size, 0, size, size);

            // Mastery Level Pane
            Element levelPane = root.child(LevelPane.class);
            currentLevel = levelPane.child(LevelValue.class).text(0);
            levelPane.child(LevelSeparator.class).text("/");
            levelPane.child(LevelValue.class).text(mastery.getMaxLevel());

            // Mastery Description Pane
            popup = root.child(PopupPane.class);
            popup.child(MasteryName.class).text(mastery.name);
            masterySet.register(new MasteryDescriptionView(popup, mastery));

            // Event Handlers
            root.on(UIAction.Click, new EventListener() {

                @Override
                public void handleEvent(UIEvent event) {
                    event.preventDefault();
                    masterySet.up(mastery);
                }
            }).on(UIAction.ClickLeft, new EventListener() {

                @Override
                public void handleEvent(UIEvent event) {
                    event.preventDefault();
                    masterySet.down(mastery);
                }
            });
        }

        /**
         * 
         */
        @Subscribe(MasterySet.class)
        public void receive() {
            System.out.println("set mastery");
            int current = masterySet.getLevel(mastery);

            // Update current level
            currentLevel.text(current);

            // Switch enable / disable
            if (current != 0 || masterySet.isAvailable(mastery)) {
                image.saturate(0.8);
                root.remove(Unavailable.class);
            } else {
                image.grayscale(0.4);
                root.add(Unavailable.class);
            }

            // Switch complete / incomplete
            if (masterySet.isMax(mastery)) {
                root.add(Completed.class);
            } else {
                root.remove(Completed.class);
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
            private MasteryDescriptionView(Element root, Describable describable) {
                super(root, describable, null, true);
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

            /**
             * {@inheritDoc}
             */
            @Override
            @Subscribe(MasterySet.class)
            public void receive() {
                super.receive();
            }
        }
    }

    /**
     * @version 2013/10/04 13:04:34
     */
    private static class MasteryManager extends SelectableModel<MasterySet> {
    }
}
