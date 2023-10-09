package com.binarytree;

public class Node {
    private Node leftNode;
    private Node rightNode;
    private int data;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

    public Node getLeftNode() {
        return this.leftNode;
    }

    public Node getRightNode() {
        return this.rightNode;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node insert(int data) {
        if (data > this.data) {
            if (this.rightNode != null) {
                this.rightNode = this.rightNode.insert(data); 
            } else {
                this.setRightNode(new Node(data));
            }
        }
        // Left
        else {
            if (this.leftNode != null) {
                this.leftNode = this.leftNode.insert(data); 
            } else {
                this.setLeftNode(new Node(data));
            }
        }
        return balance();
    }

    public Node min() {
        if (this.getLeftNode() != null) {
            return this.getLeftNode().min();
        }
        return this;
    }

    public Node find(int data) {
        if (this.data == data) {
            return this;
        }
        // Right
        if (data > this.data) {
            if (this.rightNode == null) {
                return null;
            }
            return this.rightNode.find(data);
        } else {
            if (this.leftNode == null) {
                return null;
            }
            return this.leftNode.find(data);
        }
    }

    public Node parent(int data) {
        if (this.find(data) == null) {
            return null;
        }
        if (this.data == data) {
            return null;
        }

        if (this.leftNode != null) {
            if (this.leftNode.getData() == data) {
                return this;
            }
        }

        if (this.rightNode != null) {
            if (this.rightNode.getData() == data) {
                return this;
            }
        }

        // Right
        if (data > this.data) {
            return this.rightNode.parent(data);
        } else {
            return this.leftNode.parent(data);
        }
    }

    public boolean leaf() {
        return (this.getLeftNode() == null && this.getRightNode() == null);
    }

    public Node remove(int data) {
        if (data < this.data) {
            if (leftNode != null) {
                leftNode = leftNode.remove(data);
            }
        } else if (data > this.data) {
            if (rightNode != null) {
                rightNode = rightNode.remove(data);
            }
        } else {
            if ((leftNode == null) || (rightNode == null)) {
                Node temp = null;
                if (temp == leftNode) {
                    temp = rightNode;
                } else {
                    temp = leftNode;
                }
                if (temp == null) {
                    temp = this;
                    return null;
                } else { 
                    return temp;
                }
            } else {
                Node temp = rightNode.min();
                this.data = temp.getData();
                rightNode = rightNode.remove(temp.getData());
            }
        }

        return balance();
    }

    public Node balance() {
        if (this.getLeftNode() != null) {
            this.setLeftNode(this.getLeftNode().balance());
        }
        if (this.getRightNode() != null) {
            this.setRightNode(this.getRightNode().balance());
        }
        int balanceFactor = calculateBalanceFactor();

        if (balanceFactor > 1) {
            if (this.leftNode != null && this.leftNode.calculateBalanceFactor() < 0) {
                this.leftNode = this.leftNode.rotateLeft(); 
            }
            return rotateRight();
        }
        else if (balanceFactor < -1) {
            if (this.rightNode != null && this.rightNode.calculateBalanceFactor() > 0) {
                this.rightNode = this.rightNode.rotateRight(); 
            }
            return rotateLeft();
        }

        return this;
    }

    private int calculateBalanceFactor() {
        int leftHeight  = (leftNode  == null) ? -1 : leftNode.calculateHeight() ;
        int rightHeight = (rightNode == null) ? -1 : rightNode.calculateHeight();
        return leftHeight - rightHeight;
    }

    private int calculateHeight() {
        int leftHeight = (leftNode == null) ? -1 : leftNode.calculateHeight();
        int rightHeight = (rightNode == null) ? -1 : rightNode.calculateHeight();
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private Node rotateLeft() {
        if (this.rightNode == null) {
            return this;
        }
        Node newRoot = this.rightNode;
        rightNode = newRoot.getLeftNode();
        newRoot.leftNode = this;
        return newRoot;
    }

    private Node rotateRight() {
        Node newRoot = this.leftNode;
        leftNode = newRoot.getRightNode();
        newRoot.rightNode = this;
        return newRoot;
    }
}
