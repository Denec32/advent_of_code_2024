package com.denec

class Day8ResonantCollinearityPart2 {
    fun solve(cityMap: List<String>): Int {
        val frequencies = collectFrequencies(cityMap)
        val antinodes: MutableSet<Pair<Int, Int>> = mutableSetOf()
        for (frequency in frequencies.values) {
            antinodes.addAll(collectAntinodes(cityMap, frequency))
        }

        return antinodes.size
    }

    private fun collectAntinodes(cityMap: List<String>, frequency: List<Pair<Int, Int>>): Set<Pair<Int, Int>> {
        val antinodes: MutableSet<Pair<Int, Int>> = mutableSetOf()

        for (antenna in frequency) {
            for (otherAntenna in frequency) {
                antinodes.add(antenna)
                if (antenna == otherAntenna) continue
                val diff = Pair(antenna.first - otherAntenna.first, antenna.second - otherAntenna.second)

                var antinode = Pair(antenna.first + diff.first, antenna.second + diff.second)

                while (isValid(cityMap, antinode)) {
                    antinodes.add(antinode)
                    antinode = Pair(antinode.first + diff.first, antinode.second + diff.second)
                }
            }
        }

        return antinodes
    }

    private fun isValid(cityMap: List<String>, antinode: Pair<Int, Int>): Boolean {
        return antinode.first >= 0 && antinode.second >= 0
                && antinode.first < cityMap.size && antinode.second < cityMap[0].length
    }

    private fun collectFrequencies(cityMap: List<String>): Map<Char, List<Pair<Int, Int>>> {
        val frequencies = mutableMapOf<Char, MutableList<Pair<Int, Int>>>()

        for (row in 0..cityMap.lastIndex) {
            for (col in 0.. cityMap[0].lastIndex) {
                if (cityMap[row][col] == '.') continue
                frequencies.computeIfAbsent(cityMap[row][col]) { mutableListOf() }.add(Pair(row, col))
            }
        }

        return frequencies
    }
}