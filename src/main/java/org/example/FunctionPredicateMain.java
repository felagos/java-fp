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

    private static <T, R> R applyFunction(Function<T, R> function, T input) {
        return function.apply(input);
    }

    private static void testFunctionAsParameter() {
        Function<Integer, String> intToString = (i) -> "Number: " + i;
        String result = applyFunction(intToString, 42);
        System.out.println("Result from Function as Parameter: " + result);
    }

    private static void testFunctionDynamicParameters() {
        MultiFunction<Integer, Integer> sumAll = numbers -> {
            int sum = 0;
            for (Integer num : numbers) {
                sum += num;
            }
            return sum;
        };

        var result = sumAll.apply(1, 2, 3, 4, 5);
        System.out.println("Sum of 1,2,3,4,5: " + result);
    }

    public static void main(String[] args) {
        FunctionPredicateMain.testFunction();
        FunctionPredicateMain.testPredicate();
        FunctionPredicateMain.testCustomFunction();
        FunctionPredicateMain.testFunctionAsParameter();
        FunctionPredicateMain.testFunctionDynamicParameters();
    }

}
