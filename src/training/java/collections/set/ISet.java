package training.java.collections.set;

import training.java.collections.IIterator;

interface  ISet<H> {

    void add(H element);

    boolean contains(H element);

    boolean remove(H element);

    int getSize();

    IIterator<H> iterator();
}
