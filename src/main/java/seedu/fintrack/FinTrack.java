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

        while (input != null) {
            switch (input) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                System.exit(0);
                break;
            default:
                System.out.println("Please enter a valid input");
                input = sc.nextLine();
            }
        }
    }
}
