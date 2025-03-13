package seedu.fintrack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FinTrackTest {
    private Commands commands;
    private ExpenseList expenseList;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        commands = new Commands();
        expenseList = new ExpenseList();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream)); // Redirects output for testing
    }

    /*** Commands Tests ***/

    @Test
    void fetchCommand_validCommand1_printsAddExpense() {
        commands.fetchCommand("1");
        assertEquals("Adding expense", outputStream.toString().trim()); // Use trim() to remove extra spaces/newlines
    }

    /*@Test
    void fetchCommand_invalidCommand_doesNothing() {
        commands.fetchCommand("99"); // Invalid command
        assertEquals("", outputStream.toString()); // No output expected
    }*/

    /*** ExpenseList Tests ***/

    @Test
    void addExpense_storesExpenseCorrectly() {
        Expense expense = new Expense(2000, "Food", "Dinner", new Date());
        expenseList.addExpense(expense);
        assertEquals(expense, expenseList.getExpense(0));
    }

    @Test
    void deleteExpense_removesExpenseFromList() {
        Expense expense = new Expense(1500, "Transport", "Taxi", new Date());
        expenseList.addExpense(expense);
        expenseList.deleteExpense(expense);
        assertThrows(IndexOutOfBoundsException.class, () -> expenseList.getExpense(0));
    }

    /*** Ui Tests ***/

    @Test
    void printGreeting_displaysGreetingMessage() {
        Ui.printGreeting();
        assertTrue(outputStream.toString().contains("Hello, I am Fin!"));
    }
}
