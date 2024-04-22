import java.util.*;

public class AutoCompleteSystem {
    class TrieNode {
        Map<String, Integer> suggestions;
        TrieNode[] children;

        TrieNode() {
            suggestions = new HashMap<>();
            children = new TrieNode[27];
        }
    }

    private int getMask(char c) {
        return c == ' ' ? 0 : c - 'a' + 1;
    }

    private void storeSuggestion(String s, int priority) {
        TrieNode current = root;
        for (char it : s.toCharArray()) {
            int index = getMask(it);
            if (current.children[index] == null)
                current.children[index] = new TrieNode();
            current = current.children[index];
            if (!current.suggestions.containsKey(s)) {
                if (current.suggestions.size() < 3)
                    current.suggestions.put(s, priority);
                else {
                    int minPriority = Integer.MAX_VALUE;
                    String minSuggestion = "";
                    for (Map.Entry<String, Integer> entry : current.suggestions.entrySet()) {
                        if (minPriority > entry.getValue()) {
                            minPriority = entry.getValue();
                            minSuggestion = entry.getKey();
                        }
                    }
                    for (Map.Entry<String, Integer> entry : current.suggestions.entrySet()) {
                        if (minPriority == entry.getValue())
                            minSuggestion = minSuggestion.compareTo(entry.getKey()) < 0 ? minSuggestion : entry.getKey();
                    }
                    if (minPriority < priority || (minPriority == priority && s.compareTo(minSuggestion) < 0)) {
                        current.suggestions.remove(minSuggestion);
                        current.suggestions.put(s, priority);
                    }
                }
            } else
                current.suggestions.put(s, Math.max(current.suggestions.get(s), priority));
        }
    }

    private String currentInput;
    private TrieNode root;
    private Map<String, Integer> frequencyMap;

    public AutoCompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        List<Pair<String, Integer>> sentencePriorityPairs = new ArrayList<>();
        for (int i = 0; i < sentences.length; i++)
            sentencePriorityPairs.add(new Pair<>(sentences[i], times[i]));
        Collections.sort(sentencePriorityPairs, new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> a, Pair<String, Integer> b) {
                return a.getKey().compareTo(b.getKey());
            }
        });
        currentInput = "";
        frequencyMap = new HashMap<>();
        for (Pair<String, Integer> pair : sentencePriorityPairs) {
            storeSuggestion(pair.getKey(), pair.getValue());
            frequencyMap.put(pair.getKey(), pair.getValue());
        }
    }

    private List<String> getSuggestions(String prefix) {
        TrieNode current = root;
        for (char it : prefix.toCharArray()) {
            int index = getMask(it);
            if (current.children[index] == null)
                return new ArrayList<>();
            current = current.children[index];
        }
        List<String> suggestions = new ArrayList<>();
        List<Pair<Integer, String>> temp = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : current.suggestions.entrySet())
            temp.add(new Pair<>(entry.getValue(), entry.getKey()));
        Collections.sort(temp, new Comparator<Pair<Integer, String>>() {
            @Override
            public int compare(Pair<Integer, String> a, Pair<Integer, String> b) {
                if (a.getKey() > b.getKey())
                    return -1;
                else if (a.getKey().equals(b.getKey()))
                    return a.getValue().compareTo(b.getValue());
                else
                    return 1;
            }
        });
        for (Pair<Integer, String> pair : temp)
            suggestions.add(pair.getValue());
        return suggestions;
    }

    public List<String> input(char c) {
        if (c == '#') {
            frequencyMap.put(currentInput, frequencyMap.getOrDefault(currentInput, 0) + 1);
            storeSuggestion(currentInput, frequencyMap.get(currentInput));
            currentInput = "";
            return new ArrayList<>();
        }
        currentInput += c;
        return getSuggestions(currentInput);
    }
}
