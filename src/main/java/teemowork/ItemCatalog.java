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
import teemowork.model.Ability;
import teemowork.model.AbilityDescriptor;
import teemowork.model.Describable;
import teemowork.model.DescriptionView;
import teemowork.model.Item;
import teemowork.model.ItemDescriptor;
import teemowork.model.Status;
import teemowork.model.Version;

/**
 * @version 2013/02/19 18:31:47
 */
public class ItemCatalog extends Page {

    private static final Status[] VISIBLE = {Health, Hreg, Mana, Mreg, AD, ASRatio, LS, Critical, AP, CDR, SV, MRPen,
            AR, MR, MSRatio};

    /**
     * 
     */
    @PageInfo(path = "ItemCatalog")
    public ItemCatalog() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(jQuery root) {
        for (Item item : Item.getAll()) {
            ItemDescriptor status = item.getDescriptor(Version.Latest);

            jQuery element = root.child(ItemCatalogStyle.ItemPanel.class);
            jQuery icons = element.child(ItemCatalogStyle.IconPanel.class);
            icons.child(ItemCatalogStyle.Icon.class).css("background-image", "url(" + item.getIcon() + ")");

            jQuery descriptions = element.child(ItemCatalogStyle.DescriptionPanel.class);
            jQuery names = descriptions.child(ItemCatalogStyle.Names.class);
            names.child(ItemCatalogStyle.Name.class).text(item.name);

            double cost = status.get(Cost);
            double total = item.getTotalCost(Version.Latest);

            names.child(ItemCatalogStyle.TotalCost.class).text(total);

            if (cost != total) {
                names.append("(");
                names.child(ItemCatalogStyle.Cost.class).text(cost);
                names.append(")");
            }

            for (Status entry : VISIBLE) {
                double value = status.get(entry);

                if (value != 0) {
                    descriptions.child(ItemCatalogStyle.Value.class).text(value + entry.getUnit() + " " + entry.name);
                }
            }

            for (Ability ability : status.getAbilities()) {
                AbilityDescriptor descriptor = ability.getDescriptor(Version.Latest);
                jQuery description = descriptions.child(ItemCatalogStyle.Ability.class);

                if (descriptor.isUnique()) {
                    description.child(ItemCatalogStyle.Unique.class).text("UNIQUE");
                }

                if (descriptor.isAura()) {
                    description.child(ItemCatalogStyle.Unique.class).text("AURA");
                }

                description.child(ItemCatalogStyle.Unique.class).text(descriptor.isActive() ? "Active" : "Passive");

                if (ability.visible) {
                    description.child(ItemCatalogStyle.Unique.class).text("[" + ability.name + "]");
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
