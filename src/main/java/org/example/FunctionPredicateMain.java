package org.example;

import java.util.List;
import java.util.function.Predicate;

import org.example.models.CustomFunction;
import org.example.models.Function;
import org.example.models.MultiFunction;
import org.example.models.MultiPredicate;

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

    private static void testFunctionConcatString() {
        MultiFunction<String, String> concat = (strings) -> {
            var strList = List.of(strings);

            return strList.stream().reduce(
                    new StringBuilder(),
                    (acc, str) -> acc.append(str),
                    (str1, str2) -> str1.append(str2))
                    .toString();
        };

        var result = concat.apply("Hello", " ", "World", "!");
        System.out.println("Concatenated String: " + result);
    }

    private static void testMultiPredicateAllEven() {
        MultiPredicate<Integer> allEven = numbers -> {
            for (Integer num : numbers) {
                if (num % 2 != 0) {
                    return false;
                }
            }
            return true;
        };

        boolean result1 = allEven.test(2, 4, 6, 8);
        boolean result2 = allEven.test(2, 4, 5, 8);

        System.out.println("Are all numbers (2,4,6,8) even? " + result1);
        System.out.println("Are all numbers (2,4,5,8) even? " + result2);
    }

    private static void testMultiPredicateAllPositive() {
        MultiPredicate<Number> allPositive = numbers -> {
            for (Number num : numbers) {
                if (num.doubleValue() <= 0) {
                    return false;
                }
            }
            return true;
        };

        boolean result1 = allPositive.test(1, 2.5, 3, 4.7);
        boolean result2 = allPositive.test(1, -2.5, 3, 4.7);

        System.out.println("Are all numbers (1, 2.5, 3, 4.7) positive? " + result1);
        System.out.println("Are all numbers (1, -2.5, 3, 4.7) positive? " + result2);
    }

    private static void testMultiPredicateStringLength() {
        MultiPredicate<String> allLongEnough = strings -> {
            for (String str : strings) {
                if (str.length() < 3) {
                    return false;
                }
            }
            return true;
        };

        boolean result1 = allLongEnough.test("Hello", "World", "Java");
        boolean result2 = allLongEnough.test("Hello", "Hi", "Java");

        System.out.println("Are all strings (Hello, World, Java) at least 3 chars? " + result1);
        System.out.println("Are all strings (Hello, Hi, Java) at least 3 chars? " + result2);
    }

    private static void testMultiPredicateAnyType() {
        MultiPredicate<Object> allNotNull = objects -> {
            for (Object obj : objects) {
                if (obj == null) {
                    return false;
                }
            }
            return true;
        };

        boolean result1 = allNotNull.test("Hello", 42, 3.14, true);
        boolean result2 = allNotNull.test("Hello", null, 3.14, true);

        System.out.println("Are all objects (String, Integer, Double, Boolean) not null? " + result1);
        System.out.println("Are all objects (String, null, Double, Boolean) not null? " + result2);
    }

    private static void testHigherOrderFunction() {
        Function<Integer, Function<Integer, Integer>> makeAdder = (Integer x) -> (Integer y) -> x + y;

        var addTen = makeAdder.apply(10);
        int sum = addTen.apply(7); // 10 + 7 = 17
        System.out.println("makeAdder: 10 + 7 = " + sum);

        Function<Function<Integer, Integer>, Function<Integer, Integer>> applyThenDouble =
                (Function<Integer, Integer> f) -> (Integer v) -> f.apply(v) * 2;

        Function<Integer, Integer> increment = (i) -> i + 1;
        var doubledAfterIncrement = applyThenDouble.apply(increment);
        int value = doubledAfterIncrement.apply(5); 
        System.out.println("applyThenDouble(increment)(5): " + value);
    }

    public static void main(String[] args) {
        FunctionPredicateMain.testFunction();
        FunctionPredicateMain.testPredicate();
        FunctionPredicateMain.testCustomFunction();
        FunctionPredicateMain.testFunctionAsParameter();
        FunctionPredicateMain.testFunctionDynamicParameters();
        FunctionPredicateMain.testFunctionConcatString();

    FunctionPredicateMain.testHigherOrderFunction();

        System.out.println("\n=== Testing Multi Predicates ===");
        FunctionPredicateMain.testMultiPredicateAllEven();
        FunctionPredicateMain.testMultiPredicateAllPositive();
        FunctionPredicateMain.testMultiPredicateStringLength();
        FunctionPredicateMain.testMultiPredicateAnyType();
    }

}
