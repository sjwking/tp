package seedu.fintrack;

import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private final List<Expense> expenses;

    public ExpenseManager() {
        this.expenses = new ArrayList<>();
    }

    /**
     * Adds an expense to the list.
     * @param expense the expense to be added.
     * @throws IllegalArgumentException if the expense is null or has a negative amount.
     */
    public void addExpense(Expense expense) {
        if (expense == null) {
            throw new IllegalArgumentException("Expense cannot be null");
        }
        if (expense.getAmount() < 0) {
            throw new IllegalArgumentException("Expense amount cannot be negative");
        }
        expenses.add(expense);
    }

    public List<Expense> getExpenses() {
        return expenses;
    }
}
