// A Service that exposes a number of CRUD operations on the the domain model

//class UserService(
//    val repository: UserRepository
//) {
//    fun addUser(user: UserAggregate) = repository.addUser(user)
//}


//**
// * with event sourcing
// */
//class UserService(
//    val repository: EventStore
//) {
//
//    fun createUser(user: UserAggregate) = repository.addDomainEvent(
//        eventId = EventId(UUID.randomUUID()),
//        domainEvent = UserCreatedDomainEvent(
//            user = user
//        )
//    )
//}

// with event sourcing and cqrs
class UserWriteService(
    val store: MutableMap<String, UserAggregate> = mutableMapOf()
) {

    fun addUser(user: UserAggregate) =
        store.apply { this[user.userId.value] = user }

}

class UserReadService(
    val store: MutableMap<String, UserAggregate> = mutableMapOf()
) {

    fun getUserAddress(userId: UserId) = AddressVO(
        Street("Some Street"),
        HouseNumber("Some Houser Number"),
        AreaCode("Some Area Code"),
        City("Kupiansk")
    )

    fun getUserContact(userId: UserId) = ContactVO(
        ContactType("contact type = email, sms or such"),
        ContactDetails("contact details")
    )
}
