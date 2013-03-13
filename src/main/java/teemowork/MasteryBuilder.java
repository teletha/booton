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

import static teemowork.model.Mastery.*;
import js.application.Page;
import js.application.PageInfo;
import js.util.jQuery;
import js.util.jQuery.Event;
import js.util.jQuery.Listener;
import teemowork.MasteryBuilderStyle.EmptyIcon;
import teemowork.MasteryBuilderStyle.Hierarchy;
import teemowork.MasteryBuilderStyle.Level;
import teemowork.MasteryBuilderStyle.MasteryIcon;
import teemowork.MasteryBuilderStyle.Offence;
import teemowork.MasteryBuilderStyle.Separator;
import teemowork.MasteryBuilderStyle.Value;
import teemowork.model.Mastery;
import teemowork.model.MasterySet;

/**
 * @version 2013/03/13 14:31:08
 */
public class MasteryBuilder extends Page {

    private static final Mastery[][] OFFENCE = { {SummonersWrath, Fury, Sorcery, Butcher},
            {null, Deadliness, Blast, Destruction}, {Havoc, WeaponExpertise, ArcaneKnowledge, null},
            {Lethality, BruteForce, MentalForce, Spellsword}, {Frenzy, Sunder, Archmage, null},
            {null, Executioner, null, null}};

    private MasterySet masterySet = new MasterySet();

    @PageInfo(path = "Mastery")
    public MasteryBuilder() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(jQuery root) {
        jQuery offence = root.child(Offence.class);

        for (Mastery[] masteries : OFFENCE) {
            jQuery hierarchy = offence.child(Hierarchy.class);

            for (final Mastery mastery : masteries) {
                jQuery icon = hierarchy.child(MasteryIcon.class);

                if (mastery == null) {
                    icon.addClass(EmptyIcon.class);
                } else {
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
                    });

                    jQuery level = icon.child(Level.class);
                    level.child(Value.class).text(0);
                    level.child(Separator.class).text("/");
                    level.child(Value.class).text(mastery.level);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "Mastery";
    }
}
