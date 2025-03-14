package seedu.fintrack;

import org.junit.jupiter.api.Test;
import java.util.Date;

class ExpenseTest {

    @Test
    void getAmount() {
        // Create an Expense with an amount of 1500 cents.
        Expense expense = new Expense(1500, "Food", "Dinner", new Date(1000L));
        // Use Java assert to verify that getAmount returns 1500.
        assert expense.getAmount() == 1500 : "Expected amount to be 1500 cents, but got " + expense.getAmount();
    }

    @Test
    void getCategory() {
        // Create an Expense with the category "Food".
        Expense expense = new Expense(1500, "Food", "Dinner", new Date(1000L));
        // Use Java assert to verify that getCategory returns "Food".
        assert "Food".equals(expense.getCategory()) : "Expected category to be 'Food', but got " + expense.getCategory();
    }

    @Test
    void getDescription() {
        // Create an Expense with the description "Dinner".
        Expense expense = new Expense(1500, "Food", "Dinner", new Date(1000L));
        // Use Java assert to verify that getDescription returns "Dinner".
        assert "Dinner".equals(expense.getDescription()) : "Expected description to be 'Dinner', but got " + expense.getDescription();
    }

    @Test
    void getDate() {
        // Create a fixed Date for testing.
        Date testDate = new Date(1000L);
        Expense expense = new Expense(1500, "Food", "Dinner", testDate);
        // Use Java assert to verify that getDate returns the provided date.
        assert testDate.equals(expense.getDate()) : "Expected date to match the provided date, but got " + expense.getDate();
    }
}
