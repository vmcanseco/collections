package training.java.collections.set;

import training.java.collections.IIterator;
import training.java.collections.list.linkedlist.LinkedList;

public class LinkedHashSet2<H> implements ISet<H>{
    private HashSet<H> hashSet;
    private LinkedList<H> linkedList;

    public LinkedHashSet2(){
        hashSet = new HashSet<>();
        linkedList = new LinkedList<>();
    }
    @Override
    public void add(H element) {
        if (!hashSet.contains(element)){
            linkedList.add(element);
            hashSet.add(element);
        }
    }

    @Override
    public boolean contains(H element) {
        return hashSet.contains(element);
    }

    @Override
    public boolean remove(H element) {
        if (hashSet.remove(element)){
            linkedList.removeAt(linkedList.indexOf(element));
            return true;
        }
        return false;
    }

    @Override
    public int getSize() {
        return hashSet.getSize();
    }

    @Override
    public IIterator<H> iterator() {
        return linkedList.iterator();
    }
}
