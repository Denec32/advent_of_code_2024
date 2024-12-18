import com.denec.Day18RamRun
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import reader.InputReader

class Day18RamRunTest {
    @Test
    fun solve_example() {
        assertEquals(
            22, Day18RamRun().solve(
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
                ), 6, 6, 12
            )
        )
    }

    @Test
    fun solve() {
        println(Day18RamRun().solve(InputReader.parseDayEighteenInput(), 70, 70, 1024))
    }
}