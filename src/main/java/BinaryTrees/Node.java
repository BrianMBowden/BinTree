package BinaryTrees;
import java.io.*;

public class Node<T> {
    T data;
    Node<T> left;
    Node<T> right;

    Node(){
        this.right = null;
        this.left = null;
        this.data = null;
    }

    public Node(T data) {
        this.data = data;
    }
}
