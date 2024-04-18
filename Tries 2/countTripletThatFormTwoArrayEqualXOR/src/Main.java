class TrieNode {
    int count;
    int sum;
    TrieNode[] children;

    TrieNode() {
        count = 0;
        sum = 0;
        children = new TrieNode[2];
        children[0] = null;
        children[1] = null;
    }
}

class Solution {
    TrieNode root;

    int getValue(TrieNode root, int num, int index) {
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (root.children[bit] == null) {
                return 0;
            }
            root = root.children[bit];
        }
        return (((root.count) * index) - (root.sum));
    }

    void insert(TrieNode root, int num, int index) {
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (root.children[bit] == null) {
                root.children[bit] = new TrieNode();
            }
            root = root.children[bit];
        }
        root.sum += index;
        root.count++;
    }

    int countTriplets(int[] arr) {
        root = new TrieNode();
        int answer = 0;
        int xorValue = 0;
        for (int i = 0; i < arr.length; i++) {
            insert(root, xorValue, i);
            xorValue ^= arr[i];
            answer += getValue(root, xorValue, i);
        }
        return answer;
    }
}
