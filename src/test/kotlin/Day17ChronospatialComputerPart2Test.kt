import com.denec.Day17ChronospatialComputerPart2
import org.junit.jupiter.api.Test
import java.util.*

class Day17ChronospatialComputerPart2Test {

    @Test
    fun solve() {
        val target = listOf(
            2, 4,
            1, 7,
            7, 5,
            1, 7,
            0, 3,
            4, 1,
            5, 5,
            3, 0
        ).joinToString("")

        Day17ChronospatialComputerPart2.dfs(target, target.length - 1, Stack<Int>())
    }
}