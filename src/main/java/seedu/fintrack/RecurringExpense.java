
package seedu.fintrack;

import java.util.Date;

public class RecurringExpense extends Expense{
    private String frequency; // Weekly, Monthly, Yearly
    private Date startDate;


    public RecurringExpense(int amount, String category, String frequency, String description,
                            Date startDate, Date date) {
        super(amount, category, description, date);
        this.frequency = frequency;
        this.startDate = startDate;
    }


    public String getFrequency() {
        return frequency;
    }


    public Date getStartDate() {
        return startDate;
    }


}
