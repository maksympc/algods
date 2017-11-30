package com.algods.collections.maps;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * Given an array of strings,
 * <p>
 * On wordCount() : return a
 * SortedMap<String, Integer> with a key for each different string, with the value the number of times that string appears in the array.
 * <p>
 * On printMap(): Using System.out.println() print all items of the Map ("key : value")
 */
public class WordsCountMapHelper {

    public static void main(String[] args) {

    }

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        SortedMap<String, Integer> map = new TreeMap<>();
        Stream.of(strings).forEach(i->map.merge(i,1,Integer::sum));
        return map;
    }

    public static void printMap(Map<String, Integer> map) {
        map.forEach((k,v)->System.out.println(" : "));
    }
}
