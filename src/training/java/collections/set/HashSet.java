package training.java.collections.set;

import training.java.collections.IIterator;
import training.java.collections.list.linkedlist.LinkedList;

import java.util.NoSuchElementException;

public class HashSet<H> implements ISet<H> {
    private int size;
    private static final int LOAD_FACTOR = 5;
    private LinkedList<H>[] buckets;

    @SuppressWarnings("unchecked")
    public HashSet() {
        buckets = new LinkedList[16];
    }


    public void add(H element) {

        int index = Math.abs(element.hashCode()) % buckets.length;
        LinkedList<H> linkedList = buckets[index];
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

    @SuppressWarnings("unchecked")
    private void redistributeBuckets() {
        IIterator<H> iterator = iterator();
        LinkedList<H>[] tempBuckets = new LinkedList[buckets.length * 2];

        while (iterator.hasNext()) {
            H element = iterator.next();

            int index = Math.abs(element.hashCode()) % tempBuckets.length;

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
        int index = Math.abs(element.hashCode()) % buckets.length;
        return buckets[index] != null && buckets[index].contains(element);
    }

    @Override
    public boolean remove(H element) {
        boolean removed = false;
        int index = Math.abs(element.hashCode()) % buckets.length;
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
            do {
                ++currentBucketSlot;
            } while (currentBucketSlot < buckets.length && buckets[currentBucketSlot]==null );
            
            return currentBucketSlot< buckets.length  ? buckets[currentBucketSlot].iterator() : null;

            /*IIterator<H> tmp = null;


            for (currentBucketSlot += 1; currentBucketSlot < buckets.length; currentBucketSlot += 1) {
                if (buckets[currentBucketSlot] != null) {
                    tmp = buckets[currentBucketSlot].iterator();
                    break;
                }
            }

            return tmp;*/

        }

        @Override
        public boolean hasNext() {
            if (currentIterator == null || !currentIterator.hasNext()){
                currentIterator = getNextIterator();
            }

            return currentIterator!=null && currentIterator.hasNext();

            /*boolean hasNext = false;

            currentIterator = getNextIterator();

            while (currentBucketSlot < buckets.length && !hasNext) {

                if (currentIterator.hasNext()) {
                    hasNext = true;
                } else {
                    currentIterator = getNextIterator();
                }


            }

            return hasNext;*/
        }

        @Override
        public H next() {
            if (hasNext()){
                return currentIterator.next();
            }else {
                throw new NoSuchElementException();
            }
        }
    }


}
