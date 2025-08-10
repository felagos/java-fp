package org.example;

/**
 * Functional interface that takes a variable number of parameters and returns a result
 * @param <T> the type of the input parameters
 * @param <R> the type of the result
 */
@FunctionalInterface
public interface MultiFunction<T, R> {
    
    /**
     * Applies this function to the given arguments.
     * @param args variable number of function arguments
     * @return the function result
     */
    @SuppressWarnings("unchecked")
    R apply(T... args);
}
