package com.binarytree;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public Node find(int data) {
        return this.root.find(data);
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void insert(int data) {
        if (this.root == null) {
            this.root = new Node(data);
            return;
        }

        this.root.insert(data);
    }

    public Node remove(int data) {
        if (this.root == null) { return null; }
        return this.root.remove(data);
    }

    public void show() {
        showHelper(this.root, 0);
    }

    static private void showHelper(Node node, int space) {
        if (node == null) {
            return;
        }

        space += 10;

        showHelper(node.getRightNode(), space);

        for (int i = 10; i < space; i++) {
            System.out.print(" ");
        }

        System.out.println(node.getData());

        showHelper(node.getLeftNode(), space);
    }
}
