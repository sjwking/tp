package seedu.fintrack;

import java.util.Scanner;

public class FinTrack {
    /**
     * Main entry-point for the java.fintrack.FinTrack application.
     */
    public static void main(String[] args) {
        String logo =
                "   ▄████████  ▄█  ███▄▄▄▄                                   \n" +
                        "  ███    ███ ███  ███▀▀▀██▄                                 \n" +
                        "  ███    █▀  ███▌ ███   ███                                 \n" +
                        " ▄███▄▄▄     ███▌ ███   ███                                 \n" +
                        "▀▀███▀▀▀     ███▌ ███   ███                                 \n" +
                        "  ███        ███  ███   ███                                 \n" +
                        "  ███        ███  ███   ███                                 \n" +
                        "  ███        █▀    ▀█   █▀                                  \n" +
                        "                                                            \n" +
                        "    ███        ▄████████    ▄████████  ▄████████    ▄█   ▄█▄\n" +
                        "▀█████████▄   ███    ███   ███    ███ ███    ███   ███ ▄███▀\n" +
                        "   ▀███▀▀██   ███    ███   ███    ███ ███    █▀    ███▐██▀  \n" +
                        "    ███   ▀  ▄███▄▄▄▄██▀   ███    ███ ███         ▄█████▀   \n" +
                        "    ███     ▀▀███▀▀▀▀▀   ▀███████████ ███        ▀▀█████▄   \n" +
                        "    ███     ▀███████████   ███    ███ ███    █▄    ███▐██▄  \n" +
                        "    ███       ███    ███   ███    ███ ███    ███   ███ ▀███▄\n" +
                        "   ▄████▀     ███    ███   ███    █▀  ████████▀    ███   ▀█▀\n" +
                        "              ███    ███                           ▀        \n";

        Scanner sc = new Scanner(System.in);
        Ui.printGreeting();
        Ui.printOptions();

        String input = sc.nextLine();
        ExpenseList expenseList = new ExpenseList();
        CategoryList categoryList = new CategoryList();
        Commands commands = new Commands(expenseList, categoryList, sc);

        while (input != null) {
            commands.fetchCommand(input);
            input = sc.nextLine();
        }
    }
}
