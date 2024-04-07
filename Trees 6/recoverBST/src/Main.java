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
    public void recoverTree(TreeNode root) {
        TreeNode current = root;
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;

        while (current != null) {

            if (current.left == null) {
                if (prev != null && prev.val > current.val) { // prev represents the last node stored as inorder, if the last node of the inorder is bigger than current node then it is a violation
                    if (first == null) {
                        first = prev;
                        second = current;
                    } else {
                        second = current;
                    }
                }
                prev = current;
                current = current.right;
            } else {
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                }
                else { //predecessor.right == current
                    if (prev != null && prev.val > current.val) {
                        if (first == null) {
                            first = prev;
                            second = current;
                        } else {
                            second = current;
                        }
                    }
                    prev = current;
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }

        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}