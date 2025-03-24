package seedu.fintrack;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ExpenseList {
    private ArrayList<Expense> expenseList;
    private ArrayList<RecurringExpense> recurringExpenses;
    private int monthlyBudget;
    private int remainingBudget;


    public ExpenseList() {
        this.expenseList = new ArrayList<>();
        this.recurringExpenses = new ArrayList<>();
        this.monthlyBudget =  0;
        this.remainingBudget =  0;
    }

    public void addExpense(Expense expense) {
        expenseList.add(expense);
        remainingBudget = remainingBudget - expense.getAmount();
    }

    void deleteExpense(Expense expense) {
        expenseList.remove(expense);
    }

    Expense getExpense(int index) {
        return expenseList.get(index);
    }

    public ArrayList<Expense> getExpenseList() {
        return expenseList;
    }

    public int size() {
        return expenseList.size();
    }

    public void updateExpense(int index, Expense expense) {
        expenseList.set(index-1, expense);
    }

    public void addRecurringExpense(RecurringExpense recurringExpense) {
        recurringExpenses.add(recurringExpense);
        addRecurringExpenses(recurringExpense);
    }


    public ArrayList<RecurringExpense> getRecurringExpenses() {
        return recurringExpenses;
    }

    public void setMonthlyBudget(int budget) {
        this.monthlyBudget = budget;
        this.remainingBudget = budget;
    }


    public int getMonthlyBudget() {
        return monthlyBudget;
    }


    public int getRemainingBudget() {
        return remainingBudget;
    }

    private void addRecurringExpenses(RecurringExpense recurringExpense) {
        Date startDate = recurringExpense.getStartDate();
        Date currentDate = new Date(); // Get the current date

        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);

        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.setTime(currentDate);

        int numberOfOccurrences = 0;

        while (startCalendar.getTime().before(currentDate) || startCalendar.getTime().equals(currentDate)) {
            Expense expense = new Expense(
                    recurringExpense.getAmount(),
                    recurringExpense.getCategory(),
                    recurringExpense.getDescription(),
                    startCalendar.getTime()
            );
            expenseList.add(expense);


            switch (recurringExpense.getFrequency().toLowerCase()) {
            case "weekly":
                startCalendar.add(Calendar.WEEK_OF_YEAR, 1);
                break;
            case "monthly":
                startCalendar.add(Calendar.MONTH, 1);
                break;
            case "yearly":
                startCalendar.add(Calendar.YEAR, 1);
                break;
            default:
                throw new IllegalArgumentException("Invalid frequency: " + recurringExpense.getFrequency());
            }
            numberOfOccurrences++;
        }
    }
}
