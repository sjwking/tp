package seedu.duke;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FinTrack {

    private static String username = null;
    private static String welcomeMessage = "Welcome to FinTrack!";
    private static Map<String, Runnable> commands = new HashMap<>();

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello I am\n" + logo);

        if (username == null) {
            System.out.println("What is your name?");
            Scanner scanner = new Scanner(System.in); // Using one scanner
            username = scanner.nextLine();
            System.out.println("Welcome " + username + "! " + welcomeMessage);
        }

        initializeCommands();

        while (true) {
            showOptions();
            Scanner scanner = new Scanner(System.in); // Reusing scanner
            String input = scanner.nextLine();
            handleInput(input);
        }
    }

    private static void initializeCommands() {
        commands.put("1", FinTrack::handleExpense);    // Linking to handleExpense
        commands.put("2", FinTrack::checkHistory);    // Linking to checkHistory
        commands.put("3", FinTrack::checkBudget);     // Linking to checkBudget
        commands.put("4", FinTrack::exit);            // Linking to exit
    }

    private static void showOptions() {
        System.out.println("Select an option:");
        System.out.println("1: Add Expense");
        System.out.println("2: Check History");
        System.out.println("3: Check Budget");
        System.out.println("4: Exit");
    }

    public static void handleExpense() {
        System.out.println("Adding expense...");
    }

    public static void checkHistory() {
        System.out.println("Checking history...");
    }

    public static void checkBudget() {
        System.out.println("Checking budget...");
    }

    public static void exit() {
        System.out.println("Exiting...");
        System.exit(0);
    }

    public static void handleInput(String input) {
        Runnable action = commands.get(input);
        if (action != null) {
            action.run();
        } else {
            System.out.println("Unknown command: " + input);
        }
    }
}
