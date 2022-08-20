package training.java.collections.list.arraylist;

import training.java.collections.list.BaseList;
import training.java.collections.list.IList;

public class ArrayList extends BaseList implements IList {
    private int maxCapacity = 2;
    private String[] data;

    ArrayList() {
        data = new String[maxCapacity];
    }


    @Override
    public void add(String element) {
        checkNullValue(element);
        if (size == maxCapacity) {
            maxCapacity *= 2;
            String[] tmp = new String[maxCapacity];
            int idx = 0;
            for (String value : data) {
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
    public boolean contains(String element) {
        checkNullValue(element);
        boolean found = false;
        for (String value : data) {
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
    public String getAt(int index) {
        validateBounds(index);
        return data[index];
    }

    @Override
    public void setAt(int index, String element) {
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
        String[] tmp = new String[maxCapacity];
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
        return size;
    }


}
