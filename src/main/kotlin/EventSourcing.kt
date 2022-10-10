import java.util.*

/**
 * Now the service that handles all CRUD operations will change but not change state by updating
 * domain objects state but rather it will append domain events to the eventstore.
 *
 * Generating and Consuming Events
 *
 */

class UserServiceES(
    val eventStore: EventStore
) {
    fun createUser(user:User) {
//        eventStore.addDomainEvent(EventId(UUID.randomUUID()), UserCreatedDomainEvent())
    }
}












