import javax.swing.tree.TreeNode;
import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        preorder(A, B, ans);
        return ans;
    }

    public boolean preorder(TreeNode root, int target, ArrayList<Integer> list) {
        if (root == null)
            return false;

        if (root.val == target || preorder(root.left, target, list) || preorder(root.right, target, list)) {
            list.add(root.val);
            return true;
        }

        return false;
    }
}
