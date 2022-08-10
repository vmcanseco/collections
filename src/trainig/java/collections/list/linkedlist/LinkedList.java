package trainig.java.collections.list.linkedlist;

public class LinkedList  implements IList{
    int size=-1;
    private Node head;
    private Node last;

    public LinkedList(){
        //this.head = new Node();
    }

    @Override
    public void add(String element) {
        Node tmp = new Node();
        tmp.setData(element);
        if (head==null){
            this.head = tmp;
            this.last = head;
        }else {
            this.last.setNext(tmp);
            this.last=this.last.getNext();
        }

        this.size++;
    }



    @Override
    public boolean contains(String element) {
        boolean  found = false;

        Node tmp = this.head;
        while (tmp!=null){
            if (tmp.getData().equals(element)){
                found = true;
                break;
            }
            tmp = tmp.getNext();
        }

        return found;
    }

    @Override
    public String getAt(int index) throws Exception {
        validateBounds(index);

        int iteration=0;
        Node tmp = head;
        String element=null;
        while (tmp!=null){
            if (iteration==index) {
                element = tmp.getData();
                break;
            }
            tmp = tmp.getNext();
            iteration++;
        }
        return element;
    }

    @Override
    public void setAt(int index, String element) throws Exception{
        validateBounds(index);
        int iteration=0;
        Node current = this.head;
        Node previous = null;
        Node newNode = new Node();
        newNode.setData(element);
        while (current!=null){

            if (iteration==index) {
                if (previous!=null){
                    newNode.setNext(current.getNext());
                    previous.setNext(newNode);
                }else {
                    newNode.setNext(this.head);
                    this.head = newNode;
                }
                break;
            }
            previous = current;

            current = current.getNext();
            iteration++;
        }
        this.size--;
    }

    @Override
    public void removeAt(int index) throws Exception {
        validateBounds(index);

        int iteration=0;
        Node current = this.head;
        Node previous = null;

        while (current!=null){

            if (iteration==index) {
                if (previous!=null){
                    previous.setNext(current.getNext());
                }else {
                    this.head=current.getNext();
                }
                break;
            }
            previous = current;

            current = current.getNext();
            iteration++;
        }
        this.size--;
    }

    @Override
    public int getSize() {
        return this.size+1;
    }

    @Override
    public Node getHead() {
        return this.head;
    }

    private void validateBounds(int index) throws Exception {
        if (this.size==-1 || index> this.size){
            throw new Exception(String.format("Index out of range {%d} ",index));
        }
    }


}
