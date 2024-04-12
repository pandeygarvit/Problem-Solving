class Trie {

    private class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }


    public void insert(String word) {

        TrieNode current = root;

        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }

            current = current.children[c - 'a'];
        }

        current.isEnd = true;
    }

    public boolean search(String word) {

        TrieNode current = root;

        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return false;
            }

            current = current.children[c - 'a'];
        }
        return current.isEnd;
    }

    public boolean startsWith(String prefix) {

        TrieNode current = root;

        for (char c : prefix.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return false;
            }

            current = current.children[c - 'a'];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */