import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.*

class EventStoreTest {

//    @Test
//    internal fun `given an event store when addUserEvent is called then expect a valid event in the store`() {
//        val eventStore = EventStore()
//
//        val domainEvent = AddUserEvent(
//            eventId = EventId(UUID.randomUUID()),
//            userAggregate = createUserAggregate()
//        )
//
//        eventStore.addDomainEvent(
//            eventId = domainEvent.eventId,
//            domainEvent = domainEvent
//        )
//
//        assertTrue(eventStore.events.isNotEmpty())
//    }
//
//    @Test
//    internal fun `given events when getEvents then expect a list of events`() {
//
//        val eventStore = EventStore()
//
//        val domainEvent = AddUserEvent(
//            eventId = EventId(UUID.randomUUID()),
//            userAggregate = createUserAggregate()
//        )
//
//        eventStore.addDomainEvent(
//            domainEvent = domainEvent,
//            eventId = domainEvent.eventId
//        )
//
//        val eventList = eventStore.getEvents(domainEvent.eventId)
//
//        assertTrue(eventList.isNotEmpty())
//    }
}