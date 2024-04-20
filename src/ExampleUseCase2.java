
public class ExampleUseCase2 {

    public static void main(String[] args) {
        ToDoList check = new ToDoList1();

        //Can add and remove events as you complete them
        check.addEvent("Finish Homeowork", 3, 240423);
        check.addEvent("Prepare For Meeting", 0, 240423);
        check.addEvent("Have Fun");
        check.removeEvent("Have Fun", 240419);
        //Adds third event with date, no importance level
        check.addEvent("Call Mom", 0, 240420);
        //completes Clean event and adds date when it was completed
        check.removeEvent("Prepare For Meeting", 240423);

        //can filter to print out events that you already completed or need to complete
        check.orderByImportance();
        System.out.println(check.displayEventsCompleted());
        System.out.println("\n\n\n");
        check.orderByDate();
        System.out.println(check.displayEventsNeedToDo());
        System.out.println("\n\n\n");

    }
}
