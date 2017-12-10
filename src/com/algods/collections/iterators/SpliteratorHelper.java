package com.algods.collections.iterators;

import java.util.*;

/**
 * On spliteratorWork( List<Double> lst ):
 * -using Spliterator add to List<Double> sqrts all square roots of items from lst ,if this item greater than 1
 * -use Math.sqrt(number) to find square root : Math.sqrt(4)-> 2.0
 * On print(List<Double> list):
 * -get spliterator() of given list
 * -divide spliterator into 2 parts ( use spliterator.trySplit())
 * -print all items which >=2 from first part (use .println())
 * -print empty string
 * -print all items which >=10 from second part (use .println())
 */
public class SpliteratorHelper {

    public static void main(String[] args) {
        List lst = Arrays.asList(4., 8., 16., 100., 110., 121.);
        List<Double> sqrts = spliteratorWork(lst);
        print(sqrts);
    }

    public static List<Double> spliteratorWork(List<Double> lst) {
        List<Double> sqrs = new ArrayList<>();
        Spliterator<Double> s = lst.spliterator();
        s.forEachRemaining((i) -> {
            if (i > 1) {
                sqrs.add(Math.sqrt(i));
            }
        });
        return sqrs;
    }

    public static void print(List<Double> list) {
        Spliterator<Double> spliterator = list.spliterator();
        spliterator.trySplit().forEachRemaining((i) -> {
            if (i >= 2) System.out.println(i);
        });
        System.out.println();
        spliterator.forEachRemaining((i) -> {
            if (i >= 10) System.out.println(i);
        });
    }
}
