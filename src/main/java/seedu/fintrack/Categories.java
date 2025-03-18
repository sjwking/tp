package seedu.fintrack;

import java.util.ArrayList;

public class Categories {
    private static ArrayList<String> categories = new ArrayList<>();

    // Static block ensures categories are initialized before any static method is called
    static {
        categories.add("Food");
        categories.add("Transport");
        categories.add("Others");
    }

    public static String getCategory(int index) {
        return categories.get(index - 1);
    }

    public static int size() {
        return categories.size();
    }

    public static void printCategories() {
        int index = 1;
        for (String category : categories) {
            System.out.println(index + ". " + category);
            index++;
        }
    }

    public static void addCategory(String category) {
        categories.add(category);
    }

    public static void removeCategory(String category) {
        categories.remove(category);
    }

    public static Boolean checkCategory(String category) {
        return categories.contains(category);
    }
}
