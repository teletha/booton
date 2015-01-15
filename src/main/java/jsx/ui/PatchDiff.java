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
import jsx.collection.DualList;
import jsx.style.Style;
import jsx.ui.Patch.AddAttribute;
import jsx.ui.Patch.AddClass;
import jsx.ui.Patch.ChangeAttribute;
import jsx.ui.Patch.InsertChild;
import jsx.ui.Patch.MoveChild;
import jsx.ui.Patch.RemoveAttribute;
import jsx.ui.Patch.RemoveChild;
import jsx.ui.Patch.RemoveClass;
import jsx.ui.Patch.RemoveInlineStyle;
import jsx.ui.Patch.ReplaceChild;
import jsx.ui.Patch.ReplaceText;
import jsx.ui.Patch.SetInlineStyle;

/**
 * @version 2014/10/07 12:49:34
 */
class PatchDiff {

    /**
     * <p>
     * Helper method to diff elements and apply patches.
     * </p>
     * 
     * @param prev A previouse state.
     * @param next A next state.
     */
    static void apply(VirtualElement prev, VirtualElement next) {
        List<Patch> diff = diff(prev, next);

        for (int i = 0; i < diff.size(); i++) {
            diff.get(i).apply();
        }
        prev.dispose();
    }

    /**
     * <p>
     * Diff elements.
     * </p>
     * 
     * @param prev A previouse state.
     * @param next A next state.
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

        List<Patch> patches = new ArrayList();
        patches.addAll(diff(next.dom, prev.attributes, next.attributes));
        patches.addAll(diff(next.dom, prev.classList, next.classList));
        patches.addAll(diffInlineStyle(next.dom, prev.inlines, next.inlines));
        patches.addAll(diff(next.dom, prev, next));

        return patches;
    }

    /**
     * <p>
     * Diff class list.
     * </p>
     * 
     * @param context
     * @param prev A previouse state.
     * @param next A next state.
     * @return
     */
    static List<Patch> diff(Element context, NativeArray<Style> prev, NativeArray<Style> next) {
        List<Patch> patches = new ArrayList();

        for (int i = 0, length = next.length(); i < length; i++) {
            Style nextClass = next.get(i);
            int prevIndex = prev.indexOf(nextClass);

            if (prevIndex == -1) {
                patches.add(new AddClass(context, nextClass));
            }
        }

        for (int i = 0, length = prev.length(); i < length; i++) {
            Style prevClass = prev.get(i);

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
     * @param prev A previouse state.
     * @param next A next state.
     * @return
     */
    static List<Patch> diff(Element context, DualList<String, String> prev, DualList<String, String> next) {
        List<Patch> patches = new ArrayList();

        for (int nextIndex = 0; nextIndex < next.size(); nextIndex++) {
            String key = next.key(nextIndex);
            int prevIndex = prev.key(key);

            if (prevIndex == -1) {
                patches.add(new AddAttribute(context, key, next.value(nextIndex)));
            } else {
                String prevValue = prev.value(prevIndex);
                String nextValue = next.value(nextIndex);

                if (!prevValue.equals(nextValue)) {
                    patches.add(new ChangeAttribute(context, key, nextValue));
                }
            }
        }

        for (int i = 0; i < prev.size(); i++) {
            String key = prev.key(i);

            if (next.key(key) == -1) {
                patches.add(new RemoveAttribute(context, key));
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
     * @param prev A previouse state.
     * @param next A next state.
     * @return
     */
    static List<Patch> diffInlineStyle(Element context, DualList<String, String> prev, DualList<String, String> next) {
        List<Patch> patches = new ArrayList();

        for (int nextIndex = 0; nextIndex < next.size(); nextIndex++) {
            String key = next.key(nextIndex);
            int prevIndex = prev.key(key);

            if (prevIndex == -1) {
                patches.add(new SetInlineStyle(context, key, next.value(nextIndex)));
            } else {
                String prevValue = prev.value(prevIndex);
                String nextValue = next.value(nextIndex);

                if (!prevValue.equals(nextValue)) {
                    patches.add(new SetInlineStyle(context, key, nextValue));
                }
            }
        }

        for (int i = 0; i < prev.size(); i++) {
            String key = prev.key(i);

            if (next.key(key) == -1) {
                patches.add(new RemoveInlineStyle(context, key));
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
     * @param prev A previouse state.
     * @param next A next state.
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
                        } else {
                            /**
                             * {@link VirtualNode#dom}
                             * <p>
                             * We passes the Real DOM from the previous Virtual DOM to the next
                             * Virtual DOM. To tell the truth, we don't want to manipulate Real DOM
                             * in here. But here is the best place to pass the reference.
                             * </p>
                             */
                            nextItem.dom = prevItem.dom;
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
                                    nextItem.dom = prevItem.dom;
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
