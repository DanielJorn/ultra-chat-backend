package ultra.chat.backend.entity

import javax.persistence.*

@Entity
@Table(name = "messages")
class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0

    @Column(name = "text")
    val text: String = ""

    @Column(name = "chat_id")
    val chatId: Long = 0
}