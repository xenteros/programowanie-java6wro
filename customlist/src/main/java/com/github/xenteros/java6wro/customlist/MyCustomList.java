package com.github.xenteros.java6wro.customlist;

public class MyCustomList<T> {

    private T value;
    private MyCustomList nextElement;

    public void add(T newEntry) {
        if (nextElement == null) {
            nextElement = new MyCustomList(newEntry);
        } else {
            nextElement.add(newEntry);
        }
    }

    public void print() {
        System.out.println(this.value);
        if (nextElement != null) {
            nextElement.print();
        }
    }

    public MyCustomList get(int i) {
        MyCustomList temp = nextElement;
        if (i==0){
            return this;
        }
        for (int j = 0; j < i-1; j++) {
            temp = temp.getNextElement();
        }
        return temp;
    }

    public void delete(int i) {
        MyCustomList iMinusPierwszy = get(i-1);
        MyCustomList iPlusPierwszy = get(i+1);
        iMinusPierwszy.setNextElement(iPlusPierwszy);
    }


    public MyCustomList(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public MyCustomList getNextElement() {
        return nextElement;
    }

    public void setNextElement(MyCustomList nextElement) {
        this.nextElement = nextElement;
    }
}
