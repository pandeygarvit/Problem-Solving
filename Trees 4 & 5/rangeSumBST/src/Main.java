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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if (root == null) {
            return 0;
        }

        if (root.val >= low && root.val <= high) {
            sum += root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if (low > root.val) {
            sum += rangeSumBST(root.right, low, high);
        } else if (high < root.val) {
            sum += rangeSumBST(root.left, low, high);
        }

        return sum;
    }

}