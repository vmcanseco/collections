package training.java.collections.map;

import training.java.collections.IIterator;
import training.java.collections.list.linkedlist.LinkedList;

public class HashMap<K, V> implements IMap<K, V> {

    private int size;
    private static final int LOAD_FACTOR = 5;
    private LinkedList<Entry<K, V>>[] buckets;

    @Override
    public void put(K key, V value) {

        int index = Math.abs(key.hashCode()) % buckets.length;
        LinkedList<Entry<K, V>> linkedList = buckets[index];
        Entry<K, V> entry = new Entry<>(key, value);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            linkedList.add(entry);
            buckets[index] = linkedList;
            size++;
        } else {
            if (!linkedList.contains(entry)) {
                linkedList.add(entry);
                size++;
            }
        }

        if (linkedList.getSize() == LOAD_FACTOR) {
            //redistributeBuckets();
        }

    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean containsValue(V value) {
        return false;
    }

    @Override
    public IIterator<Entry<K, V>> iterator() {
        return null;
    }
}
