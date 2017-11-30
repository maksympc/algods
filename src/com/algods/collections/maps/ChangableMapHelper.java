package com.algods.collections.maps;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Modify and return the given map as follows:
 * if the first key % 2 != 0 return sub map from First Key inclusive to FirstKey+4 inclusive in descending order
 * else return sub map from LastKey-4 inclusive to the Last Key inclusive in descending order
 */
public class ChangableMapHelper {

    public static void main(String[] args) {
        "123".chars();
    }

    public static NavigableMap<Integer, String> getSubMap(NavigableMap<Integer, String> map) {
        if (map.firstEntry().getKey() % 2 != 0)
            return new TreeMap<>(map.subMap(map.firstKey(), true, map.firstKey() + 4, true)).descendingMap();
        return new TreeMap<>(map.subMap(map.lastKey() - 4, true, map.lastKey(), true)).descendingMap();
    }

}
