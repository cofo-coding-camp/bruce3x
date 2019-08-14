@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._74

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertTrue(
            solution.searchMatrix(
                arrayOf(
                    intArrayOf(1, 3, 5, 7),
                    intArrayOf(10, 11, 16, 20),
                    intArrayOf(23, 30, 34, 50)
                ),
                target = 3
            )
        )

        assertFalse(
            solution.searchMatrix(
                arrayOf(
                    intArrayOf(1, 3, 5, 7),
                    intArrayOf(10, 11, 16, 20),
                    intArrayOf(23, 30, 34, 50)
                ),
                target = 13
            )
        )

        assertFalse(
            solution.searchMatrix(
                arrayOf(
                    intArrayOf(1, 1)
                ),
                target = 2
            )
        )
    }
}