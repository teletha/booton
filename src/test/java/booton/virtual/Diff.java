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

import booton.virtual.PatchListOperation.Insert;
import booton.virtual.PatchListOperation.Last;
import booton.virtual.PatchListOperation.Remove;
import booton.virtual.PatchListOperation.Replace;
import booton.virtual.PatchMapOperation.Add;
import booton.virtual.PatchMapOperation.Change;

/**
 * @version 2014/08/29 9:19:06
 */
public class Diff {

    /**
     * @param prev
     * @param next
     * @return
     */
    public static List<PatchOperation> diff(VirtualElement prev, VirtualElement next) {
        List<PatchOperation> operations = new ArrayList();
        operations.addAll(diff(prev.attributes, next.attributes));
        operations.addAll(diffChildren(prev.children, next.children));

        return operations;
    }

    /**
     * @param prev
     * @param next
     */
    public static List<PatchListOperation> diffChildren(VirtualNodeList prev, VirtualNodeList next) {
        List<PatchListOperation> operations = new ArrayList();

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

                    if (prev.indexOf(nextItem) == -1) {
                        operations.add(new Insert(nextItem, actualManipulationPosition++));
                    } else {
                        operations.add(new Last(nextItem));
                    }
                }
            } else {
                if (nextSize <= nextPosition) {
                    // all next items are scanned, but prev items are remaining
                    operations.add(new Remove(prev.items[prevPosition++], actualManipulationPosition));
                } else {
                    // prev and next items are remaining
                    VirtualNode prevItem = prev.items[prevPosition];
                    VirtualNode nextItem = next.items[nextPosition];

                    if (prevItem.id == nextItem.id) {
                        // same item
                        actualManipulationPosition++;
                        prevPosition++;
                        nextPosition++;
                        System.out.println("SAME");
                    } else {
                        System.out.println("DIFF");
                        // different item
                        int nextItemInPrev = prev.indexOf(nextItem);
                        int prevItemInNext = next.indexOf(prevItem);

                        if (nextItemInPrev == -1) {
                            if (prevItemInNext == -1) {
                                operations.add(new Replace(prevItem, nextItem, actualManipulationPosition++));
                                prevPosition++;
                            } else {
                                operations.add(new Insert(nextItem, actualManipulationPosition++));
                            }
                            nextPosition++;
                        } else {
                            if (prevItemInNext == -1) {
                                operations.add(new Remove(prevItem, actualManipulationPosition));
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

    /**
     * @param prev
     * @param next
     */
    public static List<PatchListOperation> diff(List prev, List next) {
        List<PatchListOperation> operations = new ArrayList();

        int prevSize = prev.size();
        int nextSize = next.size();
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
                    Object nextItem = next.get(nextPosition++);

                    if (prev.indexOf(nextItem) == -1) {
                        operations.add(new Insert(nextItem, actualManipulationPosition++));
                    } else {
                        operations.add(new Last(nextItem));
                    }
                }
            } else {
                if (nextSize <= nextPosition) {
                    // all next items are scanned, but prev items are remaining
                    operations.add(new Remove(prev.get(prevPosition++), actualManipulationPosition));
                } else {
                    // prev and next items are remaining
                    Object prevItem = prev.get(prevPosition);
                    Object nextItem = next.get(nextPosition);

                    if (prevItem.equals(nextItem)) {
                        // same item
                        actualManipulationPosition++;
                        prevPosition++;
                        nextPosition++;
                    } else {
                        // different item
                        int nextItemInPrev = prev.indexOf(nextItem);
                        int prevItemInNext = next.indexOf(prevItem);

                        if (nextItemInPrev == -1) {
                            if (prevItemInNext == -1) {
                                operations.add(new Replace(prevItem, nextItem, actualManipulationPosition++));
                                prevPosition++;
                            } else {
                                operations.add(new Insert(nextItem, actualManipulationPosition++));
                            }
                            nextPosition++;
                        } else {
                            if (prevItemInNext == -1) {
                                operations.add(new Remove(prevItem, actualManipulationPosition));
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

    /**
     * @param prev
     * @param next
     * @return
     */
    public static List<PatchMapOperation> diff(Map<String, String> prev, Map<String, String> next) {
        List<PatchMapOperation> operations = new ArrayList();

        for (Entry<String, String> entry : next.entrySet()) {
            String key = entry.getKey();

            if (!prev.containsKey(key)) {
                operations.add(new Add(key, entry.getValue()));
            } else {
                String prevValue = prev.get(key);
                String nextValue = entry.getValue();

                if (!prevValue.equals(nextValue)) {
                    operations.add(new Change(key, nextValue));
                }
            }
        }

        for (Entry<String, String> entry : prev.entrySet()) {
            String key = entry.getKey();

            if (!next.containsKey(key)) {
                operations.add(new PatchMapOperation.Remove(key));
            }
        }
        return operations;
    }
}
