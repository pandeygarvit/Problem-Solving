import java.util.* ;
import java.io.*;
/************************************************************

 Following is the TreeNode class structure

 class TreeNode<T>
 {
 public:
 T data;
 TreeNode<T> left;
 TreeNode<T> right;

 TreeNode(T data)
 {
 this.data = data;
 left = null;
 right = null;
 }
 };

 ************************************************************/
import java.util.*;
public class Solution {

    public  static int findCeil(TreeNode<Integer> node, int x) {
        if (node == null) {
            return -1;
        }
        if (node.data == x) {
            return node.data;
        } else if (node.data < x) {
            return findCeil(node.right, x);
        } else {
            int ceil = findCeil(node.left, x);
            return (ceil == -1 ? node.data : ceil);
        }
    }

}
