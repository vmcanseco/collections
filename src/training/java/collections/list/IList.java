package training.java.collections.list;

import training.java.collections.list.exceptions.NotNullValueAllowedException;

public interface IList {
    void add(String element);

    boolean contains(String element);

    String getAt(int index);

    void setAt(int index, String element);

    void removeAt(int index);

    int getSize();



}
