package training.java.collections.list.linkedlist;

import training.java.collections.IIterator;

 class LinkedListReverseIterator<H> implements IIterator<H> {

    private Node<H> currentNode;

    LinkedListReverseIterator(Node<H> last){
        currentNode = last;
    }

    @Override
    public boolean hasNext() {
        return currentNode!=null;
    }

    @Override
    public H next() {
        H element = currentNode.data;
        currentNode = currentNode.previous;
        return element;
    }
}