package com.datastructures.bst;

import java.util.Comparator;

public class BSTNodeComparator implements Comparator<BSTNode> {

    @Override
    public int compare(BSTNode left, BSTNode right) {
        return Integer.valueOf(left.getValue()).compareTo(Integer.valueOf(right.getValue()));
    }
}
