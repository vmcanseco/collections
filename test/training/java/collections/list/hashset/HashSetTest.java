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

    @Test
    public void whenItemAdded_thenOnlyOneNext(){
        ISet<String> hashSet = new HashSet<>();
        hashSet.add("One");

        IIterator<String> iterator = hashSet.iterator();
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    public void whenItemAdded_thenElementFound(){
        ISet<String> hashSet = new HashSet<>();
        hashSet.add("One");

        Assertions.assertTrue(hashSet.contains("One"));

    }

    @Test
    public void whenNoItemAdded_thenElementNotFound(){
        ISet<String> hashSet = new HashSet<>();
        hashSet.add("One");

        Assertions.assertFalse(hashSet.contains("Two"));

    }

    @Test
    public void whenItemRemoved_thenTrue(){
        String value="One";
        System.out.println(value.hashCode());
        ISet<String> hashSet = new HashSet<>();
        hashSet.add(value);

        boolean removed=hashSet.remove(value);
        Assertions.assertTrue(removed);
        //System.out.println(hashSet.getSize());
        Assertions.assertEquals(0,hashSet.getSize());

    }
}
