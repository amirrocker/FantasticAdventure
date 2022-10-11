package projector

import ContactVO
import User
import UserReadRepository
import java.util.Optional


class UserProjector(
    val readRepository: UserReadRepository
) {

    fun project(user: User) {
        val contact = readRepository.getUserContact(user.userId)
        val contactByType = mutableMapOf<String, Set<ContactVO>>()
        user.contacts.forEach {
            println("user.contacts")
            val contacts = contactByType[contact.type.value]
        }
    }
}