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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> checkPath = new ArrayList<>();

        hasPathSum(root, targetSum, checkPath, ans);

        return ans;

    }

    public void hasPathSum(TreeNode root, int targetSum, List<Integer> checkPath, List<List<Integer>> ans) {

        if (root == null) {
            return;
        }

        checkPath.add(root.val);

        if (root.left == null && root.right == null && targetSum-root.val == 0) {
            ans.add(new ArrayList<>(checkPath));
        }

        hasPathSum(root.left, targetSum-root.val, checkPath, ans);
        hasPathSum(root.right, targetSum-root.val, checkPath, ans);

        checkPath.remove(checkPath.size() - 1);

    }

}