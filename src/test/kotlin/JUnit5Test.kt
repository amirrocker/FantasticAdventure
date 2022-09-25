import org.junit.jupiter.api.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class JUnit5Test {

    @Test
    @DisplayName("Should demonstrate a simple assertion")
    internal fun `given eventstore when addUserEvent then expect new event in eventstore`() {
        Assertions.assertTrue(false)
    }


    // using assertAll we can see which tests fail
    @Test
    internal fun `given a list when checking all items then use multiple assertions`() {
        val list = listOf(1, 2, 3, 4, 5)
        assertAll(
            { Assertions.assertEquals(1, list[0]) },
            { Assertions.assertEquals(1, list[1]) },
            { Assertions.assertEquals(1, list[2]) },
            { Assertions.assertEquals(4, list[3]) },
            { Assertions.assertEquals(5, list[4]) },
        )
    }

    @Test
    internal fun `should only run when criteria are met`() {
        // when this criterium is not met, test is ignored
        Assumptions.assumeTrue(true)
        Assertions.assertEquals(1, 1)
    }

    data class Shape(val numberOfSides:Int)

    /**
     * Create ParametrizedTest that runs over a given set of data
     */
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7])
    internal fun `given value source when run test then expect an assert for every value`(
        numberOfSides: Int
    ) {
        val shape = Shape(numberOfSides)
        println("out $numberOfSides")
        Assertions.assertEquals(numberOfSides, shape.numberOfSides)
    }

}