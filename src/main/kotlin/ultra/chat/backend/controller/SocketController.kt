package ultra.chat.backend.controller

import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import ultra.chat.backend.model.Message
import ultra.chat.backend.model.OutputMessage
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

@Controller
class SocketController {

    @MessageMapping("/{chatId}/message")
    @SendTo("/socket-api/{chatId}/history")
    fun send(message: Message, @DestinationVariable("chatId") chatId: Int): OutputMessage {
        println(message.from)
        return OutputMessage(
            message.from,
            message.text,
            SimpleDateFormat("HH:mm").format(Date())
        )
    }
}
