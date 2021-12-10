package BinaryTrees;

public class BinTree<T> {

    Node<T> root;

    BinTree(T data){
        root = new Node<T>(data);
    }

    BinTree(){
        root = null;
    }

}
