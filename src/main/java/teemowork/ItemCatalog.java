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

import js.application.Page;
import js.application.PageInfo;
import js.util.jQuery;
import teemowork.model.Item;
import teemowork.model.ItemStatus;
import teemowork.model.Status;
import teemowork.model.Variable;
import teemowork.model.VariableResolver;
import teemowork.model.Version;
import booton.css.CSS;
import booton.util.Font;

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

            jQuery element = root.child(Styles.ItemPanel.class);
            jQuery icons = element.child(Styles.IconPanel.class);
            icons.child(Styles.Icon.class).css("background-image", "url(" + item.getIcon() + ")");

            jQuery descriptions = element.child(Styles.DescriptionPanel.class);
            jQuery names = descriptions.child(Styles.Names.class);
            names.child(Styles.Name.class).text(item.name);

            double cost = status.get(Cost);
            double total = item.getTotalCost(Version.Latest);

            names.child(Styles.TotalCost.class).text(total);

            if (cost != total) {
                names.append("(");
                names.child(Styles.Cost.class).text(cost);
                names.append(")");
            }

            for (Status entry : VISIBLE) {
                double value = status.get(entry);

                if (value != 0) {
                    descriptions.child(Styles.Value.class).text(value + entry.getUnit() + " " + entry.name);
                }
            }

            for (Entry<String, List> entry : status.passives.entrySet()) {
                descriptions.child(Styles.Value.class).text(entry.getKey() + " - ");

                for (Object token : entry.getValue()) {
                    if (token instanceof Variable) {
                        buildVariable(descriptions, (Variable) token, 1);
                    } else {
                        descriptions.append(token.toString());
                    }
                }
            }
        }
    }

    /**
     * @param root
     * @param variable
     * @param size
     * @param skillLevel
     */
    private void buildVariable(jQuery root, Variable variable, int skillLevel) {
        VariableResolver resolver = variable.getResolver();
        Status status = variable.getStatus();
        List<Variable> amplifiers = variable.amplifiers;

        // compute current value
        root.child(SkillStyle.Computed.class).text(status.format(1));

        // All values
        double[] values = resolver.enumerate();

        if (1 < values.length || !amplifiers.isEmpty()) {
            root.append("(");

            for (int i = 0; i < values.length; i++) {
                jQuery value = root.child(SkillStyle.Value.class).text(status.round(values[i]));

                if (i == skillLevel - 1) {
                    value.addClass(SkillStyle.Current.class);
                }

                if (i != values.length - 1) {
                    root.child(SkillStyle.Separator.class).text("/");
                }
            }

            if (!amplifiers.isEmpty()) {
                for (Variable amplifier : amplifiers) {
                    writeAmplifier(root, amplifier, skillLevel);
                }
            }
            root.append(")");
        }
    }

    private void writeAmplifier(jQuery root, Variable amplifier, int skillLevel) {
        jQuery element = root.child(SkillStyle.Amplifier.class);
        element.append("+");

        VariableResolver resolver = amplifier.getResolver();

        if (!resolver.isSkillLevelBased()) {
            skillLevel = resolver.convertLevel(skillLevel);
        }

        int size = resolver.estimateSize();

        for (int i = 0; i < size; i++) {
            jQuery value = element.child(SkillStyle.Value.class).text(1);

            if (size != 1 && i == skillLevel - 1) {
                value.addClass(SkillStyle.Current.class);
            }

            if (i != size - 1) {
                element.child(SkillStyle.Separator.class).text("/");
            }
        }

        element.append(amplifier.getStatus().getUnit());

        if (!amplifier.amplifiers.isEmpty()) {
            element.append("(");
            for (Variable nest : amplifier.amplifiers) {
                writeAmplifier(element, nest, skillLevel);
            }
            element.append(")");
        }

        element.append(amplifier.getStatus().name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "ItemCatalog";
    }

    /**
     * @version 2013/02/24 22:15:35
     */
    private static final class SkillStyle {

        private static Font Sans = new Font("http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600");

        /** The skill icon size. */
        private static final int IconSize = 45;

        /** The level box height. */
        private static final int LevelBoxHeight = 5;

        /**
         * @version 2013/02/02 11:27:13
         */
        private static class SkillTable extends CSS {

            {
                display.tableCell();
                font.family(Sans);
            }
        }

        /**
         * @version 2013/02/02 11:27:13
         */
        class SkillRow extends CSS {

            {
                display.block();
                margin.bottom(1, em);
            }
        }

        /**
         * @version 2013/02/06 18:51:27
         */
        private static class Icon extends CSS {

            {
                display.block();
                box.size(IconSize, px);
                background.contain().size(IconSize, px);
                border.radius(10, px).color(50, 50, 50).width(2, px).solid();
            }
        }

        /**
         * @version 2013/02/02 11:27:13
         */
        private static class LevelBox extends CSS {

            {
                display.table();
                box.width(IconSize, px).height(LevelBoxHeight, px);
                border.width(1, px).solid().color.black();
                margin.top(2, px).bottom(5, px);
            }
        }

        /**
         * @version 2013/02/02 11:27:13
         */
        private static class LevelMark extends CSS {

            {
                display.tableCell();
                box.width(IconSize / 5, px).height(LevelBoxHeight, px);
                borderLeft.solid().color.black().width(1, px);
                background.image(linear(rgba(240, 192, 28, 0.5), rgba(160, 123, 1, 0.5)));

                while (firstChild()) {
                    border.none();
                }
            }
        }

        /**
         * @version 2013/02/02 11:27:13
         */
        private static class LevelMark3 extends LevelMark {

            {
                box.width(IconSize / 3, px);
            }
        }

        /**
         * @version 2013/02/09 23:26:39
         */
        private static class Assigned extends CSS {

            {
                background.image(linear(rgba(240, 192, 28, 1), rgba(160, 123, 1, 1)));
            }
        }

        /**
         * @version 2013/02/02 11:27:13
         */
        private static class IconBox extends CSS {

            {
                display.tableCell();
                padding.right(IconSize / 5, px);
                cursor.pointer();
            }
        }

        /**
         * @version 2013/02/02 11:27:13
         */
        private static class DescriptionBox extends CSS {

            {
                display.tableCell();
                text.verticalAlign.top();
                box.height(60, px);
            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Name extends CSS {

            {
                margin.right(0.5, em);
                font.weight.bold();
            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Text extends CSS {

            {
                display.block();
                margin.top(0.4, em);
                line.height(140, percent);
                font.size.smaller();
            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Cost extends CSS {

            {

            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Range extends CSS {

            {

            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Computed extends CSS {

            {
                font.weight.bolder();
            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Value extends CSS {

            {
                text.align.center();
            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Separator extends CSS {

            {

            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Current extends CSS {

            {
                font.color(rgba(160, 123, 1, 1));
            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Passive extends CSS {

            {
                margin.right(1, em);
            }
        }

        /**
         * @version 2013/02/06 20:03:25
         */
        private static class Amplifier extends CSS {

            {
                font.color(25, 111, 136);

                while (inBackOf(Value.class)) {
                    margin.left(0.4, em);
                }

                while (inBackOf(Amplifier.class)) {
                    margin.left(0.4, em);
                }
            }
        }

        /**
         * @version 2013/02/16 0:35:05
         */
        private static class Active extends CSS {

            {
                box.opacity(0.5);
            }
        }

    }

    /**
     * @version 2013/02/16 9:51:18
     */
    private static final class Styles {

        private static Font Sans = new Font("http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600");

        /** The skill icon size. */
        private static final int IconSize = 45;

        /**
         * @version 2013/02/16 9:52:23
         */
        private static class ItemPanel extends CSS {

            {
                display.table();
                margin.bottom(15, px);
            }
        }

        /**
         * @version 2013/02/16 10:00:01
         */
        private static class IconPanel extends CSS {

            {
                display.tableCell();
                padding.right(IconSize / 5, px);
                cursor.pointer();
            }
        }

        /**
         * @version 2013/02/16 9:52:23
         */
        private static class DescriptionPanel extends CSS {

            {
                display.tableCell();
                text.verticalAlign.top();
                box.height(60, px);
            }
        }

        /**
         * @version 2013/02/16 10:00:01
         */
        private static class Names extends CSS {

            {
                display.block();
                margin.bottom(0.4, em);
                font.family(Sans);
            }
        }

        /**
         * @version 2013/02/16 10:00:01
         */
        private static class Name extends CSS {

            {
                margin.right(0.5, em);
                font.weight.bold();
            }
        }

        /**
         * @version 2013/02/16 10:00:01
         */
        private static class TotalCost extends CSS {

            {
                margin.right(0.5, em);
            }
        }

        /**
         * @version 2013/02/16 10:00:01
         */
        private static class Cost extends CSS {

            {

            }
        }

        /**
         * @version 2013/02/16 10:00:01
         */
        private static class Value extends CSS {

            {
                display.block();
                margin.bottom(0.2, em);
                font.size.smaller().family(Sans);
            }
        }

        /**
         * @version 2013/02/16 10:00:01
         */
        private static class Icon extends CSS {

            private int size = 44;

            {
                display.inlineBlock();
                box.size(size, px);
                background.contain().size(size + 2, px).horizontal(-1, px).vertical(-1, px);
                border.radius(5, px).color(50, 50, 50).width(1, px).solid();
                text.verticalAlign.middle();
            }
        }
    }
}
