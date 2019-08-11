@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._518

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        assertEquals(4, solution.change(5, coins = intArrayOf(1, 2, 5)))
        assertEquals(0, solution.change(3, coins = intArrayOf(2)))
        assertEquals(1, solution.change(10, coins = intArrayOf(10)))
    }
}