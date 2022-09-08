package training.java.collections.list.linkedlist;

import training.java.collections.list.IIterator;

 class LinkedListIterator<H> implements IIterator<H> {

    private Node<H> currentNode;

    LinkedListIterator(Node<H> head){
        currentNode = head;
    }

    @Override
    public boolean hasNext() {
        return currentNode!=null;
    }

    @Override
    public H next() {
        H element = currentNode.data;
        currentNode=currentNode.next;
        return element;
    }
}
