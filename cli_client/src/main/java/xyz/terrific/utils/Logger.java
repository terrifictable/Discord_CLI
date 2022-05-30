package xyz.terrific.utils;

public class Logger {
    private String ap = "Unknown";

    /**
     * The Logger
     * @param ap This will be displayed in the brackets, to indicate where this logger is located
     */
    public Logger(String ap) {
        this.ap = ap;
        this.log("Logger created as: " + this.ap);
    }

    /**
     * @param message Sends: "[`ChannelID`]   message"
     */
    public void message(int channel_id, String message) {
        System.out.printf("[%s]  %s\n", channel_id, message);
    }
    /**
     * @param message Sends: "Sends: "[`ChannelID`]   message"
     */
    public void message(String channel_name, String message) {
        System.out.printf("[%s]  %s\n", channel_name, message);
    }

    /**
     * @param message Sends: "[`AP`] ( {GREEN} `INFO`)   message"
     */
    public void success(String message) {
        System.out.printf("[%s] (\u001b[92mINFO\u001b[0m)  %s\n", ap, message);
    }
    /**
     * @param message Sends: "[`AP`] ( {GREEN} `INFO`)   message"
     */
    public void success(String ap, String message) {
        System.out.printf("[%s] (\u001b[92mINFO\u001b[0m)  %s\n", ap, message);
    }

    /**
     * @param message Sends: "[`AP`] ( {GRAY} `INFO`)   message"
     */
    public void log(String message) {
        System.out.printf("[%s] (\u001b[90mINFO\u001b[0m)  %s\n", ap, message);
    }
    /**
     * @param message Sends: "[`AP`] ( {GRAY} `INFO`)   message"
     */
    public void log(String ap, String message) {
        System.out.printf("[%s] (\u001b[90mINFO\u001b[0m)  %s\n", ap, message);
    }

    /**
     * @param message Sends: "[`AP`] ( {YELLOW} `WARNING`)   message"
     */
    public void warning(String message) {
        System.out.printf("[%s] (\u001b[93mWARNING\u001b[0m)  %s\n", this.ap, message);
    }
    /**
     * @param message Sends: "[`AP`] ( {YELLOW} `WARNING`)   message"
     */
    public void warning(String ap, String message) {
        System.out.printf("[%s] (\u001b[93mWARNING\u001b[0m)  %s\n", ap, message);
    }

    /**
     * @param message Sends: "[`AP`] ( {RED} `ERROR`)   message"
     */
    public void error(String message) {
        System.out.printf("[%s] (\u001b[91mERROR\u001b[0m)  %s\n", ap, message);
    }
    /**
     * @param message Sends: "[`AP`] ( {RED} `ERROR`)   message"
     */
    public void error(String ap, String message) {
        System.out.printf("[%s] (\u001b[91mERROR\u001b[0m)  %s\n", ap, message);
    }

}
