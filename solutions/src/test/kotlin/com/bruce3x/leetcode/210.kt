@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._210

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertTrue
import org.junit.Test


class SolutionTest {
    @Test
    fun findOrder() {
        val solution = Solution()

        assertArrayEquals(
            intArrayOf(0, 1),
            solution.findOrder(
                2, arrayOf(
                    intArrayOf(1, 0)
                )
            )
        )

        val result = solution.findOrder(
            4, arrayOf(
                intArrayOf(1, 0),
                intArrayOf(2, 0),
                intArrayOf(3, 1),
                intArrayOf(3, 2)
            )
        )
        assertTrue(
            result contentEquals intArrayOf(0, 1, 2, 3) || result contentEquals intArrayOf(0, 2, 1, 3)
        )

        assertArrayEquals(
            intArrayOf(0),
            solution.findOrder(1, emptyArray())
        )
        assertArrayEquals(
            intArrayOf(1, 0),
            solution.findOrder(2, emptyArray())
        )
        assertArrayEquals(
            intArrayOf(),
            solution.findOrder(
                2, arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(0, 1)
                )
            )
        )
    }
}