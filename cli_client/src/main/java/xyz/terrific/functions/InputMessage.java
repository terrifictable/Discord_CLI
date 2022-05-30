package xyz.terrific.functions;

import xyz.terrific.Main;
import xyz.terrific.command.CommandManager;
import xyz.terrific.utils.SendDiscordMessage;

import java.util.Scanner;

public class InputMessage {

    public static void command() {



    }

    public static void handleInput() {

        Scanner scanner = new Scanner(System.in);
        String message;
        while (true) {
            System.out.print("> ");
            if (!scanner.hasNext()) return;

            message = scanner.nextLine();
            if (message.startsWith(Main.prefix)) Main.commandManager.handleCommand(message);
            else {

                SendDiscordMessage.Companion.send(message);

            }
        }

    }

}
