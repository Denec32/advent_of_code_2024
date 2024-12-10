import com.denec.Day10HoofItPart2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import reader.InputReader

class Day10HoofItPart2Test {
     @Test
     fun solve_example() {
         assertEquals(81, Day10HoofItPart2().solve(listOf(
             listOf(8, 9, 0, 1, 0, 1, 2, 3),
             listOf(7, 8, 1, 2, 1, 8, 7, 4),
             listOf(8, 7, 4, 3, 0, 9, 6, 5),
             listOf(9, 6, 5, 4, 9, 8, 7, 4),
             listOf(4, 5, 6, 7, 8, 9, 0, 3),
             listOf(3, 2, 0, 1, 9, 0, 1, 2),
             listOf(0, 1, 3, 2, 9, 8, 0, 1),
             listOf(1, 0, 4, 5, 6, 7, 3, 2)
         )))
     }

     @Test
     fun solve() {
         println(Day10HoofItPart2().solve(InputReader.parseDayTenInput()))
     }
 }