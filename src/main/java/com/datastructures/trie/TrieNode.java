package com.datastructures.trie;

import lombok.Data;

import java.util.*;

@Data
public class TrieNode {

    private String name;
    private HashMap<Character, TrieNode> children;
    private boolean isEndOfWord = false;

    public TrieNode(String name) {
        this.name = name;
        this.children = new HashMap<>();
    }
}
