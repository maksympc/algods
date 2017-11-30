package com.algods.collections.iterators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Using BufferedReader read one string with numbers written across the space ("1 2 3 4 5 ...").
 * Put this numbers to any Collection of Integers.Sort this collection!
 * Using Iterator remove all even annoying numbers(death for elem%2=0 !) from your Collection
 * Print all remaining elements to console (use System.out.println() method)
 */
public class OddIterator {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //lets go
        List<Integer> list = Stream.of(reader.readLine().split(" "))
                                    .map(Integer::valueOf).collect(Collectors.toCollection(ArrayList::new));
        list.sort(Comparator.naturalOrder());
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            if(iterator.next()%2==0){
                iterator.remove();
            }
        }
        list.forEach(System.out::println);
    }

}
