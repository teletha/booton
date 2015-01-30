/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.piece;

import static jsx.style.value.Color.*;

import java.util.Collection;

import js.dom.Element;
import jsx.style.Style;
import jsx.style.StyleRuleDescriptor;
import jsx.style.property.Background.BackgroundImage;
import jsx.style.value.Color;
import jsx.style.value.Numeric;
import jsx.style.value.Shadow;
import jsx.ui.VirtualStructure;
import jsx.ui.Widget;

/**
 * @version 2015/01/30 14:29:09
 */
public abstract class ImageGrid<T> extends Widget {

    /**
     * <p>
     * Set image sources.
     * </p>
     * 
     * @return
     */
    protected abstract Collection<T> sources();

    /**
     * <p>
     * Find name of the specified source.
     * </p>
     * 
     * @param source A images source.
     * @return
     */
    protected abstract String getTitle(T source);

    /**
     * <p>
     * Apply image to the element.
     * </p>
     * 
     * @param source A image source.
     * @param element A images element.
     * @return
     */
    protected abstract void apply(T source, Element element);

    protected abstract Style image(T source);

    /**
     * <p>
     * Activate this method when some source is seleted by pointer event.
     * </p>
     * 
     * @param source
     */
    protected abstract void select(T source);

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize(VirtualStructure 〡) {
        〡.nbox.〡(Class.Root, () -> {
            〡.nbox.〡s(Class.ImageSet, this::select, sources(), source -> {
                〡.nbox.〡(Class.Container, () -> {
                    〡.nbox.〡(Class.IconImage.with(image(source)));
                    〡.nbox.〡(Class.Title, getTitle(source));
                });
            });
        });

        // Element set = root.child(ImageSet);
        //
        // for (final T source : sources) {
        // image.observe(UIAction.Click).to(value -> {
        // select(source);
        // });
        //
        // images.put(source, image);
        // }
    }

    /**
     * @version 2015/01/30 14:32:48
     */
    private static class Class extends StyleRuleDescriptor {

        private static final Color backColor = new Color(0, 10, 10);

        private static final Numeric ImageSize = new Numeric(70, px);

        private static final Shadow in = shadow().inset()
                .offset(0, 1, px)
                .blurRadius(1, px)
                .color(rgba(0, 0, 0, 0.075));

        private static final Shadow out = shadow().blurRadius(8, px).color(rgba(82, 168, 236, 0.6));

        static Style Root = () -> {
            display.block();
            margin.auto();
            line.height(0);
            box.width(ImageSize.multiply(10).add(2));
        };

        static Style ImageSet = () -> {
            display.inlineFlex().direction.row().wrap.enable();
            border.top.solid().width(2, px).color(backColor);
            border.left.solid().width(2, px).color(backColor);
        };

        static Style Container = () -> {
            position.relative();
            display.block();
        };

        static Style IconImage = () -> {
            display.block();
            box.size(ImageSize);
            border.bottom.solid().width(2, px).color(backColor);
            border.right.solid().width(2, px).color(backColor);
            cursor.pointer();

            after(() -> {
                content.text("");
                display.block();
                position.absolute();
                box.width(100, percent).height(100, percent).opacity(1);
                background.color(hsla(0, 100, 100, 0.2));

                transit().duration(0.2, s).easeInOut().whenHover(() -> {
                    box.opacity(0);
                });
            });
        };

        static Style Title = () -> {
            Numeric boxWidth = ImageSize.add(40);
            Color color = new Color(0, 98, 97, 1);

            font.weight.bold().size(18, px);
            text.align.center();
            line.height(20, px);
            padding.size(5, px);
            background.image(BackgroundImage.of(linear(color.opacify(-0.4), color)));
            position.absolute().left(50, percent).bottom(ImageSize.add(20));
            margin.left(boxWidth.divide(-2));
            box.minWidth(boxWidth).zIndex(1).opacity(0);
            border.width(4, px).solid().color(color.lighten(-100)).radius(5, px);
            pointerEvents.none();

            // createBottomBubble(7);
            createBottomBubble(7, new Numeric(4, px), color.lighten(-100), color);

            transit().duration(0.2, s).delay(100, ms).easeInOut().whenSiblingHover(() -> {
                box.opacity(1);
                position.bottom(ImageSize);
            });
        };

        // @Priority(100)
        static Style Unselected = () -> {
            box.opacity(0);
            margin.right(-70, px);
        };

        static Style InputStyle = () -> {
            display.block();
            box.height(20, px).width(200, px).shadow(in);
            padding.vertical(4, px).horizontal(6, px);
            margin.bottom(10, px);
            font.size(14, px).color(85, 85, 85);
            line.height(20, px);
            text.verticalAlign.middle();
            border.radius(4, px).width(1, px).solid().color(rgb(204, 204, 204));
            background.color(White);

            transit().duration(0.2, s).linear().whenFocus(() -> {
                border.color(rgba(82, 168, 236, 0.8));
                outline.none();
                box.shadow(in, out);
            });
        };
    }
}
