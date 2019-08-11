@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._162

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        assertEquals(2, solution.findPeakElement(intArrayOf(1, 2, 3, 1)))
        assertTrue(solution.findPeakElement(intArrayOf(1, 2, 1, 3, 5, 6, 4)) in intArrayOf(1, 5))
    }
}