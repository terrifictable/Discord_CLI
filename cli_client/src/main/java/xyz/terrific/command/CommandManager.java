package xyz.terrific.command;

import xyz.terrific.Main;
import xyz.terrific.command.commands.Clear;
import xyz.terrific.command.commands.Commands;
import xyz.terrific.command.commands.Set;
import xyz.terrific.command.commands.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager {

    public static List<Command> commands = new ArrayList<>();

    public CommandManager() {
        setup();
    }


    public void setup() {

        addCommand(new Commands());
        addCommand(new Clear());
        addCommand(new Test());
        addCommand(new Set());

    }


    public void addCommand(Command command) {
        commands.add(command);
    }
    public void handleCommand(String message) {
        if (!message.startsWith(Main.prefix))
            return;

        message = message.substring(Main.prefix.length());

        if (message.split(" ").length > 0) {
            String commandName = message.split(" ")[0];

            boolean found = false;

            for (Command command : commands) {
                if (command.aliases.contains(commandName) || command.name.equalsIgnoreCase(commandName)) {
                    command.onCommand(Arrays.copyOfRange(message.split(" "), 1, message.split(" ").length), message);
                    found = true;
                }
            }
            if (!found)
                Main.logger.error("HandleCommand", "Command '" + commandName + "' not found try '" + Main.prefix + "commands' for a list of all commands");
        }
    }

}
