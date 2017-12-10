package com.algods.collections.lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * On static List<String> changeList(List<String> list) method you must do:
 * <p>
 * 1. find the longest string in list
 *  -if you use method max of class Collections : don't forget to implement a comparator for this method
 *    Collections.max(list, (s1,s2)->{...})
 *    by default, this method compares strings alphabetically!
 * -of course you can use other approaches(for example comparison in a for-loop)
 * 2. replace all list items with this row
 * 3. return modified list
 * <p>
 * Sample Input:
 * hi hello goodmorning ass
 * <p>
 * Sample Output:
 * goodmorning
 * goodmorning
 * goodmorning
 * goodmorning
 */
public class ChangeListHelper {

    static List<String> changeList(List<String> list) {
        // step 1
        String longest = list.stream().max((s1, s2) -> s1.length() - s2.length()).get();
        // step 2 and 3
        return list.stream().map(s -> s = longest).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        changeList(Arrays.asList("hi", "hello", "goodmorning", "ass")).forEach(System.out::println);
    }
}
