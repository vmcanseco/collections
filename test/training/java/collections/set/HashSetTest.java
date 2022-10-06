package training.java.collections.set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import training.java.collections.IIterator;

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
        Assertions.assertEquals("One",iterator.next());
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

    @Test
    public  void whenMultiplesItemAdded_thenRedistribute(){
         final int LIMIT=90;
        ISet<String> hashSet = new HashSet<>();
        String first=null,firstAfter;
        for(int i=0;i<LIMIT;i++){
            hashSet.add(String.valueOf(i));
            if (i==0){
                first = hashSet.iterator().next();
            }
        }
        firstAfter = hashSet.iterator().next();
        Assertions.assertNotEquals(first,firstAfter);

    }
}
