import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ToDoListSecondaryTest {

    /**
     * Tests addEvent for adding only event.
     */
    @Test
    public void testAddEvent1() {
        ToDoList test = new ToDoList1();
        test.addEvent("clean");
        assertEquals(test.getImportance("clean"), 0);
        assertEquals(test.getDate("clean"), 0);
    }

    /**
     * Tests addEvent for adding event, importance, and date.
     */
    @Test
    public void testAddEvent2() {
        ToDoList test = new ToDoList1();
        test.addEvent("clean", 3, 121212);
        assertEquals(test.getImportance("clean"), 3);
        assertEquals(test.getDate("clean"), 121212);
    }

    /**
     * Tests removeEvent.
     */
    @Test
    public void testRemoveEvent() {
        ToDoList test = new ToDoList1();
        test.addEvent("homework", 3, 121212);
        test.removeEvent("homework", 240419);
        assertEquals(test.getImportance("homework"), -1);
        assertEquals(test.getDate("homework"), 240419);
    }

    /**
     * Tests orderByImportance.
     */
    @Test
    public void testOrderByImportance() {
        ToDoList test = new ToDoList1();
        test.addEvent("homework", 3, 121212);
        test.addEvent("clean", -1, 240419);
        test.addEvent("music", 2, 0);
        test.orderByImportance();
        assertEquals(test.getSortedByImp().dequeue().key(), "homework");
        assertEquals(test.getSortedByImp().dequeue().key(), "music");
        assertEquals(test.getSortedByImp().dequeue().key(), "clean");
    }

    /**
     * Tests orderByDate.
     */
    @Test
    public void testOrderByDate() {
        ToDoList test = new ToDoList1();
        test.addEvent("homework", 3, 121212);
        test.addEvent("clean", -1, 240419);
        test.addEvent("music", 2, 0);
        test.orderByImportance();
        assertEquals(test.getSortedByImp().dequeue().key(), "homework");
        assertEquals(test.getSortedByImp().dequeue().key(), "music");
        assertEquals(test.getSortedByImp().dequeue().key(), "clean");
    }

}
