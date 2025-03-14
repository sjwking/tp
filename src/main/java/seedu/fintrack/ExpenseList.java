package seedu.fintrack;

import java.util.ArrayList;

public class ExpenseList {
    private ArrayList<Expense> expenseList;
    public ExpenseList() {
        this.expenseList = new ArrayList<>();
    }

    void addExpense(Expense expense) {
        expenseList.add(expense);
    }

    void deleteExpense(Expense expense) {
        expenseList.remove(expense);
    }

    Expense getExpense(int index) {
        return expenseList.get(index);
    }

    public int size() {
        return expenseList.size();
    }

    public void updateExpense(int index, Expense expense) {
        expenseList.set(index, expense);
    }
}
