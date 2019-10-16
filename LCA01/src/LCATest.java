import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
//@RunWith(JUnit5.class)
public class LCATest {

    //Test null tree
    @Test
    public void testNullRoot(){
        LCA.Node testNode = null;
        LCA.Node a= new LCA.Node(3);
        LCA.Node b= new LCA.Node(4);
        assertNull(LCA.lowestCommonAncestor(testNode,a,b));

    }
    //test null node
    @Test
    public void testNullNode(){
        LCA.Node testNode = null;
        assertNull(testNode);

    }

    //test a balanced binary tree
    @Test
    public void testBalancedTree(){
        /*
                1
            2        3
        4       5 6     7
         */
        LCA.Node root = new LCA.Node(1);
        root.left=new LCA.Node(2);
        root.right = new LCA.Node(3);
        root.left.left = new LCA.Node(4);
        root.left.right = new LCA.Node(5);
        root.right.left = new LCA.Node(6);
        root.right.right = new LCA.Node(7);
        //testing 2 on same leevel with only root as ancestor
        LCA.Node a = new LCA.Node(2);
        LCA.Node b = new LCA.Node(3);
        assertEquals(1, LCA.lowestCommonAncestor(root, a, b).data, "testing balanced tree: a=2 b=3 should be 1");
        //testing 2 on same level with different immediate ancestors
        a = new LCA.Node(4);
        b = new LCA.Node(7);
        assertEquals(1, LCA.lowestCommonAncestor(root, a, b).data, "testing balanced tree: a=4 b=7 should be 1");
        //testing 2 on different levels
        a = new LCA.Node(2);
        b = new LCA.Node(7);
        assertEquals(1, LCA.lowestCommonAncestor(root, a, b).data, "testing balanced tree: a=2 b=7 should be 1");
        //testing 2 where one is ancestor of other
        a = new LCA.Node(3);
        b = new LCA.Node(6);
        assertEquals(3, LCA.lowestCommonAncestor(root, a, b).data, "testing balanced tree: a=3 b=6 should be 3");

    }

    //testing left leaning tree
    @Test
    public void testLeftTree(){
        /*                          10
                                  20
                                30
                              40
                            50
                          60
         */
        LCA.Node root = new LCA.Node(10);
        root.left= new LCA.Node(20);
        root.right= null;
        root.left.left= new LCA.Node(30);
        root.left.left.left=new LCA.Node(40);
        root.left.left.left.left=new LCA.Node(50);
        root.left.left.left.left=new LCA.Node(60);

        //testing two where one is direct ancestor of other
        LCA.Node a  = new LCA.Node(20);
        LCA.Node b = new LCA.Node(30);
        assertEquals(20,LCA.lowestCommonAncestor(root,a,b).data, "Testing left tree with a direct ancestor of b.Should be 20" );

        //testing nodes a few levels apart
        a  = new LCA.Node(20);
        b = new LCA.Node(60);
        assertEquals(20,LCA.lowestCommonAncestor(root,a,b).data, "Testing left tree with nodes few levels apart.Should be 20" );

    }

    //testing right leab tree
    @Test
    public void testRightTree(){
        /*                      20
                                    40
                                        60
                                            80
                                                100
         */
        LCA.Node root = new LCA.Node(20);
        root.right= new LCA.Node(40);
        root.left= null;
        root.right.right= new LCA.Node(60);
        root.right.right.right=new LCA.Node(80);
        root.right.right.right.right=new LCA.Node(100);

        //testing two where one is direct ancestor of other
        LCA.Node a  = new LCA.Node(20);
        LCA.Node b = new LCA.Node(40);
        assertEquals(20,LCA.lowestCommonAncestor(root,a,b).data, "Testing left tree with a direct ancestor of b. Should be 20" );

        //testing nodes a few levels apart
        a  = new LCA.Node(20);
        b = new LCA.Node(80);
        assertEquals(20,LCA.lowestCommonAncestor(root,a,b).data, "Testing left tree with nodes few levels apart. Should be 20" );
    }


    //extra testing for a more complex realistic tree i.e not left/right leaning tree or perfectly balanced tree
    //test building a more realistic tree
    @Test
    public void testBuildTree(){
        LCA.Node rootNode = createBinaryTree();
        assertEquals(40, rootNode.data);
    }

    //test a reasonable tree
    @Test
    public void testBasicCase(){
        LCA.Node rootNode = createBinaryTree();
        System.out.println("Lowest common ancestor for node 5 and 30:");
        LCA.Node node5 = new LCA.Node(5);
        LCA.Node node30 = new LCA.Node(30);
        assertEquals(20, LCA.lowestCommonAncestor(rootNode, node5, node30).data);
    }


    public static LCA.Node createBinaryTree() {

        LCA.Node rootNode = new LCA.Node(40);
        LCA.Node node20 = new LCA.Node(20);
        LCA.Node node10 = new LCA.Node(10);
        LCA.Node node30 = new LCA.Node(30);
        LCA.Node node60 = new LCA.Node(60);
        LCA.Node node50 = new LCA.Node(50);
        LCA.Node node70 = new LCA.Node(70);
        LCA.Node node5 = new LCA.Node(5);
        LCA.Node node45 = new LCA.Node(45);
        LCA.Node node55 = new LCA.Node(55);

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

    //DAG stuff test section
    //1. Testing basic functionality
    //Test null tree
    @Test
    public void testNullRootDAG(){
        LCA.DAGNode testNode = null;
        LCA.DAGNode a= new LCA.DAGNode(3);
        LCA.DAGNode b= new LCA.DAGNode(4);
        assertNull(LCA.dagFindLCA(testNode,a,b));

    }
    //test null node
    @Test
    public void testNullNodeDAG(){
        LCA.DAGNode testNode = null;
        assertNull(testNode);

    }

    //test single node tree
    @Test
    public void testSingleNOdeTree(){
        LCA.DAGNode root = new LCA.DAGNode(1);
        LCA.DAGNode a = new LCA.DAGNode(1);
        LCA.DAGNode b = new LCA.DAGNode(1);
        assertEquals(1,LCA.dagFindLCA(root,a,b).data, "Testing single noe tree");
    }

    @Test
    public void createDAGAndTest() {
        //2. Testing on a realistic DAG
        LCA.DAGNode rootDAG = new LCA.DAGNode(1);
        LCA.DAGNode node2 = new LCA.DAGNode(2);
        LCA.DAGNode node3 = new LCA.DAGNode(3);
        LCA.DAGNode node4 = new LCA.DAGNode(4);
        LCA.DAGNode node5 = new LCA.DAGNode(5);
        LCA.DAGNode node6 = new LCA.DAGNode(6);

        rootDAG.children.add(node2);
        rootDAG.children.add(node3);
        rootDAG.children.add(node4);
        rootDAG.children.add(node5);
        rootDAG.children.add(node6);
        node2.children.add(node4);
        node2.parents.add(rootDAG);
        node3.children.add(node4);
        node3.children.add(node5);
        node3.parents.add(rootDAG);
        node4.children.add(node5);
        node4.parents.add(node2);
        node4.parents.add(node3);
        node4.parents.add(rootDAG);
        node5.parents.add(node3);
        node5.parents.add(node4);
        node5.parents.add(rootDAG);
        node6.parents.add(node4);

        assertEquals(1,LCA.dagFindLCA(rootDAG, rootDAG, node4).data, "Answer shoudl eb 1");
        //testing with null inputs
        assertNull(LCA.dagFindLCA(null,null,null),"Anser is null");
        //test with same a and b
        assertEquals(6, LCA.dagFindLCA(rootDAG, node6, node6).data);

        //if(LCA.dagFindLCA(rootDAG, node4, node6)==null)System.out.println("null bitch");
        assertEquals(4, LCA.dagFindLCA(rootDAG, node4, node6).data);

        //node not in tree
        assertNull(LCA.dagFindLCA(rootDAG, new LCA.DAGNode(9),new LCA.DAGNode(99)));



    }



}