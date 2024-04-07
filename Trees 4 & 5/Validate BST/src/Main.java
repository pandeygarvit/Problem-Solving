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
    public boolean isValidBST(TreeNode root) {

        return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    public boolean solve(TreeNode root, Long leftBound, Long rightBound) {

        if (root == null) {
            return true;
        }

        boolean validNode = root.val > leftBound && root.val < rightBound;

        return validNode && solve(root.left, leftBound, (long) root.val) && solve(root.right, (long) root.val, rightBound);
    }
}