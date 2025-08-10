package org.example;

import java.util.Optional;
import java.util.function.Consumer;

public class OptionalMain {

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
        OptionalMain.testOptional();
        OptionalMain.testOptionalDefaultValue();

        try {
            OptionalMain.testOptionalException();
        } catch (Exception e) {
            System.out.println("Exception Caught from Optional: " + e.getMessage());
        }

    }

}
