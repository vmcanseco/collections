package training.java.collections.list.arraylist;

import training.java.collections.list.BaseList;
import training.java.collections.IIterator;
import training.java.collections.list.IList;
import training.java.collections.list.linkedlist.LinkedList;

public class ArrayList<H> extends BaseList<H> implements IList<H> {
    private int maxCapacity;
    private H[] data;

    public ArrayList(int capacity){
        maxCapacity=capacity;
        data = (H[])new Object[maxCapacity];

    }

    public ArrayList() {
        this(2);
    }


    @Override
    public void add(H element) {
        checkNullValue(element);
        if (size == maxCapacity) {
            maxCapacity *= 2;
            H[] tmp = (H[]) new Object[maxCapacity];
            int idx = 0;
            for (H value : data) {
                tmp[idx] = value;
                idx++;
            }
            tmp[idx] = element;
            data = tmp;
        }
        data[size] = element;
        size++;
    }

    @Override
    public boolean contains(H element) {
        checkNullValue(element);
        boolean found = false;
        for (H value : data) {
            if (value == null) {
                break;
            } else if (value.equals(element)) {
                found = true;
                break;
            }
        }
        return found;
    }


    @Override
    public H getAt(int index) {
        validateBounds(index);
        return data[index];
    }

    @Override
    public void setAt(int index, H element) {
        checkNullValue(element);
        validateBounds(index);
        data[index] = element;
        /*String tmp[] = new String[size];

        for (int idxTmp = 0, idxData = 0; idxTmp < size; ) {
            if (idxTmp != index) {
                tmp[idxTmp] = data[idxData];
                idxData++;
            } else {
                tmp[idxTmp] = element;
            }
            idxTmp++;
        }
        data = tmp;
        size++;*/
    }

    @Override
    public void removeAt(int index) {
        validateBounds(index);
        H[] tmp = (H[])new Object[maxCapacity];
        for (int idxTmp = 0, idxData = 0; idxData < size; ) {
            if (idxData != index) {
                tmp[idxTmp] = data[idxData];
                idxData++;
                idxTmp++;
            } else {
                idxData++;
            }

        }
        data = tmp;
        size--;
    }

    @Override
    public int getSize() {
        return maxCapacity;
    }

    @Override
    public int indexOf(H element) {
        return 0;
    }

    @Override
    public IIterator<H> iterator() {
        return null;
    }

    @Override
    public IIterator<H> reverseIterator() {
        LinkedList<String> a = new LinkedList<>();
        LinkedList.LinkedListIterator2<String> b = new LinkedList.LinkedListIterator2<>(null);
        LinkedList.LinkedListIterator3 c = a.new LinkedListIterator3();
        return null;
    }

    @Override
    protected void validateBounds(int index) {
        if (index > maxCapacity) {
            throw new IndexOutOfBoundsException(String.format("Index out of range {%d}", index));
        }
    }
}
