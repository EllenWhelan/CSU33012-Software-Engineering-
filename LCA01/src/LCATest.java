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

}