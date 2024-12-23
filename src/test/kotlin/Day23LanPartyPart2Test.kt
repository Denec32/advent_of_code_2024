import com.denec.Day23LanPartyPart2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import reader.InputReader

class Day23LanPartyPart2Test {
    @Test
    fun solve_example() {
        assertEquals(
            "co,de,ka,ta", Day23LanPartyPart2().solve(
                listOf(
                    "kh-tc",
                    "qp-kh",
                    "de-cg",
                    "ka-co",
                    "yn-aq",
                    "qp-ub",
                    "cg-tb",
                    "vc-aq",
                    "tb-ka",
                    "wh-tc",
                    "yn-cg",
                    "kh-ub",
                    "ta-co",
                    "de-co",
                    "tc-td",
                    "tb-wq",
                    "wh-td",
                    "ta-ka",
                    "td-qp",
                    "aq-cg",
                    "wq-ub",
                    "ub-vc",
                    "de-ta",
                    "wq-aq",
                    "wq-vc",
                    "wh-yn",
                    "ka-de",
                    "kh-ta",
                    "co-tc",
                    "wh-qp",
                    "tb-vc",
                    "td-yn",
                )
            )
        )
    }

    @Test
    fun solve() {
        println(Day23LanPartyPart2().solve(InputReader.parseDayTwentyThreeInput()))
    }
}