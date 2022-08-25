package training.java.collections.list.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import training.java.collections.list.IList;
import training.java.collections.list.arraylist.ArrayList;

public class LinkedListTest {

    @Test
    void whenListIsCreated_thenSizeZero(){
        //given
        IList list = new LinkedList();

        //when
        int size = list.getSize();

        //then
        Assertions.assertEquals(0,size);
    }

    @Test
    void whenItemAdded_thenSizeOne() throws Exception {
        //given
        IList list = new LinkedList();

        //when

        list.add("One");

        //then
        Assertions.assertEquals(1,list.getSize());
        Assertions.assertEquals("One",list.getAt(0));
    }
    @Test
    void whenOutOfIndex_thenException()  {
        //given
        IList list = new LinkedList();

        //when
        //then
        try {
            list.getAt(0);
            Assertions.fail("Invalid index");
        } catch (Exception e) {
            Assertions.assertEquals("Index out of range {0}",e.getMessage());
        }
    }
    /*@Test
    void whenIterate() throws Exception {
        LinkedList list = new LinkedList();
        list.add("One");
        list.add("Three");
        list.iterate();
        System.out.println("New Iteration");
        list.setAt(1,"Two");
        list.iterate();

        Assertions.assertEquals(1,1);
    }*/

    @Test
    void whenItemAdded_thenItemFound() throws Exception {
        //given
        IList list = new LinkedList();

        //when
        list.add("One");

        //then
        Assertions.assertEquals(true, list.contains("One"));

    }

    @Test
    void whenItemAdded_thenItemNotFound() throws Exception {
        //given
        IList list = new LinkedList();

        //when
        list.add("One");

        //then
        Assertions.assertEquals(false, list.contains("Two"));

    }

    @Test
    void whenItemRemoved_thenSizeDecreased() throws Exception {
        //given
        IList list = new LinkedList();
        list.add("One");
        list.add("Two");
        list.add("Three");
        //when
        list.removeAt(1);

        //then
        Assertions.assertEquals(2,list.getSize());

    }

    @Test
    void whenFirstItemRemoved_thenSizeDecreased() throws Exception {
        //given
        IList list = new LinkedList();
        list.add("One");
        list.add("two");

        //when
        list.removeAt(0);

        //then
        Assertions.assertEquals(1,list.getSize());

    }

    @Test
    void whenLastItemRemoved_thenSizeDecreased() throws Exception {
        //given
        IList list = new LinkedList();
        list.add("One");
        list.add("Two");
        list.add("Three");
        //when
        list.removeAt(2);

        //then
        Assertions.assertEquals(2,list.getSize());

    }

    @Test
    void whenItemAddedAtIndex_thenArrayOffset() throws Exception {
        //given
        IList list = new LinkedList();
        list.add("One");
        list.add("Three");
        list.add("Four");

        //when
        list.setAt(1,"Two");

        //then
        Assertions.assertEquals("One",list.getAt(0));
        Assertions.assertEquals("Two",list.getAt(1));
        Assertions.assertEquals("Four",list.getAt(2));
    }

    @Test
    void whenItemAddedAtZeroIndex_thenHeadChanges() throws Exception {
        //given
        IList list = new LinkedList();
        list.add("Two");

        //when
        list.setAt(0, "One");

        //then
        Assertions.assertEquals("One", list.getAt(0));
    }


    @Test
    void whenItemAddedAtInvalidIndex_thenException()  {
        //given
        IList list = new LinkedList();
        list.add("One");


        //when
        try {
            list.setAt(2,"Two");
        } catch (Exception ex) {
            Assertions.assertEquals("Index out of range {2}",ex.getMessage());
        }
    }


}
