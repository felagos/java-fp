package org.example;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerMain {

    private static void testConsumer() {
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept("Hello, World!");
    }

    private static void testSupplier() {
        Supplier<Double> randomNumberSupplier = () -> Math.random();
        double randomNumber = randomNumberSupplier.get();
        System.out.println("Random Number: " + randomNumber);
    }

    public static void main(String[] args) {
        ConsumerMain.testConsumer();
        ConsumerMain.testSupplier();
    }

}
