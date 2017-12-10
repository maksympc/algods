package com.algods.huffman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanCoding {
    private static final String FILENAME = "resource/huffman.txt";

    /**
     * read the character string from file
     */
    private String read() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(FILENAME));
        return scanner.next();
    }

    /**
     * create map of characters and corresponding frequency from input string
     */
    private Map<Character, Integer> parse(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    // Need to build a tree from lowest (frequency the least) element to highest.
    // Take two elements and combine them in InternalNode element. And then put the new element in queue again.
    // also have corner case with 1 element unique element.
    private Node buildTree(PriorityQueue<Node> queue, int charsCount, int length) {
        int sum = 0;

        if (queue.size() == 1) {
            sum = length;
        }
        while (queue.size() > 1) {
            Node first = queue.poll();
            Node second = queue.poll();
            InternalNode node = new InternalNode(first, second);
            queue.add(node);
            sum += node.getSum();
        }
        // show numbers of unique characters and sums of internal frequency.
        System.out.println(charsCount + " " + sum);
        // get the last element from priority queue. It will be the root of "frequency" tree
        return queue.poll();
    }

    private void run() throws FileNotFoundException {
        // read from
        String s = read();
        // calculate frequency
        Map<Character, Integer> frequencyCharsMap = parse(s);
        // to show input string value in encoded format
        Map<Character, Node> charsNodes = new HashMap<Character, Node>();
        // priority queue, add characters in natural ordering of their frequency.
        PriorityQueue<Node> queue = new PriorityQueue<>();

        for (Map.Entry<Character, Integer> e : frequencyCharsMap.entrySet()) {
            LeafNode leafNode = new LeafNode(e.getKey(), e.getValue());
            queue.add(leafNode);
            charsNodes.put(e.getKey(), leafNode);

        }
        // print priority queue state
//        while(!queue.isEmpty()) {
//            System.out.println((LeafNode)queue.poll());
//        }
        Node root = buildTree(queue, frequencyCharsMap.size(), s.length());
        // corner case. Set the root element code as 0.
        if (frequencyCharsMap.size() == 1) {
            root.buildCode("0");
        }
        // if we have more than one element, we should build codes for all characters, that present in our tree, from lowest to highest according to next scheme.
        // moving from root internal node, for left element add "0" code and for right add "1" code.
        else {
            root.buildCode("");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new HuffmanCoding().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}

class Node implements Comparable<Node> {
    private final int sum;
    private String code;

    public Node(int sum) {
        this.sum = sum;
    }
    public int getSum() {
        return sum;
    }
    public void buildCode(String code) {
        this.code = code;
    }
    @Override
    public int compareTo(Node o) {
        return sum - o.sum;
    }
}

class InternalNode extends Node {
    Node left;
    Node right;

    public InternalNode(Node left, Node right) {
        super(left.getSum() + right.getSum());
        this.left = left;
        this.right = right;
    }
    @Override
    public void buildCode(String code) {
        super.buildCode(code);
        left.buildCode(code + "0");
        right.buildCode(code + "1");
    }
}

class LeafNode extends Node {
    char symbol;

    public LeafNode(char symbol, int count) {
        super(count);
        this.symbol = symbol;
    }
    @Override
    public void buildCode(String code) {
        super.buildCode(code);
        System.out.println(symbol + ": " + code);
    }
    @Override
    public String toString() {
        return symbol + ": " + super.getSum();
    }
}