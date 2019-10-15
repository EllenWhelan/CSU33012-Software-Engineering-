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
//hello test
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

   /* public static void main(String[] args) {


    }*/

   //DAG classs stuff
    public static class DAGNode {
        int data;
        ArrayList<DAGNode> parents, children;

        DAGNode(int value) {
            data = value;
            parents = children = new ArrayList<DAGNode>();
        }

        public DAGNode setChildren(ArrayList<DAGNode> list){
            this.children=list;
            return null;
        }
       public DAGNode setParents(ArrayList<DAGNode> list){
           this.parents=list;
           return null;
       }

    }

    public  static DAGNode dagFindLCA(DAGNode root, DAGNode a, DAGNode b){
        if (root==null) return null;
        if (root == a ||root == b) return root;
        if(a.data==b.data)        return a;

        ArrayList <DAGNode> lca = new ArrayList<DAGNode>();
        if(a.parents.size()==0||b.parents.size()==0) return null;
        for(int i=0; i<a.parents.size();i++){
            for(int j=0;j<b.parents.size();j++){
                if(a.parents.get(i).data==b.parents.get(j).data){
                    lca.add(a.parents.get(i));
                }
            }

        }

        if(lca.size()==0){
            System.out.println("hello bitch");
            if (a.data>b.data) lca.add(dagFindLCA(root,a.parents.get(0), b));
            else lca.add(dagFindLCA(root,a,b.parents.get(0)));
        }


            DAGNode maxTemp = lca.get(0);

            for (int i = 0; i < lca.size(); i++) {
                if (lca.get(i).data > maxTemp.data) maxTemp = lca.get(i);
            }
            return maxTemp;



    }




}
