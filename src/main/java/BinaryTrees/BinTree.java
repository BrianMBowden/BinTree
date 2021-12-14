package BinaryTrees;

public class BinTree {

    Node root;

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
}
