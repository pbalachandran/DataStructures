package com.datastructures.bst;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BSTNode implements Comparable<BSTNode> {
    private int value;
    private BSTNode lc;
    private BSTNode rc;


    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int compareTo(BSTNode that) {
        return Integer.valueOf(this.getValue()).compareTo(Integer.valueOf(that.getValue()));
    }
}
