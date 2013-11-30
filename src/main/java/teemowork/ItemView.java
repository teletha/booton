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
import js.dom.Element;
import js.dom.EventListener;
import jsx.application.Application;
import jsx.bwt.UI;
import jsx.bwt.UIAction;
import jsx.bwt.UIEvent;
import teemowork.ItemViewStyle.AbilityArea;
import teemowork.ItemViewStyle.Cost;
import teemowork.ItemViewStyle.DescriptionArea;
import teemowork.ItemViewStyle.Heading;
import teemowork.ItemViewStyle.Icon;
import teemowork.ItemViewStyle.IconArea;
import teemowork.ItemViewStyle.Material;
import teemowork.ItemViewStyle.Materials;
import teemowork.ItemViewStyle.Name;
import teemowork.ItemViewStyle.Root;
import teemowork.ItemViewStyle.StatusValue;
import teemowork.ItemViewStyle.TotalCost;
import teemowork.ItemViewStyle.UniqueAbility;
import teemowork.model.Ability;
import teemowork.model.AbilityDescriptor;
import teemowork.model.Describable;
import teemowork.model.DescriptionView;
import teemowork.model.Item;
import teemowork.model.ItemDescriptor;
import teemowork.model.Status;
import teemowork.model.StatusCalculator;
import teemowork.model.Version;

/**
 * @version 2013/06/09 19:05:04
 */
public class ItemView extends UI {

    private static final Status[] VISIBLE = {Health, Hreg, Mana, Mreg, AD, ASRatio, ARPen, LS, Critical, AP, CDR, SV,
            MRPen, AR, MR, MSRatio, GoldPer10Sec};

    /** The status calculator. */
    private final StatusCalculator calculator;

    /**
     * @param item
     */
    public ItemView(Item item, ItemDescriptor itemDescriptor, StatusCalculator calculator) {
        this.calculator = calculator;
        root.add(Root.class);

        // Icon Area
        Element icons = root.child(IconArea.class);
        // icons.child(Icon.class).backgound(item.getIcon());
        item.applyIcon(icons.child(Icon.class));

        Element materials = icons.child(Materials.class);

        for (final Item material : itemDescriptor.getBuild()) {
            material.applyIcon(materials.child(Material.class)
                    .attr("title", material.name)
                    .on(UIAction.Click, new EventListener() {

                        @Override
                        public void handleEvent(UIEvent event) {
                            Application.show(new ItemDetail(material.name));
                        }
                    }));
        }

        // Description Area
        Element descriptions = root.child(DescriptionArea.class);

        // Name and Cost
        double cost = itemDescriptor.get(Cost);
        double total = item.getTotalCost(Version.Latest);

        Element heading = descriptions.child(Heading.class);
        heading.child(Name.class).text(item.name);
        heading.child(TotalCost.class).text(total);
        if (cost != total) {
            heading.child(Cost.class).text("(" + cost + ")");
        }

        // Status
        for (Status status : VISIBLE) {
            double value = itemDescriptor.get(status);

            if (value != 0) {
                descriptions.child(StatusValue.class).text(value + status.getUnit() + " " + status.name);
            }
        }

        // Ability
        for (Ability ability : itemDescriptor.getAbilities()) {
            AbilityDescriptor abilityDescriptor = ability.getDescriptor(Version.Latest);
            Element element = descriptions.child(AbilityArea.class);

            if (abilityDescriptor.isUnique()) {
                element.child(UniqueAbility.class).text("UNIQUE");
            }

            if (abilityDescriptor.isAura()) {
                element.child(UniqueAbility.class).text("AURA");
            }

            element.child(UniqueAbility.class).text(abilityDescriptor.isActive() ? "Active" : "Passive");

            if (ability.visible) {
                element.child(UniqueAbility.class).text("[" + ability.name + "]");
            }
            new AbilityDescriptionView(element, ability, calculator, abilityDescriptor.isActive()).receive();
        }
    }

    /**
     * @version 2013/06/04 23:33:05
     */
    private static class AbilityDescriptionView extends DescriptionView {

        /**
         * @param root
         * @param describable
         */
        private AbilityDescriptionView(Element root, Describable describable, StatusCalculator calculator, boolean active) {
            super(root, describable, calculator, !active);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected int getLevel() {
            return calculator == null ? 0 : 1;
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
