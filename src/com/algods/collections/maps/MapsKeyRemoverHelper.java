package com.algods.collections.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Modify and return the given map as follows: if the key "a" has a value, set the key "b" to have that same value. In all cases remove the key "c",leaving the rest of the map unchanged.
 * {"a":"abstraction","b":"boolean","c":"xyz"} -> {"a":"abstraction","b":"abstraction"}
 */
public class MapsKeyRemoverHelper {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "abstraction");
        map.put("b", "boolean");
        map.put("c", "xyz");

        mapShare(map).entrySet().forEach(i -> System.out.println("{key:" + i.getKey() + "; value:" + i.getValue() + "} "));

    }

    public static Map<String, String> mapShare(Map<String, String> map) {
        map.remove("c");
        if (map.containsKey("a"))
            map.replace("b", map.get("b"), map.get("a"));
        return map;
    }
}
