import java.util.*;

public class Solution {
    class TrieNode {
        TrieNode[] children;
        List<Integer> indices;

        TrieNode() {
            children = new TrieNode[26];
            indices = new ArrayList<>();
        }
    }

    TrieNode root;

    void insert(String word, int idx) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null)
                node.children[ch - 'a'] = new TrieNode();
            node = node.children[ch - 'a'];
            node.indices.add(idx);
        }
    }

    List<String> search(String query, String[] contacts) {
        TrieNode node = root;
        List<String> result = new ArrayList<>();
        for (char ch : query.toCharArray()) {
            if (node.children[ch - 'a'] == null)
                return result;
            node = node.children[ch - 'a'];
        }
        for (int idx : node.indices)
            result.add(contacts[idx]);
        return result;
    }

    List<List<String>> displayContacts(int n, String[] contact, String query) {
        root = new TrieNode();
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(contact[i]))
                insert(contact[i], i);
            visited.add(contact[i]);
        }

        List<List<String>> result = new ArrayList<>();
        StringBuilder subQuery = new StringBuilder();
        for (char ch : query.toCharArray()) {
            subQuery.append(ch);
            List<String> contacts = search(subQuery.toString(), contact);
            Collections.sort(contacts);
            if (contacts.isEmpty())
                result.add(Collections.singletonList("0"));
            else
                result.add(new ArrayList<>(contacts));
        }
        return result;
    }
}
