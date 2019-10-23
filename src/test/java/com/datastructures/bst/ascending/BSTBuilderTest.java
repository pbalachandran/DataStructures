package com.datastructures.bst.ascending;

import com.datastructures.bst.BSTBuilder;
import com.datastructures.bst.BSTNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BSTBuilderTest {

    private BSTBuilder subject;

    @Before
    public void setUp() throws Exception {
        subject = new BSTBuilder();
    }

    @Test
    public void build() {
        Integer[] sortedList = {1, 2, 3, 4, 5, 67, 99};
        BSTNode root = subject.build(sortedList, 0, sortedList.length -1);


        subject.inOrderPrint(root);

        Assert.assertNotNull(root);
    }
}