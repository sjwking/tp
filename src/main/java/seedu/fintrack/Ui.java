package seedu.fintrack;

public class Ui{
    private static String border = "________________________________________________________________________________\n";
    private static String greeting = "Hello, I am Fin!\n" + "How can I help you today?";
    private static String options = "Select one of the options:\n" +
            "1. Add an expense\n" +
            "2. View this months details\n" +
            "3. View spending history\n" +
            "4. Exit the program\n";

    public static void printBorder(){
        System.out.println(border);
    }

    public static void printGreeting(){
        System.out.println(border + greeting);
    }

    public static void printOptions(){
        System.out.println( border + options + border);
    }
}
