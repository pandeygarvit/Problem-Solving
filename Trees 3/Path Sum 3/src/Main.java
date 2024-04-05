import javax.swing.tree.TreeNode;
import java.util.HashMap;

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

    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return 0;
        }

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        pathSum(root, 0L, (long) targetSum, map);
        return count;
    }

    public void pathSum(TreeNode root, long sum, long target, HashMap<Long, Integer> map) {

        if (root == null) {
            return;
        }

        sum += (long) root.val;
        if (map.containsKey(sum - target)) {
            count += map.get(sum - target);
        }

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        pathSum(root.left, sum, target, map);
        pathSum(root.right, sum, target, map);

        map.put(sum, map.get(sum) - 1);
    }

}