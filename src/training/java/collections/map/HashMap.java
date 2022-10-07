package training.java.collections.map;

import training.java.collections.IIterator;
import training.java.collections.list.linkedlist.LinkedList;

import java.util.NoSuchElementException;

public class HashMap<K, V> implements IMap<K, V> {

    private int size;
    private static final int LOAD_FACTOR = 5;
    private LinkedList<Entry<K, V>>[] buckets;

    @SuppressWarnings("unchecked")
    public HashMap() {
        buckets = new LinkedList[16];
    }

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
            redistributeBuckets();
        }

    }

    @SuppressWarnings("unchecked")
    private void redistributeBuckets() {
        IIterator<Entry<K, V>> iterator = iterator();
        LinkedList<Entry<K,V>>[] tempBuckets = new LinkedList[buckets.length * 2];

        while (iterator.hasNext()) {
            Entry<K,V> entry = iterator.next();

            int index = Math.abs(entry.getKey().hashCode()) % tempBuckets.length;

            LinkedList<Entry<K,V>> linkedList = tempBuckets[index];
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                tempBuckets[index] = linkedList;
            }
            linkedList.add(entry);

        }
        buckets = tempBuckets;


    }

    @Override
    public boolean containsKey(K key) {
        int index = Math.abs(key.hashCode()) % buckets.length;
        LinkedList<Entry<K, V>> linkedList = buckets[index];
        if (linkedList!=null){
            IIterator<Entry<K,V>> iterator = linkedList.iterator();
            while (iterator.hasNext()){
                if (iterator.next().getKey().equals(key)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        boolean found =false;
        Entry<K,V> entry=null;
        int index = Math.abs(key.hashCode()) % buckets.length;
        LinkedList<Entry<K, V>> linkedList = buckets[index];
        if (linkedList!=null){
            IIterator<Entry<K,V>> iterator = linkedList.iterator();
            while (iterator.hasNext()){
                 entry = iterator.next();
                if (entry.getKey().equals(key)){
                    found = true;
                }
            }
        }
        if (found){
            return entry.getValue();
        }else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean containsValue(V value) {
        IIterator<Entry<K, V>> iterator = iterator();
        while (iterator.hasNext()){
            Entry<K,V> entry = iterator.next();
            if (entry.getValue().equals(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public IIterator<Entry<K, V>> iterator() {
        return new HashMapIterator();
    }

    @Override
    public int getSize() {
        return size;
    }

    private class HashMapIterator implements IIterator<Entry<K, V>> {

        IIterator<Entry<K, V>> currentIterator;
        int currentBucketSlot = -1;

        private IIterator<Entry<K, V>> getNextIterator() {
            do {
                ++currentBucketSlot;
            } while (currentBucketSlot < buckets.length && buckets[currentBucketSlot]==null );

            return currentBucketSlot< buckets.length  ? buckets[currentBucketSlot].iterator() : null;

        }

        @Override
        public boolean hasNext() {
            if (currentIterator == null || !currentIterator.hasNext()){
                currentIterator = getNextIterator();
            }

            return currentIterator!=null && currentIterator.hasNext();
        }

        @Override
        public Entry<K, V> next() {
            if (hasNext()){
                return currentIterator.next();
            }else {
                throw new NoSuchElementException();
            }
        }
    }
}
