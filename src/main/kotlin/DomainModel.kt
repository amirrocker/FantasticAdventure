import java.util.*

@JvmInline
value class UserId(val value: String)

@JvmInline
value class FirstName(val value: String)

@JvmInline
value class LastName(val value: String)

@JvmInline
value class ContactSetVO(val value: Set<Contact>)

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
    UserId("userId1"),
    PersonalInformationVO(
        FirstName("max"),
        LastName("Mustermann")
    ),
    ContactSetVO(
        setOf(
            Contact(
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


// User aggregate
data class UserAggregate(
    val userId: UserId,
    val personalInformation: PersonalInformationVO,
    val contactSet: ContactSetVO,
    val address: AddressVO,
)

data class PersonalInformationVO(
    val firstName: FirstName,
    val lastName: LastName,
)

data class Contact(
    val type: ContactType,
    val detail: ContactDetails
)

data class AddressVO(
    val street: Street,
    val houseNumber: HouseNumber,
    val areaCode: AreaCode,
    val city: City,
)