package xyz.terrific.command.commands;

import xyz.terrific.command.Command;

public class Clear extends Command {
    public Clear() {
        super("clear");
    }

    @Override
    public void onCommand(String[] args, String command) {
        // System.out.println(new String(new char[50]).replace("\0", "\r\n"));

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
