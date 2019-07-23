@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._33

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertEquals(4, solution.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
        assertEquals(-1, solution.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
        assertEquals(1, solution.search(intArrayOf(1, 3), 3))
        assertEquals(0, solution.search(intArrayOf(1, 3), 1))
    }
}