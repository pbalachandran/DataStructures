package com.datastructures.trie;

import java.util.*;

public class TrieTreeBuilder {

    public final String ROOT = "ROOT";
    private TrieNode root = new TrieNode(ROOT);

    public TrieNode buildTrieTree(List<String> words) {
        for (String word : words) {
            int index = 0;
            TrieNode current = root;
            while (index < word.length()) {
                Character c = word.charAt(index);
                current = buildTrieTreeNode(c, current);
                index++;
            }
            current.setEndOfWord(true);
        }
        return root;
    }

    private TrieNode buildTrieTreeNode(Character c, TrieNode current) {
        TrieNode child;
        Set<Character> keySet = current.getChildren().keySet();
        if (!keySet.isEmpty() && keySet.contains(c)) {
            child = current.getChildren().get(c);
        } else {
            child = new TrieNode(String.valueOf(c));
            current.getChildren().put(c, child);
        }
        return child;
    }

    public boolean searchPrefix(String prefix) {
        return searchNodes(prefix, 0, false, root);
    }

    public boolean searchWord(String word) {
        return searchNodes(word, 0, true, root);
    }

    public boolean deletePrefix(String prefix) {
        if (searchPrefix(prefix)) {
            return deleteNodesAndAdjust(prefix, true);
        }
        return false;
    }

    public boolean deleteWord(String word) {
        if (searchWord(word)) {
            return deleteNodesAndAdjust(word, false);
        }
        return false;
    }

    private boolean deleteNodesAndAdjust(String prefix, boolean isDeletePrefix) {
        try {
            List<TrieNode> nodeChain = findNodeChain(prefix);

            int index = nodeChain.size() - 1;
            TrieNode target = nodeChain.get(index);
            target.setEndOfWord(false);

            if (isDeletePrefix) {
                target.getChildren().clear();
            }
            reverseTraversal(index, target, nodeChain);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void reverseTraversal(int index, TrieNode target, List<TrieNode> nodeChain) {
        while (index > 0) {
            if (!target.getChildren().isEmpty()) {
                break;
            } else {
                index--;
                TrieNode parent = nodeChain.get(index);
                if (!target.isEndOfWord()) {
                    parent.getChildren().remove(target.getName().charAt(0));
                    target = parent;
                } else {
                    break;
                }
            }
        }
    }

    private List<TrieNode> findNodeChain(String word) throws Exception {
        List<TrieNode> nodeChain = new ArrayList<>();

        int index = 0;
        TrieNode target = root;
        nodeChain.add(target);
        while (index < word.length()) {
            target = findNode(word.charAt(index++), target);
            if (target != null) {
                nodeChain.add(target);
            } else {
                throw new Exception("Word does not exist in the dictionary");
            }
        }
        return nodeChain;
    }

    private TrieNode findNode(char character, TrieNode target) {
        return target.getChildren().get(character);
    }

    private boolean searchNodes(String prefix, int currentCharacterIndex,
                                boolean isWordSearch, TrieNode current) {
        if (current.getChildren().keySet().contains(prefix.charAt(currentCharacterIndex))) {
            TrieNode child = current.getChildren().get(prefix.charAt(currentCharacterIndex));
            currentCharacterIndex++;

            if (currentCharacterIndex < prefix.length()) {
                return searchNodes(prefix, currentCharacterIndex, isWordSearch, child);
            } else {
                if (isWordSearch) {
                    return child.isEndOfWord() ? true : false;
                } else {
                    return true;
                }
            }
        } else {
            return false;
        }
    }

    public int countWords(TrieNode node) {
        int count = 0;
        List<TrieNode> children = new ArrayList<>(node.getChildren().values());
        for (TrieNode child : children) {
            if (child.isEndOfWord()) {
                count++;
            }
            count += countWords(child);
        }
        return count;
    }

    public void printTrieTree(TrieNode node) {
        List<TrieNode> children = new ArrayList<>(node.getChildren().values());
        for (TrieNode child : children) {
            System.out.println(child.getName());

            if (child.isEndOfWord()) {
                System.out.println("+++++++++++");
            }
            printTrieTree(child);
        }
    }
}