package com.datastructures.bst.bstcheck;

import com.datastructures.bst.BSTBuilder;
import com.datastructures.bst.BSTNode;

public class BSTCheck {

    private BSTNode root;

    public static void main(String[] args) {
        Integer[] sortedList = {1, 2, 3, 4, 5, 67, 99, 101, 201, 333, 456, 554, 556, 777, 888, 999};
        BSTCheck bstCheck = new BSTCheck();
        boolean isBST = bstCheck.isBST(sortedList);
        System.out.println("isBST: " + isBST);
    }

    public boolean isBST(Integer[] sortedList) {
        root = BSTBuilder.build(sortedList, 0, sortedList.length - 1);
        return isBST(root);
    }

    public boolean isBST(BSTNode node) {
        if (node == null) {
            return true;
        }

        if (node.getLc() == null && node.getRc() == null) {
            return true;
        } else {
            if (node.getLc() != null && node.getRc() == null) {
                return node.getLc().getValue() <= node.getValue() && isBST(node.getLc());
            } else if (node.getLc() == null && node.getRc() != null) {
                return node.getRc().getValue() > node.getValue() && isBST(node.getRc());
            } else {
                return (node.getLc().getValue() <= node.getValue() && node.getRc().getValue() > node.getValue()) && (isBST(node.getLc()) && isBST(node.getRc()));
            }
        }
    }
}
