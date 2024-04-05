import javax.swing.tree.TreeNode;

/************************************************************

 Following is the TreeNode class structure

 class TreeNode {
 int data;
 TreeNode left;
 TreeNode right;

 TreeNode(int data) {
 this.data = data;
 this.left = null;
 this.right = null;
 }
 }

 ************************************************************/

public class Solution {
    public static int heightOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return (1 + Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right)));
    }
}