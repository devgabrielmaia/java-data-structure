package com.gabrielmaia.stack;

@FunctionalInterface
public interface StringFormatter<T> {
    String toString(T item);
}
