package training.java.collections.list.hashset;

import training.java.collections.list.IIterator;
import training.java.collections.list.arraylist.ArrayList;
import training.java.collections.list.linkedlist.LinkedList;

public class HashSet<H> implements ISet<H> {
    private ArrayList<LinkedList<H>> bucket;
    private int size;

    HashSet(){
        bucket=new ArrayList<>(16);

    }

    public void add(H  element){
        int index=element.hashCode() %  bucket.getSize();
        LinkedList<H> linkedList = bucket.getAt(index);
        if (linkedList==null){
            linkedList=new LinkedList<>();
            linkedList.add(element);
            bucket.setAt(index,linkedList);
            size++;
        }else {
            if (!linkedList.contains(element)) {
                linkedList.add(element);
                size++;
            }
        }
    }

    @Override
    public boolean contains(H element) {
        boolean exists=false;
        int index=element.hashCode() %  bucket.getSize();
        LinkedList<H> linkedList = bucket.getAt(index);
        if (linkedList!=null){
            exists = linkedList.contains(element);
        }
        return exists;
    }

    @Override
    public boolean remove(H element) {
        boolean removed=false;
        int index=element.hashCode() %  bucket.getSize();
        LinkedList<H> linkedList = bucket.getAt(index);
        if (linkedList!=null){
            int elementAt = linkedList.indexOf(element);
            if (elementAt!=-1){
                linkedList.removeAt(elementAt);
                removed=true;
                size--;
            }
        }

        return  removed;

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public IIterator<H> iterator() {
        return new HashSetIterator<H>(bucket);
    }

    private class HashSetIterator<H> implements IIterator<H>{

        private  ArrayList<LinkedList<H>> bucket;
        HashSetIterator(ArrayList<LinkedList<H>> bucket){
            this.bucket = bucket;
        }
        IIterator currentIterator;
        int currentBucketSlot;

        @Override
        public boolean hasNext() {
            boolean hasNext=false;
                for(int index=currentBucketSlot;index<bucket.getSize();index++){
                    if (bucket.getAt(index)!=null){
                        currentIterator = bucket.getAt(index).iterator();
                        break;
                    }
                }

            if (currentIterator!=null){
                hasNext = currentIterator.hasNext();
                if (!hasNext){
                    currentIterator=null;
                    hasNext();
                }
            }

            return hasNext;
        }

        @Override
        public H next() {
            return (H)currentIterator.next();
        }
    }



}
