package com.datastructures.bst;

public class BSTBuilder {


    public static BSTNode build(Integer[] nodeValues, int start, int end) {

        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;
        BSTNode node = BSTNode
                .builder()
                .value(nodeValues[mid])
                .build();

        node.setLc(build(nodeValues, start, mid - 1));
        node.setRc(build(nodeValues, mid + 1, end));
        return node;
    }

    public static void inOrderPrint(BSTNode root) {
        if (root.getLc() != null) {
            inOrderPrint(root.getLc());
        }

        System.out.println(root.toString());

        if (root.getRc() != null) {
            inOrderPrint(root.getRc());
        }
    }

    public static void main(String[] args) {
        // Given a sorted list of numbers in ascending order
        // create a BST with minimum depth
    }
}
