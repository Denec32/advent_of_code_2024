import com.denec.Day22MonkeyMarket
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import reader.InputReader

class Day22MonkeyMarketTest {
    @Test
    fun solve_example() {
        assertEquals(37327623, Day22MonkeyMarket().solve(listOf(
            "1",
            "10",
            "100",
            "2024",
        )))
    }

    @Test
    fun solve() {
        println(Day22MonkeyMarket().solve(InputReader.parseDayTwentyTwoInput()))
    }
}