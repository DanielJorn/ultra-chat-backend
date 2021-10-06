package ultra.chat.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UltraChatBackendApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<UltraChatBackendApplication>(*args)
        }
    }
}
