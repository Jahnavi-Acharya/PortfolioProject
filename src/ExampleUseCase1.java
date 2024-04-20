
public class ExampleUseCase1 {

    public static void main(String[] args) {
        ToDoList check = new ToDoList1();
        //Adds first event without any importance level or date to be completed by
        check.addEvent("Clean");
        //Adds second event with importance level and date to be completed by
        check.addEvent("Attend Meeting", 3, 240423);
        check.addEvent("Prepare For Meeting", 0, 240423);
        //Adds third event with date, no importance level
        check.addEvent("Have fun", 0, 240530);
        //completes Clean event and adds date when it was completed
        check.removeEvent("Clean", 240418);

        //can order by importance or date and print out events
        check.orderByImportance();
        System.out.println(check.toString());
        System.out.println("\n\n\n");
        check.orderByDate();
        System.out.println(check.toString());
        System.out.println("\n\n\n");

    }
}
