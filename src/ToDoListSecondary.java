import java.util.Comparator;

import components.map.Map;
import components.map.Map.Pair;
import components.sortingmachine.SortingMachine;
import components.sortingmachine.SortingMachine1L;

/**
 * Abstract class implementing the ToDoList interface. Subclasses can override
 * specific methods as needed.
 */
public abstract class ToDoListSecondary implements ToDoList {

    @Override
    public final void addEvent(String event) {
        if (ALL_EVENTS_IMP.hasKey(event) && this.getImportance(event) == -1) {
            this.addImportance(event, 0);
            this.addDate(event, 0);
        } else {
            ALL_EVENTS_IMP.add(event, 0);
            ALL_EVENTS_DATE.add(event, 0);
        }
    }

    @Override
    public final void addEvent(String event, int importance, int date) {
        if (ALL_EVENTS_IMP.hasKey(event) && ALL_EVENTS_IMP.value(event) == -1) {
            this.addImportance(event, importance);
            this.addDate(event, date);
        } else {
            ALL_EVENTS_IMP.add(event, importance);
            ALL_EVENTS_DATE.add(event, date);
        }
    }

    @Override
    public final void removeEvent(String event, int dateRem) {
        this.addImportance(event, -1);
        this.addDate(event, dateRem);
    }

    /**
     * Comparator for comparing pairs of strings and integers based on the
     * integer values. Comparator for sorting importance in orderByImportance.
     */
    private static final class CompareImportance
            implements Comparator<Map.Pair<String, Integer>> {

        @Override
        public int compare(Map.Pair<String, Integer> o1,
                Map.Pair<String, Integer> o2) {
            return o2.value().compareTo(o1.value());
        }

    }

    @Override
    public final void orderByImportance() {
        Comparator<Map.Pair<String, Integer>> order = new CompareImportance();
        SortingMachine<Map.Pair<String, Integer>> sortByImp = new SortingMachine1L<>(
                order);

        if (SORTED_BY_DATE.length() > 0) {
            while (SORTED_BY_DATE.length() != 0) {
                Map.Pair<String, Integer> rem = SORTED_BY_DATE.dequeue();
                ALL_EVENTS_DATE.add(rem.key(), rem.value());
            }
        }

        int size = ALL_EVENTS_IMP.size();
        for (int i = 0; i < size; i++) {
            Pair<String, Integer> temp = ALL_EVENTS_IMP.removeAny();
            sortByImp.add(temp);
        }

        sortByImp.changeToExtractionMode();

        for (int i = 0; i < size; i++) {
            SORTED_BY_IMP.enqueue(sortByImp.removeFirst());
        }

    }

    /**
     * Comparator for comparing pairs of strings and integers based on the
     * integer values. Comparator for sorting date in orderByDate.
     */
    private static final class CompareDate
            implements Comparator<Map.Pair<String, Integer>> {

        @Override
        public int compare(Map.Pair<String, Integer> o1,
                Map.Pair<String, Integer> o2) {
            return o1.value().compareTo(o2.value());
        }

    }

    @Override
    public final void orderByDate() {
        Comparator<Map.Pair<String, Integer>> order = new CompareDate();
        SortingMachine<Map.Pair<String, Integer>> sortByDate = new SortingMachine1L<>(
                order);

        if (SORTED_BY_IMP.length() > 0) {
            while (SORTED_BY_IMP.length() != 0) {
                Map.Pair<String, Integer> rem = SORTED_BY_IMP.dequeue();
                ALL_EVENTS_IMP.add(rem.key(), rem.value());
            }
        }

        int size = ALL_EVENTS_DATE.size();
        for (int i = 0; i < size; i++) {
            Pair<String, Integer> temp = ALL_EVENTS_DATE.removeAny();
            sortByDate.add(temp);
        }

        sortByDate.changeToExtractionMode();

        for (int i = 0; i < size; i++) {
            SORTED_BY_DATE.enqueue(sortByDate.removeFirst());
        }
    }

    @Override
    public final String displayEventsNeedToDo() {
        String ans = "";
        for (Map.Pair<String, Integer> i : ALL_EVENTS_IMP) {
            if (!(i.value() == -1)) {
                ans = ans + i.key() + "\n";
            }
        }
        for (Map.Pair<String, Integer> i : SORTED_BY_IMP) {
            if (!(i.value() == -1)) {
                ans = ans + i.key() + "\n";
            }
        }
        return ans;
    }

    @Override
    public final String displayEventsCompleted() {
        String ans = "";
        for (Map.Pair<String, Integer> i : ALL_EVENTS_IMP) {
            if ((i.value() == -1)) {
                ans = ans + i.key() + "\n";
            }
        }
        for (Map.Pair<String, Integer> i : SORTED_BY_IMP) {
            if ((i.value() == -1)) {
                ans = ans + i.key() + "\n";
            }
        }
        return ans;
    }

    @Override
    public final String toString() {

        String ans = "To-Do-List \nEvent, Importance or Completed, "
                + "Date Completed or Date to be Completed\n";
        String imp = "";
        String date = "";
        if (SORTED_BY_DATE.length() == 0 && SORTED_BY_IMP.length() == 0) {
            for (Map.Pair<String, Integer> i : ALL_EVENTS_IMP) {
                imp = this.getStringImportance(this.getImportance(i.key()));
                date = this.getStringDate(this.getDate(i.key()));
                ans = ans + i.key() + ", " + imp + ", " + date + "\n";
            }

        }

        if (SORTED_BY_IMP.length() > 0 && SORTED_BY_DATE.length() == 0) {
            this.orderByImportance();
            for (Map.Pair<String, Integer> i : SORTED_BY_IMP) {
                imp = this.getStringImportance(i.value());
                date = this.getStringDate(this.getDate(i.key()));
                ans = ans + i.key() + ", " + imp + ", " + date + "\n";
            }
        }

        if (SORTED_BY_DATE.length() > 0 && SORTED_BY_IMP.length() == 0) {
            this.orderByDate();
            for (Map.Pair<String, Integer> i : SORTED_BY_DATE) {
                imp = this.getStringImportance(this.getImportance(i.key()));
                date = this.getStringDate(i.value());
                ans = ans + i.key() + ", " + imp + ", " + date + "\n";
            }

        }
        return ans;

    }

    @Override
    public final boolean equals(Object o) {
        boolean ans = true;
        ToDoListSecondary other = (ToDoListSecondary) o;
        if (!(this.getSortedByImp().equals(other.getSortedByImp()))) {
            ans = false;
        }
        if (!(this.getSortedByDate().equals(other.getSortedByDate()))) {
            ans = false;
        }
        if (!(this.getAllEventsImp().equals(other.getAllEventsImp()))) {
            ans = false;
        }
        if (!(this.getAllEventsDate().equals(other.getAllEventsDate()))) {
            ans = false;
        }
        return ans;

    }

}
