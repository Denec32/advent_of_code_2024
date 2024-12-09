import com.denec.Day9DiskFragmenterPart2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import reader.InputReader

class Day9DiskFragmenterPart2Test {

     @Test
     fun solve_example() {
         assertEquals("2858", Day9DiskFragmenterPart2().solve("2333133121414131402"))
     }

     @Test
     fun solve() {
         println(Day9DiskFragmenterPart2().solve(InputReader.parseDayNineInput()))
     }
 }