import components.map.Map;
import components.map.Map.Pair;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.standard.Standard;

/**
 * Interface for a to-do list kernel component with primary methods.
 *
 * This interface defines methods for managing to-do list events, including
 * adding events, retrieving their importance and date, and converting
 * importance and date values to strings.
 *
 * This interface also includes fields for storing event information and sorted
 * queues for efficient retrieval and sorting of events by importance and date.
 *
 * @initially <pre>
 *  ensures
 *   event = "" and
 *   allEventsImp = {} and
 *   allEventsDate = {} and
 *   sortedByImp = <>, sortedByDate = <>
 * </pre>
 *
 * @author Jahnavi Acharya
 */
public interface ToDoListKernel extends Standard<ToDoList> {

    /**
     * Constant representing an empty string for the event.
     */
    String EVENT = "";

    /**
     * Map containing all events and their importance.
     */
    Map<String, Integer> ALL_EVENTS_IMP = new Map1L<String, Integer>();

    /**
     * Map containing all events and their date.
     */
    Map<String, Integer> ALL_EVENTS_DATE = new Map1L<String, Integer>();

    /**
     * Queue containing pairs of events and their importance, sorted by
     * importance.
     */
    Queue<Pair<String, Integer>> SORTED_BY_IMP = new Queue1L<>();

    /**
     * Queue containing pairs of events and their date, sorted by date.
     */
    Queue<Pair<String, Integer>> SORTED_BY_DATE = new Queue1L<>();

    /**
     * Retrieves the importance of the specified event.
     *
     * @param event
     *            the event to retrieve importance for
     * @requires The specified event exists in {@code ALL_EVENTS_IMP}.
     * @ensures Returns the importance of the specified event.
     * @return the importance number of the event
     */
    int getImportance(String event);

    /**
     * Retrieves the date of the specified event.
     *
     * @param event
     *            the event to retrieve date for
     * @requires The specified event exists in {@code ALL_EVENTS_IMP}.
     * @ensures Returns the date of the specified event in the right format of
     *          YearMonthDay.
     * @return the date number of the event
     */
    int getDate(String event);

    /**
     * Adds importance for the specified event.
     *
     * @param event
     *            the event to add importance for
     * @param imp
     *            the importance to add
     * @requires event to be a key in {@code ALL_EVENTS_IMP} and imp is an
     *           Integer between -1 and 3 inclusive.
     * @ensures updates the importance for the specified event.
     */
    void addImportance(String event, int imp);

    /**
     * Adds date for the specified event.
     *
     * @param event
     *            the event to add date for
     * @param date
     *            the date to add
     * @requires event to be a key in {@code ALL_EVENTS_IMP} and date is a 6
     *           digit integer in the format YearMonthDay.
     * @ensures updates the date for the specified event.
     */
    void addDate(String event, int date);

    /**
     * Converts the given importance value to a string representation.
     *
     * @param i
     *            the importance value to convert
     * @requires i to be an integer between -1 and 3 inclusive.
     * @ensures Returns the string representation of the importance.
     * @return the string representation of the importance
     */
    String getStringImportance(int i);

    /**
     * Converts the given date value to a string representation.
     *
     * @param i
     *            the date value to convert
     * @requires i to be a 6 digit integer in the format YearMonthDay.
     * @ensures Returns the string representation of the date.
     * @return the string representation of the date
     */
    String getStringDate(int i);

    /**
     * Retrieves the map containing all events and their importance.
     *
     * @return the map containing all events and their importance
     */
    Map<String, Integer> getAllEventsImp();

    /**
     * Retrieves the map containing all events and their date.
     *
     * @return the map containing all events and their date
     */
    Map<String, Integer> getAllEventsDate();

    /**
     * Retrieves the queue containing pairs of events and their importance,
     * sorted by importance.
     *
     * @return the queue containing pairs of events and their importance, sorted
     *         by importance
     */
    Queue<Pair<String, Integer>> getSortedByImp();

    /**
     * Retrieves the queue containing pairs of events and their date, sorted by
     * date.
     *
     * @return the queue containing pairs of events and their date, sorted by
     *         date
     */
    Queue<Pair<String, Integer>> getSortedByDate();

    /**
     * Sets the map containing all events and their importance.
     *
     * @param o
     *            a ToDoList object
     * @requires o is not null
     *
     * @this = #o
     */
    void setAllEventsImp(ToDoList o);

    /**
     * Sets the map containing all events and their date.
     *
     * @param o
     *            a ToDoList object
     * @requires o is not null
     *
     * @this = #o
     */
    void setAllEventsDate(ToDoList o);

    /**
     * Sets the queue containing pairs of events and their importance, sorted by
     * importance.
     *
     * @param o
     *            a ToDoList object
     * @requires o is not null
     *
     * @this = #o
     */
    void setSortedByImp(ToDoList o);

    /**
     * Sets the queue containing pairs of events and their date, sorted by date.
     *
     * @param o
     *            a ToDoList object
     * @requires o is not null
     *
     * @this = #o
     */
    void setSortedByDate(ToDoList o);

}
