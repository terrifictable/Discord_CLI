package xyz.terrific.command.commands;

import xyz.terrific.Main;
import xyz.terrific.command.Command;
import xyz.terrific.command.CommandManager;

public class Commands extends Command {
    public Commands() {
        super("commands", "Returns a list of all commands");
    }

    @Override
    public void onCommand(String[] args, String cmd) {
        StringBuilder commands = new StringBuilder();

        for (Command command : CommandManager.commands) {
            commands.append(command.name).append(", ");
        }

        Main.logger.log("Command | Commands", "Commands: " + commands.toString().substring(0, commands.length() - 2));
    }
}
