package com.algods.collections.iterators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListIteratorReverseHelper {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list;
        //enter your code here
        list = Stream.of(reader.readLine().split(" ")).collect(Collectors.toCollection(ArrayList::new));

        ListIterator<String> it = list.listIterator();

        while(it.hasNext()){
            String s = it.next();
            if(!s.startsWith("J")){
                it.remove();
            }else{
                it.set(s.substring(1));
            }
        }

        while(it.hasPrevious()){
            System.out.println(it.previous());
        }
    }
}
