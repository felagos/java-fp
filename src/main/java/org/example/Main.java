package org.example;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    private static void testConsumer() {
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept("Hello, World!");
    }

    private static void testSupplier() {
        Supplier<Double> randomNumberSupplier = () -> Math.random();
        double randomNumber = randomNumberSupplier.get();
        System.out.println("Random Number: " + randomNumber);
    }

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
        Main.testConsumer();
        Main.testSupplier();
        Main.testFunction();
        Main.testPredicate();
        Main.testCustomFunction();
    }
}