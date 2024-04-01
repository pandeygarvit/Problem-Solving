import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();

        if (root == null) {
            return ans;
        }

        rightSideView(root, 0, ans);
        return ans;
    }

    public void rightSideView(TreeNode root, int level, List<Integer> ans) {

        if (root == null) {
            return;
        }

        if (level == ans.size()) {
            ans.add(root.val);
        }

        rightSideView(root.right, level + 1, ans);
        rightSideView(root.left, level + 1, ans);

    }
}