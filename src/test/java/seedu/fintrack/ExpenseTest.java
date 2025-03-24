package seedu.fintrack;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpenseTest {

    @Test
    void getAmount() {
        // Create an Expense with an amount of 1500 cents.
        Expense expense = new Expense(1500, "Food", "Dinner", new Date(1000L));
        // Use JUnit assertEquals to verify that getAmount returns 1500.
        assertEquals(1500, expense.getAmount(), "Expected amount to be 1500 cents");
    }

    @Test
    void getCategory() {
        // Create an Expense with the category "Food".
        Expense expense = new Expense(1500, "Food", "Dinner", new Date(1000L));
        // Use JUnit assertEquals to verify that getCategory returns "Food".
        assertEquals("Food", expense.getCategory(), "Expected category to be 'Food'");
    }

    @Test
    void getDescription() {
        // Create an Expense with the description "Dinner".
        Expense expense = new Expense(1500, "Food", "Dinner", new Date(1000L));
        // Use JUnit assertEquals to verify that getDescription returns "Dinner".
        assertEquals("Dinner", expense.getDescription(), "Expected description to be 'Dinner'");
    }

    @Test
    void getDate() {
        // Create a fixed Date for testing.
        Date testDate = new Date(1000L);
        Expense expense = new Expense(1500, "Food", "Dinner", testDate);
        // Use JUnit assertEquals to verify that getDate returns the provided date.
        assertEquals(testDate, expense.getDate(), "Expected date to match the provided date");
    }
}
