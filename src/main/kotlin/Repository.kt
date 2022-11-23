
interface UserRepository

interface UserWriteRepository : UserRepository {
    fun addUser(user:User)
    fun getUser(userId: UserId):User
}

interface UserReadRepository : UserRepository {
    fun getUserAddress(userId:UserId): UserAddress
    fun getUserContact(userId: UserId):UserContact
}

class InMemoryUserWriteRepository(
    val service : UserWriteService
): UserWriteRepository {

    override fun addUser(user: User) {
        service.addUser(user)
    }

    override fun getUser(userId: UserId) = service.store.get(userId.value)!!
}

class InMemoryUserReadRepository(
    val service: UserReadService
) : UserReadRepository {

    override fun getUserAddress(userId: UserId): UserAddress =
        service.getUserAddress(userId)


    override fun getUserContact(userId: UserId): UserContact =
        service.getUserContact(userId)

}



