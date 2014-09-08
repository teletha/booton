/*
 * Copynext (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.virtual;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import booton.virtual.Patch.AddAttribute;
import booton.virtual.Patch.ChangeAttribute;
import booton.virtual.Patch.InsertChild;
import booton.virtual.Patch.MoveChild;
import booton.virtual.Patch.RemoveAttribute;
import booton.virtual.Patch.RemoveChild;
import booton.virtual.Patch.ReplaceChild;

/**
 * @version 2014/09/08 16:29:52
 */
public class Diff {

    /**
     * <p>
     * Diff elements.
     * </p>
     * 
     * @param prev
     * @param next
     * @return
     */
    public static List<Patch> diff(VirtualElement prev, VirtualElement next) {
        List<Patch> patches = new ArrayList();
        patches.addAll(diff(prev, prev.attributes, next.attributes));
        patches.addAll(diff(prev, prev.children, next.children));

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
    public static List<Patch> diff(VirtualElement context, Map<String, String> prev, Map<String, String> next) {
        List<Patch> patches = new ArrayList();

        for (Entry<String, String> entry : next.entrySet()) {
            String key = entry.getKey();

            if (!prev.containsKey(key)) {
                patches.add(new AddAttribute(context, key, entry.getValue()));
            } else {
                String prevValue = prev.get(key);
                String nextValue = entry.getValue();

                if (!prevValue.equals(nextValue)) {
                    patches.add(new ChangeAttribute(context, key, nextValue));
                }
            }
        }

        for (Entry<String, String> entry : prev.entrySet()) {
            String key = entry.getKey();

            if (!next.containsKey(key)) {
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
    public static List<Patch> diff(VirtualElement context, VirtualNodeList prev, VirtualNodeList next) {
        List<Patch> patches = new ArrayList();

        int prevSize = prev.items.length;
        int nextSize = next.items.length;
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
                    VirtualNode nextItem = next.items[nextPosition++];
                    int index = prev.indexOf(nextItem);

                    if (index == -1) {
                        patches.add(new InsertChild(context, null, nextItem));
                    } else {
                        patches.add(new MoveChild(context, prev.items[index]));
                    }
                }
            } else {
                if (nextSize <= nextPosition) {
                    // all next items are scanned, but prev items are remaining
                    patches.add(new RemoveChild(context, prev.items[prevPosition++]));
                } else {
                    // prev and next items are remaining
                    VirtualNode prevItem = prev.items[prevPosition];
                    VirtualNode nextItem = next.items[nextPosition];

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
                                patches.add(new ReplaceChild(context, prevItem, nextItem));
                                prevPosition++;
                            } else {
                                patches.add(new InsertChild(context, prevItem, nextItem));
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
