

//User function Template for Java

// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }


import org.w3c.dom.Node;

class Solution{

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst (Node root) {


        return largestBstHelper(root).size;


    }

    static Tuple largestBstHelper(Node root) {
        if (root == null) {
            return new Tuple(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Tuple left = largestBstHelper(root.left);
        Tuple right = largestBstHelper(root.right);

        if (left.maxElement < root.data && right.minElement > root.data) {
            // It is a BST
            return new Tuple(left.size + right.size + 1, Math.min(root.data, left.minElement), Math.max(root.data, right.maxElement));
        }

        return new Tuple(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static class Tuple {
        int size;
        int minElement;
        int maxElement;

        Tuple(int size, int minElement, int maxElement) {
            this.size = size;
            this.minElement = minElement;
            this.maxElement = maxElement;
        }
    }

}