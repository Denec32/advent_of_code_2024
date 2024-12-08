import com.denec.Day8ResonantCollinearity
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import reader.InputReader

class Day8ResonantCollinearityTest {

    @Test
    fun solve_example() {
        assertEquals(14, Day8ResonantCollinearity().solve(listOf(
            "............",
            "........0...",
            ".....0......",
            ".......0....",
            "....0.......",
            "......A.....",
            "............",
            "............",
            "........A...",
            ".........A..",
            "............",
            "............",
        )))
    }

    @Test
    fun solve() {
        println(Day8ResonantCollinearity().solve(InputReader.parseDayEightInput()))
    }
}