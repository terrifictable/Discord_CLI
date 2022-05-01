package xyz.terrific.mod.mixin

import net.minecraft.client.network.ClientPlayerEntity
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo
import xyz.terrific.mod.Main
import xyz.terrific.mod.utils.SendDiscordMessage

@Mixin(ClientPlayerEntity::class)
class ChatMixin {
    @Inject(method = ["sendChatMessage(Ljava/lang/String;)V"], at = [At("HEAD")], cancellable = true)
    private fun onSendChatMessageSDM(message: String, info: CallbackInfo) {
        if (message.startsWith("/dmc")) info.cancel() else return

        val content = message.split(" ")
        if (content.size > 1) {
            // TODO: On/Off/Toggle
            if (content[1] == "on") {
                Main.toggled = true
                Main.addChatMessage("Toggled ${if (Main.toggled) "On" else "Off"}.")
            }
            else if (content[1] == "off") {
                Main.toggled = false
                Main.addChatMessage("Toggled ${if (Main.toggled) "On" else "Off"}.")
            }
            else if (content[1] == "toggle") {
                Main.toggle()
                Main.addChatMessage("Toggled ${if (Main.toggled) "On" else "Off"}.")
            }
            else if (content[1] == "send") {
                SendDiscordMessage.send(message.substring(10, message.length))
            }


            else if (content[1] == "set") {

                if (content.size >= 3) {

                    if (content[2] == "token") {
                        Main.TOKEN = content[3]
                        val token = content[3];
                        var newToken = ""

                        newToken += token.substring(0, token.length / 2)
                        for (i in 0 until ((token.length / 2) + (token.length / 3))) {
                            newToken += "*"
                        }

                        Main.addChatMessage("Token set to $newToken")
                    }
                    else if (content[2] == "port") {
                        Main.PORT = content[3]
                        Main.addChatMessage("Server-Port changed to ${content[3]}")
                    }
                    else if (content[2] == "ip") {
                        Main.IP = content[3]
                        Main.addChatMessage("Server-IP changed to ${content[3]}")
                    }
                    else if (content[2] == "channelid") {
                        Main.CHANNELID = content[3]
                        Main.addChatMessage("Channel-ID changed to ${content[3]}")
                    }
                }
                else {
                    Main.addChatMessage("=== Set  Commands ===")
                    Main.addChatMessage(" >set token      [token]   <->   Sets discord token to send discord messages")
                    Main.addChatMessage(" >set ip         [IP]      <->   Sets IP to CLI server")
                    Main.addChatMessage(" >set port       [port]    <->   Sets port to CLI server")
                    Main.addChatMessage(" >set ChannelID  [id]      <->   Sets Discord Channel ID")
                }
            }
        }
        else {
            Main.addChatMessage("=== Commands ===")
            Main.addChatMessage(" >set                          <->    Set Commands")
            Main.addChatMessage(" >sdm                          <->    Send Discord Message (with channelid inline)")
            Main.addChatMessage(" >send <channelid> [message]   <->    Sends Discord chat message in before set channel (you need to set your token first)")
            Main.addChatMessage(" >toggle                       <->    Toggle Mod")
            Main.addChatMessage(" >on                           <->    Toggles Mod On")
            Main.addChatMessage(" >off                          <->    Toggles Mod Off")
        }
    }
}
