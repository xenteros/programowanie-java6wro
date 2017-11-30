package com.github.xenteros.java6wro.customlist;

public class MyCustomStringList {

    private String value;
    private MyCustomStringList nextElement;

    public void add(String newString) {
        if (nextElement == null) {
            nextElement = new MyCustomStringList(newString);
        } else {
            nextElement.add(newString);
        }
    }

    public void print() {
        System.out.println(this.value);
        if (nextElement != null) {
            nextElement.print();
        }
    }

    public MyCustomStringList get(int i) {
        MyCustomStringList temp = nextElement;
        if (i==0){
            return this;
        }
        for (int j = 0; j < i-1; j++) {
            temp = temp.getNextElement();
        }
        return temp;
    }

    public void delete(int i) {
        MyCustomStringList iMinusPierwszy = get(i-1);
        MyCustomStringList iPlusPierwszy = get(i+1);
        iMinusPierwszy.setNextElement(iPlusPierwszy);
    }


    public MyCustomStringList(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public MyCustomStringList getNextElement() {
        return nextElement;
    }

    public void setNextElement(MyCustomStringList nextElement) {
        this.nextElement = nextElement;
    }
}
