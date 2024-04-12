import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private void inorder(Node root, List<Integer> inord) {
        if (root == null)
            return;

        inorder(root.left, inord);
        inord.add(root.data);
        inorder(root.right, inord);
    }

    public List<Integer> merge(Node root1, Node root2) {
        List<Integer> inorder1 = new ArrayList<>();
        List<Integer> inorder2 = new ArrayList<>();
        List<Integer> mergedList = new ArrayList<>();

        inorder(root1, inorder1);
        inorder(root2, inorder2);

        int i = 0, j = 0;
        while (i < inorder1.size() && j < inorder2.size()) {
            if (inorder1.get(i) < inorder2.get(j)) {
                mergedList.add(inorder1.get(i++));
            } else {
                mergedList.add(inorder2.get(j++));
            }
        }

        while (i < inorder1.size()) {
            mergedList.add(inorder1.get(i++));
        }
        while (j < inorder2.size()) {
            mergedList.add(inorder2.get(j++));
        }

        return mergedList;
    }
}
