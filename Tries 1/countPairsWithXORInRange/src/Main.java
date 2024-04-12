class Solution {

    public int countPairs(int[] nums, int low, int high) {

        int count = 0;
        TrieNode root = new TrieNode();

        for (int num : nums) {
            count += query(num, root, high, 14);
            count -= query(num, root, low - 1, 14);

            insertIntoTrie(num, root);
        }

        return count;
    }

    private class TrieNode {

        TrieNode left;
        TrieNode right;
        int count;

        TrieNode () {
            left = null;
            right = null;
            count = 0;
        }
    }

    private int getCount(TrieNode root) {
        return (root == null ? 0 : root.count);
    }

    private int query(int num, TrieNode root, int high, int index) {
        TrieNode current = root;
        if (index == -1) {
            return getCount(current);
        }
        if (root == null) {
            return 0;
        }

        int mask = (1 << index);
        int bitValue = (mask & num) > 0 ? 1 : 0;
        int bitHigh = (mask & high) > 0 ? 1 : 0;

        if (bitValue == 0) {
            if (bitHigh == 0) {
                return query(num, current.left, high, index - 1);
            } else {
                return (getCount(current.left) + query(num, current.right, high, index - 1));
            }
        } else {
            if (bitHigh == 0) {
                return query(num, current.right, high, index - 1);
            } else {
                return (getCount(current.right) + query(num, current.left, high, index - 1));
            }
        }

    }

    private void insertIntoTrie(int num, TrieNode root) {
        TrieNode current = root;
        int bitCount = 14;
        while (bitCount >= 0) {
            int mask = (1 << bitCount);
            int bitValue = (num & mask) > 0 ? 1 : 0;

            if (bitValue == 0) {
                if (current.left == null) {
                    current.left = new TrieNode();
                }
                current = current.left;
            }
            if (bitValue == 1) {
                if (current.right == null) {
                    current.right = new TrieNode();
                }
                current = current.right;
            }
            current.count++;
            bitCount--;
        }

    }

    // public int countPairs(int[] nums, int low, int high) {

    //   int count = 0;
    //   for (int i = 0; i < nums.length; i++) {
    //     for (int j = i + 1; j < nums.length; j++) {

    //       int xorValue = nums[i] ^ nums[j];
    //       if (low <= xorValue && xorValue <= high) {
    //         count++;
    //       }

    //     }
    //   }
    //   return count;
    // }
}