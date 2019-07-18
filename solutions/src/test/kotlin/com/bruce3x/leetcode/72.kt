@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._72

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertEquals(3, solution.minDistance("horse", "ros"))
        assertEquals(5, solution.minDistance("intention", "execution"))

        assertEquals(3, solution.minDistance("", "eat"))
        assertEquals(0, solution.minDistance("", ""))
    }
}