package com.github.xenteros.java6wro.misc;

import java.util.UUID;

public class WordCountHelper {

    private final String uuid = UUID.randomUUID().toString();
    private final String word;
    private int count = 1;

    public void increment () {
        this.count += 1;
    }

    public WordCountHelper(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "WordCountHelper{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordCountHelper that = (WordCountHelper) o;

        if (count != that.count) return false;
        return word != null ? word.equals(that.word) : that.word == null;
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
}
