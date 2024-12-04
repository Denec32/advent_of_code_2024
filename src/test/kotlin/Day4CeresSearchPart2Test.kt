import com.denec.Day4CeresSearchPart2
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import reader.InputReader

class Day4CeresSearchPart2Test {
     @Test
     fun solve_example() {
         assertEquals(9, Day4CeresSearchPart2().solve(listOf(
            ".M.S......",
            "..A..MSMS.",
            ".M.S.MAA..",
            "..A.ASMSM.",
            ".M.S.M....",
            "..........",
            "S.S.S.S.S.",
             ".A.A.A.A..",
            "M.M.M.M.M.",
             ".........."
         )))
     }

    @Test
    fun solve() {
        println(Day4CeresSearchPart2().solve(InputReader.parseDayFourInput()))
    }
 }