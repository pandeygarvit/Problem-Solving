/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;

 TreeNode(int val) {
 this.val = val;
 this.left = null;
 this.right = null;
 }
 }

 *********************************************/

import javax.swing.tree.TreeNode;
import java.util.*;

public class Solution {
    public static List<Integer> bottomView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        TreeMap<Integer, Integer> bottomViewMap = new TreeMap<>();

        Tuple first = new Tuple(root, 0);
        Queue<Tuple> q = new LinkedList<>();
        q.add(first);

        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {

                Tuple temp = q.remove();

                bottomViewMap.put(temp.y, temp.root.val);

                if (temp.root.left != null) {
                    q.add(new Tuple(temp.root.left, temp.y - 1));
                }
                if (temp.root.right != null) {
                    q.add(new Tuple(temp.root.right, temp.y + 1));
                }

            }

        }

        for (int val : bottomViewMap.values()) {
            ans.add(val);
        }

        return ans;

    }

    static class Tuple {
        TreeNode root;
        int y;

        Tuple(TreeNode root, int y) {
            this.root = root;
            this.y = y;

        }
    }
}
