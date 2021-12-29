package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.lang.Math;

public class BinTree {

    Node root;
    int tilt;

    BinTree(int data){
        root = new Node(data);
    }

    BinTree(){
        root = null;
    }

    public BinTree createBinTree(){
        BinTree bt = new BinTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        return bt;
    }

    private Node addRecursive(Node current, int data){
        if (current == null){
            return new Node(data);
        }

        if (data < current.data){
            current.left = addRecursive(current.left, data);
        }
        else if (data > current.data){
            current.right = addRecursive(current.right, data);
        }
        else {
            return current;
        }
        return current;
    }

    public void add(int data){
        root = addRecursive(root, data);
    }

    private boolean containsNodeRecursive(Node current, int data){
        if (current == null){
            return false;
        }

        if (data == current.data){
            return true;
        }
        return data < current.data ? containsNodeRecursive(current.left, data)
                : containsNodeRecursive(current.right, data);
    }
    public boolean contains(int data){
        return containsNodeRecursive(root, data);
    }

    private Node deleteRecursive(Node current, int value){
        if (current == null){
            //node not found
            return null;
        }

        if (value == current.data){
            //node found
            //node has no children - replace node with null as a parent
            if (current.left == null && current.right == null){
                return null;
            }

            //node has exactly one child - replace this node with its only child
            if (current.right == null){
                return current.left;
            }

            if (current.left == null){
                return current.right;
            }
            //node has two children - tree reorganization
            int smallestValue = findSmallest(current.right);
            current.data = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }


        if(value < current.data){
            //tree is sorted left to right increasing
            //go left
            deleteRecursive(current.left, value);
        }
        //go right in all other cases
        deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallest(Node root){return root.left == null ? root.data : findSmallest(root.left);}

    public void delete(int value){root = deleteRecursive(root, value);}

    //Depth First Searches:
    //In-order - left sub-tree, root node, right sub-tree
    //Pre-order - root node, left sub-tree, right sub-tree
    //Post-Order - left sub-tree, right sub-tree, root node

    public void traverseInOrder(Node node){
        if (node != null){
            traverseInOrder(node.left);
            System.out.println(node.data);
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(Node node){
        if (node != null){
            System.out.println(node.data);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(Node node){
        if (node != null){
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.println(node.data);
        }
    }

    //Breadth First Search - visits all nodes on that level before moving on
    public void traverseLevelOrder(){
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while(!nodes.isEmpty()){
            Node node = nodes.remove();

            System.out.println(" " + node.data);

            if (node.left != null){
                nodes.add(node.left);
            }

            if (node.right != null){
                nodes.add(node.right);
            }
        }
    }

    public int tilt(){
        tiltRecursive(root);
        System.out.println("tilt is: " + this.tilt);
        return this.tilt;
    }

    private int tiltRecursive(Node node){
        if (node == null){
            System.out.println("returning zero");
            return 0;
        }

        System.out.println("Node number: " + node.data);

        int tiltLeft = tiltRecursive(node.left);
        System.out.println("left tilt of Node " + node.data + ": " + tiltLeft);

        int tiltRight = tiltRecursive(node.right);
        System.out.println("Right tilt of Node " + node.data + ": " + tiltRight);

        this.tilt += Math.abs(tiltLeft - tiltRight);
        System.out.println("Total tilt: " + this.tilt);

        return tiltLeft + tiltRight + node.data;

    }

    public static void main(String[] args){

    }



}
