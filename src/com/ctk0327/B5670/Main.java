package com.ctk0327.B5670;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static int result;
    static String line;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while ((line = bf.readLine()) != null) {
            result = 0;
            Trie trie = new Trie();
            int N = Integer.parseInt(line);
            String[] temp = new String[N];
            for (int i = 0; i < N; i++) {
                temp[i] = bf.readLine();
                trie.insert(temp[i]);
            }
            for (Character c : trie.root.getChildren().keySet()) {
                computeResult(trie.root.getChildren().get(c), 1);
            }
            System.out.printf("%.2f\n",result/(double)N);
        }
    }

    private static void computeResult(TrieNode trieNode, int count) {
        Map<Character, TrieNode> map = trieNode.getChildren();
        if (map.size() > 1) {
            trieNode.setCount(count + 1);
        } else {
            if (map.size() == 1 && trieNode.isEndOfWord()) {
                trieNode.setCount(count + 1);
            } else {
                trieNode.setCount(count);
            }
        }

        if (trieNode.isEndOfWord()) {
            if (map.size() != 0) {
                result += trieNode.getCount() - 1;
            } else {
                result += trieNode.getCount();
            }
        }
        for (Character c : map.keySet()) {
            computeResult(map.get(c), trieNode.getCount());
        }
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        current.setEndOfWord(true);
    }

    boolean delete(String word) {
        return delete(root, word, 0);
    }

    boolean containsNode(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    boolean isEmpty() {
        return root == null;
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }
}

class TrieNode {
    private final Map<Character, TrieNode> children = new HashMap<>();
    private boolean endOfWord;
    private int count;

    public TrieNode() {
        count = 1;
    }

    void setCount(int a) {
        count = a;
    }

    int getCount() {
        return count;
    }

    Map<Character, TrieNode> getChildren() {
        return children;
    }

    boolean isEndOfWord() {
        return endOfWord;
    }

    void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}
