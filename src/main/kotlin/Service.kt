import java.util.*

// A Service that exposes a number of CRUD operations on the the domain model

//class UserService(
//    val repository: UserRepository
//) {
//    fun addUser(user: UserAggregate) = repository.addUser(user)
//}


/**
 * with event sourcing
 */
class UserService(
    val repository: EventStore
) {

    fun createUser(user: UserAggregate) = repository.addDomainEvent(
        eventId = EventId(UUID.randomUUID()),
        domainEvent = UserCreatedDomainEvent(
            user = user
        )
    )

}