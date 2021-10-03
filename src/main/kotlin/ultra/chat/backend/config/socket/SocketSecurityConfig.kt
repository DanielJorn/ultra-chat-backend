package ultra.chat.backend.config.socket

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer

@Configuration
class SocketSecurityConfig: AbstractSecurityWebSocketMessageBrokerConfigurer() {

    override fun configureInbound(messages: MessageSecurityMetadataSourceRegistry?) {
        messages
            ?.simpDestMatchers("/socket-api/*/message", "/socket-api/*/history")
                ?.authenticated()
            ?.simpDestMatchers("/**")
                ?.permitAll()
    }

    override fun sameOriginDisabled(): Boolean = true
}