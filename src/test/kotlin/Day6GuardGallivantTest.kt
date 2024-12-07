import com.denec.Day6GuardGallivant
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import reader.InputReader

class Day6GuardGallivantTest {

    @Test
    fun solve_example() {
        assertEquals(41, Day6GuardGallivant().solve(
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
        println(Day6GuardGallivant().solve(InputReader.parseDaySixInput()))
    }
}