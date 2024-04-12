import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;
    int minLength;
    int index;

    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
        minLength = Integer.MAX_VALUE;
    }
}

class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word, int i) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            if (current.minLength > word.length()) {
                current.minLength = word.length();
                current.index = i;
            }
            current = current.children.get(ch);
        }
        if (current.minLength > word.length()) {
            current.minLength = word.length();
            current.index = i;
        }
        current.isEndOfWord = true;
    }

    boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return false;
            }
            current = current.children.get(ch);
        }
        return current != null && current.isEndOfWord;
    }

    int startsWith(String prefix) {
        TrieNode current = root;
        int ans = -1;
        for (char ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return current.index;
            }
            ans = current.index;
            current = current.children.get(ch);
        }
        return current.index;
    }
}

public class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie trie = new Trie();
        int k = 0;
        for (String word : wordsContainer) {
            StringBuilder reversedWord = new StringBuilder(word).reverse();
            trie.insert(reversedWord.toString(), k);
            k++;
        }
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            StringBuilder reversedQuery = new StringBuilder(wordsQuery[i]).reverse();
            ans[i] = trie.startsWith(reversedQuery.toString());
        }
        return ans;
    }
}
