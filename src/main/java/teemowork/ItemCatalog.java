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

import java.util.List;
import java.util.Map.Entry;

import js.util.jQuery;
import jsx.application.Page;
import jsx.application.PageInfo;
import teemowork.model.Item;
import teemowork.model.ItemStatus;
import teemowork.model.Status;
import teemowork.model.Version;
import teemowork.model.variable.Variable;

/**
 * @version 2013/02/19 18:31:47
 */
public class ItemCatalog extends Page {

    private static final Status[] VISIBLE = {Health, Hreg, Mana, Mreg, AD, ASRatio, LS, Critical, AP, CDR, SV, AR, MR,
            MSRatio};

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
            ItemStatus status = item.getStatus(Version.Latest);

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

            for (Entry<String, List> entry : status.passives.entrySet()) {
                descriptions.child(ItemCatalogStyle.Value.class).text(entry.getKey() + " - ");

                for (Object token : entry.getValue()) {
                    if (token instanceof Variable) {
                        descriptions.append(token.toString());
                    } else {
                        descriptions.append(token.toString());
                    }
                }
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
}
