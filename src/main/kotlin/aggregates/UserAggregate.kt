package aggregates

import AddressVO
import ContactSetVO
import CreateUserCommand
import PersonalInformationVO
import UpdateUserCommand
import UserCreatedDomainEvent
import UserId
import UserReadRepository
import UserWriteRepository

// User aggregate - now as CQRS Version
data class UserAggregate(
    val userId: UserId,
    val userWriteRepository: UserWriteRepository,
    val userReadRepository: UserReadRepository,
    val personalInformation: PersonalInformationVO,
    val contactSet: ContactSetVO,
    val address: AddressVO,
) {

    fun handleCreateUserCommand(createUserCommand: CreateUserCommand) =
        createUserCommand.user.apply {
            userWriteRepository.addUser(this)
        }.also {
            listOf(UserCreatedDomainEvent(it))
        }

    fun handleUpdateUserCommand(updateUserCommand: UpdateUserCommand) =
        userWriteRepository.getUser(updateUserCommand.userId).apply {
            userWriteRepository.addUser(this.copy(userId = updateUserCommand.user.userId, firstName=updateUserCommand.user.firstName))
//            userWriteRepository.addUser(this.copy(address = address.copy(street = Street("new address"))))
        }
}