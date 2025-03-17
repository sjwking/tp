package seedu.fintrack;

import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Commands {
    public static Scanner sc;
    private static ExpenseList expenseList;
    private static final HashMap<String, Runnable> commands = new HashMap<>();


    public Commands(ExpenseList expenseList, Scanner sc) {
        this.expenseList = expenseList;
        this.sc = sc;
        commands.put("1", () -> addExpense());
        commands.put("2", () -> viewMonth());
        commands.put("3", () -> viewHistory());
        commands.put("4", () -> updateExpense());
        commands.put("5", () -> deleteExpense(0));
        commands.put("6", () -> exit());
    }

    public void fetchCommand(String input) {
        Runnable command = commands.get(input);
        if (command != null) {
            command.run();
        } else {
            System.out.println("Invalid command.");
        }
    }

    public static void addExpense() {
        System.out.println("Enter expense amount (in cents):");
        int amount = Integer.parseInt(sc.nextLine());
        System.out.println("Enter expense category:");
        String category = sc.nextLine();
        System.out.println("Enter expense description:");
        String description = sc.nextLine();
        System.out.println("Enter expense date (format yyyy-MM-dd):");
        String dateStr = sc.nextLine();
        Date date = parseDate(dateStr);
        Expense expense = new Expense(amount, category, description, date);
        expenseList.addExpense(expense);
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

    private void updateExpense() {
        System.out.println("Enter the index of the expense to update:");
        int index = Integer.parseInt(sc.nextLine());
        if (index < 0 || index >= expenseList.size()) {
            System.out.println("Invalid index.");
            return;
        }
        System.out.println("Enter new expense amount (in cents):");
        int amount = Integer.parseInt(sc.nextLine());
        System.out.println("Enter new expense category:");
        String category = sc.nextLine();
        System.out.println("Enter new expense description:");
        String description = sc.nextLine();
        System.out.println("Enter new expense date (format yyyy-MM-dd):");
        String dateStr = sc.nextLine();
        Date date = parseDate(dateStr);
        Expense newExpense = new Expense(amount, category, description, date);
        expenseList.updateExpense(index, newExpense);
        System.out.println("Expense updated.");
    }

    void deleteExpense(int i) {
        System.out.println("Enter the index of the expense to delete:");
        int index = Integer.parseInt(sc.nextLine());
        if (index < 0 || index >= expenseList.size()) {
            System.out.println("Invalid index.");
            return;
        }
        Expense expense = expenseList.getExpense(index);
        expenseList.deleteExpense(expense);
        System.out.println("Expense deleted.");
    }

    private void exit() {
        System.out.println("Exiting program.");
        System.exit(0);
    }

    private static Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Using current date.");
            return new Date();
        }
    }
}
