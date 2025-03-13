package seedu.fintrack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Date;

class ExpenseManagerTest {

    @Test
    public void addExpense_validExpense_expenseAdded() {
        ExpenseManager manager = new ExpenseManager();
        Expense expense = new Expense(1500, "Food", "Lunch at cafe", new Date());
        manager.addExpense(expense);
        assertEquals(1, manager.getExpenses().size());
        assertEquals(expense, manager.getExpenses().get(0));
    }

    @Test
    public void addExpense_negativeAmountExpense_exceptionThrown() {
        ExpenseManager manager = new ExpenseManager();
        Expense expense = new Expense(-500, "Refund", "Negative expense example", new Date());
        assertThrows(IllegalArgumentException.class, () -> manager.addExpense(expense));
    }
}
