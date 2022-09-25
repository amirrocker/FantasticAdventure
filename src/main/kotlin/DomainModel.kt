import java.util.*

@JvmInline
value class UserId(val value: String)

@JvmInline
value class FirstName(val value: String)

@JvmInline
value class LastName(val value: String)

@JvmInline
value class ContactSetVO(val value: Set<ContactVO>)

@JvmInline
value class ContactType(val value: String)

@JvmInline
value class ContactDetails(val value: String)

@JvmInline
value class EventId(val value: UUID)

@JvmInline
value class Street(val value: String)

@JvmInline
value class HouseNumber(val value: String)

@JvmInline
value class AreaCode(val value: String)

@JvmInline
value class City(val value: String)

// temp User aggregate stub
fun createUserAggregate() = UserAggregate(
    UserWriteRepository(
        UserService()
    ),
    UserId("userId1"),
    PersonalInformationVO(
        FirstName("max"),
        LastName("Mustermann")
    ),
    ContactSetVO(
        setOf(
            ContactVO(
                type = ContactType("ContactType"),
                detail = ContactDetails("contactDetail")
            )
        )
    ),
    address = AddressVO(
        street = Street("someStreet"),
        houseNumber = HouseNumber("someStreet"),
        areaCode = AreaCode("area code a"),
        city = City("someStreet"),
    )
)

data class PersonalInformationVO(
    val firstName: FirstName,
    val lastName: LastName,
)

data class ContactVO(
    val type: ContactType,
    val detail: ContactDetails
)

data class AddressVO(
    val street: Street,
    val houseNumber: HouseNumber,
    val areaCode: AreaCode,
    val city: City,
)

// User aggregate - most simple version
// no cqrs - not even a real aggregate
//data class UserAggregateV1(
//    val userId: UserId,
//    val personalInformation: PersonalInformationVO,
//    val contactSet: ContactSetVO,
//    val address: AddressVO,
//)

// User aggregate - now as CQRS Version
data class UserAggregate(
    val userWriteRepository: UserRepository,
    val userId: UserId,
    val personalInformation: PersonalInformationVO,
    val contactSet: ContactSetVO,
    val address: AddressVO,
) {

    fun handleCreateUserCommand(createUserCommand: CreateUserCommand) =
        createUserCommand.userAggregate.apply {
            userWriteRepository.addUser(this)
        }

    fun handleUpdateUserCommand(updateUserCommand: UpdateUserCommand) =
        userWriteRepository.getUser(updateUserCommand.userId).apply {
            address.copy(street = Street("new address"))
        }.also {
            userWriteRepository.addUser(it)
        }
}

