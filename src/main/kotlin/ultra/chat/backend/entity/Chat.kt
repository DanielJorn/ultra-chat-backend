package ultra.chat.backend.entity

import javax.persistence.*

@Entity
@Table(name = "chats")
class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0

    @Column(name = "title")
    val title: String = ""
}