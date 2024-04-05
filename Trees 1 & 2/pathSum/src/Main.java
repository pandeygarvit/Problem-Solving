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
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return (root.val - targetSum == 0);
        }

        boolean leftHasPathSum = (root.left != null) ? hasPathSum(root.left, targetSum-root.val) : false;
        boolean rightHasPathSum = (root.right != null) ? hasPathSum(root.right, targetSum-root.val) : false;


        return (leftHasPathSum || rightHasPathSum);

    }
}