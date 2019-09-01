@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._132

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        assertEquals(1, solution.minCut("aab"))
        println()
        assertEquals(3, solution.minCut("ccaacabacb"))
    }
}