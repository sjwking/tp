package seedu.fintrack;

import seedu.fintrack.utils.Storage;
import seedu.fintrack.utils.Ui;
import java.util.Scanner;


public class FinTrack {
    /**
     * Main entry-point for the java.fintrack.FinTrack application.
     */
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        Ui.printGreeting();
        Ui.printLogo();
        Ui.printOptions();

        String input = sc.nextLine();
        ExpenseList expenseList = new ExpenseList();
        Commands commands = new Commands(expenseList, sc);

        Storage storage = new Storage();
        storage.loadExpensesFromFile(expenseList);

        while (input != null) {
            commands.fetchCommand(input);
            input = sc.nextLine();
        }
    }
}
