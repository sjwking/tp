package seedu.fintrack.utils;


public class Ui {
    //Color codes for the text
    public static String reset = "\u001B[0m";
    public static String cyan = "\u001B[36m";
    public static String green = "\u001B[32m";
    public static String yellow = "\u001B[33m";
    public static String purple = "\u001B[35m";
    public static String red = "\u001B[31m";
    public static String blue = "\u001B[34m";

    private static String border = "________________________________________________________________________________\n";
    private static String greeting = "Hello, I am Fin! Your go-to expense tracker\nHow can I help you today?";
    private static String logo =
            "   ▄████████  ▄█  ███▄▄▄▄\n" +
                    "  ███    ███ ███  ███▀▀▀██▄\n" +
                    "  ███    █▀  ███▌ ███   ███\n" +
                    " ▄███▄▄▄     ███▌ ███   ███\n" +
                    "▀▀███▀▀▀     ███▌ ███   ███\n" +
                    "  ███        ███  ███   ███\n" +
                    "  ███        ███  ███   ███\n" +
                    "  ███        █▀    ▀█   █▀\n" +
                    "\n" +
                    "    ███        ▄████████    ▄████████  ▄████████    ▄█   ▄█▄\n" +
                    "▀█████████▄   ███    ███   ███    ███ ███    ███   ███ ▄███▀\n" +
                    "   ▀███▀▀██   ███    ███   ███    ███ ███    █▀    ███▐██▀\n" +
                    "    ███   ▀  ▄███▄▄▄▄██▀   ███    ███ ███         ▄█████▀\n" +
                    "    ███     ▀▀███▀▀▀▀▀   ▀███████████ ███        ▀▀█████▄\n" +
                    "    ███     ▀███████████   ███    ███ ███    █▄    ███▐██▄\n" +
                    "    ███       ███    ███   ███    ███ ███    ███   ███ ▀███▄\n" +
                    "   ▄████▀     ███    ███   ███    █▀  ████████▀    ███   ▀█▀\n" +
                    "              ███    ███                           ▀\n";

    public static void printGreeting() {
        System.out.println(border + greeting);
    }

    public static void printLogo() {
        System.out.println(logo);
    }

    public static void printOptions() {
        String options = "✨ Hey! Here's what I can help you with ✨\n" +
                cyan + "1. 💸 Add a new expense\n" + reset +
                green + "2. 📅 Check out this month's spending\n" + reset +
                yellow + "3. 📈 View your spending history\n" + reset +
                purple + "4. ✏️ Update an expense entry\n" + reset +
                red + "5. 🗑️ Delete an expense\n" + reset +
                blue + "6. 🎯 Set your monthly budget\n" + reset +
                cyan + "7. 🔄 Add a recurring expense\n" + reset +
                green + "8. 🏷️ Create a new category\n" + reset +
                red + "9. 🚪 Exit the app\n" + reset;
        System.out.println(border + options + border);
    }

    public static void showMessage(String message) {
        System.out.println(message);
    }

    public static void showError(String errorMessage) {
        System.err.println(errorMessage);
    }
}
