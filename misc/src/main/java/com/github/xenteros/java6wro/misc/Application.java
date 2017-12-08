package com.github.xenteros.java6wro.misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Application {

    public static void main(String[] args) {

        String a = "ABC";
        String b = "ABC";
        String c = new String("ABC");
        String d = new String("ABC").intern();
        String e = "A"+ "B" + "C";

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == e);


        Integer one = 130;
        Integer onebis = 130;
        System.out.println(one == onebis);

//        Dog dog = null;
//        dog = new Dog("Burek");
//        burkify(dog);
//        System.out.println(dog.getName());
    }

    public static void burkify(Dog dog) {
        dog.setName("Burk");
    }

    public static void fifify(Dog d) {
        d = new Dog("FIFI");
    }

    public static Map<String, WordCountHelper> read() {
        java.io.BufferedReader br;
        Map<String, WordCountHelper> mapCountOfWords = new HashMap<>();
        Map<WordCountHelper, List<String[]>> example = new HashMap<>();
        int count = 0;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Ola\\Downloads\\pan-tadeusz.txt"));

            String nextLine = br.readLine();
            String[] words = nextLine.split("[^\\p{L}]+");
            for (String word : words) {
                if (word.length() > 0) {
                    if (mapCountOfWords.containsKey(word.toLowerCase())) {
                        WordCountHelper wordCountHelper = mapCountOfWords.get(word.toLowerCase());
                        wordCountHelper.increment();
                        example.get(wordCountHelper).add(words);
                    } else {
                        WordCountHelper wordCountHelper = new WordCountHelper(word.toLowerCase());
                        mapCountOfWords.put(word.toLowerCase(), wordCountHelper);
                        List<String[]> list = new ArrayList<>();
                        list.add(words);
                        example.put(wordCountHelper, list);
                    }
                }
            }
            while (nextLine != null) {
                nextLine = br.readLine();
                if (nextLine != null) {
                    words = nextLine.split("[^\\p{L}]+");
                    for (String word : words) {
                        if (word.length() > 0) {
                            if (mapCountOfWords.containsKey(word.toLowerCase())) {
                                WordCountHelper wordCountHelper = mapCountOfWords.get(word.toLowerCase());
                                example.get(wordCountHelper).add(words);
                                wordCountHelper.increment();
                            } else {
                                WordCountHelper wordCountHelper = new WordCountHelper(word.toLowerCase());
                                mapCountOfWords.put(word.toLowerCase(), wordCountHelper);
                                List<String[]> list = new ArrayList<>();
                                list.add(words);
                                example.put(wordCountHelper, list);
                            }
                        }
                    }
                }
            }
            if (br != null)
                br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        "zmacał"
        example.entrySet().stream()
                .filter(e -> e.getKey().getCount() == 2)
                .sorted(Comparator.comparing(e -> e.getKey().getWord()))
                .forEach(System.out::println);
        return mapCountOfWords;
    }
}
