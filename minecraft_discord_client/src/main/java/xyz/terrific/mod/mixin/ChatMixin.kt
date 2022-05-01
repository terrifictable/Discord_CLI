package xyz.terrific.mod.mixin

import net.minecraft.client.MinecraftClient
import net.minecraft.client.network.ClientPlayerEntity
import net.minecraft.text.LiteralText
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo
import xyz.terrific.mod.Main


@Mixin(ClientPlayerEntity::class)
class ChatMixin {
    @Inject(method = ["sendChatMessage(Ljava/lang/String;)V"], at = [At("HEAD")], cancellable = true)
    private fun onSendChatMessageSDM(message: String, info: CallbackInfo) {
        if (message.startsWith("/discord")) info.cancel() else return

        var content = message.split(" ");
        if (content.size > 1) {
            // TODO: On/Off/Toggle
            if (content[1].equals("on"))
                Main.toggled = true;
            else if (content[1].equals("off"))
                Main.toggled = false;
            else if (content[1].equals("toggle"))
                Main.toggle();
            MinecraftClient.getInstance().inGameHud.chatHud.addMessage(LiteralText("\u00a7dDiscordCLI \u00a78\u00BB \u00a77Toggled ${if (Main.toggled) "On" else "Off"}."));
        }

        /* SystemToast.show(
            MinecraftClient.getInstance().toastManager,
            SystemToast.Type.WORLD_GEN_SETTINGS_TRANSFER,
            LiteralText("DiscordCLI"),
            LiteralText("Something.")
        ) */
    }
}
