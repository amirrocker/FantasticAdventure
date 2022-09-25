import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class UserServiceTest {

    @Test
    internal fun `given repository when createUser then expect valid event in repository`() {
        // no mockk yet
        val userService = UserService(
            repository = EventStore()
        )

        userService.createUser(createUserAggregate())

        Assertions.assertTrue(userService.repository.events.isNotEmpty())
    }
}