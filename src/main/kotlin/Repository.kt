import java.util.*

// we define a very simple in-memory repository
//class UserRepository(
//    val eventStore: Map<String, UserAggregate> = emptyMap()
//) {
//    fun addUser(user: UserAggregate) {
////        val addUserEvent = AddUserEvent(EventId(), user.userId, user)
//    }
//}



interface UserRepository

interface UserWriteRepository : UserRepository {
    fun addUser(user:UserAggregate)
    fun getUser(userId: UserId):UserAggregate
}

interface UserReadRepository : UserRepository {
    fun getUserAddress(userId:UserId): AddressVO
    fun getUserContact(userId: UserId):ContactVO
}

class InMemoryUserWriteRepository(
    val service : UserWriteService
): UserWriteRepository {

    override fun addUser(user: UserAggregate) {
        service.addUser(user)
    }

    override fun getUser(userId: UserId) = service.store.get(userId.value)!!
}

class InMemoryUserReadRepository(
    val service: UserReadService
) : UserReadRepository {

    override fun getUserAddress(userId: UserId): AddressVO =
        service.getUserAddress(userId)

    override fun getUserContact(userId: UserId): ContactVO =
        service.getUserContact(userId)
}



