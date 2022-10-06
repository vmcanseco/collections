package training.java.collections.set;

import training.java.collections.IIterator;
import training.java.collections.list.linkedlist.LinkedList;

public class LinkedHashSet3<H> extends HashSet<H> implements ISet<H>{

    private LinkedList<H> linkedList;

    public LinkedHashSet3(){
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(H element) {
        if (!contains(element)){
            super.add(element);
            linkedList.add(element);
        }
    }


    @Override
    public boolean remove(H element) {
        boolean removed = super.remove(element);
        if (removed){
            linkedList.removeAt(linkedList.indexOf(element));
        }
        return removed;
    }


    @Override
    public IIterator<H> iterator() {
        return linkedList.iterator();
    }


}
