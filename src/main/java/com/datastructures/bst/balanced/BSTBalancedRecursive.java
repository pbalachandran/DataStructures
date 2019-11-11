package com.datastructures.bst.balanced;

import com.datastructures.bst.BSTBuilder;
import com.datastructures.bst.BSTNode;

public class BSTBalancedRecursive {

    private BSTNode root;

    public static void main(String[] args) {
        Integer[] sortedList = {1, 2, 3, 4, 5, 6, 7, 8};
        BSTBalancedRecursive bstBalancedRecursive = new BSTBalancedRecursive();
        boolean isBalanced = bstBalancedRecursive.isBalancedRecursive(sortedList);
        System.out.println("isBalancedRecursive " + isBalanced);
    }

    public boolean isBalancedRecursive(Integer[] sortedList) {
        root = BSTBuilder.build(sortedList, 0, sortedList.length - 1);
        boolean isBalanced = (height(root.getLc(), 0) != height(root.getRc(), 0));
        return isBalanced;
    }

    private int height(BSTNode node, int currentHeight) {
        int lHeight = 0, rHeight = 0;

        if (node.getLc() != null) {
            lHeight = height(node.getLc(), currentHeight + 1);
        }

        if (node.getRc() != null) {
            rHeight = height(node.getRc(), currentHeight + 1);
        }
        return Math.max(lHeight, rHeight);
    }
}
