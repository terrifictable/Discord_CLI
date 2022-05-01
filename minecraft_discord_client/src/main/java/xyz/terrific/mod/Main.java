package xyz.terrific.mod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.text.LiteralText;

import java.util.List;

public class Main implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("MDC");
	public static List<String> old_messages = null;
	public static String CHANNELID = "-1";
	public static String IP = "127.0.0.1";
	public static boolean toggled = true;
	public static String PORT = "5000";
	public static String TOKEN = "";
	public static int limit = 5;

	@Override
	public void onInitialize() {
		LOGGER.info("Initialized");
	}

	public static void toggle() {
		Main.toggled = !Main.toggled;

		if (Main.toggled)
			Main.toggled = false;
		else
			Main.toggled = true;
	}

	public static void addChatMessage(String message) {
		MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(new LiteralText("\u00a7dDiscordCLI \u00a78\u00BB \u00a77" + message));
	}

	// Interesting
	/* SystemToast.show(
		MinecraftClient.getInstance().toastManager,
		SystemToast.Type.WORLD_GEN_SETTINGS_TRANSFER,
		LiteralText("DiscordCLI"),
		LiteralText("Something.")
	) */
}
