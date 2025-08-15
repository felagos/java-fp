package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringMain {

    private static void testJoinListAsString() {
        var letters = new String[] {"S", "P", "R", "I", "N", "G"};

        var result = Stream.of(letters)
            .map(letter -> letter.split(""))
            .peek(System.out::println)
            .flatMap(Arrays::stream)
            .collect(Collectors.joining());

        System.out.println("Joined string: " + result);
    }

    public static void main(String[] args) {
        StringMain.testJoinListAsString();
    }

}
