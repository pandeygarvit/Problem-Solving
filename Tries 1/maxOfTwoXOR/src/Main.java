class Solution {
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        int maxXOR = 0;

        for (int num : nums) {
            insertIntoTrie(num, root);
        }

        for (int num : nums) {
            int idealValue = num ^ Integer.MAX_VALUE;
            int presentClosestValue = query(root, idealValue);

            maxXOR = Math.max(maxXOR, presentClosestValue ^ num);
        }

        return maxXOR;
    }

    private class TrieNode {
        TrieNode left;
        TrieNode right;

        TrieNode() {
            left = null;
            right = null;
        }
    }

    private int query(TrieNode root, int val) { // find value closes to val
        TrieNode current = root;
        int ans = 0;
        int bitIndex = 30;

        while (bitIndex >= 0) {
            int mask = (1 << bitIndex);
            int bitValue = (val & mask) > 0 ? 1 : 0;

            if (bitValue == 0) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current = current.right;
                    ans |= mask;
                }
            } else {
                if (current.right != null) {
                    current = current.right;
                    ans |= mask;
                } else {
                    current = current.left;
                }
            }

            bitIndex--;
        }
        return ans;
    }

    private void insertIntoTrie(int num, TrieNode root) {
        TrieNode current = root;

        int bitCount = 30;
        while (bitCount >= 0) {
            int mask = (1 << bitCount);
            int bitValue = (mask & num) > 0 ? 1 : 0;
            if (bitValue == 0) {
                if (current.left == null) {
                    current.left = new TrieNode();
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new TrieNode();
                }
                current = current.right;
            }
            bitCount--;
        }
    }
}