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
}

class UserWriteRepository(
    val service : UserService
) {

    fun addUser(user: UserAggregate) {
        service.addUser(user)
    }

}


