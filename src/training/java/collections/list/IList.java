package training.java.collections.list;

public interface IList<T> {
    void add(T element);

    boolean contains(T element);

    T getAt(int index);

    void setAt(int index, T element);

    void removeAt(int index);

    int getSize();

    IIterator<T> iterator();

    IIterator<T> reverseIterator();
}
