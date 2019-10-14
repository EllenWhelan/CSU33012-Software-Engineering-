import org.junit.Test;



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
    
}