package org.example;

import java.util.function.Predicate;

public class FunctionPredicateMain {

    private static void testFunction() {
        Function<Integer, String> intToString = (i) -> "Number: " + i;
        String result = intToString.apply(42);
        System.out.println("Result casting function: " + result);
    }

    private static void testPredicate() {
        Predicate<Integer> isEven = (s) -> s % 2 == 0;
        Boolean result = isEven.test(10);

        System.out.println("Is 10 even? " + result);
    }

    private static void testCustomFunction() {
        CustomFunction customFunction = (str1, str2) -> str1 + str2;
        String result = customFunction.concatenate("Hello, ", "World!");
        System.out.println("Concatenated String: " + result);
    }

    public static void main(String[] args) {
        FunctionPredicateMain.testFunction();
        FunctionPredicateMain.testPredicate();
        FunctionPredicateMain.testCustomFunction();
    }

}
