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
import js.util.jQuery;
import js.util.jQuery.Listener;
import jsx.application.Application;
import jsx.bwt.UI;
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
import teemowork.model.Version;

/**
 * @version 2013/06/09 19:05:04
 */
public class ItemView extends UI {

    private static final Status[] VISIBLE = {Health, Hreg, Mana, Mreg, AD, ASRatio, ARPen, LS, Critical, AP, CDR, SV,
            MRPen, AR, MR, MSRatio};

    /**
     * @param item
     */
    public ItemView(Item item, ItemDescriptor itemDescriptor) {
        root.add(Root.class);

        // Icon Area
        jQuery icons = root.child(IconArea.class);
        item.applyIcon(icons.child(Icon.class));

        jQuery materials = icons.child(Materials.class);

        for (final Item material : itemDescriptor.getBuild()) {
            material.applyIcon(materials.child(Material.class).attr("title", material.name).click(new Listener() {

                @Override
                public void handler(UIEvent event) {
                    Application.show(new ItemDetail(material.name));
                }
            }));
        }

        // Description Area
        jQuery descriptions = root.child(DescriptionArea.class);

        // Name and Cost
        double cost = itemDescriptor.get(Cost);
        double total = item.getTotalCost(Version.Latest);

        jQuery heading = descriptions.child(Heading.class);
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
            jQuery element = descriptions.child(AbilityArea.class);

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
            new AbilityDescriptionView(element, ability, abilityDescriptor.isActive()).receive();
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
        private AbilityDescriptionView(jQuery root, Describable describable, boolean active) {
            super(root, describable, !active);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected int getLevel() {
            return 0;
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
