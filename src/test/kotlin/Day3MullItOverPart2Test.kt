import com.denec.Day3MullItOverPart2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import reader.InputReader.Companion.parseDayThreeInput

class Day3MullItOverPart2Test {
     @Test
     fun solve_example() {
         assertEquals(48, Day3MullItOverPart2().solve("xxmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"))
     }

     @Test
     fun solve() {
         println(Day3MullItOverPart2().solve(parseDayThreeInput()))
     }
 }