package com.github.xenteros.java6wro.customlist;

public class Application {

    public static void main(String[] args) {
        MyCustomList list = new MyCustomList("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
//        list.print();
        System.out.println(list.get(3));
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}
