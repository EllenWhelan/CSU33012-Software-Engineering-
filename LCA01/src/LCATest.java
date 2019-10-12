import org.junit.Test;



import static org.junit.jupiter.api.Assertions.*;
//@RunWith(JUnit5.class)
public class LCATest {

    //Test for if root is null
    @Test
    public void testNullRoot(){
        LCA.Node root = null;
        LCA.Node a= new LCA.Node(3);
        LCA.Node b= new LCA.Node(4);
        assertNull(LCA.lowestCommonAncestor(root,a,b));

    }

    //test if root=a, root=b
    @Test
    public void testRootEqualsAorB(){
        LCA.Node a= new LCA.Node(3);
        LCA.Node b= new LCA.Node(4);
        LCA.Node root =a;
        assertEquals(root.data, LCA.lowestCommonAncestor(root, a, b));

    }

    @Test
    public void testBuildTree(){
        LCA.Node rootNode = createBinaryTree();
        assertEquals(40, rootNode.data);
    }
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

}