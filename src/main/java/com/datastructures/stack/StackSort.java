package com.datastructures.stack;


import java.util.List;
import java.util.Stack;

/**
 * Sort numbers in a stack using another stack - no other data structure is permitted
 */
public class StackSort {

    private static Stack<Number> left, right;

    public static Stack<Number> sort(List<Number> numbers) {
        left = new Stack<>();
        right = new Stack<>();
        for (Number n : numbers) {
            left.push(n);
        }
        doSort();
        return right;
    }

    private static void doSort() {

        while (!left.isEmpty()) {
            Number leftTop = left.peek();

            Number rightTop = null;
            if (!right.isEmpty()) {
                rightTop = right.peek();
            }

            if (rightTop == null || (leftTop.intValue() <= rightTop.intValue())) {
                right.push(left.pop());
            } else {
                Number rightTemp = right.pop();
                right.push(left.pop());
                left.push(rightTemp);

                while (!right.isEmpty()) {
                    Number current = right.pop();
                    Number next = null;
                    if (right.size() > 1) {
                        next = right.peek();
                    }

                    if (next != null && current.intValue() > next.intValue()) {
                        left.push(right.pop());
                        right.push(current);
                    } else {
                        left.push(current);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
    }
}
