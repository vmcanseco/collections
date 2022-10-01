package training.java.collections.list.hashset;

import training.java.collections.list.IIterator;

public class LinkedHashSet<H> implements ISet<H> {
    private LinkedHashNode<H> head;
    private LinkedHashNode<H>[] bucket;
    private static final int LOAD_FACTOR=5;
    private int size;

    public LinkedHashSet(){
        bucket = new LinkedHashNode[16];
        head = new LinkedHashNode<>();
    }


    @Override
    public void add(H element) {
        int index = Math.abs(element.hashCode() ) % bucket.length;
        LinkedHashNode<H> node = bucket[index];
        LinkedHashNode<H> tmp = new LinkedHashNode<>();
        tmp.data=element;
        if (node != null){
            if (!node.data.equals(element)){
                tmp.next = node;
            }else{
                return;
            }
        }
        if (size==0){
            head.after = tmp;
        }else{
            LinkedHashNode last= head.before;
            tmp.before= last;
            last.after = tmp;
        }
        head.before = tmp;
        bucket[index]=tmp;
        size++;
    }

    @Override
    public boolean contains(H element) {
        int index = Math.abs(element.hashCode() ) % bucket.length;
        LinkedHashNode<H> node = bucket[index];
        boolean found = false;
        while (node!=null){
            if (node.data.equals(element)){
                found =true;
            }
            node = node.next;
        }
        return  found;
    }

    @Override
    public boolean remove(H element) {
        int index = Math.abs(element.hashCode() ) % bucket.length;
        LinkedHashNode<H> node = bucket[index];
        boolean removed = false;
        LinkedHashNode<H> previous=null;
        while (node!=null){
            if (node.data.equals(element)){
                if (previous!=null){
                    previous.next = node.next;
                }else{
                    bucket[index]=null;
                }
                removed =true;
                size--;
            }
            previous = node;
            node = node.next;
        }
        return  removed;

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public IIterator<H> iterator() {
        return new LinkedHashSetIterator();
    }

    private class LinkedHashSetIterator implements IIterator<H>{

        private LinkedHashNode<H> node= head.after;
        @Override
        public boolean hasNext() {
            return node!=null;
        }

        @Override
        public H next() {
            H element = node.data;
            node = node.after;
            return element;
        }
    }
}
