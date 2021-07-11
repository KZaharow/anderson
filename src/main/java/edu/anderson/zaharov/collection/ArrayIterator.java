package edu.anderson.zaharov.collection;

import lombok.RequiredArgsConstructor;

import java.util.Iterator;

/**
 * class needs for custom array list
 *
 * @param <E> get type for iterrator
 */
@RequiredArgsConstructor
public class ArrayIterator<E> implements Iterator<E> {

    private final E[] values;

    private int index = 0;

    @Override
    public boolean hasNext() {

        return index < values.length;
    }

    @Override
    public E next() {

        return values[index++];
    }
}