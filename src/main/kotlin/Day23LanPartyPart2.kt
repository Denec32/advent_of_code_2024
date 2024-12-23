package com.denec

class Day23LanPartyPart2 {
    fun solve(input: List<String>): String {
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


        findClique(adj, mutableSetOf(), computers, mutableSetOf())
        return ans.sorted().joinToString(",")
    }

    var ans = setOf<String>()
    private fun findClique( adj: Map<String, List<String>>, r: MutableSet<String>, p: MutableSet<String>, x: MutableSet<String>) {
        if (p.isEmpty() && x.isEmpty()) {
            if (r.size > ans.size) ans = r
            return
        }

        for (vertex in p.toSet()) {
            findClique(
                adj,
                r.toMutableSet().also { it.add(vertex) },
                p.filter { adj[vertex]?.contains(it) == true }.toMutableSet(),
                x.filter { adj[vertex]?.contains(it) == true }.toMutableSet()
            )

            p.remove(vertex)
            x.add(vertex)
        }
    }
}