package xyz.terrific.command.commands;

import xyz.terrific.Main;
import xyz.terrific.command.Command;

import java.util.Arrays;

public class Test extends Command {
    public Test() {
        super("test");
    }

    @Override
    public void onCommand(String[] args, String command) {
        Main.logger.log("Command | Test", "Test!");
        Main.logger.log("Command | Test", "Args: " + Arrays.toString(args));
    }
}
