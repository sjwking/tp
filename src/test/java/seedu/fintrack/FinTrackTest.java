package seedu.fintrack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FinTrackTest {
    private Commands commands;
    private ExpenseList expenseList;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        expenseList = new ExpenseList();
        // Simulated input for addExpense: amount, category, description, date.
        String simulatedInput = "1000\nFood\nLunch\n2025-03-14\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        commands = new Commands(expenseList, scanner);
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream)); // Redirects output for testing
    }

    /*** Commands Tests ***/

    @Test
    void fetchCommand_validCommand1_addsExpense() {
        // When command "1" is fetched, addExpense() will prompt and eventually add an expense.
        commands.fetchCommand("1");
        // Verify the expense was added.
        assertEquals(1, expenseList.size());
        // Check that the output contains the confirmation message.
        assertTrue(outputStream.toString().contains("Expense added."));
    }

    @Test
    void fetchCommand_invalidCommand_doesNothing() {
        // Test an invalid command.
        commands.fetchCommand("99"); // Invalid command should trigger error message.
        // Check that the output indicates an invalid command.
        assertTrue(outputStream.toString().contains("Invalid command."));
    }

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
