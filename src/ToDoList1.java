import components.map.Map;
import components.map.Map.Pair;
import components.queue.Queue;

/**
 * Manages a to-do list with event details and sorting capabilities.
 *
 * Provides methods for adding events, setting their importance and date, and
 * converting importance and date values to strings. Includes fields for storing
 * event information and sorted queues for efficient retrieval.
 *
 * @Convention Importance values range from -1 to 3, representing different
 *             levels of importance. Date values are 6-digit integers in the
 *             format YearMonthDay.
 *
 * @Correspondence - {@code event}: String representation of an event. -
 *                 {@code ALL_EVENTS_IMP}: Map of events and their importance. -
 *                 {@code ALL_EVENTS_DATE}: Map of events and their date. -
 *                 {@code SORTED_BY_IMP}: Queue of events sorted by importance.
 *                 - {@code SORTED_BY_DATE}: Queue of events sorted by date.
 *
 * @author Jahnavi Acharya
 */
public class ToDoList1 extends ToDoListSecondary {

    //NOTE: Couldn't really get transferFrom, compareTo, and newInstance to work
    public ToDoList1() {
        this.clear();
    }

    @Override
    public final int getImportance(String event) {
        // TODO Auto-generated method stub
        return ALL_EVENTS_IMP.value(event);
    }

    @Override
    public final int getDate(String event) {
        // TODO Auto-generated method stub
        return ALL_EVENTS_DATE.value(event);
    }

    @Override
    public final void addImportance(String event, int imp) {
        ALL_EVENTS_IMP.replaceValue(event, imp);

    }

    @Override
    public final void addDate(String event, int date) {
        ALL_EVENTS_DATE.replaceValue(event, date);

    }

    @Override
    public final String getStringImportance(int i) {
        String imp = "";
        if (i == 0) {
            imp = "No Importance";
        } else if (i == 1) {
            imp = "Low Importance";
        } else if (i == 2) {
            imp = "Medium Importance";
        } else if (i == 3) {
            imp = "High Importance";
        } else {
            imp = "Completed";
        }
        return imp;
    }

    @Override
    public final String getStringDate(int i) {
        String date = "";
        if (i == 0) {
            date = "No Date";
        } else {
            int dateInt = i;
            int year = dateInt / 10000;
            dateInt = dateInt % 10000;
            int month = dateInt / 100;
            dateInt = dateInt % 100;
            int day = dateInt;
            date = month + "/" + day + "/" + year;
        }
        return date;
    }

    @Override
    public final void clear() {
        while (ALL_EVENTS_IMP.size() != 0) {
            ALL_EVENTS_IMP.removeAny();
        }

        while (ALL_EVENTS_DATE.size() != 0) {
            ALL_EVENTS_DATE.removeAny();
        }

        while (SORTED_BY_IMP.length() != 0) {
            SORTED_BY_IMP.dequeue();
        }

        while (SORTED_BY_DATE.length() != 0) {
            SORTED_BY_DATE.dequeue();
        }
    }

    @Override
    public final ToDoList newInstance() {
        return new ToDoList1();
    }

    @Override
    public final void transferFrom(ToDoList source) {
        this.clear();
        this.setAllEventsImp(source);
        this.setAllEventsDate(source);
        this.setSortedByImp(source);
        this.setSortedByDate(source);
        source.clear();

    }

    @Override
    public final int compareTo(ToDoList o) {
        if (this.equals(o)) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public final Map<String, Integer> getAllEventsImp() {
        // TODO Auto-generated method stub
        return ALL_EVENTS_IMP;
    }

    @Override
    public final Map<String, Integer> getAllEventsDate() {
        // TODO Auto-generated method stub
        return ALL_EVENTS_DATE;
    }

    @Override
    public final Queue<Pair<String, Integer>> getSortedByImp() {
        // TODO Auto-generated method stub
        return SORTED_BY_IMP;
    }

    @Override
    public final Queue<Pair<String, Integer>> getSortedByDate() {
        // TODO Auto-generated method stub
        return SORTED_BY_DATE;
    }

    @Override
    public final void setAllEventsImp(ToDoList o) {
        for (Map.Pair<String, Integer> i : o.getAllEventsImp()) {
            ALL_EVENTS_IMP.add(i.key(), i.value());
        }
    }

    @Override
    public final void setAllEventsDate(ToDoList o) {
        for (Map.Pair<String, Integer> i : o.getAllEventsDate()) {
            ALL_EVENTS_DATE.add(i.key(), i.value());
        }

    }

    @Override
    public final void setSortedByImp(ToDoList o) {
        for (Map.Pair<String, Integer> i : o.getSortedByImp()) {
            SORTED_BY_IMP.enqueue(i);
        }

    }

    @Override
    public final void setSortedByDate(ToDoList o) {
        for (Map.Pair<String, Integer> i : o.getSortedByDate()) {
            SORTED_BY_DATE.enqueue(i);
        }
    }

}
