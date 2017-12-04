package com.github.xenteros.java6wro.customlist.tree;

class Node<T extends Comparable> {

    private T value;
    private Node<T> left;
    private Node<T> right;

    public Node(T value) {
        this.value = value;
    }

    public void insert(T newEntry) {
        int i = newEntry.compareTo(value);
        if (i == 0) {
            throw new RuntimeException();
        }
        if (i < 0) {
            if (left == null) {
                left = new Node<T>(newEntry);
                return;
            }
            left.insert(newEntry);
            return;
        }
        if (right == null) {
            right = new Node<T>(newEntry);
            return;
        }
        right.insert(newEntry);
    }
    public void print() {
        if (left != null) {
            left.print();
        }
        System.out.println(value);
        if (right != null) {
            right.print();
        }
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}
