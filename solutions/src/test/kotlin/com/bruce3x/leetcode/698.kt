@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._698

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        assertTrue(
            solution.canPartitionKSubsets(intArrayOf(4, 3, 2, 3, 5, 2, 1), k = 4)
        )
        assertFalse(
            solution.canPartitionKSubsets(intArrayOf(2, 2, 2, 2, 3, 4, 5), k = 4)
        )
    }
}