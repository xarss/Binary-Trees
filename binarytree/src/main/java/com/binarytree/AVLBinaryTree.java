package com.binarytree;

public class AVLBinaryTree {
    private Node root;

    public AVLBinaryTree() {
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
        this.root = this.root.balance();
    }

    public Node remove(int data) {
        if (this.root == null) { return null; }
        Node removed = this.root.remove(data);
        this.root = this.root.balance();
        return removed;
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
