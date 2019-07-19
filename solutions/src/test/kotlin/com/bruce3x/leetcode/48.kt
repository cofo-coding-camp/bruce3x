@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._48

import org.junit.Assert
import org.junit.Test


typealias Matrix = Array<IntArray>

class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        Assert.assertTrue(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9)
            ).also(solution::rotate)
                .apply { print() }
                    matrixEquals
                    arrayOf(
                        intArrayOf(7, 4, 1),
                        intArrayOf(8, 5, 2),
                        intArrayOf(9, 6, 3)
                    )
        )

        Assert.assertTrue(
            arrayOf(
                intArrayOf(5, 1, 9, 11),
                intArrayOf(2, 4, 8, 10),
                intArrayOf(13, 3, 6, 7),
                intArrayOf(15, 14, 12, 16)
            ).also(solution::rotate)
                .apply { print() }
                    matrixEquals
                    arrayOf(
                        intArrayOf(15, 13, 2, 5),
                        intArrayOf(14, 3, 4, 1),
                        intArrayOf(12, 6, 8, 9),
                        intArrayOf(16, 7, 10, 11)
                    )
        )
    }

    private infix fun Matrix.matrixEquals(other: Matrix): Boolean {
        if (this.size != other.size) return false

        for (i in 0 until size) {
            if (this[i].contentEquals(other[i]).not()) return false
        }

        return true
    }

    private fun Matrix.print() = joinToString(separator = "\n") { it.joinToString() } + "\n"
}