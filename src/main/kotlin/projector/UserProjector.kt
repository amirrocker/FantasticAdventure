package projector

import User
import UserReadRepository
import java.util.Optional

class UserProjector(
    val readRepository: UserReadRepository
) {

    fun project(user: User) {
        val contact = readRepository.getUserContact(user.userId)
        user.contacts.forEach {
            println("project state into the readDomainModel.")
        }
    }

}