package ru.sbt;

import java.util.Map;

/**
 * Created by leonid on 10/18/16.
 */
public interface CountMap<E> {

    void add(E e);

    int getCount(E e);

    int remove(E e);

    int size();

    void addAll(CountMap<? extends E> source);

    Map<E, Integer> toMap();

    void toMap(Map<? super E, Integer> destination);
}
