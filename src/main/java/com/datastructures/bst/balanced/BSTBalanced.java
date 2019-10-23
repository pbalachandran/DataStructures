package com.datastructures.bst.balanced;

import com.datastructures.bst.BSTBuilder;
import com.datastructures.bst.BSTNode;

public class BSTBalanced {

    private BSTNode root;
    private int lHeight, rHeight;
    private BSTBuilder bstBuilder;

    public static void main(String[] args) {
        Integer[] sortedList = {1, 2, 3, 4, 5};
        BSTBalanced bstBalanced = new BSTBalanced();
        bstBalanced.compute(sortedList);
    }

    public void compute(Integer[] sortedList) {
        root = bstBuilder.build(sortedList, 0, sortedList.length - 1);

    }
}