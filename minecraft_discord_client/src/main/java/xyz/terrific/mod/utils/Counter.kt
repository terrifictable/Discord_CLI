package io.github.hotlava03.chatutils.util

import net.minecraft.text.Text

class Counter {
   companion object {
      var lastMessage: Text? = null
      var spamCounter = 1
   }
}
