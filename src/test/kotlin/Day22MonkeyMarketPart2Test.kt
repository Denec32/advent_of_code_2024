import com.denec.Day22MonkeyMarketPart2
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import reader.InputReader

class Day22MonkeyMarketPart2Test {
    @Test
    fun solve_example() {
        assertEquals(23, Day22MonkeyMarketPart2().solve(listOf(
            "1",
            "2",
            "3",
            "2024",
        )))
    }

    @Test
    fun solve() {
        println(Day22MonkeyMarketPart2().solve(InputReader.parseDayTwentyTwoInput()))
    }
}