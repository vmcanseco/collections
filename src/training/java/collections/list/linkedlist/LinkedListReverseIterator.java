package training.java.collections.list.linkedlist;

import training.java.collections.list.IIterator;
import training.java.collections.list.IList;

public class LinkedListReverseIterator<H> implements IIterator<H> {

    private IList<H> linkedList;
    private int current;

    LinkedListReverseIterator(IList<H> linkedList){
        this.linkedList = linkedList;
        current = linkedList.getSize();
    }

    @Override
    public boolean hasNext() {
        return current>0;
    }

    @Override
    public H next() {
        current--;
        H element = this.linkedList.getAt(current);
        return element;
    }
}