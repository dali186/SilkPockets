package DataStucture.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> implements MyTree<T>{

    private Node root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public T min(){
        //가장 오른쪽에 위치
        return this.minNode(this.root);
    }

    private T minNode(Node node) {
        T minData = node.data;

        while (node.left != null) {
            minData = node.left.data;
            node = node.left;
        }

        return minData;
    }

    private T maxNode(Node node) {
        T maxData = node.data;

        while (node.right != null) {
            maxData = node.right.data;
            node = node.right;
        }

        return maxData;
    }

    public T max() {
        //가장 왼쪽에 위치
        return this.maxNode(this.root);
    }

    @Override
    public void insert(T val) {
        this.root = this.insertNode(this.root, val);
        this.size++;
    }

    private Node insertNode(Node node, T val) {
        if (node == null) return new Node(val);
        if (val.compareTo(node.data) < 0) {
            node.left = insertNode(node.left, val);
        } else if (val.compareTo(node.data) > 0) {
            node.right = insertNode(node.right, val);
        }

        return node;
    }

    @Override
    public void delete(T val) {
        this.deleteNode(this.root, val);
    }

    private Node deleteNode(Node node, T val) {
        if (node == null) return null;
        if (val.compareTo(node.data) < 0) {
            node.left = deleteNode(node.left, val);
        } else if (val.compareTo(node.data) > 0) {
            node.right = deleteNode(node.right, val);
        } else {
            // val == node.data
            this.size--;
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            node.data = this.minNode(node.right);
            node.right = deleteNode(node.right, node.data);
        }
        return node;
    }

    @Override
    public boolean contains(T val) {
        return this.containsNode(this.root, val);
    }

    private boolean containsNode(Node node, T val) {
        if (node == null) return false;

        if (val.compareTo(node.data) == 0) {
            return true;
        }

        if (val.compareTo(node.data) < 0) {
            return containsNode(node.left, val);
        }

        //if (val.compareTo(node.data) > 0)
        return containsNode(node.right, val);
    }

    @Override
    public int size() {
        return this.size;
    }

    public List<T> preOrder() {
        return this.preOrderTree(root, new ArrayList<>());
    }

    private List<T> preOrderTree(Node node, List<T> visited) {
        if (node == null) return visited;

        visited.add(node.data);
        preOrderTree(node.left, visited);
        preOrderTree(node.right, visited);

        return visited;
    }

    public List<T> inOrder() {
        return this.inOrderTree(root, new ArrayList<>());
    }

    private List<T> inOrderTree(Node node, List<T> visited) {
         if (node == null) return visited;

         inOrderTree(node.left, visited);
         visited.add(node.data);
         inOrderTree(node.right, visited);

         return visited;
    }

    public List<T> postOrder() {
        return this.postOrderTree(root, new ArrayList<>());
    }

    private List<T> postOrderTree(Node node, List<T> visited) {
        if (node == null) return visited;

        postOrderTree(node.left, visited);
        postOrderTree(node.right, visited);
        visited.add(node.data);

        return visited;
    }

    private class Node {
        T data;
        Node left;
        Node right;

        public Node(T data) {
            this.data = data;
        }
    }
}
