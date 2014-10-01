/*
 * Copynext (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import java.util.ArrayList;
import java.util.List;

import js.dom.Element;
import js.lang.NativeArray;
import jsx.ui.Patch.AddAttribute;
import jsx.ui.Patch.AddClass;
import jsx.ui.Patch.ChangeAttribute;
import jsx.ui.Patch.InsertChild;
import jsx.ui.Patch.MoveChild;
import jsx.ui.Patch.RemoveAttribute;
import jsx.ui.Patch.RemoveChild;
import jsx.ui.Patch.RemoveClass;
import jsx.ui.Patch.ReplaceChild;
import jsx.ui.Patch.ReplaceText;
import booton.css.CSS;

/**
 * @version 2014/09/17 9:24:03
 */
class Diff {

    /**
     * <p>
     * Diff elements.
     * </p>
     * 
     * @param prev
     * @param next
     * @return
     */
    static List<Patch> diff(VirtualElement prev, VirtualElement next) {
        /**
         * {@link VirtualNode#dom}
         * <p>
         * We passes the Real DOM from the previous Virtual DOM to the next Virtual DOM. To tell the
         * truth, we don't want to manipulate Real DOM in here. But here is the best place to pass
         * the reference.
         * </p>
         */
        next.dom = prev.dom;
        prev.dom = null;

        List<Patch> patches = new ArrayList();
        patches.addAll(diff(next.dom, prev.attributes, next.attributes));
        patches.addAll(diff(next.dom, prev.classList, next.classList));
        patches.addAll(diff(next.dom, prev, next));

        return patches;
    }

    /**
     * <p>
     * Diff class list.
     * </p>
     * 
     * @param context
     * @param prev
     * @param next
     * @return
     */
    static List<Patch> diff(Element context, NativeArray<Class<? extends CSS>> prev, NativeArray<Class<? extends CSS>> next) {
        List<Patch> patches = new ArrayList();

        for (int i = 0, length = next.length(); i < length; i++) {
            Class nextClass = next.get(i);
            int prevIndex = prev.indexOf(nextClass);

            if (prevIndex == -1) {
                patches.add(new AddClass(context, nextClass));
            }
        }

        for (int i = 0, length = prev.length(); i < length; i++) {
            Class prevClass = prev.get(i);

            if (next.indexOf(prevClass) == -1) {
                patches.add(new RemoveClass(context, prevClass));
            }
        }
        return patches;
    }

    /**
     * <p>
     * Diff attributes.
     * </p>
     * 
     * @param context
     * @param prev
     * @param next
     * @return
     */
    static List<Patch> diff(Element context, VirtualKVS<String, String> prev, VirtualKVS<String, String> next) {
        List<Patch> patches = new ArrayList();

        for (int nextIndex = 0; nextIndex < next.names.length(); nextIndex++) {
            String key = next.names.get(nextIndex);
            int prevIndex = prev.names.indexOf(key);

            if (prevIndex == -1) {
                patches.add(new AddAttribute(context, key, next.values.get(nextIndex)));
            } else {
                String prevValue = prev.values.get(prevIndex);
                String nextValue = next.values.get(nextIndex);
                System.out.println(key + "  [" + prevValue + "@" + nextValue + "]");
                if (!prevValue.equals(nextValue)) {
                    patches.add(new ChangeAttribute(context, key, nextValue));
                }
            }
        }

        for (int i = 0; i < prev.names.length(); i++) {
            String key = prev.names.get(i);

            if (next.names.indexOf(key) == -1) {
                patches.add(new RemoveAttribute(context, key));
            }
        }
        return patches;
    }

    /**
     * <p>
     * Diff child nodes.
     * </p>
     * 
     * @param context
     * @param prev
     * @param next
     * @return
     */
    static List<Patch> diff(Element context, VirtualFragment<Element> prev, VirtualFragment<Element> next) {
        List<Patch> patches = new ArrayList();

        int prevSize = prev.items.length();
        int nextSize = next.items.length();
        int max = prevSize + nextSize;
        int prevPosition = 0;
        int nextPosition = 0;
        int actualManipulationPosition = 0;

        for (int i = 0; i < max; i++) {
            if (prevSize <= prevPosition) {
                if (nextSize <= nextPosition) {
                    break; // all items were scanned
                } else {
                    // all prev items are scanned, but next items are remaining
                    VirtualNode nextItem = next.items.get(nextPosition++);
                    int index = prev.indexOf(nextItem);

                    if (index == -1) {
                        patches.add(new InsertChild(context, null, nextItem));
                    } else {
                        patches.add(new MoveChild(context, prev.items.get(index).dom));
                    }
                }
            } else {
                if (nextSize <= nextPosition) {
                    // all next items are scanned, but prev items are remaining
                    patches.add(new RemoveChild(context, prev.items.get(prevPosition++)));
                } else {
                    // prev and next items are remaining
                    VirtualNode prevItem = prev.items.get(prevPosition);
                    VirtualNode nextItem = next.items.get(nextPosition);

                    if (prevItem.id == nextItem.id) {
                        // same item
                        if (prevItem instanceof VirtualElement) {
                            VirtualElement prevElement = (VirtualElement) prevItem;
                            VirtualElement nextElement = (VirtualElement) nextItem;

                            patches.addAll(diff(prevElement, nextElement));
                        }

                        actualManipulationPosition++;
                        prevPosition++;
                        nextPosition++;
                    } else {
                        // different item
                        int nextItemInPrev = prev.indexOf(nextItem);
                        int prevItemInNext = next.indexOf(prevItem);

                        if (nextItemInPrev == -1) {
                            if (prevItemInNext == -1) {
                                if (prevItem instanceof VirtualText && nextItem instanceof VirtualText) {
                                    patches.add(new ReplaceText(prevItem, (VirtualText) nextItem));
                                } else {
                                    patches.add(new ReplaceChild(context, prevItem, nextItem));
                                }
                                prevPosition++;
                            } else {
                                patches.add(new InsertChild(context, prevItem.dom, nextItem));
                            }
                            nextPosition++;
                            actualManipulationPosition++;
                        } else {
                            if (prevItemInNext == -1) {
                                patches.add(new RemoveChild(context, prevItem));
                            } else {
                                // both items are found in each other list
                                // hold and skip the current value
                                actualManipulationPosition++;
                            }
                            prevPosition++;
                        }
                    }
                }
            }
        }
        return patches;
    }
}
