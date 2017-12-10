package com.algods.collections.lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Given string as this "1 2 3 4 5....". reader read this string.
 * 1.Separate elements with a space from str;
 * 2.add all this numbers to head of Linkedlist;
 * 3.remove 3 times the element at index 0;
 * 4.sort the resulting list in ascending order and print all of its elements each on a new line;
 */
public class ListRemover {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        LinkedList<Integer> ll = new LinkedList<>();
        Arrays.asList(str.split(" ")).stream().mapToInt(i -> Integer.valueOf(i)).boxed().forEach(ll::addFirst);
        //your code
        ll.stream().skip(3).sorted().forEach(System.out::println);
    }
}
