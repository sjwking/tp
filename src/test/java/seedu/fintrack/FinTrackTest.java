package seedu.fintrack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinTrackTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testHandleExpense() {
        FinTrack.handleExpense();
        assertEquals("Adding expense...\n",
                outContent.toString(),
                "handleExpense() should print 'Adding expense...'");
    }

    @Test
    public void testCheckHistory() {
        FinTrack.checkHistory();
        assertEquals("Checking history...\n",
                outContent.toString(),
                "checkHistory() should print 'Checking history...'");
    }

    @Test
    public void testCheckBudget() {
        FinTrack.checkBudget();
        assertEquals("Checking budget...\n",
                outContent.toString(),
                "checkBudget() should print 'Checking budget...'");
    }

    @Test
    public void testExit() {

        FinTrack.exit();
        assertEquals("Exiting...\n",
                outContent.toString(),
                "exit() should print 'Exiting...'");
    }

    @Test
    public void testHandleInput_validCommand() {
        FinTrack.handleInput("1");
        assertEquals("Adding expense...\n",
                outContent.toString(),
                "Input '1' should trigger handleExpense()");
    }

    @Test
    public void testHandleInput_invalidCommand() {
        FinTrack.handleInput("invalid");
        assertEquals("Unknown command: invalid\n",
                outContent.toString(),
                "Invalid input should print an error message.");
    }
}
