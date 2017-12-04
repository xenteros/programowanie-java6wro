package com.github.xenteros.java6wro.customlist.tree;

public class CustomTree<T extends Comparable> {

    private Node<T> root;


    public void add(T t){
        if(root==null){
            root= new Node<T>(t);
        }
        else{
            root.insert(t);
        }
    }

    public void print() {
        if (root != null) {
            root.print();
        }
    }

    public CustomTree() {
    }

    public Node<T> getRoot() {
        return root;
    }

}
