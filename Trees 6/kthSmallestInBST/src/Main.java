import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {

        TreeNode current = root;
        int count = 1;

        while (current != null) {

            if (current.left == null) {

                if (count == k) {
                    return current.val;
                } else {
                    count++;
                }

                current = current.right;
            } else {

                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    if (count == k) {
                        return current.val;
                    } else {
                        count++;
                    }
                    predecessor.right = null;
                    current = current.right;
                }
            }

        }

        return -1;
    }
}