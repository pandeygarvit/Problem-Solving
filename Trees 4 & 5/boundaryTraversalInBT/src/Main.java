/************************************************************

 Following is the Binary Tree node structure:

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

 ************************************************************/

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Solution {
    public static List<Integer> traverseBoundary(TreeNode root){

        List<Integer> ans = new ArrayList<>();

        List<Integer> leftBoundary = new ArrayList<>();
        List<Integer> bottomBoundary = new ArrayList<>();
        List<Integer> rightBoundary = new ArrayList<>();

        // leftSideBoundary(root, leftBoundary);

        if (root.left != null) {
            leftSideBoundary(root, leftBoundary);
        } else {
            leftBoundary.add(root.data);
        }

        bottomSideBoundary(root, bottomBoundary);
        rightSideBoundary(root.right, rightBoundary);
        Collections.reverse(rightBoundary);

        ans.addAll(leftBoundary);
        ans.addAll(bottomBoundary);
        ans.addAll(rightBoundary);

        return ans;
    }

    public static void leftSideBoundary(TreeNode root, List<Integer> leftBoundary) {
        if (root == null) {
            return;
        }


        if (root.left != null || root.right != null) {
            leftBoundary.add(root.data);

            if (root.left != null) {
                leftSideBoundary(root.left, leftBoundary);
            } else {
                leftSideBoundary(root.right, leftBoundary);
            }
        }

    }

    public static void bottomSideBoundary(TreeNode root, List<Integer> bottomBoundary) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            bottomBoundary.add(root.data);
        }

        bottomSideBoundary(root.left, bottomBoundary);
        bottomSideBoundary(root.right, bottomBoundary);
    }

    public static void rightSideBoundary(TreeNode root, List<Integer> rightBoundary) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        if (root.right != null || root.left != null) {
            rightBoundary.add(root.data);

            if (root.right != null) {
                rightSideBoundary(root.right, rightBoundary);
            } else {
                rightSideBoundary(root.left, rightBoundary);
            }
        }

    }
}