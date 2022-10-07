package training.java.collections.map;

import training.java.collections.IIterator;

public interface IMap<K,V> {

    void put(K key, V value);
    boolean containsKey(K key);
    V get(K key);
    boolean containsValue(V value);
    IIterator<Entry<K,V>> iterator();
    int getSize();
}
