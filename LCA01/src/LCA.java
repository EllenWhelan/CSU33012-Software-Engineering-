import java.util.ArrayList;
import java.util.List;
public class LCA {
    // A Binary Tree node
    public static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

        public static Node lowestCommonAncestor(Node root, Node a, Node b) {
            if (root == null)
                return null;
            if (root.data == a.data || root.data == b.data)
                return root;

            Node left = lowestCommonAncestor(root.left, a, b);
            Node right = lowestCommonAncestor(root.right, a, b);

            // If we get left and right not null , it is lca for a and b
            if (left != null && right != null)
                return root;
            if (left == null)
                return right;
            else
                return left;
        }

    public static void main(String[] args) {


    }



}
