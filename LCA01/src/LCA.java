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
        // Creating a binary tree
           /* Node rootNode = createBinaryTree();
            System.out.println("Lowest common ancestor for node 5 and 30:");
            Node node5 = new Node(5);
            Node node30 = new Node(30);
            System.out.println(lowestCommonAncestor(rootNode, node5, node30).data);*/

    }

    public static Node createBinaryTree() {

        Node rootNode = new Node(40);
        Node node20 = new Node(20);
        Node node10 = new Node(10);
        Node node30 = new Node(30);
        Node node60 = new Node(60);
        Node node50 = new Node(50);
        Node node70 = new Node(70);
        Node node5 = new Node(5);
        Node node45 = new Node(45);
        Node node55 = new Node(55);

        rootNode.left = node20;
        rootNode.right = node60;

        node20.left = node10;
        node20.right = node30;

        node60.left = node50;
        node60.right = node70;

        node10.left = node5;
        node50.right = node55;
        return rootNode;
    }

}
