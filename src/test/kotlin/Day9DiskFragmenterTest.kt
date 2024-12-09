import com.denec.Day9DiskFragmenter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import reader.InputReader

class Day9DiskFragmenterTest {

    @Test
    fun solve_example() {
        assertEquals("1928", Day9DiskFragmenter().solve("2333133121414131402"))
    }


    @Test
    fun solve() {
        println(Day9DiskFragmenter().solve(InputReader.parseDayNineInput()))
    }
}