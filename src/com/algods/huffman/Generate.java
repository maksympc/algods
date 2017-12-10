package com.algods.huffman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

/**This class is used for generating random symbols*/
public class Generate {

    private static final int SIZE = 10000;
    private static final String FILENAME = "resource/huffman.txt";

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Generating " + SIZE + " characters in " + FILENAME);
        new Generate().run();
        System.out.println("Success!");
    }

    private void run() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File(FILENAME));
        Random rand = new Random();
        for (int i = 0; i < SIZE; i++) {
            writer.print((char) ('a' + rand.nextInt(26)));
        }
        writer.close();
    }

}
