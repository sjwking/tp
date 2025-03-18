package seedu.fintrack.utils;

public class CategoryException extends Exception {
    public void printError() {
        System.out.println("Please enter a valid input");
    }
}
