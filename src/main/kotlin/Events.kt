import java.time.LocalDate
import java.util.UUID

typealias EventId = String

sealed class DomainEvent(
    // every event must be unique
    val id: UUID = UUID.randomUUID(),
    val createdAt: LocalDate = LocalDate.now()
)

class UserCreatedDomainEvent(
    val user: User
) : DomainEvent()

class UserAddressAddedDomainEvent(
    val user: User,
    val address: AddressVO
) : DomainEvent()

class UserAddressRemovedDomainEvent(
    val user: User,
    val address: AddressVO
) : DomainEvent()

class UserContactAddedDomainEvent(
    val contactType: ContactType,
    val contactDetails: ContactDetails
) : DomainEvent()

class UserContactRemovedDomainEvent(
    val contactType: ContactType,
    val contactDetails: ContactDetails
) : DomainEvent()


data class AddUserEvent(
    val eventId: EventId,
    val userAggregate: User
) : DomainEvent()

class EventStore(
    val events: MutableMap<String, List<DomainEvent>> = mutableMapOf()
) {

    fun addDomainEvent(id: EventId, domainEvent: DomainEvent) {
        if(events.containsKey<Any>(id)) {
            val eventList = events[id]
            eventList?.union(listOf(domainEvent))
        } else {
            events.put(id, listOf(domainEvent))
        }
    }

    fun getEvents(eventId: EventId ):List<DomainEvent> =
        events[eventId].orEmpty()

}
