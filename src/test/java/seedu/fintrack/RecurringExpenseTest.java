package seedu.fintrack;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecurringExpenseTest {
    @Test
    void getAmount() {
        // Create an Expense with an amount of 1500 cents.
        RecurringExpense expense = new RecurringExpense(1500, "Food",
                "Monthly", "Dinner", new Date(1000L), new Date(1000L));

        // Use JUnit assertEquals to verify that getAmount returns 1500.
        assertEquals(1500, expense.getAmount(), "Expected amount to be 1500 cents");
    }

    @Test
    void getCategory() {
        // Create an Expense with the category "Food".
        RecurringExpense expense = new RecurringExpense(1500, "Food",
                "Monthly", "Dinner", new Date(1000L), new Date(1000L));
        assertEquals("Food", expense.getCategory(), "Expected category to be 'Food'");
    }

    @Test
    void getDescription() {
        // Create an Expense with the description "Dinner".
        RecurringExpense expense = new RecurringExpense(1500, "Food",
                "Monthly", "Dinner", new Date(1000L), new Date(1000L));
        assertEquals("Dinner", expense.getDescription(), "Expected description to be 'Dinner'");
    }

    @Test
    void getDate() {
        // Create a fixed Date for testing.
        Date testDate = new Date(1000L);
        RecurringExpense expense = new RecurringExpense(1500, "Food",
                "Monthly", "Dinner", new Date(1000L), new Date(1000L));
        assertEquals(testDate, expense.getDate(), "Expected date to match the provided date");
    }

    @Test
    void getStartDate() {
        Date testDate = new Date(1000L);
        RecurringExpense expense = new RecurringExpense(1500, "Food",
                "Monthly", "Dinner", new Date(1000L), new Date(1000L));
        assertEquals(testDate, expense.getStartDate(), "Expected date to match the provided date");
    }

    @Test
    void getFrequency() {
        RecurringExpense expense = new RecurringExpense(1500, "Food",
                "Monthly", "Dinner", new Date(1000L), new Date(1000L));
        assertEquals("Monthly", expense.getFrequency(), "Expected frequency to be 'Monthly'");
    }
}
