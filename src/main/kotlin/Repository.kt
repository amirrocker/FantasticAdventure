// we define a very simple in-memory repository
class UserRepository(
    val eventStore: Map<String, UserAggregate> = emptyMap()
) {
    fun addUser(user: UserAggregate) {
//        val addUserEvent = AddUserEvent(EventId(), user.userId, user)
    }
}