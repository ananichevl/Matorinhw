package org.ananichev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leonid on 10/19/16.
 */
public class Test {
    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapImpl<>();
        map.add(10);
        map.add(10);
        map.add(1);
        map.add(1);
        map.add(1);
        map.add(2);
        map.add(2);
        map.add(5);
        Map<Integer, Integer> m1 = map.toMap();
        Map<Number, Integer> m2 = new HashMap<>();
        map.toMap(m2);
        System.out.println(map.remove(1));
        System.out.println(map.getCount(10));
        System.out.println(map.remove(2));
        System.out.println(map.size());

        List<Number> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        list.add(10);
        list.add(1);
        l.add(2);
        list.removeAll(l);
        System.out.println(list);
    }
}
