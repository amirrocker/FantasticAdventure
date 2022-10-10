package projections

import AddressByRegionQuery
import AddressVO
import ContactByTypeQuery
import ContactVO
import UserReadRepository

/**
 * a projection that handles our queries
 */
class UserProjection(
    val readRepository: UserReadRepository
) {

    fun handle(query: AddressByRegionQuery): Set<AddressVO> =
        readRepository
            .getUserAddress(query.userId)
            .addressByRegion[query.region.value] ?: emptySet()

    fun handle(query: ContactByTypeQuery): Set<ContactVO> =
        readRepository
            .getUserContact(query.userId)
            .contactByType[query.contactType.value] ?: emptySet()

}