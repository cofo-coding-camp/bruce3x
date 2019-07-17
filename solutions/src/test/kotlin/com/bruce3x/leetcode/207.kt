@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._207

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test


class SolutionTest {
    @Test
    fun canFinish() {
        val solution = Solution()

        assertTrue(
            solution.canFinish(
                2,
                arrayOf(intArrayOf(1, 0))
            )
        )

        assertFalse(
            solution.canFinish(
                2,
                arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
            )
        )
    }
}