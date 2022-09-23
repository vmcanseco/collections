package training.java.collections.list.hashset;

import training.java.collections.list.IIterator;
import training.java.collections.list.linkedlist.LinkedList;

public class HashSet<H> implements ISet<H> {
    private int size;
    private static final int LOAD_FACTOR = 5;
    private LinkedList<H>[] buckets;

    public HashSet() {
        buckets = (LinkedList<H>[]) new Object[16];
    }


    public void add(H element) {

        int index = element.hashCode() % buckets.length;
        LinkedList<H> linkedList = buckets[index];//bucket.getAt(index);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            linkedList.add(element);
            buckets[index] = linkedList;
            size++;
        } else {
            if (!linkedList.contains(element)) {
                linkedList.add(element);
                size++;
            }
        }

        if (linkedList.getSize() == LOAD_FACTOR) {
            redistributeBuckets();
        }

    }

    private void redistributeBuckets() {
        IIterator<H> iterator = iterator();
        LinkedList<H> tempBuckets[] = (LinkedList<H>[]) new Object[buckets.length * 2];

        while (iterator.hasNext()) {
            H element = iterator.next();

            int index = element.hashCode() % tempBuckets.length;

            LinkedList<H> linkedList = tempBuckets[index];
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                tempBuckets[index] = linkedList;
            }
            linkedList.add(element);

        }
        buckets = tempBuckets;


    }

    @Override
    public boolean contains(H element) {
        boolean exists = false;
        int index = element.hashCode() % buckets.length;
        LinkedList<H> linkedList = buckets[index];
        if (linkedList != null) {
            exists = linkedList.contains(element);
        }
        return exists;
    }

    @Override
    public boolean remove(H element) {
        boolean removed = false;
        int index = element.hashCode() % buckets.length;
        LinkedList<H> linkedList = buckets[index];
        if (linkedList != null) {
            int elementAt = linkedList.indexOf(element);
            if (elementAt != -1) {
                linkedList.removeAt(elementAt);
                removed = true;
                size -= 1;
            }
        }

        return removed;

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public IIterator<H> iterator() {
        return new HashSetIterator();
    }

    private class HashSetIterator implements IIterator<H> {

        IIterator<H> currentIterator;
        int currentBucketSlot = -1;

        private IIterator<H> getNextIterator() {

            IIterator<H> tmp = null;
            for (currentBucketSlot += 1; currentBucketSlot < buckets.length; currentBucketSlot += 1) {
                if (buckets[currentBucketSlot] != null) {
                    tmp = buckets[currentBucketSlot].iterator();
                    break;
                }
            }

            return tmp;

        }

        @Override
        public boolean hasNext() {
            boolean hasNext = false;

            currentIterator = getNextIterator();

            while (currentBucketSlot < buckets.length && !hasNext) {

                //if (currentIterator != null) {
                if (currentIterator.hasNext()) {
                    hasNext = true;
                } else {
                    currentIterator = getNextIterator();
                }

                /*} else {
                    currentIterator = getNextIterator();
                }*/


            }

            return hasNext;
        }

        @Override
        public H next() {
            return currentIterator.next();
        }
    }


}
