@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._495

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertEquals(4, solution.findPoisonedDuration2(intArrayOf(1, 4), 2))
        assertEquals(3, solution.findPoisonedDuration2(intArrayOf(1, 2), 2))
    }
}