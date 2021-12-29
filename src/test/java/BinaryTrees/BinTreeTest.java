
package BinaryTrees;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;


class BinTreeTest {

    int[] testDataSet1 = {6,4,8,3,5,7,9};
    int[] inOrderTest = {3,4,5,6,7,8,9};
    int[] preOrderTest = {6,4,3,5,8,7,9};
    int[] postOrderTest = {3,5,4,7,9,8,6};

    @Test
    void add() {
    }

    @Test
    void contains() {
        System.out.println("Testing contains");
        BinTree bt = new BinTree();
        bt = bt.createBinTree(testDataSet1);
        assertTrue(bt.contains(6));
        assertTrue(bt.contains(7));

        assertFalse(bt.contains(1));

    }

    @Test
    void simpleTest(){
        System.out.println("This should work?");
    }

    @Test
    void delete(){
        BinTree bt = new BinTree();
        System.out.println("Testing delete");
        bt = bt.createBinTree(testDataSet1);
        assertTrue(bt.contains(6));
        bt.delete(6);
        assertFalse(bt.contains(6));
    }


    @Test
    void traverseInOrder() {
        BinTree bt = new BinTree();
        Queue<Integer> t = new LinkedList<>();
        Queue<Integer> expected = new LinkedList<>();
        for (int data : inOrderTest) {expected.add(data);}
        System.out.println("Testing In-Order");
        bt = bt.createBinTree(testDataSet1);
        bt.traverseInOrder(bt.root, t);
        assertEquals(expected.size(), t.size());
        while (!expected.isEmpty()) {
            assertSame(expected.remove(), t.remove());}
    }

    @Test
    void traversePreOrder() {
        BinTree bt = new BinTree();
        Queue<Integer> t = new LinkedList<>();
        Queue<Integer> expected = new LinkedList<>();
        for (int data : preOrderTest) {expected.add(data);}
        System.out.println("Testing Pre-Order");
        bt = bt.createBinTree(testDataSet1);
        bt.traversePreOrder(bt.root, t);
        assertEquals(expected.size(), t.size());
        while (!expected.isEmpty()) {
            assertSame(expected.remove(), t.remove());}
    }

    @Test
    void traversePostOrder() {
        BinTree bt = new BinTree();
        Queue<Integer> t = new LinkedList<>();
        Queue<Integer> expected = new LinkedList<>();
        for (int data : postOrderTest) {expected.add(data);}
        System.out.println("Testing Post-Order");
        bt = bt.createBinTree(testDataSet1);
        bt.traversePostOrder(bt.root, t);
        assertEquals(expected.size(), t.size());
        while (!expected.isEmpty()) {
            assertSame(expected.remove(), t.remove());}
    }

    @Test
    void traverseLevelOrder() {
        BinTree bt = new BinTree();
        System.out.println("Testing Level-Order");
        bt = bt.createBinTree(testDataSet1);
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

        assertEquals(15, bt.tilt());

    }
}