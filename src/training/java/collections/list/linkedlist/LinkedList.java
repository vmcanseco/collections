package training.java.collections.list.linkedlist;

import training.java.collections.list.BaseList;
import training.java.collections.IIterator;
import training.java.collections.list.IList;

public class LinkedList<H> extends BaseList<H> implements IList<H> {

    private Node<H> head;
    private Node<H> last;


    public LinkedList() {
        size = -1;
    }

    @Override
    public void add(H element) {
        checkNullValue(element);
        Node<H> tmp = new Node<>();
        tmp.data = element;
        if (head == null) {
            this.head = tmp;
            this.last = head;
        } else {
            tmp.previous = this.last;
            this.last.next = tmp;
            this.last = this.last.next;
        }

        this.size++;
    }


    @Override
    public boolean contains(H element) {
        checkNullValue(element);
        boolean found = false;

        Node tmp = this.head;
        while (tmp != null) {
            if (tmp.data.equals(element)) {
                found = true;
                break;
            }
            tmp = tmp.next;
        }

        return found;
    }



    @Override
    public H getAt(int index) {
        validateBounds(index);

        int iteration = 0;
        Node<H> tmp = head;
        H element = null;
        while (tmp != null) {
            if (iteration == index) {
                element = tmp.data;
                break;
            }
            tmp = tmp.next;
            iteration++;
        }
        return element;
    }

    @Override
    public void setAt(int index, H element) {
        checkNullValue(element);
        validateBounds(index);
        int iteration = 0;
        Node<H> current = this.head;
        while (current != null) {
            if (iteration == index) {
                current.data = element;
            }
            current = current.next;
            iteration++;
        }

    }

    /*public void setAt(int index, String element) {
        checkNullValue(element);
        validateBounds(index);
        int iteration = 0;
        Node current = this.head;
        Node tmp = new Node();
        tmp.data = element;
        Node previous = null;
        while (current != null) {
            if (iteration == index) {
                if (previous != null) {
                    tmp.next = current;
                    tmp.previous = previous;
                    current.previous = tmp;
                    previous.next = tmp;
                } else {
                    tmp.next = current;
                    current.previous = tmp;
                }

                if (tmp.previous == null) {
                    this.head = tmp;
                }
                break;
            }
            previous = current;
            current = current.next;
            iteration++;
        }
        this.size++;
    }*/

    @Override
    public void removeAt(int index) {
        validateBounds(index);

        int iteration = 0;
        Node<H> current = this.head;
        Node<H> previous = null;

        while (current != null) {

            if (iteration == index) {
                if (previous != null) {
                    Node<H> next = current.next;
                    previous.next = next;
                    if (next != null) {
                        next.previous = previous;
                    } else {
                        current.previous = null;
                        this.last = previous;
                    }

                } else {
                    this.head = current.next;
                }
                break;
            }
            previous = current;

            current = current.next;
            iteration++;
        }
        this.size--;
    }

    @Override
    public int getSize() {
        return size + 1;
    }

    @Override
    public int indexOf(H element) {
        checkNullValue(element);
        int index=0;

        Node tmp = this.head;
        while (tmp != null) {
            if (tmp.data.equals(element)) {
                break;
            }
            index++;
            tmp = tmp.next;
        }

        return index == getSize() ? -1:index;
    }

    @Override
    public IIterator<H> iterator() {
        return new LinkedListIterator3();
    }

    public IIterator<H> iteratorAnonymousClass() {
        return new IIterator<H>() {
            private Node<H> currentNode=head;
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
        };
    }

    @Override
    public IIterator<H> reverseIterator() {

        return new LinkedListReverseIterator<>(last);
    }


    @Override
    protected void validateBounds(int index) {
        if (this.size == -1 || index > this.size) {
            throw new IndexOutOfBoundsException(String.format("Index out of range {%d}", index));
        }
    }


    public static class LinkedListIterator2<H> implements IIterator<H> {

        private Node<H> currentNode;

        public LinkedListIterator2(Node<H> head){
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

    public class LinkedListIterator3 implements IIterator<H> {

        private Node<H> currentNode;

        public LinkedListIterator3(){
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

}
