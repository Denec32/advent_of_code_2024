package com.denec

class Day18RamRunPart2 {
    fun solve(bytes: List<String>, width: Int, height: Int): String {
        for (byteCount in 0..bytes.size) {
            if (Day18RamRun().solve(bytes, width, height, byteCount) == -1) {
                return bytes[byteCount - 1]
            }
        }

        return ""
    }
}