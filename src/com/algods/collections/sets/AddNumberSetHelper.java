package com.algods.collections.sets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddNumberSetHelper {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] sets = reader.readLine().split(";");
        //your code(add elements to set1 from sets[0])
        Set<Integer> set1 = Stream.of(sets[0].split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());
        //your code(add elements to set2 from sets[1])
        Set<Integer> set2 = Stream.of(sets[1].split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());
        //your code(add elements to set3 from sets[2])
        Set<Integer> set3 = Stream.of(sets[2].split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());

        Set<Integer> resultTreeSet = unionTreeLargeNumber(set1, set2, set3);
        //print elements of resultTreeSet(using System.out.printLn()) below
        resultTreeSet.forEach(System.out::println);
    }

    public static TreeSet<Integer> unionTreeLargeNumber(Set<Integer> set1, Set<Integer> set2, Set<Integer> set3) {
        TreeSet<Integer> resultSet = Stream.of(set1, set2, set3)
                .mapToInt(
                        s -> s.stream().max(Integer::compareTo).get())
                .boxed()
                .collect(Collectors.toCollection(() -> new TreeSet(Collections.reverseOrder())));
        return resultSet;
    }


}
