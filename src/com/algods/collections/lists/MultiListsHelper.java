package com.algods.collections.lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Sooo this task may seem difficult , but actually it is not ! some after it become man...)
 * your BufferedReader gets string as this : "1 2 3 4 5"
 * <p>
 * next, you must create a list of numbers from this line(ArrayList<Integer>) in the createBigList:
 * String[] strarr = str.split(" "); - String element from given string ( "1", "2", "3", "4", "5")
 * In for-each loop convert to Integer and add all alements from strarr to bigList
 *  -->Use Integer.parseInt(s) or Integer.valueOf(s) to convert from String to Integer
 * return this bigList
 * <p>
 * have created three list, add the desired items in each and sort this lists in ascending order:
 * div2List for integers that x%2=0 {2, 4}
 * div3List for integers that x%3=0 {3}
 * otherlist for the remaining integers {1, 5}
 * if x%2=0 and x%3=0 add x to div2List and div3List!
 * Sort all three lists and create List of this three lists where the first element is div2List, second -  div3List and third - otherlist.
 * method printInLine(resultList) is already written by me
 */
public class MultiListsHelper {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String allElements = reader.readLine();
        List<Integer> bigList = createBigList(allElements);

        ArrayList<Integer> div2list;
        ArrayList<Integer> div3list;
        ArrayList<Integer> otherlist;

        //add the necessary elements from bigList to div2list,div3list,otherlist and sort all three lists
        div2list = bigList.stream().filter(i -> i % 2 == 0).sorted().collect(Collectors.toCollection(ArrayList::new));
        div3list = bigList.stream().filter(i -> i % 3 == 0).sorted().collect(Collectors.toCollection(ArrayList::new));
        otherlist = bigList.stream().filter(i -> !(i % 2 == 0 || i % 3 == 0)).sorted().collect(Collectors.toCollection(ArrayList::new));

        //get result list from createListOfLists
        List<List<Integer>> resultList = createListOfLists(div2list, div3list, otherlist);

        //call printInLine() for resultList
        printInLine(resultList);
    }

    public static List<Integer> createBigList(String str) {
        return Arrays.asList(str.split(" ")).stream().mapToInt((i) -> Integer.valueOf(i)).boxed().collect(Collectors.toList());
    }

    public static List<List<Integer>> createListOfLists(List<Integer> div2list, List<Integer> div3list, List<Integer> otherList) {
        //add all lists like items in resultList(list of lists) and return it, first-div2list, second-div3list, third-otherList
        return Arrays.asList(div2list, div3list, otherList);
    }

    public static void printInLine(List<List<Integer>> resultList) {
        // step 1. Get stream from result list
        // step 2. Map lists to String representation
        // step 3. Combine new string with ';' delimiter
        System.out.println(
                resultList.stream().map(i -> i.stream().map(j -> j.toString()).collect(Collectors.joining(" "))).collect(Collectors.joining(";"))
        );
    }
}
