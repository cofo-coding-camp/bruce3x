@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._547

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertEquals(
            2,
            solution.findCircleNum(
                arrayOf(
                    intArrayOf(1, 1, 0),
                    intArrayOf(1, 1, 0),
                    intArrayOf(0, 0, 1)
                )
            )
        )

        assertEquals(
            1,
            solution.findCircleNum(
                arrayOf(
                    intArrayOf(1, 1, 0),
                    intArrayOf(1, 1, 1),
                    intArrayOf(0, 1, 1)
                )
            )
        )
    }
}