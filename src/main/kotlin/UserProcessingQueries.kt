/**
 * Define the required queries. A query is an intent to get data.
 */
data class ContactByTypeQuery(
    val userId: UserId,
    val contactType: ContactType
)

data class AddressByRegionQuery(
    val userId: UserId,
    val region: Region
)