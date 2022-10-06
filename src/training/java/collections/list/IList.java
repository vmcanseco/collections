package training.java.collections.list;

import training.java.collections.IIterator;

public interface IList<T> {
    void add(T element);

    boolean contains(T element);

    T getAt(int index);

    void setAt(int index, T element);

    void removeAt(int index);

    int getSize();

    int  indexOf(T element);

    IIterator<T> iterator();

    IIterator<T> reverseIterator();
}
