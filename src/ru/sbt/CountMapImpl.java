package ru.sbt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by leonid on 10/18/16.
 */
public class CountMapImpl<E> implements CountMap<E> {
    private int size = 0;
    private Object[] objects = new Object[100];

    @Override
    public void add(E e) {
        objects[size++] = e;
    }

    @Override
    public int getCount(E e) {
        int count = 0;
        for(int i = 0; i < size; i++){
            if(objects[i].equals(e)){
                count++;
            }
        }
        return count;
    }

    @Override
    public int remove(E e) {
        int count = getCount(e);
        for(int i = 0; i < size; i++){
            if(objects[i].equals(e)){
                for(int j = i; j < size - 1; j++){
                    objects[j] = objects[j+1];
                }
                size--;
                return count;
            }
        }
        return 0;
    }

    @Override
    public int size() {
        HashSet<E> set = new HashSet<>();
        for(int i = 0; i < size; i++){
            set.add((E) objects[i]);
        }
        return set.size();
    }

    @Override
    public void addAll(CountMap<? extends E> source) {

    }

    @Override
    public Map<E, Integer> toMap() {
        Map<E, Integer> map = new HashMap<>();
        for(int i = 0; i < size; i++){
            if (map.containsKey(objects[i])){
                map.put((E) objects[i], map.get(objects[i]) + 1);
            }else {
                map.put((E) objects[i], 1);
            }
        }
        return map;
    }

    @Override
    public void toMap(Map<? super E, Integer> destination) {
        destination = this.toMap();
    }
}
