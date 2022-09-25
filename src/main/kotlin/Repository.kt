import java.util.*

// we define a very simple in-memory repository
//class UserRepository(
//    val eventStore: Map<String, UserAggregate> = emptyMap()
//) {
//    fun addUser(user: UserAggregate) {
////        val addUserEvent = AddUserEvent(EventId(), user.userId, user)
//    }
//}



interface Repository

interface UserRepository {
    fun addUser(user:UserAggregate)
    fun getUser(userId: UserId):UserAggregate
}

class UserWriteRepository(
    val service : UserService
): UserRepository {

    override fun addUser(user: UserAggregate) {
        service.addUser(user)
    }

    // avoid !! if possible
    override fun getUser(userId: UserId) = service.store.get(userId.value)!!

}


