package training.java.collections.list.hashset;

import training.java.collections.list.IIterator;

interface  ISet<H> {

    void add(H element);

    boolean contains(H element);

    boolean remove(H element);

    int getSize();

    IIterator<H> iterator();
}
