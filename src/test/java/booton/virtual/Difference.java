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
        int leftVirtualPosition = 0;
        int rightVirtualPosition = 0;
        int actualManipulatePosition = 0;
        int actualOffset = 0;
        int upCount = 0;
        boolean[] skip = new boolean[max];
        boolean[] alreadyOperated = new boolean[max];

        for (int i = 0; i < max; i++) {
            if (alreadyOperated[leftVirtualPosition]) {
                leftVirtualPosition++;
                continue;
            }

            if (leftSize <= leftVirtualPosition) {
                if (rightSize <= rightVirtualPosition) {
                    break; // all items were scanned
                } else {
                    // all left items are scanned, but right items are remaining
                    operations.add(new Insert(right.get(rightVirtualPosition++), actualManipulatePosition++));
                    actualOffset++;
                    continue;
                }
            } else {
                if (rightSize <= rightVirtualPosition) {
                    // all right items are scanned, but left items are remaining
                    operations.add(new Remove(left.get(leftVirtualPosition++), actualManipulatePosition));
                    actualOffset--;
                    continue;
                } else {
                    // left and right items are remaining
                    Object leftItem = left.get(leftVirtualPosition);
                    Object rightItem = right.get(rightVirtualPosition);

                    if (leftItem == rightItem) {
                        // same item
                        actualManipulatePosition++;
                        leftVirtualPosition++;
                        rightVirtualPosition++;
                        continue;
                    } else {
                        // different item
                        int rightItemInLeft = left.indexOf(rightItem);
                        int leftItemInRight = right.indexOf(leftItem);

                        if (rightItemInLeft == -1 && leftItemInRight == -1) {
                            operations.add(new Replace(leftItem, rightItem, actualManipulatePosition++));
                            leftVirtualPosition++;
                            rightVirtualPosition++;
                            continue;
                        }

                        if (rightItemInLeft == -1) {
                            operations.add(new Insert(rightItem, actualManipulatePosition++));
                            rightVirtualPosition++;
                            actualOffset++;
                            continue;
                        }

                        if (leftItemInRight == -1) {
                            operations.add(new Remove(leftItem, actualManipulatePosition));
                            leftVirtualPosition++;
                            actualOffset--;
                            continue;
                        }

                        // both items are found in each other list
                        if (rightVirtualPosition < rightItemInLeft + actualOffset) {
                            operations.add(new Up(rightItem, rightItemInLeft + actualOffset, actualManipulatePosition++));
                            rightVirtualPosition++;
                            actualOffset++;
                            alreadyOperated[rightItemInLeft] = true;
                            continue;
                        }
                        leftVirtualPosition++;
                        rightVirtualPosition++;

                        // if (rightItemInLeft == -1) {
                        // } else if (leftItemInRight == -1) {
                        // } else {
                        // // right item is found in left
                        // if (rightVirtualPosition <= rightItemInLeft) {
                        // // int from = actualManipulatePosition + rightItemInLeft -
                        // // leftVirtualPosition;
                        // // upCount++;
                        // // skip[rightItemInLeft] = true;
                        // // operations.add(new Up(rightItem, from,
                        // // actualManipulatePosition++));
                        // // rightVirtualPosition++;
                        // // continue;
                        // } else {
                        // // int from = actualManipulatePosition + rightItemInLeft + upCount -
                        // // leftVirtualPosition;
                        // //
                        // // if (from != actualManipulatePosition) {
                        // // operations.add(new Down(rightItem, from,
                        // // actualManipulatePosition++));
                        // // }
                        // }
                        // // leftVirtualPosition++;
                        // // rightVirtualPosition++;
                        // }
                    }
                }
            }
        }

        return operations;
    }
}
