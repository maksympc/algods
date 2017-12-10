package com.algods.collections.maxelement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Java-Collections-Framework course
 *
 *  Need to find max element, in input list using by the java 8 syntax
 * */
public class MaxElementHelper {

    public static Integer maxElem(List<Integer> list){
        // possible solution
        return list.stream().max(Integer::compareTo).get();
    }

    public static void main(String[] args) {
        // step 1. Create new Random class
        // step 2. Open a stream producing 100 pseudorandom int values.
        // step 3. Create a Stream consisting of the elements of this stream, each boxed to an Integer
        // step 4. Collect stream to new ArrayList instance
        List<Integer> list = new Random().ints(10,0, 1000).boxed().collect(Collectors.toCollection(ArrayList::new));
        list.stream().map(i->i+", ").forEach(System.out::print);
        System.out.println("\nmax:"+maxElem(list));
    }
}
