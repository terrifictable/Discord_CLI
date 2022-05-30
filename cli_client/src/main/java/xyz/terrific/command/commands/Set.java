package xyz.terrific.command.commands;

import xyz.terrific.Main;
import xyz.terrific.command.Command;

public class Set extends Command {
    public Set() {
        super("set");
    }

    @Override
    public void onCommand(String[] args, String command) {
        if (args.length <= 0) {
            Main.logger.error("Commands | Set", "-set help");
            return;
        }

        switch (args[0]) {
            case "channelid" -> Main.CHANNEL_ID = args[1];
            case "token" -> Main.TOKEN = args[1];
            case "ip" -> Main.IP = args[1];
            case "port" -> Main.PORT = args[1];
            default -> {
                Main.logger.log("""
                        
                        -set channelid <channel_id>
                        -set token <discord_token>
                        -set ip <message_server_IP>
                        -set port <message_server_PORT>"""
                );
            }
        }

    }
}
