import aggregates.UserAggregate
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import java.util.*

class CqrsEsTest {

    @Test
    internal fun `given app when command run then query should return result`() {

        // TODO the default value creation should be inside UserId and overridable with a constructor argument
        val userId = UserId(UUID.randomUUID().toString())
        val events = emptyList<DomainEvent>()

        val userWriteService = UserWriteService()
        val writeRepository = InMemoryUserWriteRepository(userWriteService)

        val userReadService = UserReadService()
        val readRepository = InMemoryUserReadRepository(userReadService)

        val userAggregate = UserAggregate(
            userId = userId,
            userWriteRepository = writeRepository,
            userReadRepository = readRepository,

        )

        val user = User(userId, FirstName("firstName"), LastName( "lastName"))

        val createUserCommand = CreateUserCommand(userId, user.firstName, user.lastName)

        events + userAggregate.handleCreateUserCommand(createUserCommand)

        events.count() shouldBe 1

    }
}