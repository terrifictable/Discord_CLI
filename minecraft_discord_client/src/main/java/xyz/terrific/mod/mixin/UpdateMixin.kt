package xyz.terrific.mod.mixin

import net.minecraft.world.World
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo
import xyz.terrific.mod.Main
import xyz.terrific.mod.Main.old_messages
import xyz.terrific.mod.utils.ServerGetMessages


@Mixin(World::class)
class UpdateMixin {

    @Inject(at = [At("RETURN")], method = ["tickBlockEntities"])
    protected fun tickWorldAfterBlockEntities(ci: CallbackInfo?) {
        // Probably the worst code I've ever written

        try {
            var messages = ServerGetMessages.getMessages()

            if (old_messages != null) {
                if (messages != old_messages) {
                    for (message in messages) {
                        val index: Int = message.indexOf(message)
                        if (message != old_messages[index] && message != "\n") {
                            Main.addChatMessage(message)
                        }
                    }
                }
            }

            old_messages = messages
        } catch (e: Exception) {
            return
        }

    }
}
