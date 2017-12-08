package com.github.xenteros.java6wro.wydawaniereszty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Application {

    public static void main(String[] args) {
//        System.out.println(ExchangeService.getExchange(99));

        List<Integer> listOne = IntStream.range(1, 100000).boxed().collect(toList());
        List<Integer> listTwo = IntStream.range(50000, 150000).boxed().collect(toList());

        long start = System.currentTimeMillis();
        List<Integer> dupes = new ArrayList<>();
        for (Integer first : listOne) {     //100000
            if (listTwo.contains(first)) {  //100000
                dupes.add(first);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Calculation took " + (end - start) + " without HashSet");

        dupes = new ArrayList<>();
        Set<Integer> set = new HashSet<>(listTwo);
        start = System.currentTimeMillis();
        for (Integer first : listOne) {     //100000
            if (set.contains(first)) {      //1
                dupes.add(first);
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Calculation took " + (end - start) + " with HashSet");

    }

}
