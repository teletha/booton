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

import booton.virtual.PatchOperation.AddAttribute;
import booton.virtual.PatchOperation.ChangeAttribute;
import booton.virtual.PatchOperation.InsertChild;
import booton.virtual.PatchOperation.MoveChild;
import booton.virtual.PatchOperation.RemoveAttribute;
import booton.virtual.PatchOperation.RemoveChild;
import booton.virtual.PatchOperation.ReplaceChild;

/**
 * @version 2014/09/08 16:29:52
 */
public class Diff {

    /**
     * @param prev
     * @param next
     * @return
     */
    public static List<PatchOperation> diff(VirtualElement prev, VirtualElement next) {
        List<PatchOperation> operations = new ArrayList();
        operations.addAll(diffAttribute(prev, prev.attributes, next.attributes));
        operations.addAll(diffChildren(prev, prev.children, next.children));

        return operations;
    }

    /**
     * @param prev
     * @param next
     * @return
     */
    public static List<PatchOperation> diffAttribute(VirtualElement context, Map<String, String> prev, Map<String, String> next) {
        List<PatchOperation> operations = new ArrayList();

        for (Entry<String, String> entry : next.entrySet()) {
            String key = entry.getKey();

            if (!prev.containsKey(key)) {
                operations.add(new AddAttribute(context, key, entry.getValue()));
            } else {
                String prevValue = prev.get(key);
                String nextValue = entry.getValue();

                if (!prevValue.equals(nextValue)) {
                    operations.add(new ChangeAttribute(context, key, nextValue));
                }
            }
        }

        for (Entry<String, String> entry : prev.entrySet()) {
            String key = entry.getKey();

            if (!next.containsKey(key)) {
                operations.add(new RemoveAttribute(context, key));
            }
        }
        return operations;
    }

    /**
     * @param prev
     * @param next
     */
    public static List<PatchOperation> diffChildren(VirtualElement context, VirtualNodeList prev, VirtualNodeList next) {
        List<PatchOperation> operations = new ArrayList();

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
                        operations.add(new InsertChild(context, null, nextItem));
                    } else {
                        operations.add(new MoveChild(context, prev.items[index]));
                    }
                }
            } else {
                if (nextSize <= nextPosition) {
                    // all next items are scanned, but prev items are remaining
                    operations.add(new RemoveChild(context, prev.items[prevPosition++]));
                } else {
                    // prev and next items are remaining
                    VirtualNode prevItem = prev.items[prevPosition];
                    VirtualNode nextItem = next.items[nextPosition];

                    if (prevItem.id == nextItem.id) {
                        // same item
                        if (prevItem instanceof VirtualElement) {
                            VirtualElement prevElement = (VirtualElement) prevItem;
                            VirtualElement nextElement = (VirtualElement) nextItem;

                            operations.addAll(diff(prevElement, nextElement));
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
                                operations.add(new ReplaceChild(context, prevItem, nextItem));
                                prevPosition++;
                            } else {
                                operations.add(new InsertChild(context, prevItem, nextItem));
                            }
                            nextPosition++;
                            actualManipulationPosition++;
                        } else {
                            if (prevItemInNext == -1) {
                                operations.add(new RemoveChild(context, prevItem));
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
        return operations;
    }
}
