/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
 int data;
 TreeNode left;
 TreeNode right;
 TreeNode() {
 this.data = 0;
 this.left = null;
 this.right = null;
 }
 TreeNode(int data) {
 this.data = data;
 this.left = null;
 this.right = null;
 }
 TreeNode(int data, TreeNode left, TreeNode right) {
 this.data = data;
 this.left = left;
 this.right = right;
 }
 };
 ********************************************************/

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {

        List<Integer> inOrder = new ArrayList<Integer>();
        List<Integer> preOrder = new ArrayList<Integer>();
        List<Integer> postOrder = new ArrayList<Integer>();

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        while (!st.isEmpty()) {

            Pair process = st.pop();

            if (process.getValue() == 1) {
                preOrder.add(process.getKey().data);
                process.setValue(process.getValue() + 1);
                st.push(process);
                if (process.getKey().left != null) {
                    st.push(new Pair(process.getKey().left, 1));
                }
            } else if (process.getValue() == 2) {
                inOrder.add(process.getKey().data);
                process.setValue(process.getValue() + 1);
                st.push(process);
                if (process.getKey().right != null) {
                    st.push(new Pair(process.getKey().right, 1));
                }
            } else {
                postOrder.add(process.getKey().data);
            }

        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(inOrder);
        ans.add(preOrder);
        ans.add(postOrder);
        return ans;

        // All recursion
        // List<Integer> inOrder = new ArrayList<Integer>();
        // List<Integer> preOrder = new ArrayList<Integer>();
        // List<Integer> postOrder = new ArrayList<Integer>();

        // inOrderTraversal(root, inOrder);
        // preOrderTraversal(root, preOrder);
        // postOrderTraversal(root, postOrder);

        // List<List<Integer>> ans = new ArrayList<>();
        // ans.add(inOrder);
        // ans.add(preOrder);
        // ans.add(postOrder);
        // return ans;
    }

    public static void inOrderTraversal(TreeNode node, List<Integer> inOrder) {

        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, inOrder);
        inOrder.add(node.data);
        inOrderTraversal(node.right, inOrder);
    }

    public static void preOrderTraversal(TreeNode node, List<Integer> preOrder) {

        if (node == null) {
            return;
        }

        preOrder.add(node.data);
        preOrderTraversal(node.left, preOrder);
        preOrderTraversal(node.right, preOrder);
    }

    public static void postOrderTraversal(TreeNode node, List<Integer> postOrder) {

        if (node == null) {
            return;
        }

        postOrderTraversal(node.left, postOrder);
        postOrderTraversal(node.right, postOrder);
        postOrder.add(node.data);
    }


}

class Pair {
    TreeNode key;
    int value; // 1: pre-order, 2: in-order, 3: post-order

    Pair(TreeNode key, int value) {
        this.key = key;
        this.value = value;
    }

    // Getter for the key
    public TreeNode getKey() {
        return this.key;
    }

    // Getter for the value
    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}