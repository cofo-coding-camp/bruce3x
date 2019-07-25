@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._51

import org.junit.Assert.assertNotEquals
import org.junit.Test


typealias Board = List<String>

fun Board.print() = joinToString(separator = "\n") { it.split("").joinToString(separator = " ") }.also(::println)

infix fun Board.contentEquals(other: Board): Boolean {
    if (size != other.size) return false
    for (i in 0 until size) {
        if (this[i] != other[i]) return false
    }
    return true
}

class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        val results = solution.solveNQueens(4)

        results.forEach {
            it.print()
            println()
        }

        assertNotEquals(-1, results.indexOfFirst {
            it contentEquals listOf(
                ".Q..",
                "...Q",
                "Q...",
                "..Q."
            )
        })
        assertNotEquals(-1, results.indexOfFirst {
            it contentEquals listOf(
                "..Q.",
                "Q...",
                "...Q",
                ".Q.."
            )
        })
    }
}