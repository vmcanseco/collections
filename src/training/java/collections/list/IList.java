package training.java.collections.list;

public interface IList {
    void add(String element);

    boolean contains(String element);

    String getAt(int index) throws Exception;

    void setAt(int index, String element) throws Exception;

    void removeAt(int index) throws Exception;

    int getSize();

}