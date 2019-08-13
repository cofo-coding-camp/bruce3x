@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._63

import org.junit.Assert.*
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertEquals(
            2, solution.uniquePathsWithObstacles(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 0)
                )
            )
        )
    }
}