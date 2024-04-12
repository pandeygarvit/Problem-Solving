import java.util.List;

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] wordsOfSentence = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        TrieNode root = new TrieNode();
        for (String str : dictionary) {
            insertIntoTrie(str, root);
        }

        for (String word : wordsOfSentence) {
            ans.append(query(word, root));
            ans.append(" ");
        }
        int lastIndex = ans.lastIndexOf(" ");
        if (lastIndex != -1) {
            ans.deleteCharAt(lastIndex);
        }

        return ans.toString();
    }

    public class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    public String query(String word, TrieNode root) {
        TrieNode current = root;
        if (current.children[word.charAt(0) - 'a'] == null) {
            return word;
        }
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (current.children[currentChar - 'a'] == null) {
                if (current.isEnd == true){
                    return str.toString();
                }
                else{
                    return word;
                }
            }
            if (current.isEnd == true) {
                return str.toString();
            }
            str.append(currentChar);
            current = current.children[currentChar - 'a'];
        }

        return str.toString();
    }

    public void insertIntoTrie(String word, TrieNode root) {

        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (current.children[currentChar - 'a'] == null) {
                current.children[currentChar - 'a'] = new TrieNode();
            }
            current = current.children[currentChar - 'a'];
        }

        current.isEnd = true;
    }
}