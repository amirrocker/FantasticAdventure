// A Service that exposes a number of CRUD operations on the the domain model

class UserWriteService(
    val store: MutableMap<String, User> = mutableMapOf()
) {
    fun addUser(user: User) =
        store.apply { this[user.userId.value] = user }
}

class UserReadService(
    val store: MutableMap<String, User> = mutableMapOf()
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
