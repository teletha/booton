/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import jsx.style.PropertyDefinition;

/**
 * @version 2014/10/29 12:54:42
 */
public class PointerEvents extends PropertyDefinition<PointerEvents> {

    /**
     * <p>
     * The element behaves as it would if the pointer-events property was not specified. In SVG
     * content, this value and the value visiblePainted have the same effect.
     * </p>
     * 
     * @return
     */
    public PointerEvents auto() {
        return value("auto");
    }

    /**
     * <p>
     * The element is never the target of mouse events; however, mouse events may target its
     * descendant elements if those descendants have pointer-events set to some other value. In
     * these circumstances, mouse events will trigger event listeners on this parent element as
     * appropriate on their way to/from the descendant during the event capture/bubble phases.
     * </p>
     * 
     * @return
     */
    public PointerEvents none() {
        return value("none");
    }

    /**
     * <p>
     * SVG only. The element can only be the target of a mouse event when the visibility property is
     * set to visible and when the mouse cursor is over the interior (i.e., 'fill') of the element
     * and the fill property is set to a value other than none, or when the mouse cursor is over the
     * perimeter (i.e., 'stroke') of the element and the stroke property is set to a value other
     * than none.
     * </p>
     * 
     * @return
     */
    public PointerEvents visiblePainted() {
        return value("visiblePainted");
    }

    /**
     * <p>
     * SVG only. The element can only be the target of a mouse event when the visibility property is
     * set to visible and when the mouse cursor is over the interior (i.e., fill) of the element.
     * The value of the fill property does not effect event processing.
     * </p>
     * 
     * @return
     */
    public PointerEvents visibleFill() {
        return value("visibleFill");
    }

    /**
     * <p>
     * SVG only. The element can only be the target of a mouse event when the visibility property is
     * set to visible and when the mouse cursor is over the perimeter (i.e., stroke) of the element.
     * The value of the stroke property does not effect event processing.
     * </p>
     * 
     * @return
     */
    public PointerEvents visibleStroke() {
        return value("visibleStroke");
    }

    /**
     * <p>
     * SVG only. The element can be the target of a mouse event when the visibility property is set
     * to visible and the mouse cursor is over either the interior (i.e., fill) or the perimeter
     * (i.e., stroke) of the element. The values of the fill and stroke do not effect event
     * processing.
     * </p>
     * 
     * @return
     */
    public PointerEvents visible() {
        return value("visible");
    }

    /**
     * <p>
     * SVG only. The element can only be the target of a mouse event when the mouse cursor is over
     * the interior (i.e., 'fill') of the element and the fill property is set to a value other than
     * none, or when the mouse cursor is over the perimeter (i.e., 'stroke') of the element and the
     * stroke property is set to a value other than none. The value of the visibility property does
     * not effect event processing.
     * </p>
     * 
     * @return
     */
    public PointerEvents painted() {
        return value("painted");
    }

    /**
     * <p>
     * SVG only. The element can only be the target of a mouse event when the pointer is over the
     * interior (i.e., fill) of the element. The values of the fill and visibility properties do not
     * effect event processing.
     * </p>
     * 
     * @return
     */
    public PointerEvents fill() {
        return value("fill");
    }

    /**
     * <p>
     * SVG only. The element can only be the target of a mouse event when the pointer is over the
     * perimeter (i.e., stroke) of the element. The values of the stroke and visibility properties
     * do not effect event processing.
     * </p>
     * 
     * @return
     */
    public PointerEvents stroke() {
        return value("stroke");
    }

    /**
     * <p>
     * SVG only. The element can only be the target of a mouse event when the pointer is over the
     * interior (i.e., fill) or the perimeter (i.e., stroke) of the element. The values of the fill,
     * stroke and visibility properties do not effect event processing.
     * </p>
     * 
     * @return
     */
    public PointerEvents all() {
        return value("all");
    }
}
