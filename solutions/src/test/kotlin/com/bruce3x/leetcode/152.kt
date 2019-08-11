@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._152

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        assertEquals(6, solution.maxProduct(intArrayOf(2, 3, -2, 4)))
        assertEquals(0, solution.maxProduct(intArrayOf(-2, 0, -1)))
    }
}