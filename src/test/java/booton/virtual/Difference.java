/*
 * Copyright (C) 2014 Nameless Production Committee
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

import booton.virtual.DiffOperation.Down;
import booton.virtual.DiffOperation.Insert;
import booton.virtual.DiffOperation.Remove;
import booton.virtual.DiffOperation.Replace;
import booton.virtual.DiffOperation.Up;

/**
 * @version 2014/08/29 9:19:06
 */
public class Difference {

    /**
     * @param left
     * @param right
     */
    public static List<DiffOperation> diff(List left, List right) {
        List<DiffOperation> operations = new ArrayList();

        int leftSize = left.size();
        int rightSize = right.size();
        int max = leftSize + rightSize;
        int leftPosition = 0;
        int rightPosition = 0;
        int operatePosition = 0;
        int upCount = 0;

        for (int i = 0; i < max; i++) {
            if (leftPosition < leftSize) {
                if (rightPosition < rightSize) {
                    // left and right items are remaining
                    Object leftItem = left.get(leftPosition);
                    Object rightItem = right.get(rightPosition);

                    if (leftItem == rightItem) {
                        // same
                        operatePosition++;
                        leftPosition++;
                        rightPosition++;
                    } else {
                        // diff
                        int leftIndex = left.indexOf(rightItem);
                        int rightIndex = right.indexOf(leftItem);

                        if (leftIndex == -1) {
                            // right item is not found in left
                            if (rightIndex == -1) {
                                // left item is not found in right
                                operations.add(new Replace(leftItem, rightItem, operatePosition++));
                                leftPosition++;
                                rightPosition++;
                            } else {
                                // left item is found in right
                                operations.add(new Insert(rightItem, operatePosition++));
                                rightPosition++;
                            }
                        } else if (rightIndex == -1) {
                            // left item is not found in right
                            if (leftIndex == -1) {
                                // right item is not found in left
                                operations.add(new Replace(leftItem, rightItem, operatePosition++));
                                leftPosition++;
                                rightPosition++;
                            } else {
                                // right item is found in left
                                operations.add(new Remove(leftItem, operatePosition));
                                leftPosition++;
                            }
                        } else {
                            // right item is found in left
                            if (rightPosition <= leftIndex) {
                                upCount++;
                                operations.add(new Up(rightItem, operatePosition + leftIndex - leftPosition, operatePosition++));
                            } else {
                                int from = operatePosition + leftIndex + upCount - leftPosition;

                                if (from != operatePosition) {
                                    operations.add(new Down(rightItem, from, operatePosition++));
                                }
                            }
                            leftPosition++;
                            rightPosition++;
                        }
                    }
                } else {
                    // all right items are scanned, but left items are remaining
                    operations.add(new Remove(left.get(leftPosition), operatePosition));
                    leftPosition++;
                }
            } else {
                if (rightPosition < rightSize) {
                    // all left items are scanned, but right items are remaining
                    operations.add(new Insert(right.get(rightPosition), operatePosition++));
                    rightPosition++;
                } else {
                    break; // all items were scanned
                }
            }
        }

        return operations;
    }
}
