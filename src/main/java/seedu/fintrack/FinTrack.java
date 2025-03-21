package seedu.fintrack;

import seedu.fintrack.utils.Parser;
import seedu.fintrack.utils.Storage;
import seedu.fintrack.utils.Ui;

import java.util.Scanner;


public class FinTrack {
    /**
     * Main entry-point for the java.fintrack.FinTrack application.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Do the initial setup for the application, which will happen once at the start.
        Ui.printGreeting();
        //Ui.printLogo();
        Ui.printOptions();

        //String input = sc.nextLine();
        ExpenseList expenseList = new ExpenseList();
        Parser parser = new Parser(sc);
        Commands commands = new Commands(expenseList, parser);

        Storage storage = new Storage();
        storage.loadExpensesFromFile(expenseList);

        boolean isRunning = true;
        //Main application loop starts, user input is read and processed
        //until the user enters the "exit" command.
        while (isRunning) {
            String rawInput = parser.getCommandInput();
            // If the user entered "exit" (or an equivalent command), terminate gracefully.
            if (rawInput.equals("exit") || rawInput.equals("quit")) {
                commands.fetchCommand("exit");
                isRunning = false;  // Break out of the loop.
            } else {
                commands.fetchCommand(rawInput);
            }
        }
    }
}
