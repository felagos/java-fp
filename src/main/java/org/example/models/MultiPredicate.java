package org.example.models;

/**
 * Functional interface that takes a variable number of parameters of any type and returns a boolean result
 * @param <T> the type of the input parameters
 */
@FunctionalInterface
public interface MultiPredicate<T> {
    
    /**
     * Evaluates this predicate on the given arguments.
     * @param args variable number of predicate arguments
     * @return the predicate result (true or false)
     */
    @SuppressWarnings("unchecked")
    boolean test(T... args);
}
