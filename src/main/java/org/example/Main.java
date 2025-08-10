package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
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

    private static void testMap() {
        var fruits = List.of("Apple", "Banana", "Cherry");
        var fruitsUpperCase = fruits.stream()
                .map(s -> s.toUpperCase())
                .toList();

        System.out.println("Fruits in Upper Case: " + fruitsUpperCase);
    }

    private static void testReduceAsSum() {
        var numbers = List.of(1, 2, 3, 4, 5);
        var sum = numbers.stream()
                .reduce(0, (acc, curr) -> acc + curr);

        System.out.println("Sum of Numbers: " + sum);
    }

    private static void testReduceAsObject() {
        var wrapper = List.of(1, 2, 3, 4, 5)
                .stream()
                .reduce(
                        new IntegerWrapper(),
                        (acc, curr) -> {
                            acc.setValue(acc.getValue() + curr);
                            return acc;
                        },
                        (acc1, acc2) -> {
                            acc1.setValue(acc1.getValue() + acc2.getValue());
                            return acc1;
                        });

        System.out.println("Wrapped Sum: " + wrapper.getValue());
    }

    private static void testReduceAsIndex() {
        var games = List.of(
                new Games(1, "The Legend of Zelda", "Action-Adventure"),
                new Games(2, "Super Mario Bros", "Platformer"),
                new Games(3, "The Witcher 3", "RPG"));

        var indexes = games.stream()
                .reduce(
                        new HashMap<Integer, Games>(),
                        (acc, curr) -> {
                            acc.put(curr.getId(), curr);
                            return acc;
                        },
                        (acc1, acc2) -> {
                            acc1.putAll(acc2);
                            return acc1;
                        });

        System.out.println("Game Indexes: " + indexes);
    }

    private static void testOptional() {
        var optional = Optional.of("Hello, World!");
        Consumer<String> printer = (str) -> System.out.println(str);

        optional.ifPresent(printer);
    }

    private static void testOptionalDefaultValue() {
        var optional = Optional.ofNullable(null);
        var value = optional.orElseGet(() -> "Default Value");
        optional.ifPresentOrElse(
                (str) -> System.out.println("Value Present: " + str),
                () -> System.out.println("No Value Present"));

        System.out.println("Optional Default Value: " + value);
    }

    private static void testOptionalException() {
         var optional = Optional.ofNullable(null);
         optional.orElseThrow(() -> new RuntimeException("No Value Present"));
    }

    public static void main(String[] args) {
        Main.testConsumer();
        Main.testSupplier();
        Main.testFunction();
        Main.testPredicate();
        Main.testCustomFunction();
        Main.testMap();
        Main.testReduceAsSum();
        Main.testReduceAsObject();
        Main.testReduceAsIndex();
        Main.testOptional();
        Main.testOptionalDefaultValue();
        

        try {
            Main.testOptionalException();
        } catch (Exception e) {
            System.out.println("Exception Caught from Optional: " + e.getMessage()); 
        }

    }
}