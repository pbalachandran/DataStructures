package com.datastructures.bst.height;

import com.datastructures.bst.BSTBuilder;
import com.datastructures.bst.BSTNode;
import com.datastructures.bst.BSTNodeComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BSTHeightCalculator {

    private int height = 0;
    private BSTNode root;
    private BSTBuilder bstBuilder;

    public static void main(String[] args) {
        Integer[] sortedList = {1, 2, 3, 4, 5, 67, 99, 101, 201, 333, 456, 554, 556, 777, 888, 999};
        BSTHeightCalculator bstHeightCalculator = new BSTHeightCalculator();
        bstHeightCalculator.compute(sortedList);
    }

    public void compute(Integer[] sortedList) {
        root = bstBuilder.build(sortedList, 0, sortedList.length - 1);

        List<BSTNode> children = null;
        Queue<BSTNode> parents = new PriorityQueue<>(1, new BSTNodeComparator());

        BSTNode parent;
        parents.add(root);

        boolean done = false;
        while (!done) {
            if (!parents.isEmpty()) {
                parent = parents.remove();
                children = getChildren(parent);
            } else {
                if (children.isEmpty()) {
                    done = true;
                    System.out.println("Height: " + height);
                } else {
                    height++;
                    parents.addAll(children);
                    children = null;
                }
            }
        }
    }

    private List<BSTNode> getChildren(BSTNode node) {
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
