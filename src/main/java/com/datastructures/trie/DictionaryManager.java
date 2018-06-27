package com.datastructures.trie;

import java.util.ArrayList;
import java.util.List;

public class DictionaryManager {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("BAT");
        words.add("BATS");
        words.add("BLUE");
        words.add("BLUES");
        words.add("GHOST");
        words.add("BLOCK");
        words.add("BLOCKED");
        words.add("CORK");
        words.add("COAT");
        words.add("BATSMAN");
        words.add("GOAT");

        TrieTreeBuilder builder = new TrieTreeBuilder();
        TrieNode root = builder.buildTrieTree(words);

        builder.printTrieTree(root);
        System.out.println("\n");

        System.out.println("Prefix Search - \"CO\" exists: " + builder.searchPrefix("CO"));
        System.out.println("Prefix Search - \"COAT\" exists: " + builder.searchPrefix("COAT"));
        System.out.println("Prefix Search - \"AT\" exists: " + builder.searchPrefix("AT"));
        System.out.println("Prefix Search - \"BL\" exists: " + builder.searchPrefix("BL"));
        System.out.println("Prefix Search - \"UE\" exists: " + builder.searchPrefix("UE"));
        System.out.println("Prefix Search - \"GO\" exists: " + builder.searchPrefix("GO"));

        System.out.println("\n");

        System.out.println("Word Search - \"BATS\" exists: " + builder.searchWord("BATS"));
        System.out.println("Word Search - \"CORK\" exists: " + builder.searchWord("CORK"));
        System.out.println("Word Search - \"BATSMAN\" exists: " + builder.searchWord("BATSMAN"));
        System.out.println("Word Search - \"BATT\" exists: " + builder.searchWord("BATT"));
        System.out.println("Word Search - \"COATED\" exists: " + builder.searchWord("COATED"));
        System.out.println("Word Search - \"GOAT\" exists: " + builder.searchWord("GOAT"));
        System.out.println("Word Search - \"GHOST\" exists: " + builder.searchWord("GHOST"));
    }
}
