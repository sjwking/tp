package seedu.fintrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CategoryList {
    private ArrayList<String> categoryList;
    private Scanner scanner = new Scanner(System.in);

    public CategoryList() {
        categoryList = new ArrayList<>(Arrays.asList(
                "Food", "Transportation", "Household",
                "Utilities", "Subscriptions", "Add custom category"
        ));
    }

    public int getCategoryCount() {
        return categoryList.size();
    }

    public String getCategory(int index) {
        return categoryList.get(index-1);
    }

    public void printCategories() {
        for(int i = 0; i < categoryList.size(); i++) {
            System.out.println(i+1 + ". " + categoryList.get(i));
        }
    }

    public void printCustomCategories() {
        System.out.println("Here are your custom categories:");
        int numberOfDefaultCategories = 5;
        for(int i = numberOfDefaultCategories; i < categoryList.size()-1; i++) {
            System.out.println(i-4 + ". " + categoryList.get(i));
        }
    }

    public void addCategory(String category) {
        categoryList.add(category);
        Collections.swap(categoryList, categoryList.size() - 1, categoryList.size() - 2);
    }

    public String addCustomCategory() {
        System.out.println("Enter the name of the category: ");
        String category = scanner.nextLine();
        addCategory(category);
        return category;
    }

    public String processCategory() {
        int categoryIndex = Integer.parseInt(scanner.nextLine());
        if (categoryIndex > categoryList.size() || categoryIndex <= 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        String category;
        if (categoryIndex == getCategoryCount()) {
            category = addCustomCategory();
        } else {
            category = getCategory(categoryIndex);
        }
        return category;
    }

    public void removeCategory(int index) {
        int actualIndex = index + 4;
        String categoryToRemove = categoryList.get(actualIndex);
        categoryList.remove(actualIndex);
        System.out.println("'" + categoryToRemove + "'" + " has been removed successfully.");
    }
}
