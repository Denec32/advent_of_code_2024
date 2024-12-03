package reader

class InputReader {
    companion object {
        fun parseDayOneInput(): Pair<MutableList<Int>, MutableList<Int>> {
            val input = {}.javaClass.getResource("input_1.txt")?.readText() ?: ""
            val firstList = mutableListOf<Int>()
            val secondList = mutableListOf<Int>()

            for (line in input.lines()) {
                if (line.isEmpty()) continue
                val (first, second) = line.split("   ")
                firstList.add(first.toInt())
                secondList.add(second.toInt())
            }

            return firstList to secondList
        }

        fun parseDayTwoInput(): List<List<Int>> {
            val input = {}.javaClass.getResource("input_2.txt")?.readText() ?: ""

            return input.lines().stream()
                .filter { line -> line.isNotEmpty() }
                .map { line -> line.split(" ").map { it.toInt() } }
                .toList()
        }
    }
}