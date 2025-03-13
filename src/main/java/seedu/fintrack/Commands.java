package seedu.fintrack;

import java.util.HashMap;

public class Commands {
    private static HashMap<String, Runnable> commands = new HashMap<>();

    Commands(){
        this.commands.put("1", () -> addExpense());
        this.commands.put("2", () -> month());
        this.commands.put("3", () -> history());
    }

    public void fetchCommand(String input){
        Runnable command = commands.get(input);
        command.run();
    }

    public static void addExpense(){
        System.out.println("Adding expense");
    }

    public static void month(){
        System.out.println("Month");
    }

    public static void history(){
        System.out.println("History");
    }
}
