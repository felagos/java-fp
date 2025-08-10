package org.example;

import java.util.HashMap;
import java.util.List;

public class ListOperatorsMain {

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

    public static void main(String[] args) {
        ListOperatorsMain.testMap();
        ListOperatorsMain.testReduceAsSum();
        ListOperatorsMain.testReduceAsObject();
        ListOperatorsMain.testReduceAsIndex();
    }

}
