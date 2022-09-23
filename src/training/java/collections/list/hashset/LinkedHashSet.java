package training.java.collections.list.hashset;

import training.java.collections.list.IIterator;

public class LinkedHashSet<H> implements ISet<H> {
    private LinkedHashNode<H> head;
    private LinkedHashNode<H>[] bucket;
    private static final int LOAD_FACTOR=5;
    private int size;

    public LinkedHashSet(){
        bucket = new LinkedHashNode[16];
    }


    @Override
    public void add(H element) {
        int index = Math.abs(element.hashCode() ) % bucket.length;

    }

    @Override
    public boolean contains(H element) {
        return false;
    }

    @Override
    public boolean remove(H element) {
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public IIterator<H> iterator() {
        return null;
    }
}
