import com.denec.Day21KeypadConundrum
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day21KeypadConundrumTest {
    @Test
    fun solve_029A() {
        assertEquals(68 * 29, Day21KeypadConundrum().solve("029A", 2))
    }

    @Test
    fun solve_980A() {
        assertEquals(60 * 980, Day21KeypadConundrum().solve("980A", 2))
    }

    @Test
    fun solve_179A() {
        assertEquals(68 * 179, Day21KeypadConundrum().solve("179A", 2))
    }

    @Test
    fun solve_456A() {
        assertEquals(64 * 456, Day21KeypadConundrum().solve("456A", 2))
    }

    @Test
    fun solve_379A() {
        assertEquals(64 * 379, Day21KeypadConundrum().solve("379A", 2))
    }

    @Test
    fun solve_example() {
        assertEquals(
            126384, Day21KeypadConundrum().solve(
                listOf(
                    "029A",
                    "980A",
                    "179A",
                    "456A",
                    "379A",
                ), 2
            )
        )
    }

    @Test
    fun solve() {
        println(Day21KeypadConundrum().solve(
                listOf(
                    "789A",
                    "540A",
                    "285A",
                    "140A",
                    "189A",
                ), 2
            )
        )
    }

    @Test
    fun solve_part2() {
        println(Day21KeypadConundrum().solve(
                listOf(
                    "789A",
                    "540A",
                    "285A",
                    "140A",
                    "189A",
                ), 25
            )
        )
    }
}