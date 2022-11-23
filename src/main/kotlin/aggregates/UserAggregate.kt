package aggregates

import AddressVO
import ContactSetVO
import CreateUserCommand
import DomainEvent
import EventStore
import FirstName
import LastName
import UpdateUserCommand
import User
import UserCreatedDomainEvent
import UserId
import UserReadRepository
import UserWriteRepository

// User aggregate - now as CQRS Version
data class UserAggregate(
    val userId: UserId,
    val userWriteRepository: UserWriteRepository,
    val userReadRepository: UserReadRepository,
    val contactSet: ContactSetVO,
    val address: AddressVO,
) {

    fun handleCreateUserCommand(createUserCommand: CreateUserCommand):User {
        val user = User(
            createUserCommand.userId,
            FirstName(createUserCommand.firstName.value),
            LastName(createUserCommand.lastName.value),
        )
        userWriteRepository.addUser(user)
        return user
    }

    fun handleUpdateUserCommand(updateUserCommand: UpdateUserCommand): User {
        val user = User(
            updateUserCommand.userId,
            FirstName("first"),
            LastName("last"),
            updateUserCommand.contacts,
            updateUserCommand.addresses,
        )
        userWriteRepository.addUser(user)
        return user
    }
}

