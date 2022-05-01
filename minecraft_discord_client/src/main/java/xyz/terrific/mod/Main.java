package xyz.terrific.mod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("MDC");
	public static boolean toggled = true;

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
}
