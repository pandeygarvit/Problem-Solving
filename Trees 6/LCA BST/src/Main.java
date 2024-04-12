import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //   if (root == null) {
    //     return null;
    //   }

    //   TreeNode left = lowestCommonAncestor(root.left, p, q);
    //   TreeNode right = lowestCommonAncestor(root.right, p, q);

    //   if (left == null && right == null && (p.val == root.val || q.val == root.val)) {
    //     return root;
    //   }
    //   if (left == null) {
    //     return (root.val == p.val || root.val == q.val ? root : right);
    //   }
    //   if (right == null) {
    //     return (root.val == p.val || root.val == q.val ? root : left);
    //   }
    //   if ((left.val == p.val && right.val == q.val) || (left.val == q.val && right.val == p.val)) {
    //     return root;
    //   }

    //   return null;
    // }

}