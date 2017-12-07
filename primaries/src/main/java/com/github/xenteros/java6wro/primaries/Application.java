package com.github.xenteros.java6wro.primaries;

import java.security.SecureRandom;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {

        //Przykład generowania UUID
        String uuid = UUID.randomUUID().toString();

        List<String> stringList = new ArrayList<>();
        stringList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        stringList.sort((foo, bar) -> {
            if (foo.length() == bar.length()) {
                return foo.compareTo(bar);
            } return foo.length() - bar.length();
        });

        Map<String, List<String>> result = stringList.stream()
                .collect(Collectors.groupingBy(String::toUpperCase,
                        Collectors.mapping(Function.identity(), Collectors.toList())));

        stringList.sort(Comparator.comparingInt(String::length));
        stringList.sort(Comparator.naturalOrder());
        //Przykładowy sposób losowania elementu z seta.
        //      OrElse(null)
        // do przemyślenia - pewnie nienajlepsze, ale
        //      nie tego dotyczy przykład.
        Set<String> set = new HashSet<>();
        String randomSetElement = set.stream()
                .skip((int)(set.size()*Math.random()))
                .findFirst()
                .orElse(null);

        //Schemat generowania 30 użytkowników
        for (int i  = 0; i < 30; i++) {
            String firstName = ""; //wylosuj imię ze zbioru imion
            String lastName = ""; //wylosuj nazwisko ze zbioru nazwisk

//            set.add(new User(firstName, lastName)); //potrzebny odpowiedni konstruktor
        }

        //Przykład generowania intów z przedziału. Można wykorzystać do
        //losowania wieku.
        Random random = new SecureRandom();
        int between20inclAnd30excl = random.nextInt(10) + 20;

        Set<User> users = new HashSet<>();
        IntSummaryStatistics ageStatistics = users.stream()
                .collect(Collectors.summarizingInt(User::getAge));

        List<String> stringList2 = new ArrayList<>();
        stringList2.add("A");
        stringList2.add("B");
        stringList2.add("C");
        stringList2.add("D");
        stringList2.add("E");
        stringList2.add("F");
        stringList2.add("G");
        stringList2.add("GG");
        stringList2.add("GG");
        stringList2.add("ABC");

        System.out.println("PEEK");
        Stream<String> stringStream = stringList2.stream()
                .peek(System.out::println);
        System.out.println("END OF PEEK");

        stringStream.collect(Collectors.toList());
//        List<String> wordsOfLenth1 = new ArrayList<>();
//        for (String s : stringList) {
//            if (s.length() == 1) {
//                wordsOfLenth1.add(s);
//            }
//        }
        //STREAM API
//        List<String> wordsOfLenth1 = stringList.stream()
//                .filter(s -> s.length() <= 2)
//                .sorted(comparingInt(String::length).reversed())
//                .map(String::toLowerCase)
//                .collect(toList());
//
//
//        for (String s : wordsOfLenth1) {
//            System.out.println(s);
//        }



        int[] sieve = sieve(100000);

        Optional<Integer> max = IntStream.range(2, sieve.length - 1)
                .filter(i -> sieve[i] == 0 || sieve[i] == 1)
                .filter(j -> sieve[j] == 1)
                .boxed()
                .max(Integer::compareTo);

    }



    public static int[] sieve(int n) {
        int[] sito = new int[n];
        sito[0] = 1;
        sito[1] = 1;
        for (int i = 2; i < sito.length; i++) {
            if (sito[i] == 0) {
                for (int j = 2; i*j < sito.length; j++) {
                    sito[j*i] = 1;
                }
            }
        }
        return sito;
    }


    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n% 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeNaive(int n) {
        if (n < 2) {
            return false;
        }
        int divisorCounter = 2;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                divisorCounter++;
            }
            if (divisorCounter > 2) {
                return false;
            }
        }
        if (divisorCounter == 2) {
            return true;
        }
        return false;
    }
}
