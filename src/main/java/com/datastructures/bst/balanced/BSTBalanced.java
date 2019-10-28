package com.datastructures.bst.balanced;

import com.datastructures.bst.BSTBuilder;
import com.datastructures.bst.BSTNode;
import com.datastructures.bst.BSTNodeComparator;
import com.datastructures.bst.height.BSTHeightCalculator;

import java.util.PriorityQueue;
import java.util.Queue;

public class BSTBalanced {

    private BSTNode root;

    public static void main(String[] args) {
        Integer[] sortedList = {1, 2, 3, 4, 5, 99, 101, 201, 333, 456, 554, 556, 777, 888, 999, 1001, 1002, 1003, 1004};
        BSTBalanced bstBalanced = new BSTBalanced();
        boolean isBalanced = bstBalanced.isBalanced(sortedList);
        System.out.println("isBalanced " + isBalanced);
    }

    public boolean isBalanced(Integer[] sortedList) {
        root = BSTBuilder.build(sortedList, 0, sortedList.length - 1);

        Queue<BSTNode> pq = new PriorityQueue<>(1, new BSTNodeComparator());

        pq.add(root);
        while (!pq.isEmpty()) {
            BSTNode node = pq.remove();

            int lheight = 0, rheight = 0;
            if (node.getLc() != null) {
                pq.add(node.getLc());
                lheight = BSTHeightCalculator.computeHeight(node.getLc());
            }

            if (node.getRc() != null) {
                pq.add(node.getRc());
                rheight = BSTHeightCalculator.computeHeight(node.getRc());
            }

            if (lheight != rheight) {
                return false;
            }
        }
        return true;
    }
}