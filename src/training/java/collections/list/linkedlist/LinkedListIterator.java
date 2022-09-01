package training.java.collections.list.linkedlist;

import training.java.collections.list.IIterator;
import training.java.collections.list.IList;

public class LinkedListIterator<H> implements IIterator<H> {

    private IList<H> linkedList;
    private int current = 0;

    LinkedListIterator(IList<H> linkedList){
        this.linkedList = linkedList;
    }

    @Override
    public boolean hasNext() {
        return this.linkedList.getSize()>current;
    }

    @Override
    public H next() {
        H element = this.linkedList.getAt(current);
        current++;
        return element;
    }
}
