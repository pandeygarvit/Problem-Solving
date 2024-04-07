//User function Template for Java


import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Stack;

class Solution
{
    //Function to find the nodes that are common in both BST.
    public static ArrayList<Integer> findCommon(Node root1, Node root2) {

        ArrayList<Integer> ans = new ArrayList<>();

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        while (true) {

            if (root1 != null) {
                st1.push(root1);
                root1 = root1.left;
            } else if (root2 != null) {
                st2.push(root2);
                root2 = root2.left;
            } else if (!st1.isEmpty() && !st2.isEmpty()){
                root1 = st1.peek();
                root2 = st2.peek();

                if (root1.data == root2.data) {

                    ans.add(root1.data);

                    st1.pop();
                    st2.pop();
                    root1 = root1.right;
                    root2 = root2.right;

                } else if (root1.data > root2.data) {
                    st2.pop();
                    root2 = root2.right;
                    root1 = null;
                } else if (root1.data < root2.data) {
                    st1.pop();
                    root1 = root1.right;
                    root2 = null;
                }

            } else {
                break;
            }

        }

        return ans;

    }

}