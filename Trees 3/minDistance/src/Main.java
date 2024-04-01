class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;

    Node lowestCommonAncestor(Node node, int value1, int value2) {
        if (node == null)
            return null;

        if (node.data == value1 || node.data == value2)
            return node;

        Node leftLCA = lowestCommonAncestor(node.left, value1, value2);
        Node rightLCA = lowestCommonAncestor(node.right, value1, value2);

        if (leftLCA != null && rightLCA != null)
            return node;

        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    int findLevel(Node node, int data, int level) {
        if (node == null)
            return -1;
        if (node.data == data)
            return level;
        int left = findLevel(node.left, data, level + 1);
        if (left == -1)
            return findLevel(node.right, data, level + 1);
        return left;
    }

    int findDistance(Node node, int value1, int value2) {
        Node lca = lowestCommonAncestor(node, value1, value2);

        int distance1 = findLevel(lca, value1, 0);
        int distance2 = findLevel(lca, value2, 0);

        return distance1 + distance2;
    }
}