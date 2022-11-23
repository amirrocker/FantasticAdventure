// A Service that exposes a number of CRUD operations on the the domain model

class UserWriteService(
    val store: MutableMap<String, User> = mutableMapOf()
) {
    fun addUser(user: User) =
        store.apply { this[user.userId.value] = user }
}

class UserReadService(
    val addressStore: MutableMap<String, UserAddress> = mutableMapOf(),
    val contactsStore: MutableMap<String, UserContact> = mutableMapOf()
) {

    fun getUserAddress(userId: UserId) = store[userId]

    fun getUserContact(userId: UserId) = UserContact(

    )
}
