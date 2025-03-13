package seedu.fintrack;
import java.util.Date;

public class Expense {
    private int amount; //amount in cents
    private String category;
    private String description;
    private Date date;

    Expense(int amount, String category, String description, Date date) {
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }
}
