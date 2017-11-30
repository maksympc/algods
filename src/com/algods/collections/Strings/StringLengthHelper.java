package com.algods.collections.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of strings, return a list of the strings, omitting any string length 4 or more.
 * ["a", "bbb", "cccc", "dddddd"] → ["a", "bbb"]
 */
public class StringLengthHelper {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee", "ffffffff", "ggggggggg");
        noLongString(strings);
    }

    public static List<String> noLongString(List<String> strings) {
        return strings.stream().filter(s -> s.length() <= 4).collect(Collectors.toCollection(ArrayList::new));
    }
}
