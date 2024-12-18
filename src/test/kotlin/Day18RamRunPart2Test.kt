import com.denec.Day18RamRun
import com.denec.Day18RamRunPart2
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import reader.InputReader

class Day18RamRunPart2Test {
    @Test
    fun solve_example() {
        assertEquals(
            "6,1", Day18RamRunPart2().solve(
                listOf(
                    "5,4",
                    "4,2",
                    "4,5",
                    "3,0",
                    "2,1",
                    "6,3",
                    "2,4",
                    "1,5",
                    "0,6",
                    "3,3",
                    "2,6",
                    "5,1",
                    "1,2",
                    "5,5",
                    "2,5",
                    "6,5",
                    "1,4",
                    "0,4",
                    "6,4",
                    "1,1",
                    "6,1",
                    "1,0",
                    "0,5",
                    "1,6",
                    "2,0",
                ), 6, 6
            )
        )
    }

    @Test
    fun solve() {
        println(Day18RamRunPart2().solve(InputReader.parseDayEighteenInput(), 70, 70))
    }
}