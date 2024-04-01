/*************************************************************

 Following is thr TreeNode class structure

 class BinaryTreeNode<T>
 {
 T data;
 BinaryTreeNode<T> left;
 BinaryTreeNode<T> right;

 BinaryTreeNode(T data) {
 this.data = data;
 left = null;
 right = null;
 }
 };

 *************************************************************/
public class Solution {

    static int count = 0;
    public static void printLeftView(TreeNode<Integer> root) {

        printLeftView(root, 0);
    }

    public static void printLeftView(TreeNode<Integer> root, int level) {
        if (root == null) {
            return;
        }

        if (count == level) {
            System.out.print(root.data + " ");
            count++;
        }

        printLeftView(root.left, level + 1);
        printLeftView(root.right, level + 1);
    }
}