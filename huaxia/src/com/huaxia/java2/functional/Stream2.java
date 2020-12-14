package com.huaxia.java2.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
/*
 * map() filter() forEach()
 */
public class Stream2 {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();

        stringList.add("ONE");
        stringList.add("TWO");
        stringList.add("THREE");
        stringList.add("FOUR");
        stringList.add("FIVE");
        stringList.add("SIX");

        long count = stringList.stream().count();
        System.out.println("count = " + count);

        System.out.println();
        stringList.stream()
        .map((value) -> { return value.toLowerCase(); })
        .forEach(System.out::println);
        
        System.out.println();
        Stream<String> stream = stringList.stream();
        stream.filter((value) -> {
            return value.length() > 3;})
        .map((value) -> { return value.toLowerCase(); })
        .forEach(System.out::println);
        
    }
}