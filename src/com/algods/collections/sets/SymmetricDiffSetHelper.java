package com.algods.collections.sets;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1.Find Symmetrical difference of sets on symDifference(Set<T> set1, Set<T> set2) and return it.
 * ﻿* For example ﻿sets:{1 2 3 4} {3 4 5 6} --> Symmetrical difference = ﻿{1 2 5 6}
 */
public class SymmetricDiffSetHelper {

    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        new Random().ints(7, 0, 10).boxed().forEach(s1::add);
        new Random().ints(7, 0, 10).boxed().forEach(s2::add);
        System.out.print("s1: ");
        s1.forEach(i -> System.out.print(i + ", "));
        System.out.print("\ns2: ");
        s2.forEach(i -> System.out.print(i + ", "));
        System.out.print("\nAfter symDifference: ");
        symDifference(s1, s2).forEach(i -> System.out.print(i + ", "));
    }

    public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2) {
        //Enter your code below
        return Stream.concat(set1.stream(), set2.stream()).filter(i -> set1.contains(i) ^ set2.contains(i)).collect(Collectors.toCollection(HashSet::new));
    }

}
