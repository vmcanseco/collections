package training.java.collections.map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import training.java.collections.IIterator;
import java.util.NoSuchElementException;


public class HashMapTest {

    @Test
    public void whenItemAdded_thenSizeOne(){
        IMap<String, String> hashMap = new HashMap<>();
        hashMap.put("One","Uno");

        Assertions.assertEquals(1,hashMap.getSize());
    }

    @Test
    public void whenItemAdded_thenHasNext(){
        IMap<String, String> hashMap = new HashMap<>();
        hashMap.put("One","Uno");

        IIterator<Entry<String, String>> iterator = hashMap.iterator();
        Assertions.assertTrue(iterator.hasNext());
        Entry<String,String> entry = iterator.next();
        Assertions.assertEquals("One",entry.getKey());
        Assertions.assertEquals("Uno",entry.getValue());
    }

    @Test
    public void whenItemAdded_thenOnlyOneNext(){
        IMap<String, String> hashMap = new HashMap<>();
        hashMap.put("One","Uno");

        IIterator<Entry<String, String>> iterator = hashMap.iterator();
        Assertions.assertTrue(iterator.hasNext());
        Entry<String,String> entry = iterator.next();
        Assertions.assertEquals("One",entry.getKey());
        Assertions.assertEquals("Uno",entry.getValue());
        Assertions.assertFalse(iterator.hasNext());
        Assertions.assertThrows(NoSuchElementException.class, iterator::next);

    }

    @Test
    public void whenItemAdded_thenKeyFound(){
        IMap<String, String> hashMap = new HashMap<>();
        hashMap.put("One","Uno");

        Assertions.assertTrue(hashMap.containsKey("One"));

    }


    @Test
    public void whenNoItemAdded_thenKeyNotFound(){
        IMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Two","Dos");

        Assertions.assertFalse(hashMap.containsKey("One"));

    }

    @Test
    public void whenItemAdded_thenGetValue(){
        IMap<String, String> hashMap = new HashMap<>();
        hashMap.put("One","Uno");

        Assertions.assertEquals("Uno",hashMap.get("One"));
    }

    @Test
    public void whenItemNotAdded_thenException(){
        IMap<String, String> hashMap = new HashMap<>();
        hashMap.put("One","Uno");

            Assertions.assertThrows(NoSuchElementException.class,()->{
                hashMap.get("Two");
            });
    }
    @Test
    public void whenItemAdded_thenValueFound(){
        IMap<String, String> hashMap = new HashMap<>();
        hashMap.put("One","Uno");

        Assertions.assertTrue(hashMap.containsValue("Uno"));

    }

    @Test
    public void whenNoItemAdded_thenValueNotFound(){
        IMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Two","Dos");

        Assertions.assertFalse(hashMap.containsValue("One"));

    }

    @Test
    public void whenItemDuplicated_thenNotAdded(){
        IMap<String, String> hashMap = new HashMap<>();
        hashMap.put("One","Uno");
        hashMap.put("One","Uno");
        Assertions.assertEquals(1,hashMap.getSize());

    }


    @Test
    public  void whenMultiplesItemAdded_thenRedistribute(){
        final int LIMIT=90;
        IMap<String, Integer> hashMap = new HashMap<>();
        Entry<String,Integer> first=null,firstAfter;
        for(int i=0;i<LIMIT;i++){
            hashMap.put(String.valueOf(i),i);
            if (i==0){
                first = hashMap.iterator().next();
            }
        }
        firstAfter = hashMap.iterator().next();
        Assertions.assertNotEquals(first,firstAfter);

    }


}
