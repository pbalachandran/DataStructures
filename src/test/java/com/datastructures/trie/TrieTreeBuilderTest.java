package com.datastructures.trie;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TrieTreeBuilderTest {

    private TrieNode root;
    private TrieTreeBuilder trieTreeBuilder;

    private List<String> words;

    @Before
    public void setUp() {
        words = new ArrayList<>();
        words.add("BAT");
        words.add("BATS");
        words.add("BLUE");
        words.add("BALL");
        words.add("BLUES");
        words.add("GHOST");
        words.add("BLOCK");
        words.add("BLOCKED");
        words.add("CORK");
        words.add("COAT");
        words.add("BATSMAN");
        words.add("GOAT");

        trieTreeBuilder = new TrieTreeBuilder();
        root = trieTreeBuilder.buildTrieTree(words);
    }

    @Test
    public void buildTrieTree_searchAllWords_returnsRootNode() {
        assertNotNull(root);
        assertAllWords();
    }

    @Test
    public void countWords_returnsTotalCount() {
        assertTrue(trieTreeBuilder.countWords(root) == 12);
    }

    @Test
    public void searchPrefix_returnsBoolean() {
        assertTrue(trieTreeBuilder.searchPrefix("CO"));
        assertTrue(trieTreeBuilder.searchPrefix("COAT"));
        assertFalse(trieTreeBuilder.searchPrefix("AT"));
        assertTrue(trieTreeBuilder.searchPrefix("BL"));
        assertFalse(trieTreeBuilder.searchPrefix("UE"));
        assertFalse(trieTreeBuilder.searchPrefix("BATIS"));
        assertTrue(trieTreeBuilder.searchPrefix("GO"));
    }

    @Test
    public void searchWord_returnsBoolean() {
        assertTrue(trieTreeBuilder.searchWord("BATS"));
        assertTrue(trieTreeBuilder.searchWord("CORK"));
        assertTrue(trieTreeBuilder.searchWord("BATSMAN"));
        assertFalse(trieTreeBuilder.searchWord("BATT"));
        assertFalse(trieTreeBuilder.searchWord("BA"));
        assertFalse(trieTreeBuilder.searchWord("COATED"));
        assertTrue(trieTreeBuilder.searchWord("GOAT"));
        assertTrue(trieTreeBuilder.searchWord("GHOST"));
    }

    @Test
    public void deletePrefix_returnBoolean() {
        assertTrue(trieTreeBuilder.deletePrefix("BAT"));
        assertFalse(trieTreeBuilder.searchPrefix("BAT"));
        assertTrue(trieTreeBuilder.searchPrefix("BA"));

        assertFalse(trieTreeBuilder.searchWord("BAT"));
        assertFalse(trieTreeBuilder.searchWord("BATS"));
        assertFalse(trieTreeBuilder.searchWord("BATSMAN"));
        assertTrue(trieTreeBuilder.searchWord("BALL"));

        assertTrue(trieTreeBuilder.countWords(root) == 9);
    }

    @Test
    public void deleteWord_returnBoolean() {
        assertFalse(trieTreeBuilder.deleteWord("ATT"));

        assertTrue(trieTreeBuilder.deleteWord("BATS"));
        assertFalse(trieTreeBuilder.searchWord("BATS"));

        assertTrue(trieTreeBuilder.searchWord("BAT"));
        assertTrue(trieTreeBuilder.searchWord("BATSMAN"));
        assertTrue(trieTreeBuilder.searchWord("CORK"));

        assertTrue(trieTreeBuilder.deleteWord("BATSMAN"));
        assertFalse(trieTreeBuilder.searchWord("BATSMAN"));
        assertTrue(trieTreeBuilder.searchWord("BAT"));

        assertTrue(trieTreeBuilder.countWords(root) == 10);
    }

    private void assertAllWords() {
        assertTrue(trieTreeBuilder.searchWord("BAT"));
        assertTrue(trieTreeBuilder.searchWord("BATS"));
        assertTrue(trieTreeBuilder.searchWord("BLUE"));
        assertTrue(trieTreeBuilder.searchWord("BALL"));
        assertTrue(trieTreeBuilder.searchWord("BLUES"));
        assertTrue(trieTreeBuilder.searchWord("GHOST"));
        assertTrue(trieTreeBuilder.searchWord("BLOCK"));
        assertTrue(trieTreeBuilder.searchWord("BLOCKED"));
        assertTrue(trieTreeBuilder.searchWord("CORK"));
        assertTrue(trieTreeBuilder.searchWord("COAT"));
        assertTrue(trieTreeBuilder.searchWord("BATSMAN"));
        assertTrue(trieTreeBuilder.searchWord("GOAT"));
    }
}