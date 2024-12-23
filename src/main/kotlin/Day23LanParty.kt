package com.denec

class Day23LanParty {
    fun solve(input: List<String>): Int {
        val adj = mutableMapOf<String, MutableList<String>>()
        val computers = mutableSetOf<String>()

        for (entry in input) {
            val computer1 = entry.split("-")[0]
            val computer2 = entry.split("-")[1]

            adj.computeIfAbsent(computer1) { mutableListOf() }.add(computer2)
            adj.computeIfAbsent(computer2) { mutableListOf() }.add(computer1)

            computers.add(computer1)
            computers.add(computer2)
        }
        val visited = mutableSetOf<List<String>>()
        for (computer in computers.filter { it.startsWith('t') }) {
            val neighbors = adj[computer]

            for (i in 0..neighbors!!.lastIndex) {
                for (j in i + 1..neighbors.lastIndex) {
                    if (adj[neighbors[i]]?.contains(neighbors[j]) == true) {
                        //println("found set of ${neighbors[i]}, ${neighbors[j]}, $computer")
                        visited.add(listOf(neighbors[i], neighbors[j], computer).sorted())
                    }
                }
            }
        }

        return visited.size
    }
}