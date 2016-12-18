package org.ananichev;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leonid on 10/19/16.
 */
public class CountMapImpl<E> implements CountMap<E> {
    private Map<E, Integer> map = new HashMap<>();

    @Override
    public void add(E e) {
        if(map.containsKey(e)){
            map.put(e, map.get(e) + 1);
        }else{
            map.put(e, 1);
        }
    }

    @Override
    public int getCount(E e) {
        return map.get(e);
    }

    @Override
    public int remove(E e) {
        if(map.containsKey(e)){
            map.put(e, map.get(e) - 1);
            return map.get(e) + 1;
        }
        return 0;
    }

    @Override
    public int size() {
        return map.keySet().size();
    }

    @Override
    public void addAll(CountMap<? extends E> source) {
        for(E e : source.toMap().keySet()){
            if(map.containsKey(e)){
                map.put(e, this.getCount(e) + source.toMap().get(e));
            }else{
                this.add(e);
            }
        }
    }

    @Override
    public Map<E, Integer> toMap() {
        return new HashMap<>(map);
    }

    @Override
    public void toMap(Map<? super E, Integer> destination) {
        for(E e : map.keySet()){
            destination.put(e, map.get(e));
        }
    }
}
