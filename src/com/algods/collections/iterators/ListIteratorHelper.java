package com.algods.collections.iterators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Additional code
 * 1.Using ListIterator iterate over the elements of list from the beginning to the end and after each word "Hip" add "Hop"
 * 2.Using ListIterator print the all elements(using .println())
 */
public class ListIteratorHelper {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = Arrays.stream(reader.readLine().split("\\s")).collect(Collectors.toCollection(LinkedList::new));
        //paste your code here
        ListIterator<String> it = (ListIterator<String>) list.iterator();
        while (it.hasNext()) {
            if (it.next().equals("Hip")) {
                it.add("Hop");
            }
        }
        list.forEach(System.out::println);
    }
}
