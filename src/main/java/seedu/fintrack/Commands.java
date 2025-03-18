package seedu.fintrack;

import seedu.fintrack.utils.FinTrackException;
import seedu.fintrack.utils.Ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Commands {
    public static Scanner sc;
    private static ExpenseList expenseList;
    private static final HashMap<String, Runnable> commands = new HashMap<>();

    public Commands(ExpenseList expenseList, Scanner sc) {
        // Assert that the necessary objects are provided
        assert expenseList != null : "Expense list should not be null";
        assert sc != null : "Scanner should not be null";

        this.expenseList = expenseList;
        this.sc = sc;

        //Added exceptions for graceful error handling
        commands.put("1", () -> {
            try {
                addExpense();
            } catch (FinTrackException e) {
                System.out.println("Error: " + e.getMessage());
                Ui.printOptions();
            }
        });
        commands.put("2", () -> viewMonth());
        commands.put("3", () -> viewHistory());
        commands.put("4", () -> {
            try {
                updateExpense();
            } catch (FinTrackException e) {
                System.out.println("Error: " + e.getMessage());
                Ui.printOptions();
            }
        });
        commands.put("5", () -> {
            try {
                deleteExpense();
            } catch (FinTrackException e) {
                System.out.println("Error: " + e.getMessage());
                Ui.printOptions();
            }
        });
        commands.put("6", () -> {
            try {
                setMonthlyBudget();
            } catch (FinTrackException e) {
                System.out.println("Error: " + e.getMessage());
                Ui.printOptions();
            }
        });
        commands.put("7", () -> {
            try {
                addRecurringExpense();
            } catch (FinTrackException e) {
                System.out.println("Error: " + e.getMessage());
                Ui.printOptions();
            }
        });

        commands.put("8", () -> exit());

        assert commands.size() == 8 : "Commands map should contain 8 commands";
    }

    public void fetchCommand(String input) {
        Runnable command = commands.get(input);
        if (command != null) {
            command.run();
        } else {
            System.out.println("Invalid command.");
            Ui.printOptions();
        }
    }

    public static void addExpense() throws FinTrackException {
        int amount = readInt("Enter expense amount (in cents):");
        if (amount < 0) {
            System.out.println("Expense amount must be non-negative.");
            return;
        }
        System.out.println("Enter expense category:");
        String category = sc.nextLine();
        System.out.println("Enter expense description:");
        String description = sc.nextLine(); // Default description
        Date date = readDate("Enter expense date (format yyyy-MM-dd):");

        Expense expense = new Expense(amount, category, description, date);
        int sizeBefore = expenseList.size();
        expenseList.addExpense(expense);
        if (expenseList.getMonthlyBudget() > 0) {
            System.out.println("Your remaining budget for the month is: " + expenseList.getRemainingBudget());
        }
        assert expenseList.size() == sizeBefore + 1 : "Expense list did not increment as expected";
        System.out.println("Expense added.");
    }

    private void viewMonth() {
        Date now = new Date();
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM-yyyy");
        String currentMonth = monthFormat.format(now);
        System.out.println("Expenses for " + currentMonth + ":");
        for (int i = 0; i < expenseList.size(); i++) {
            Expense expense = expenseList.getExpense(i);
            if (monthFormat.format(expense.getDate()).equals(currentMonth)) {
                System.out.println(i + ": " + expense.getDescription() +
                        " - " + expense.getAmount() + " cents");
            }
        }
    }

    private void viewHistory() {
        System.out.println("Spending history:");
        for (int i = 0; i < expenseList.size(); i++) {
            Expense expense = expenseList.getExpense(i);
            System.out.println(i + ": " + expense.getDescription() +
                    " - " + expense.getAmount() + " cents on " + expense.getDate());
        }
    }

    private void updateExpense() throws FinTrackException {
        int index = readInt("Enter the index of the expense to update:");
        if (index < 0 || index >= expenseList.size()) {
            System.out.println("Invalid index.");
            return;
        }
        int amount = readInt("Enter new expense amount (in cents):");
        if (amount < 0) {
            System.out.println("Expense amount must be non-negative.");
            return;
        }
        System.out.println("Enter new expense category:");
        String category = sc.nextLine();
        System.out.println("Enter new expense description:");
        String description = sc.nextLine();
        Date date = readDate("Enter new expense date (format yyyy-MM-dd):");

        Expense newExpense = new Expense(amount, category, description, date);
        expenseList.updateExpense(index, newExpense);
        System.out.println("Expense updated.");
    }

    private void deleteExpense() throws FinTrackException {
        int index = readInt("Enter the index of the expense to delete:");
        if (index < 0 || index >= expenseList.size()) {
            System.out.println("Invalid index.");
            return;
        }
        Expense expense = expenseList.getExpense(index);
        int sizeBefore = expenseList.size();
        expenseList.deleteExpense(expense);
        assert expenseList.size() == sizeBefore - 1 : "Expense list did not decrement as expected";
        System.out.println("Expense deleted.");
    }

    private void exit() {
        System.out.println("Exiting program.");
        System.exit(0);
    }

    // Helper method to read an integer with re-prompting on invalid input.
    private static int readInt(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = sc.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, please try again.");
            }
        }
    }

    // Helper method to read a date with re-prompting on invalid format.
    private static Date readDate(String prompt) throws FinTrackException {
        while (true) {
            System.out.println(prompt);
            String input = sc.nextLine();

            try {
                return parseDate(input);
            } catch (FinTrackException e) {
                System.out.println(e.getMessage());
                // Continue looping until a valid date is provided.
            } catch (NoSuchElementException e) {
                System.out.println();
            }
        }
    }

    private static Date parseDate(String dateStr) throws FinTrackException {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            throw new FinTrackException("Invalid date format. Expected yyyy-MM-dd, got: " + dateStr);
        }
    }

    private void setMonthlyBudget() throws FinTrackException {
        int budget = readInt("Enter monthly budget:");
        if (budget < 0) {
            throw new FinTrackException("Budget must be non-negative");
        }
        expenseList.setMonthlyBudget(budget);
        System.out.println("Monthly budget set to: " + budget);
    }


    private void addRecurringExpense() throws FinTrackException {
        int amount = readInt("Enter expense amount (in cents): ");
        if (amount < 0) {
            throw new FinTrackException("Expense amount must be non-negative.");
        }
        System.out.println("Enter expense category:");
        String category = sc.nextLine();
        System.out.println("Enter frequency (Weekly, Monthly, Yearly):");
        String frequency = sc.nextLine();
        if (!frequency.equalsIgnoreCase("Weekly") && !frequency.equalsIgnoreCase("Monthly")
                && !frequency.equalsIgnoreCase("Yearly")) {
            throw new FinTrackException("Invalid frequency. Must be Weekly, Monthly, or Yearly.");
        }
        System.out.println("Enter expense description:");
        String description = sc.nextLine();
        Date date = readDate("Enter current date (format yyyy-MM-dd):");
        Date startDate = readDate("Enter start date (format yyyy-MM-dd):");


        RecurringExpense recurringExpense = new RecurringExpense(amount, category,
                frequency, description, startDate, startDate);
        expenseList.addRecurringExpense(recurringExpense);
        System.out.println("Recurring expense added.");
    }

}
