@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._542

import org.junit.Assert.assertTrue
import org.junit.Test


private typealias IntMatrix = Array<IntArray>

private fun IntMatrix._equals(other: IntMatrix): Boolean {
    return this.size == other.size && this.zip(other).all { it.first contentEquals it.second }
}

class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertTrue(
            solution.updateMatrix(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 0)
                )
            )._equals(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 0)
                )
            )
        )
        assertTrue(
            solution.updateMatrix(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(1, 1, 1)
                )
            )._equals(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(1, 2, 1)
                )
            )
        )
    }
}