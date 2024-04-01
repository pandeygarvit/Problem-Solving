import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        TreeNode node = root;

        while (!queue.isEmpty()) {
            node = queue.remove();

            if (node.right != null) queue.add(node.right);
            if (node.left != null) queue.add(node.left);
        }
        return node.val;
    }
}