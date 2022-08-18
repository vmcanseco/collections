package training.java.collections.list.arraylist;

import training.java.collections.list.IList;

public class ArrayList implements IList {
    private int size=0;
    private String[] data=new String[0];


    @Override
    public void add(String element) {
        size++;
        String[] tmp = new String[size];
        int idx=0;
        for (String value:data){
            tmp[idx] = value;
            idx++;
        }
        tmp[idx]=element;
        data = tmp;
    }

    @Override
    public boolean contains(String element) {
        boolean found=false;
        for (String value:data){
            if (value.equals(element)){
                found =true;
                break;
            }
        }
        return found;
    }

    @Override
    public String getAt(int index) throws Exception {
        validateBounds(index);
        return data[index];
    }

    @Override
    public void setAt(int index,String element) throws Exception {
        validateBounds(index);
        size++;
        String tmp[] = new String[size];

        for (int idxTmp = 0,idxData=0;idxTmp<size;){
            if (idxTmp != index){
                tmp[idxTmp] = data[idxData];
                idxData++;
            }else {
                tmp[idxTmp] = element;
            }
            idxTmp++;
        }
        data = tmp;
    }

    @Override
    public void removeAt(int index) throws Exception {
        validateBounds(index);
        size--;
        String[] tmp = new String[size];
        int idx=0;
        for (String value:data){
            if (idx != index){
                tmp[idx]=value;
                idx++;
            }
        }
        data = tmp;
    }

    @Override
    public int getSize() {
        return size;
    }

    private void validateBounds(int index) throws Exception {
        if (index > this.size) {
            throw new Exception(String.format("Index out of range {%d}", index));
        }
    }

}
