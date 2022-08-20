package training.java.collections.list.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import training.java.collections.list.IList;
import training.java.collections.list.exceptions.NotNullValueAllowedException;
import training.java.collections.list.linkedlist.LinkedList;

public class ArrayListTest {
    @Test
    void whenItemAdded_thenSizeOne() throws Exception {
        //given
        IList list = new ArrayList();

        //when
        list.add("One");

        //then
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("One", list.getAt(0));

    }

    @Test
    void whenItemAdded_thenItemFound() throws Exception {
        //given
        IList list = new ArrayList();

        //when
        list.add("One");

        //then
        Assertions.assertTrue(list.contains("One"));

    }

    @Test
    void whenItemAdded_thenItemNotFound() {
        //given
        IList list = new ArrayList();

        //when
        list.add("One");

        //then
        Assertions.assertFalse(list.contains("Two"));

    }
    @Test
    void whenItemRemoved_thenSizeDecreased() throws Exception {
        //given
        IList list = new ArrayList();
        list.add("One");
        list.add("Two");
        list.add("Three");

        //when
        list.removeAt(1);

        //then
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertEquals("One",list.getAt(0));
        Assertions.assertEquals("Three",list.getAt(1));

    }
    @Test
    void whenItemAddedAtIndex_thenArrayOffset() throws Exception {
        //given
        IList list = new ArrayList();
        list.add("One");
        list.add("Three");
        list.add("Three");

        //when
        list.setAt(1,"Two");

        //then
        Assertions.assertEquals("One",list.getAt(0));
        Assertions.assertEquals("Two",list.getAt(1));
        Assertions.assertEquals("Three",list.getAt(2));
        Assertions.assertEquals(3,list.getSize());
    }
    @Test
    void whenItemAddedAtInvalidIndex_thenException()  {
        //given
        IList list = new ArrayList();
        list.add("One");


        //when
        try {
            list.setAt(2,"Two");
            Assertions.fail();
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertEquals("Index out of range {2}",ex.getMessage());
        }
    }

    @Test
    void whenGettingItemdAtInvalidIndex_thenException()  {
        //given
        IList list = new ArrayList();
        list.add("One");

        //when
        try {
            list.getAt(2);
            Assertions.fail();
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertEquals("Index out of range {2}",ex.getMessage());
        }
    }

    @Test
    void whenNullItemAdded_thenException(){
        //given
        IList list = new ArrayList();

        //when
        try{
            list.add(null);
            Assertions.fail();
        }catch (NotNullValueAllowedException ex){

        }


        //thenn
    }

}
