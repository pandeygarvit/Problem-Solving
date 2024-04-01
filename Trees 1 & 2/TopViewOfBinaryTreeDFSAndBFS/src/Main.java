/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
 int data;
 TreeNode left;
 TreeNode right;

 TreeNode(int data) {
 this.data = data;
 this.left = null;
 this.right = null;
 }
 }

 *********************************************/

import javax.swing.tree.TreeNode;
import java.util.*;

// import javax.swing.tree.TreeNode;
public class Solution {

    public static List<Integer> getTopView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        TreeMap<Integer, Integer> topView = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        Tuple first = new Tuple(root, 0);
        q.add(first);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Tuple temp =  q.remove();
                topView.putIfAbsent(temp.y, temp.root.data);

                if (temp.root.left != null) {
                    q.add(new Tuple(temp.root.left, temp.y-1));
                }
                if (temp.root.right != null) {
                    q.add(new Tuple(temp.root.right, temp.y+1));
                }
            }
        }

        for (int val : topView.values()) {
            ans.add(val);
        }

        return ans;
    }
    static class Tuple {
        TreeNode root;
        int y;

        Tuple (TreeNode root, int y) {
            this.root = root;
            this.y = y;
        }
    }

    // DFS solution
    // public static List<Integer> getTopView(TreeNode root) {


    //     List<List<Integer>> ans = new ArrayList<>();
    //     TreeMap<Integer, TreeMap<Integer, List<Integer>>> columnData = new TreeMap<>();

    //     verticalTraversal(root, 0, 0, columnData);

    //     for (TreeMap<Integer, List<Integer>> rowData : columnData.values()) {
    //       List<Integer> col = new ArrayList<>();
    //       for (List<Integer> nodes : rowData.values()) {
    //         Collections.sort(nodes);
    //         col.addAll(nodes);
    //       }
    //       ans.add(col);
    //     }

    //     List<Integer> res = new ArrayList<Integer>();
    //     for (int i = 0; i < ans.size(); i++) {
    //       res.add(ans.get(i).get(0));
    //     }
    //     return res;
    // }

    // public static void verticalTraversal(TreeNode root, int row, int col, TreeMap<Integer, TreeMap<Integer, List<Integer>>> columnData) {

    //     if (root == null) {
    //         return;
    //     }

    //     columnData.putIfAbsent(col, new TreeMap<>());
    //     columnData.get(col).putIfAbsent(row, new ArrayList<>());
    //     columnData.get(col).get(row).add(root.data);

    //     verticalTraversal(root.left, row + 1, col - 1, columnData);
    //     verticalTraversal(root.right, row + 1, col + 1, columnData);

    // }
}