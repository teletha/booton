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
import jsx.application.Page;
import jsx.application.PageInfo;
import teemowork.ItemCatalogStyle.AbilityArea;
import teemowork.ItemCatalogStyle.Cost;
import teemowork.ItemCatalogStyle.DescriptionPanel;
import teemowork.ItemCatalogStyle.Icon;
import teemowork.ItemCatalogStyle.Icons;
import teemowork.ItemCatalogStyle.ItemPanel;
import teemowork.ItemCatalogStyle.Material;
import teemowork.ItemCatalogStyle.Materials;
import teemowork.ItemCatalogStyle.Name;
import teemowork.ItemCatalogStyle.Names;
import teemowork.ItemCatalogStyle.TotalCost;
import teemowork.ItemCatalogStyle.Unique;
import teemowork.ItemCatalogStyle.Value;
import teemowork.model.Ability;
import teemowork.model.AbilityDescriptor;
import teemowork.model.Describable;
import teemowork.model.DescriptionView;
import teemowork.model.Item;
import teemowork.model.ItemDescriptor;
import teemowork.model.Status;
import teemowork.model.Version;

/**
 * @version 2013/06/12 12:45:51
 */
public class ItemCatalog extends Page {

    private static final Status[] VISIBLE = {Health, Hreg, Mana, Mreg, AD, ASRatio, ARPen, LS, Critical, AP, CDR, SV,
            MRPen, AR, MR, MSRatio};

    /**
     * 
     */
    @PageInfo(path = "ItemCatalog")
    public ItemCatalog() {
    }

    // private void test(jQuery root) {
    // for (Item item : Item.getAll()) {
    // ItemDescriptor descriptor = item.getDescriptor(Version.Latest);
    //
    // if (!descriptor.isDeprecated()) {
    // double cost = descriptor.get(Cost);
    // double total = item.getTotalCost(Version.Latest);
    //
    // Flex layout = new Flex(root, ItemPanel.class);
    // layout.vmax(Icon.class);
    // layout.hmax(box(Name.class).text(item.name), box(TotalCost.class).text(total),
    // box(Cost.name).text(total == cost ? ""
    // : "(" + cost + ")"));
    // layout.item(Name.class).text(item.name);
    // layout.item(TotalCost.class).text(total);
    //
    // if (total != cost) {
    // layout.item(Cost.class).text("(" + cost + ")");
    // }
    // layout.hmax();
    //
    // for (Status entry : VISIBLE) {
    // double value = descriptor.get(entry);
    //
    // if (value != 0) {
    // layout.hbox(Value.class).text(value + entry.getUnit() + " " + entry.name);
    // }
    // }
    //
    // for (Ability ability : descriptor.getAbilities()) {
    // AbilityDescriptor abilityDescriptor = ability.getDescriptor(Version.Latest);
    //
    // if (abilityDescriptor.isUnique()) {
    // layout.hbox(Unique.class).text("UNIQUE");
    // }
    //
    // if (abilityDescriptor.isAura()) {
    // layout.hbox(Unique.class).text("AURA");
    // }
    //
    // layout.hbox(Unique.class).text(abilityDescriptor.isActive() ? "Active" : "Passive");
    //
    // if (ability.visible) {
    // layout.hbox(Unique.class).text("[" + ability.name + "]");
    // }
    // // new AbilityDescriptionView(description, ability,
    // // abilityDescriptor.isActive()).receive();
    // }
    // }
    // }
    // }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(jQuery root) {
        for (Item item : Item.getAll()) {
            ItemDescriptor status = item.getDescriptor(Version.Latest);

            if (status.isDeprecated()) {
                continue;
            }

            jQuery element = root.child(ItemPanel.class);
            jQuery icons = element.child(Icons.class);
            item.applyIcon(icons.child(Icon.class));

            jQuery materials = icons.child(Materials.class);

            for (Item material : status.getBuild()) {
                material.applyIcon(materials.child(Material.class).attr("title", material.name));
            }

            jQuery descriptions = element.child(DescriptionPanel.class);
            jQuery names = descriptions.child(Names.class);
            names.child(Name.class).text(item.name);

            double cost = status.get(Cost);
            double total = item.getTotalCost(Version.Latest);

            names.child(TotalCost.class).text(total);

            if (cost != total) {
                names.append("(");
                names.child(Cost.class).text(cost);
                names.append(")");
            }

            for (Status entry : VISIBLE) {
                double value = status.get(entry);

                if (value != 0) {
                    descriptions.child(Value.class).text(value + entry.getUnit() + " " + entry.name);
                }
            }

            for (Ability ability : status.getAbilities()) {
                AbilityDescriptor descriptor = ability.getDescriptor(Version.Latest);
                jQuery description = descriptions.child(AbilityArea.class);

                if (descriptor.isUnique()) {
                    description.child(Unique.class).text("UNIQUE");
                }

                if (descriptor.isAura()) {
                    description.child(Unique.class).text("AURA");
                }

                description.child(Unique.class).text(descriptor.isActive() ? "Active" : "Passive");

                if (ability.visible) {
                    description.child(Unique.class).text("[" + ability.name + "]");
                }
                new AbilityDescriptionView(description, ability, descriptor.isActive()).receive();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "ItemCatalog";
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
