
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


    @Test
    void traverseInOrder() {
        BinTree bt = new BinTree();
        System.out.println("Testing In-Order");
        bt = bt.createBinTree();
        bt.traverseInOrder(bt.root);
    }

    @Test
    void traversePreOrder() {
        BinTree bt = new BinTree();
        System.out.println("Testing Pre-Order");
        bt = bt.createBinTree();
        bt.traversePreOrder(bt.root);
    }

    @Test
    void traversePostOrder() {
        BinTree bt = new BinTree();
        System.out.println("Testing Post-Order");
        bt = bt.createBinTree();
        bt.traversePostOrder(bt.root);
    }

    @Test
    void traverseLevelOrder() {
        BinTree bt = new BinTree();
        System.out.println("Testing Level-Order");
        bt = bt.createBinTree();
        bt.traverseLevelOrder();
    }

    @Test
    void tilt() {
        BinTree bt = new BinTree();
        System.out.println("Testing tilt");

        bt.root = new Node(4);
        bt.root.left = new Node(2);
        bt.root.left.left = new Node(3);
        bt.root.left.right = new Node(5);
        bt.root.right = new Node(9);
        bt.root.right.right = new Node(7);

        assertTrue(bt.tilt() == 15);

    }
}