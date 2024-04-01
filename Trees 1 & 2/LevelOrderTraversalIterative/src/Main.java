/*
    Following is the TreeNode class structure:

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        TreeNode(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.data = val;
            this.left = left;
            this.right = right;
        }
    };
*/

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Solution {
    public static List< Integer > getInOrderTraversal(TreeNode root) {

        List<Integer> inOrder = new ArrayList<>();
        if (root == null) {
            return null;
        }

        Stack<TreeNode> st = new Stack<>();

        TreeNode temp = new TreeNode();
        temp = root;

        while (temp != null || !st.isEmpty()) {

            while (temp != null) {
                st.push(temp);
                temp = temp.left;
            }

            temp = st.pop();
            inOrder.add(temp.data);
            temp = temp.right;

        }
        return inOrder;
    }
}