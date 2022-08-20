package training.java.collections.list;

import training.java.collections.list.exceptions.NotNullValueAllowedException;

public class BaseList {
    protected int size;
    protected void checkNullValue(String element) {
        if (element == null) {
            throw new NotNullValueAllowedException();
        }
    }

    protected void validateBounds(int index) {
        if (index > this.size) {
            throw new IndexOutOfBoundsException(String.format("Index out of range {%d}", index));
        }
    }
}
