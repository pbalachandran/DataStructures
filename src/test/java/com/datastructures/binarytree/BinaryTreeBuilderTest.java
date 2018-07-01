package com.datastructures.binarytree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BinaryTreeBuilderTest {

    private Node root;
    private BinaryTreeBuilder binaryTreeBuilder;

    @Before
    public void setUp() {
        int[] array = new int[7];

        for (int i = 0; i < 7; i++) {
            array[i] = i;
        }
        binaryTreeBuilder = new BinaryTreeBuilder();
        root = binaryTreeBuilder.build(array);
    }

    @Test
    public void build_buildsBinaryTree() {
        assertNotNull(root);
    }

    @Test
    public void countNodes_returnsNumberOfNodes() {
        assertTrue(binaryTreeBuilder.countNodes(root) == 7);
    }

    @Test
    public void countLeafNodes_returnsNumberOfLeafNodes() {
        assertTrue(binaryTreeBuilder.countLeafNodes(root) == 4);
    }
}