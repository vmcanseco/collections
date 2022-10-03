package training.java.collections.list.hashset;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import training.java.collections.list.IIterator;

public class LinkedHashSetTest {

    @Test
    public void whenItemsAdded_thenHasNext(){
        ISet<String> hashSet = new LinkedHashSet<>();
        hashSet.add("One");
        hashSet.add("Two");
        hashSet.add("Three");

        IIterator<String> iterator = hashSet.iterator();
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("One",iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Two",iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Three",iterator.next());
        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    public void whenItemAdded_thenSizeIncreased(){
        ISet<String> hashSet = new LinkedHashSet<>();
        hashSet.add("One");

        Assertions.assertEquals(1,hashSet.getSize());
    }

    @Test
    public void whenItemAdded_thenItemFound(){
        ISet<String> hashSet = new LinkedHashSet<>();
        hashSet.add("One");

        Assertions.assertTrue(hashSet.contains("One"));
    }

    @Test
    public void whenItemNotAdded_thenNotFound(){
        ISet<String> hashSet = new LinkedHashSet<>();
        hashSet.add("One");

        Assertions.assertFalse(hashSet.contains("Two"));
    }

    @Test
    public void whenSameItem_thenNotAdded(){
        ISet<String> hashSet = new LinkedHashSet<>();
        hashSet.add("One");
        hashSet.add("One");
        IIterator<String> iterator = hashSet.iterator();

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("One",iterator.next());
        Assertions.assertFalse(iterator.hasNext());
        Assertions.assertEquals(1,hashSet.getSize());
    }

    @Test
    public void whenMultipleItemsAdded_thenOrdered(){
        ISet<String> hashSet = new LinkedHashSet<>();
        for (int i =1;i<=16;i++){
            hashSet.add(String.valueOf(i));
        }
        IIterator<String> iterator = hashSet.iterator();
        int i=1;
        while (iterator.hasNext()){
            Assertions.assertEquals(String.valueOf(i),iterator.next());
            i++;
        }
    }

    @Test
    public void whenItemRemoved_thenNoElements(){
        ISet<String> hashSet = new LinkedHashSet<>();
        hashSet.add("One");

        Assertions.assertTrue(hashSet.remove("One"));
        Assertions.assertEquals(0,hashSet.getSize());
    }

    @Test
    public void whenItemNotAdded_thenCantRemove(){
        ISet<String> hashSet = new LinkedHashSet<>();
        hashSet.add("One");

        Assertions.assertFalse(hashSet.remove("Two"));
        Assertions.assertEquals(1,hashSet.getSize());
    }

    @Test
    public void whenItemRemoved_thenOrderKept(){
        ISet<String> hashSet = new LinkedHashSet<>();
        hashSet.add("One");
        hashSet.add("Two");
        hashSet.add("Three");
        hashSet.add("Four");
        hashSet.add("Five");

        IIterator<String> iterator = hashSet.iterator();
        Assertions.assertTrue(hashSet.remove("Three"));
        Assertions.assertEquals("One",iterator.next());
        Assertions.assertEquals("Two",iterator.next());
        Assertions.assertEquals("Four",iterator.next());
        Assertions.assertEquals("Five",iterator.next());
    }

    @Test
    public void whenItemRemoved_thenSequenceKept(){
        ISet<String> hashSet = new LinkedHashSet<>();
        for (int i =1;i<=80;i++){
            hashSet.add(String.valueOf(i));
        }
        Assertions.assertTrue(hashSet.remove(String.valueOf(50)));
        Assertions.assertFalse(hashSet.contains(String.valueOf(50)));
        IIterator<String> iterator = hashSet.iterator();
        int i=1;
        while (iterator.hasNext()){
            if (i!=50){
                Assertions.assertEquals(String.valueOf(i),iterator.next());
            }
            i++;
        }
    }
}
