import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<Integer>();
        }

        Stack <TreeNode> st = new Stack<>();
        st.push(root);

        List<Integer> preOrder = new ArrayList<>();

        TreeNode temp = new TreeNode();


        while (!st.isEmpty()) {

            temp = st.pop();
            preOrder.add(temp.val);

            if (temp.right != null) {
                st.push(temp.right);
            }
            if (temp.left != null) {
                st.push(temp.left);
            }

        }

        return preOrder;

    }
}