package BinaryTrees;
import java.io.*;

public class Node {
    int data;
    Node left;
    Node right;

    Node(){
        this.right = null;
        this.left = null;
    }

    public Node(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }
}
