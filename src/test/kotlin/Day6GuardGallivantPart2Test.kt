import com.denec.Day6GuardGallivantPart2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import reader.InputReader

class Day6GuardGallivantPart2Test {
    @Test
    fun solve_example() {
        assertEquals(6, Day6GuardGallivantPart2().solve(
            listOf(
                listOf('.', '.', '.', '.', '#', '.', '.', '.', '.', '.'),
                listOf('.', '.', '.', '.', '.', '.', '.', '.', '.', '#'),
                listOf('.', '.', '.', '.', '.', '.', '.', '.', '.', '.'),
                listOf('.', '.', '#', '.', '.', '.', '.', '.', '.', '.'),
                listOf('.', '.', '.', '.', '.', '.', '.', '#', '.', '.'),
                listOf('.', '.', '.', '.', '.', '.', '.', '.', '.', '.'),
                listOf('.', '#', '.', '.', '^', '.', '.', '.', '.', '.'),
                listOf('.', '.', '.', '.', '.', '.', '.', '.', '#', '.'),
                listOf('#', '.', '.', '.', '.', '.', '.', '.', '.', '.'),
                listOf('.', '.', '.', '.', '.', '.', '#', '.', '.', '.'),
            )
        ))
    }

    @Test
    fun solve() {
        println(Day6GuardGallivantPart2().solve(InputReader.parseDaySixInput()))
    }
}