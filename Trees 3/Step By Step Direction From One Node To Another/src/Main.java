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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LCA = leastCommonAncestor(root, startValue, destValue);
        // String LCAtoStartVal = "", LCAtoDestVal = "";
        StringBuilder startToLCAval = new StringBuilder();
        StringBuilder LCAtoStartVal = new StringBuilder();
        StringBuilder LCAtoDestVal = new StringBuilder();

        nodeToNode(LCA, startValue, LCAtoStartVal);
        nodeToNode(LCA, destValue, LCAtoDestVal);

        for (int i = 0; i < LCAtoStartVal.length(); i++) {
            startToLCAval.append('U');
        }

        return startToLCAval.toString()+LCAtoDestVal.toString();
    }

    public boolean nodeToNode(TreeNode root, int target, StringBuilder path) {
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        }

        path.append('L');
        if (nodeToNode(root.left, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if (nodeToNode(root.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        return false;
    }

    public TreeNode leastCommonAncestor(TreeNode root, int valueOne, int valueTwo) {

        if (root == null) {
            return null;
        }

        if (root.val == valueOne || root.val == valueTwo) {
            return root;
        }

        TreeNode leftVal = leastCommonAncestor(root.left, valueOne, valueTwo);
        TreeNode rightVal = leastCommonAncestor(root.right, valueOne, valueTwo);

        if (rightVal != null && leftVal != null) {
            return root;
        } else if (rightVal == null || leftVal == null) {
            return (rightVal != null ? rightVal : leftVal);
        }

        return null;
    }

}