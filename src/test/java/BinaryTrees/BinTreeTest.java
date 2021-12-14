
package BinaryTrees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BinTreeTest {


    @Test
    void add() {
    }

    @Test
    void contains() {
        BinTree bt = new BinTree();
        bt = bt.createBinTree();
        assertTrue(bt.contains(6));
        assertTrue(bt.contains(7));

        assertFalse(bt.contains(1));
        System.out.println("End of contains");
    }

    @Test
    void simpleTest(){
        System.out.println("This should work?");
    }

    @Test
    void delete(){
        BinTree bt = new BinTree();
        System.out.println("Testing delete");
        bt = bt.createBinTree();
        assertTrue(bt.contains(6));
        bt.delete(6);
        assertFalse(bt.contains(6));
    }
}