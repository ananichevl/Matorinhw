package org.ananichev;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by leonid on 10/19/16.
 */
public class CollectionUtils {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static<T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static<T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }

    public static<T> List<? super T> limit(List<? extends T> source, int size) {
        List<? super T> list = new ArrayList<>();
        for (int i = 0; i < size; i++){
            list.add(source.get(i));
        }
        return list;
    }

    public static<T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static<T> void removeAll(List<T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static<T> boolean containsAll(List<T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static<T> boolean containsAny(List<T> c1, List<? extends T> c2) {
        for (T t : c2){
            if(c1.contains(t)){
                return true;
            }
        }
        return false;
    }

    public static<T extends Comparable<? super T>> List<? super T> range(List<? extends T> list, T min, T max) {
        List<? super T> l = new ArrayList<>();
        for (T t : list){
            if(t.compareTo(min) >= 0 && t.compareTo(max) <= 0){
                l.add(t);
            }
        }
        return l;
    }

    public static<T> List<? super T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        List<? super T> l = new ArrayList<>();
        for (T t : list){
            if(comparator.compare(t, min) >= 0 && comparator.compare(t, max) <= 0){
                l.add(t);
            }
        }
        return l;
    }

}
