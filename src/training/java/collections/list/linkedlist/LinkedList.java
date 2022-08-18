package training.java.collections.list.linkedlist;

import training.java.collections.list.IList;

public class LinkedList implements IList {
    private int size = -1;
    private Node head;
    private Node last;


    @Override
    public void add(String element) {
        Node tmp = new Node();
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

    public void iterate(){
        Node tmp = this.head;
        while (tmp!=null){
            System.out.println("-------------------------");
            System.out.println("Current : "+tmp.data);
            if (tmp.previous!=null){
                System.out.println("Previous : "+tmp.previous.data);
            }
            if (tmp.next!=null){
                System.out.println("Next : "+tmp.next.data);
            }
            System.out.println("-------------------------");
            tmp=tmp.next;
        }
    }


    @Override
    public boolean contains(String element) {
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
    public String getAt(int index) throws Exception {
        validateBounds(index);

        int iteration = 0;
        Node tmp = head;
        String element = null;
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
    public void setAt(int index, String element) throws Exception {
        validateBounds(index);
        int iteration = 0;
        Node current = this.head;
        Node tmp = new Node();
        tmp.data = element;
        Node previous = null;
        while (current != null) {
            if (iteration == index) {
                    if (previous!=null){
                        tmp.next = current;
                        tmp.previous = previous;
                        current.previous = tmp;
                        previous.next=tmp;
                    }else{
                        tmp.next=current;
                        current.previous=tmp;
                    }

                    if (tmp.previous==null){
                        this.head = tmp;
                    }
                    break;
                }
            previous = current;
            current = current.next;
            iteration++;
        }
        this.size++;
    }

    @Override
    public void removeAt(int index) throws Exception {
        validateBounds(index);

        int iteration = 0;
        Node current = this.head;
        Node previous = null;

        while (current != null) {

            if (iteration == index) {
                if (previous != null) {
                    Node next  = current.next;
                    previous.next = next;
                    if (next!=null){
                        next.previous = previous;
                    }else{
                        current.previous=null;
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
        return this.size + 1;
    }



    private void validateBounds(int index) throws Exception {
        if (this.size == -1 || index > this.size) {
            throw new Exception(String.format("Index out of range {%d} ", index));
        }
    }


}
