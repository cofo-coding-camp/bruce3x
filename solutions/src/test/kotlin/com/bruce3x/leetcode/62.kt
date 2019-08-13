@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._62

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertEquals(3, solution.uniquePaths(3, 2))
        assertEquals(28, solution.uniquePaths(7, 3))
    }
}