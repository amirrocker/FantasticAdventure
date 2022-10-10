import java.util.UUID

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

@JvmInline
value class Region(val value: String)

data class User(
    val userId: UserId,
    val firstName: FirstName,
    val lastName: LastName,
    val contacts: Set<ContactVO> = emptySet(),
    val addresses: Set<AddressVO> = emptySet()
)

data class PersonalInformationVO(
    val firstName: FirstName,
    val lastName: LastName,
)

data class ContactVO(
    val type: ContactType,
    val detail: ContactDetails,
    val contactByType: Map<String, Set<ContactVO>> = emptyMap()
)

data class AddressVO(
    val street: Street,
    val houseNumber: HouseNumber,
    val areaCode: AreaCode,
    val city: City,
    val addressByRegion: Map<String, Set<AddressVO>> = emptyMap()
)



