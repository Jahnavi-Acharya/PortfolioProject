import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ToDoList1Test {

    //Note Couldn't get newInstance, compareTo, and transferFrom to really work.
    /**
     * Tests getImportance for a high importance value.
     */
    @Test
    public void testGetImportanceOne() {
        ToDoList test = new ToDoList1();
        test.addEvent("clean", 3, 240506);
        assertEquals(test.getImportance("clean"), 3);
    }

    /**
     * Tests getImportance for a completed importance value.
     */
    @Test
    public void testGetImportanceTwo() {
        ToDoList test = new ToDoList1();
        test.addEvent("sweep", -1, 250809);
        assertEquals(test.getImportance("sweep"), -1);
    }

    /**
     * Tests getImportance for a default importance value.
     */
    @Test
    public void testGetImportanceThree() {
        ToDoList test = new ToDoList1();
        test.addEvent("homework");
        assertEquals(test.getImportance("homework"), 0);
    }

    /**
     * Tests getDate for a default date value: no date.
     */
    @Test
    public void testGetDateOne() {
        ToDoList test = new ToDoList1();
        test.addEvent("something");
        assertEquals(test.getDate("something"), 0);
    }

    /**
     * Tests getDate for a date for a non-completed event.
     */
    @Test
    public void testGetDateTwo() {
        ToDoList test = new ToDoList1();
        test.addEvent("hi", 0, 250930);
        assertEquals(test.getDate("hi"), 250930);
    }

    /**
     * Tests getDate for a date for a completed event.
     */
    @Test
    public void testGetDateThree() {
        ToDoList test = new ToDoList1();
        test.addEvent("hi", -1, 250930);
        assertEquals(test.getDate("hi"), 250930);
    }

    /**
     * Updates importance to a noncompleted event from 1 to 3.
     */
    @Test
    public void testAddImportance1() {
        ToDoList test = new ToDoList1();
        test.addEvent("hi", 1, 250930);
        test.addImportance("hi", 3);
        assertEquals(test.getImportance("hi"), 3);
    }

    /**
     * Updates importance to a completed event from -1 to 0.
     */
    @Test
    public void testAddImportance2() {
        ToDoList test = new ToDoList1();
        test.addEvent("sing", -1, 250930);
        test.addImportance("sing", 0);
        assertEquals(test.getImportance("sing"), 0);
    }

    /**
     * Updates date from a default value.
     */
    @Test
    public void testAddDate1() {
        ToDoList test = new ToDoList1();
        test.addEvent("sing");
        test.addDate("sing", 241007);
        assertEquals(test.getDate("sing"), 241007);
    }

    /**
     * Updates date to a new date.
     */
    @Test
    public void testAddDate2() {
        ToDoList test = new ToDoList1();
        test.addEvent("dance", 0, 341204);
        test.addDate("dance", 241007);
        assertEquals(test.getDate("dance"), 241007);
    }

    /**
     * Gets string importance for -1 --> Completed.
     */
    @Test
    public void testGetStringImportance1() {
        ToDoList test = new ToDoList1();
        assertEquals(test.getStringImportance(-1), "Completed");
    }

    /**
     * Gets string importance for 0 --> Not Important.
     */
    @Test
    public void testGetStringImportance2() {
        ToDoList test = new ToDoList1();
        assertEquals(test.getStringImportance(0), "No Importance");
    }

    /**
     * Gets string importance for 1 --> Low Importance.
     */
    @Test
    public void testGetStringImportance3() {
        ToDoList test = new ToDoList1();
        assertEquals(test.getStringImportance(1), "Low Importance");
    }

    /**
     * Gets string importance for 2 --> Medium Important.
     */
    @Test
    public void testGetStringImportance4() {
        ToDoList test = new ToDoList1();
        assertEquals(test.getStringImportance(2), "Medium Importance");
    }

    /**
     * Gets string importance for 3 --> High Importance.
     */
    @Test
    public void testGetStringImportance5() {
        ToDoList test = new ToDoList1();
        assertEquals(test.getStringImportance(3), "High Importance");
    }

    /**
     * Gets string representation of date 241209 ->12/9/24.
     */
    @Test
    public void testGetStringDate1() {
        ToDoList test = new ToDoList1();
        assertEquals(test.getStringDate(241209), "12/9/24");
    }

    /**
     * Gets string representation of default date value.
     */
    @Test
    public void testGetStringDate2() {
        ToDoList test = new ToDoList1();
        assertEquals(test.getStringDate(0), "No Date");
    }

    /**
     * Tests the clear method on empty ToDoList.
     */
    @Test
    public void testClear1() {
        ToDoList test = new ToDoList1();
        test.clear();
        assertEquals(test.getAllEventsImp().size(), 0);
        assertEquals(test.getAllEventsDate().size(), 0);
        assertEquals(test.getSortedByImp().length(), 0);
        assertEquals(test.getSortedByDate().length(), 0);
    }

    /**
     * Tests the clear method on 1 input in ToDoList.
     */
    @Test
    public void testClear2() {
        ToDoList test = new ToDoList1();
        test.addEvent("clean");
        test.clear();
        assertEquals(test.getAllEventsImp().size(), 0);
        assertEquals(test.getAllEventsDate().size(), 0);
        assertEquals(test.getSortedByImp().length(), 0);
        assertEquals(test.getSortedByDate().length(), 0);
    }

    /**
     * Tests the clear method on multiple inputs in ToDoList.
     */
    @Test
    public void testClear3() {
        ToDoList test = new ToDoList1();
        test.addEvent("clean");
        test.addEvent("sweep", 2, 241230);
        test.addEvent("sleep", 0, 251006);
        test.addEvent("have fun", 3, 0);
        test.clear();
        assertEquals(test.getAllEventsImp().size(), 0);
        assertEquals(test.getAllEventsDate().size(), 0);
        assertEquals(test.getSortedByImp().length(), 0);
        assertEquals(test.getSortedByDate().length(), 0);
    }

    /**
     * Tests the newInstance method by creating a newInstance of a ToDoList
     * object with no items in it.
     */
    @Test
    public void testNewInstance1() {
        ToDoList test = new ToDoList1();
        ToDoList newInstance = test.newInstance();
        assertEquals(newInstance.getAllEventsImp().size(), 0);
        assertEquals(newInstance.getAllEventsDate().size(), 0);
        assertEquals(newInstance.getSortedByImp().length(), 0);
        assertEquals(newInstance.getSortedByDate().length(), 0);
    }

    /**
     * Tests the newInstance method by creating a newInstance of a ToDoList
     * object with items in it.
     */
    @Test
    public void testNewInstance2() {
        ToDoList test = new ToDoList1();
        test.addEvent("clean");
        test.addEvent("sweep", 2, 241230);
        test.addEvent("sleep", 0, 251006);
        test.addEvent("have fun", 3, 0);
        ToDoList newInstance = test.newInstance();
        assertEquals(newInstance.getAllEventsImp().size(), 0);
        assertEquals(newInstance.getAllEventsDate().size(), 0);
        assertEquals(newInstance.getSortedByImp().length(), 0);
        assertEquals(newInstance.getSortedByDate().length(), 0);
    }

    /**
     * Tests getAllEventsImp() with multiple Elements.
     */
    @Test
    public void testGetAllEventsImp1() {
        ToDoList test = new ToDoList1();
        assertEquals(test.getAllEventsImp().size(), 0);
        test.addEvent("clean");
        test.addEvent("sweep", 2, 241230);
        test.addEvent("sleep", 0, 251006);
        test.addEvent("have fun", 3, 0);
        assertEquals(test.getAllEventsImp().size(), 4);
    }

    /**
     * Tests getAllEventsImp() with 0 Elements.
     */
    @Test
    public void testGetAllEventsImp2() {
        ToDoList test = new ToDoList1();
        assertEquals(test.getAllEventsImp().size(), 0);
    }

    /**
     * Tests getAllEventsDate() with multiple Elements.
     */
    @Test
    public void testGetAllEventsDate1() {
        ToDoList test = new ToDoList1();
        assertEquals(test.getAllEventsDate().size(), 0);
        test.addEvent("clean");
        test.addEvent("sweep", 2, 241230);
        test.addEvent("sleep", 0, 251006);
        test.addEvent("have fun", 3, 0);
        assertEquals(test.getAllEventsDate().size(), 4);
    }

    /**
     * Tests getAllEventsDate() with 0 Elements.
     */
    @Test
    public void testGetAllEventsDate2() {
        ToDoList test = new ToDoList1();
        assertEquals(test.getAllEventsDate().size(), 0);
    }

    /**
     * Tests getSortedByImp() with multiple Elements.
     */
    @Test
    public void testGetSortedByImp1() {
        ToDoList test = new ToDoList1();
        assertEquals(test.getSortedByImp().length(), 0);
        test.addEvent("clean");
        test.addEvent("sweep", 2, 241230);
        test.addEvent("sleep", 0, 251006);
        test.addEvent("have fun", 3, 0);
        assertEquals(test.getSortedByImp().length(), 0);
        test.orderByImportance();
        assertEquals(test.getSortedByImp().length(), 4);
    }

    /**
     * Tests getSortedByDate() with multiple Elements.
     */
    @Test
    public void testGetSortedByDate1() {
        ToDoList test = new ToDoList1();
        assertEquals(test.getSortedByImp().length(), 0);
        test.addEvent("clean");
        test.addEvent("sweep", 2, 241230);
        test.addEvent("sleep", 0, 251006);
        test.addEvent("have fun", 3, 0);
        assertEquals(test.getSortedByImp().length(), 0);
        test.orderByDate();
        assertEquals(test.getSortedByDate().length(), 4);
    }

    /**
     * Tests getSortedByImp() with multiple Elements.
     */
    @Test
    public void testGetSortedByImp11() {
        ToDoList test = new ToDoList1();
        assertEquals(test.getSortedByImp().length(), 0);
        test.addEvent("clean");
        test.addEvent("sweep", 2, 241230);
        test.addEvent("sleep", 0, 251006);
        test.addEvent("have fun", 3, 0);
        assertEquals(test.getSortedByImp().length(), 0);
        test.orderByImportance();
        assertEquals(test.getSortedByImp().length(), 4);
    }

}
