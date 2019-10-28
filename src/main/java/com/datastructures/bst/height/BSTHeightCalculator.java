package com.datastructures.bst.height;

import com.datastructures.bst.BSTBuilder;
import com.datastructures.bst.BSTNode;
import com.datastructures.bst.BSTNodeComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BSTHeightCalculator {

    private BSTNode root;

    public static void main(String[] args) {
        Integer[] sortedList = {1, 2, 3, 4, 5, 67, 99, 101, 201, 333, 456, 554, 556, 777, 888, 999};
        BSTHeightCalculator bstHeightCalculator = new BSTHeightCalculator();
        int height = bstHeightCalculator.computeHeight(sortedList);
        System.out.println("Height " + height);
    }

    public int computeHeight(Integer[] sortedList) {
        root = BSTBuilder.build(sortedList, 0, sortedList.length - 1);
        return BSTHeightCalculator.computeHeight(root);
    }

    public static int computeHeight(BSTNode node) {
        int height = 0;

        List<BSTNode> children = new ArrayList<>();
        Queue<BSTNode> parents = new PriorityQueue<>(1, new BSTNodeComparator());

        BSTNode parent;
        parents.add(node);

        boolean done = false;
        while (!done) {
            if (!parents.isEmpty()) {
                parent = parents.remove();
                children.addAll(BSTHeightCalculator.getChildren(parent));
            } else {
                if (children.isEmpty()) {
                    done = true;
                } else {
                    height++;
                    parents.addAll(children);
                    children = new ArrayList<>();
                }
            }
        }
        return height;
    }

    private static List<BSTNode> getChildren(BSTNode node) {
        List<BSTNode> list = new ArrayList();
        if (node.getLc() != null) {
            list.add(node.getLc());
        }

        if (node.getRc() != null) {
            list.add(node.getRc());
        }
        return list;
    }
}
