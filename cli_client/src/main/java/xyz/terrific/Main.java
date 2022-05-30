package xyz.terrific;

import xyz.terrific.command.CommandManager;
import xyz.terrific.functions.InputMessage;
import xyz.terrific.functions.OutputMessage;
import xyz.terrific.utils.Logger;

import java.util.List;

public class Main {

    public static List<String> old_messages = null;
    public static String prefix = "-";

    public static String CHANNEL_ID = "-1";
    public static String IP = "127.0.0.1";
    public static String PORT = "5000";
    public static String TOKEN = "";

    public static CommandManager commandManager;
    public static Logger logger;


    public static void main(String[] args) {
        logger = new Logger("Main");
        commandManager = new CommandManager();

        new Thread(new Runnable() {
            @Override
            public void run() {
                InputMessage.handleInput();
            }
        }).start();

        // Start message listener and logger
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    OutputMessage.Companion.update();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        logger.error("");
                    }
                }

            }
        }).start();

    }

}
