class Solution {
    public int[] sumPrefixScores(String[] words) {

        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            insertIntoTrie(words[i], root);
        }

        int[] count = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            count[i] = query(words[i], root);
        }

        return count;
    }

    public class TrieNode {
        TrieNode[] children;
        int count;

        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }
    }

    public void insertIntoTrie(String word, TrieNode root) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            if (current.children[currentChar - 'a'] == null) {
                current.children[currentChar - 'a'] = new TrieNode();
            }
            current = current.children[currentChar - 'a'];
            current.count++;
        }
    }

    public int query(String word, TrieNode root) {

        TrieNode current = root;
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            current = current.children[currentChar - 'a'];
            count += current.count;
        }

        return count;
    }
}