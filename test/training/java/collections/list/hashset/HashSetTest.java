package training.java.collections.list.hashset;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import training.java.collections.list.IIterator;

public class HashSetTest {
    @Test
    public void whenItemAdded_thenSizeOne(){
        ISet<String> hashSet = new HashSet<>();
        hashSet.add("One");

        Assertions.assertEquals(1,hashSet.getSize());
    }

    @Test
    public void whenItemAdded_thenHasNext(){
        ISet<String> hashSet = new HashSet<>();
        hashSet.add("One");

        IIterator<String> iterator = hashSet.iterator();
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("One",iterator.next());
    }
}
