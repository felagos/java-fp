package org.example;

@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
