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
            Assertions.assertEquals("Index out of range {0} ",e.getMessage());
        }
    }
    @Test
    void whenIterate() throws Exception {
        LinkedList list = new LinkedList();
        list.add("One");
        list.add("Three");
        list.iterate();
        System.out.println("New Iteration");
        list.setAt(1,"Two");
        list.iterate();

        Assertions.assertEquals(1,1);
    }

}
