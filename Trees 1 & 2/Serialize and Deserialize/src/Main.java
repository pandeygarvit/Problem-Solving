import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        preOrderHelper(root, ans);
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String vals[] = data.split(",");
        Queue<String> q = new ArrayDeque<>(Arrays.asList(vals));
        return preOrder(q);
    }

    public void preOrderHelper(TreeNode root, StringBuilder ans) {
        if (root == null) {
            ans.append("#,");
            return;
        }

        ans.append(root.val + ",");
        preOrderHelper(root.left, ans);
        preOrderHelper(root.right, ans);

    }

    public TreeNode preOrder(Queue<String> q) {
        String s = q.remove();
        if (s.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = preOrder(q);
        root.right = preOrder(q);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
