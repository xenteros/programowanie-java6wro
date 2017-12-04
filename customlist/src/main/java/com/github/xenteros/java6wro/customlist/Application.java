package com.github.xenteros.java6wro.customlist;

import com.github.xenteros.java6wro.customlist.tree.CustomTree;

public class Application {

    public static void main(String[] args) {
        CustomTree<Integer> tree = new CustomTree<Integer>();
        tree.add(6);
        tree.add(4);
        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(3);
        tree.add(8);
        tree.add(7);
        tree.print();
    }
}
