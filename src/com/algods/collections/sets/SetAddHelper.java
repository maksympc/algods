package com.algods.collections.sets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Additional code,son!
 * 1.Given a string as "1 2 3 4 5 6 ..." . String[] strings contains of element from given string ("1","2",..).
 * Add all elements from String[] strings to Set<Integer> set.
 * 2.Add all the elements from helpList to set .
 * 3.Using Iterator remove/filter(Stream API)/"method-of-all-collections" all elements greater than 10(>) from set and return modified set.
 */
public class SetAddHelper {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        List<Integer> helpList = getList();
        Set<Integer> set = new HashSet<>();
        //add elements from strings to set
        Stream.of(strings).map(Integer::valueOf).forEach(set::add);
        //add elements from helpList to set
        helpList.stream().forEach(set::add);

        set = removeAllNumbersMoreThan10(set);
        set.forEach(System.out::println);
    }

    public static Set<Integer> removeAllNumbersMoreThan10(Set<Integer> set) {
        //put your code here
        set.removeIf(i->i>10);
        return set;
    }

    public static List<Integer> getList() {
        return new Random().ints(10, 0, 20).boxed().collect(Collectors.toCollection(ArrayList::new));

    }
}
