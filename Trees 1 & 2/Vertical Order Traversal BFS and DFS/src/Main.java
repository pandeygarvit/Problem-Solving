import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;* Definition for a binary tree node.
*/public class TreeNode {
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
         import java.util.*;
class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, List<Integer>>> mpp = new TreeMap<>();
        verticalOrderTraversal(root, mpp, 0, 0);

        List<List<Integer>> ans = new ArrayList<>();

        for (TreeMap<Integer, List<Integer>> rows : mpp.values()) {
            List<Integer> col = new ArrayList<>();
            for (List<Integer> nodes : rows.values()) {
                Collections.sort(nodes);
                col.addAll(nodes);
            }
            ans.add(col);
        }

        return ans;

    }

    public void verticalOrderTraversal(TreeNode root, TreeMap<Integer, TreeMap<Integer,     List<Integer>>> mpp, int row, int col) {

        if (root == null) {
            return;
        }

        mpp.putIfAbsent(col, new TreeMap<>());
        mpp.get(col).putIfAbsent(row, new ArrayList<>());
        mpp.get(col).get(row).add(root.val);


        verticalOrderTraversal(root.left, mpp, row + 1, col - 1);
        verticalOrderTraversal(root.right, mpp, row + 1, col + 1);

    }

}
// This is BFS
// class Solution {
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         SortedMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
//         List<List<Integer>> ans = new ArrayList<>();

//         verticalOrderTraversal(root, 0, map);

//         for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
//             ans.add(entry.getValue());
//         }

//         return ans;

//     }

//     public static void verticalOrderTraversal(TreeNode root, int x, SortedMap<Integer, ArrayList<Integer>> map) {

//         if (root == null) {
//             return;
//         }

//         map.putIfAbsent(x, new ArrayList<Integer>());
//         map.get(x).add(root.val);



//         verticalOrderTraversal(root.left, x-1, map);
//         verticalOrderTraversal(root.right, x+1, map);

//     }


// }